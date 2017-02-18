package com.bean;

public class Department {
	
	private String depId;
	private String depName;
	private String parentDepId;
	
	public String getDepId() {
		return depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getParentDepId() {
		return parentDepId;
	}
	public void setParentDepId(String parentDepId) {
		this.parentDepId = parentDepId;
	}
}
