package com.yuantiao.barrett.bus.bo;

/**
 * 报警信息
 * @author Qianli
 *
 */
public class AlarmInfoBo {
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String callTime;

	private String department;

	private String location;

	private String callType;

	public String getCallTime() {
		return callTime;
	}

	public void setCallTime(String callTime) {
		this.callTime = callTime;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	@Override
	public String toString() {
		return "AlarmInfoBo [id=" + id + ", callTime=" + callTime + ", department=" + department + ", location="
				+ location + ", callType=" + callType + "]";
	}

}
