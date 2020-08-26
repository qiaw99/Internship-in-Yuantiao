package com.yuantiao.barrett.bus.changshaDao;

import java.util.List;

import com.yuantiao.barrett.bus.bo.AlarmInfoBo;
import com.yuantiao.barrett.bus.condition.AlarmInfoQueryCondition;

public interface IAlarmInfoDao {
	public List<AlarmInfoBo> selectAll(AlarmInfoQueryCondition queryCondition);
	
	public List<AlarmInfoBo> query(AlarmInfoQueryCondition queryCondition);

	public int queryCount(AlarmInfoQueryCondition queryCondition);
}
