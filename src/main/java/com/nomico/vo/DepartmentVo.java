package com.nomico.vo;

import java.io.Serializable;

public class DepartmentVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 534886861976361772L;
	private Integer start; //从第多少条开始
	private Integer length; //取多少条
	private String deptname;
	private Integer state;
	private String startTime;
	private String endTime;
	

	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	

}
