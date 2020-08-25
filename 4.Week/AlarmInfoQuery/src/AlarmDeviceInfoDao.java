package com.yuantiao.barrett.bus.camodao;

import java.util.List;

import com.yuantiao.barrett.bus.bo.AlarmDeviceInfoBo;
import com.yuantiao.barrett.bus.bo.AlarmMicMonitorBo;
import com.yuantiao.barrett.bus.condition.AlarmInfoQueryCondition;

public interface AlarmDeviceInfoDao {
	public List<AlarmDeviceInfoBo> selectAllBays(AlarmInfoQueryCondition alarmInfoQueryCondition);

	public List<AlarmMicMonitorBo> selectAllMics(AlarmInfoQueryCondition alarmInfoQueryCondition);
}
