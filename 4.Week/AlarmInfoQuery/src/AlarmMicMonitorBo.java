package com.yuantiao.barrett.bus.bo;

public class AlarmMicMonitorBo {
	private String result;

	private String roadName;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	@Override
	public String toString() {
		return "AlarmMicMonitorBo [result=" + result + ", roadName=" + roadName + "]";
	}

}
