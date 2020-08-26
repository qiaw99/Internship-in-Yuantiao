package com.yuantiao.barrett.bus.service;

import java.util.List;

import com.yuantiao.barrett.bus.bo.AlarmInfoBo;
import com.yuantiao.barrett.bus.condition.AlarmInfoQueryCondition;
import com.yuantiao.webplatform.core.object.QueryCondition;

public interface AlarmInfoService<T extends QueryCondition> {
	public List<AlarmInfoBo> selectAll(AlarmInfoQueryCondition queryCondition);
	
	public List<AlarmInfoBo> query(T queryCondition);

	public int queryCount(AlarmInfoQueryCondition queryCondition);
}
