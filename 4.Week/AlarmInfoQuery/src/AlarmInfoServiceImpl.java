package com.yuantiao.barrett.bus.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuantiao.barrett.bus.bo.AlarmInfoBo;
import com.yuantiao.barrett.bus.changshaDao.IAlarmInfoDao;
import com.yuantiao.barrett.bus.condition.AlarmInfoQueryCondition;

@Service
public class AlarmInfoServiceImpl implements AlarmInfoService<AlarmInfoQueryCondition> {

	private static final Logger logger = LoggerFactory.getLogger(AlarmInfoServiceImpl.class);
	
	@Autowired
	IAlarmInfoDao alarmInfoDao;
	
	@Override
	public List<AlarmInfoBo> query(AlarmInfoQueryCondition queryCondition) {
		return null;
	}

	@Override
	public int queryCount(AlarmInfoQueryCondition queryCondition) {
		return alarmInfoDao.queryCount(queryCondition);
	}

	@Override
	public void insert(AlarmInfoBo alarmInfoBo) {
		
	}

	@Override
	public List<AlarmInfoBo> findOperationInfo(AlarmInfoQueryCondition queryCondition) {
		return null;
	}

	@Override
	public void updateUserOperation(AlarmInfoBo updateBo) {		
		
	}

	@Override
	public List<AlarmInfoBo> findAllUntreatedRecords(AlarmInfoQueryCondition queryCondition) {
		return null;
	}

	@Override
	public List<AlarmInfoBo> selectAll(AlarmInfoQueryCondition queryCondition) {
		return alarmInfoDao.selectAll(queryCondition);
	}
	
	@Override
	public void unifiedPrepareHandleUserOperationRecord(String username, String currentDateTime, 
			AlarmInfoQueryCondition queryCondition) {
		List<AlarmInfoBo> allUntreatedRecords = findAllUntreatedRecords(queryCondition);
		
    	if (allUntreatedRecords != null) {
    		for(AlarmInfoBo untreatedRecord : allUntreatedRecords){
				//String loginTime = DateUtil.minusDate(untreatedRecord.getStartTime(), currentDateTime);
				AlarmInfoBo updateBo = new AlarmInfoBo();
				updateBo.setId(untreatedRecord.getId());
				
				//获得当前时间
				updateBo.setCallTime(currentDateTime);
				
				SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				updateBo.setCallTime(dFormat.format(new Date()));
				
				
				updateBo.setCallType(untreatedRecord.getCallType());
				updateBo.setDepartment(untreatedRecord.getDepartment());
				updateBo.setLocation(untreatedRecord.getLocation());
				
//					if (!StringUtils.isEmpty(username)) 
//						updateBo.setUserName(username);
//					updateBo.setStartTime(untreatedRecord.getStartTime());
//					updateBo.setEndTime(currentDateTime);
//					updateBo.setLoginTime(loginTime);
				// 更新
				updateUserOperation(updateBo);
        	}
    	} 
	}

}
