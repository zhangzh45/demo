package com.action;



import java.util.Date; 

import com.model.Employee;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.faces.util.Util;


public class LoginAction extends ActionSupport {
	private String name;
	private String password;
	public void addActionError(String anErrorMessage){
		String s=anErrorMessage;
		System.out.println(s);
	}
	
	public void addActionMessage(String aMessage){
		String s=aMessage;
		System.out.println(s);
	}
	
	public void addFieldError(String fieldName,String errorMessage){
		String s=errorMessage;
		String f=fieldName;
		System.out.println(s);
		System.out.println(f);
	}
/*	private Date loginTime;
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}*/
	public String getName() {
		return name;
	} 
	public void setName(String name) {
		this.name = name;
	} 
	public String getPassword() {
		return password;
	} 
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String loginout() {
		ActionContext context = ActionContext.getContext();
		//context.getSession().remove(Constant.LOGIN_TIME);
		//context.getSession().remove(Constant.CURRENT_USER);
		return INPUT;
	}
	//admin login
	public String Identity(){
		if ("admin".equals(name)&&"123456".equals(password)) {
		//	ActionContext context = ActionContext.getContext();
			//initiate time
			//loginTime = Util.formatDateTime(new Date());
			//loginTime = new Date();
			//context.getSession().put(Constant.LOGIN_TIME, loginTime);
			//context.getSession().put(Constant.CURRENT_USER,new User(name,password));
			return SUCCESS;
		}
		else if ("admin1".equals(name)&&"1234561".equals(password)) {
				return INPUT;
			}
		return INPUT;
	}
	

	
}
