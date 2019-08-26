package com.xjwfk.o2o.enumes;

/**
* @ClassName: QueryEnum
* @Description: TODO(这个枚举类是表示查询是否成功)
* @author 白巾川
* @date 2019年8月7日
*/

public enum QueryEnum {
	SUCCESS(true,1, "查询成功"),FAIL(false,0,"查询失败");
	private boolean success;
	private int state;
	private String stateInfo;
	
	private QueryEnum(boolean success,int state, String stateInfo) {
		this.success = success;
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

}
