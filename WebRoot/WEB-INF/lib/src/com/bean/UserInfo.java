package com.bean;

public class UserInfo implements  java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String userPassword;
	private String accessMethodName;
	private String ipAddress;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getAccessMethodName() {
		return accessMethodName;
	}
	public void setAccessMethodName(String accessMethodName) {
		this.accessMethodName = accessMethodName;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	
}
