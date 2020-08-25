package com.yuantiao.barrett.bus.camoservice;

import java.util.List;

import com.yuantiao.barrett.bus.bo.AlarmDeviceInfoBo;
import com.yuantiao.barrett.bus.bo.AlarmMicMonitorBo;
import com.yuantiao.barrett.bus.condition.AlarmInfoQueryCondition;
import com.yuantiao.webplatform.core.object.QueryCondition;

public interface AlarmDeviceInfoService <T extends QueryCondition>{
	public List<AlarmDeviceInfoBo> selectAllBays(AlarmInfoQueryCondition alarmInfoQueryCondition);
	
	public List<AlarmMicMonitorBo> selectAllMics(AlarmInfoQueryCondition alarmInfoQueryCondition);
}
