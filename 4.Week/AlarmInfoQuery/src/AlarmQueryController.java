package com.yuantiao.barrett.bus.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuantiao.barrett.api.util.ExcelUtil;
import com.yuantiao.barrett.bus.bo.AlarmDeviceInfoBo;
import com.yuantiao.barrett.bus.bo.AlarmInfoBo;
import com.yuantiao.barrett.bus.bo.AlarmMicMonitorBo;
import com.yuantiao.barrett.bus.camoservice.AlarmDeviceInfoService;
import com.yuantiao.barrett.bus.condition.AlarmInfoQueryCondition;
import com.yuantiao.barrett.bus.service.AlarmInfoService;
import com.yuantiao.webplatform.core.annotation.QueryRequestParam;
import com.yuantiao.webplatform.core.object.GridQueryResult;
import com.yuantiao.webplatform.core.object.QueryController;
import com.yuantiao.webplatform.core.object.RequestCondition;

@Controller
@RequestMapping(value = "/alarmCall")
@PermitAll
public class AlarmQueryController extends QueryController<AlarmInfoQueryCondition>{
	private final Logger logger = LoggerFactory.getLogger(AlarmQueryController.class);
	
	private static final String EXCEL = "excel";
	private static final String EXCELEND = ".xls";
	
	private static Map<String, String> callTypeMap;
	private static Map<String, String> teamTypeMap;
	
	static {
		callTypeMap = new HashMap<String, String>();
		callTypeMap.put("1", "位置报警");
		callTypeMap.put("2", "拥堵报警");
		callTypeMap.put("3", "预测报警");
		callTypeMap.put("4", "区域报警");
		callTypeMap.put("5", "设备报警");
		callTypeMap.put("weizhi", "1");
		callTypeMap.put("yongdu", "2");
		callTypeMap.put("yuce", "3");
		callTypeMap.put("quyu", "4");
		callTypeMap.put("shebei", "5");
		
		teamTypeMap = new HashMap<String, String>();
		teamTypeMap.put("雨花区","雨花大队");
		teamTypeMap.put("芙蓉区", "芙蓉大队");
		teamTypeMap.put("开福区", "开福大队");
		teamTypeMap.put("天心区", "天心大队");
		teamTypeMap.put("高新区", "高新大队");
		teamTypeMap.put("岳麓区", "岳麓大队");
		
		teamTypeMap.put("yuhua","雨花区");
		teamTypeMap.put("furong", "芙蓉区");
		teamTypeMap.put("kaifu", "开福区");
		teamTypeMap.put("tianxin", "天心区");
		teamTypeMap.put("gaoxin", "高新区");
		teamTypeMap.put("yuelu", "岳麓区");
	}
	
	@Autowired
	private AlarmInfoService<AlarmInfoQueryCondition> alarmInfoService;
	
	@Autowired
	private AlarmDeviceInfoService<AlarmInfoQueryCondition> alarmDeviceInfoService;	
	
	@RequestMapping(value = "/alarmRecord.html")
	public String alarmRecord(Model m){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		long zero = System.currentTimeMillis() / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();
		String startTime = dateFormat.format(new Date(zero));
		m.addAttribute("startTime", startTime);
		
		return "alarmInfo/alarmRecord";
	}
	
	@RequestMapping("/query")
	public @ResponseBody GridQueryResult query(@QueryRequestParam("params") RequestCondition params, Model m) {
		AlarmInfoQueryCondition queryCondition = this.rCondition2QCondition(params);
		
		// Get all attributes contained in queryCondition
		Map<String, String> map = formFilterToMap(params);
		queryCondition.setUserName(map.get("userName"));
		queryCondition.setStartTime(map.get("startTime"));
		queryCondition.setEndTime(map.get("endTime"));
		queryCondition.setCallType(callTypeMap.get(map.get("callType")));
		queryCondition.setTeamType(teamTypeMap.get(map.get("teamType")));
		
		List<AlarmDeviceInfoBo> devices = null;
		
		List<AlarmInfoBo> list = null;
		
		List<AlarmMicMonitorBo> micMonitors = null;
		
		// Get all results 
		if(queryCondition.getCallType() == "5"){
			// check all bays
			devices = alarmDeviceInfoService.selectAllBays(queryCondition);
			
			// check all mic monitors
			micMonitors = alarmDeviceInfoService.selectAllMics(queryCondition);
			
			// clear the call type with null or ""? loschen
//			queryCondition.setCallType(null);
			
			list = alarmInfoService.selectAll(queryCondition);
			
			int size = list.size();
			
			// Complexity? O(lgn*n^3) 
			for(AlarmInfoBo tempAlarmInfoBo: list){
				if((tempAlarmInfoBo.getCallType()).compareTo("5") != 0){
					list.remove(tempAlarmInfoBo);
					continue;
				}
				
				for(AlarmDeviceInfoBo tempAlarmDeviceInfoBo: devices){
					
					// Check the location and the road name
					if((tempAlarmInfoBo.getLocation()).compareTo(tempAlarmDeviceInfoBo.getRoadName()) == 0){

						// Check the status of the chosen device
						if((tempAlarmDeviceInfoBo.getResult()).compareTo("Normal") == 0 || 
								(tempAlarmDeviceInfoBo.getResult()).compareTo("NODATE") == 0){
						
							// remove all normal bays 
							list.remove(tempAlarmInfoBo);
						}
					}
				}
			}
			
			// remove all normal mic monitors
			for(AlarmInfoBo tempAlarmInfoBo: list){
				if((tempAlarmInfoBo.getCallType()).compareTo("5") != 0){
					list.remove(tempAlarmInfoBo);
					continue;
				}
				
				for(AlarmMicMonitorBo tempMicMonitor: micMonitors){
					if((tempAlarmInfoBo.getLocation()).compareTo(tempMicMonitor.getRoadName()) == 0){
						if((tempMicMonitor.getResult()).compareTo("Normal") == 0 || 
								(tempMicMonitor.getResult()).compareTo("NODATE") == 0){
							list.remove(tempAlarmInfoBo);
						}
					}
				}
			}
			
			int changedSize = list.size();
			
			if(size == changedSize){
				queryCondition.setCallType("5");
			}
			
		} else {
			list = alarmInfoService.selectAll(queryCondition);
		}

		
		// Show all corresponded records
		if(list != null){
			for(AlarmInfoBo tempBo: list){
				if(tempBo.getDepartment() != null) {
					if(tempBo.getDepartment().endsWith("区")){
						tempBo.setDepartment(teamTypeMap.get(tempBo.getDepartment()));
					}
				}
				
				if(tempBo.getCallType() != null){
					if(tempBo.getCallType().endsWith("1") || tempBo.getCallType().endsWith("2") || tempBo.getCallType().endsWith("3") ||
						tempBo.getCallType().endsWith("4") || tempBo.getCallType().endsWith("5")){
						tempBo.setCallType(callTypeMap.get(tempBo.getCallType()));
					}
				}
				logger.info(tempBo.toString());
			}
		}
		
		int count = alarmInfoService.queryCount(queryCondition);
		GridQueryResult g = new GridQueryResult(count, list);
		
		return g;
	}
	
	@RequestMapping(value = "/excelExport", method = RequestMethod.POST)
	public @ResponseBody void exportExcel(HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("In Export Excel: " + request.getPathInfo());
		
		AlarmInfoQueryCondition condition = new AlarmInfoQueryCondition();
		
		condition.setCallType(request.getParameter("callType"));
		condition.setEndTime(request.getParameter("endTime"));
		condition.setStartTime(request.getParameter("startTime"));
		condition.setUserName(request.getParameter("userName"));
		condition.setTeamType(request.getParameter("teamType"));
		
		String path = EXCEL + File.separator + System.currentTimeMillis() + EXCELEND ;
		String baseSavePath = request.getSession().getServletContext().getRealPath("/") +"../";
		//String baseSavePath = System.getProperty("java.io.tmpdir");
		String realPath = baseSavePath + path;
		
		List<AlarmInfoBo> list = alarmInfoService.selectAll(condition);
		
		String[] headerNames = new String[] {"报警时间", "所属部门", "地点", "报警类型"};
		String[] fieldNames = new String[] {"id", "callTime", "department", "location", "callType"};
		String itemName = "序号";
		
		ExcelUtil.generateExcel(realPath, headerNames, fieldNames, list, itemName);
		ExcelUtil.downLoadExcel(realPath, response);

	}
	
	protected AlarmInfoQueryCondition initCondition() {
		return new AlarmInfoQueryCondition();
	}
}
