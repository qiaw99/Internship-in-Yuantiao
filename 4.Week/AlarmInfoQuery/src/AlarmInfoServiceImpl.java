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
		logger.info("" + alarmInfoDao.queryCount(queryCondition));
		return alarmInfoDao.queryCount(queryCondition);
	}

	@Override
	public List<AlarmInfoBo> selectAll(AlarmInfoQueryCondition queryCondition) {
		return alarmInfoDao.selectAll(queryCondition);
	}
}
