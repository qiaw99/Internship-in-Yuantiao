package com.yuantiao.barrett.bus.camoservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuantiao.barrett.bus.bo.AlarmDeviceInfoBo;
import com.yuantiao.barrett.bus.bo.AlarmMicMonitorBo;
import com.yuantiao.barrett.bus.camodao.AlarmDeviceInfoDao;
import com.yuantiao.barrett.bus.condition.AlarmInfoQueryCondition;

@Service
public class AlarmDeviceInfoServiceImpl implements AlarmDeviceInfoService<AlarmInfoQueryCondition> {
	
	@Autowired
	AlarmDeviceInfoDao alarmDeviceInfoDao;
	
	@Override
	public List<AlarmDeviceInfoBo> selectAllBays(AlarmInfoQueryCondition alarmInfoQueryCondition) {
		return alarmDeviceInfoDao.selectAllBays(alarmInfoQueryCondition);
	}

	@Override
	public List<AlarmMicMonitorBo> selectAllMics(AlarmInfoQueryCondition alarmInfoQueryCondition) {
		return alarmDeviceInfoDao.selectAllMics(alarmInfoQueryCondition);
	}

}
