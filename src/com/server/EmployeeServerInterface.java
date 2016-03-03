package com.server;

public class EmployeeServerInterface {
	public   String getEmpfromrole(int roleid){
		return GetEmpInfo.getEmpfromrole(roleid);
	}
	public String getRoles(){
		return 	GetEmpInfo.getRoles();
	}
	public String getEmployee(int id){
		return GetEmpInfo.getEmployee(id);
	}
}
