package com.server;

@javax.jws.WebService(targetNamespace = "http://server.com/", serviceName = "EmployeeServerInterfaceService", portName = "EmployeeServerInterfacePort")
public class EmployeeServerInterfaceDelegate {

	com.server.EmployeeServerInterface employeeServerInterface = new com.server.EmployeeServerInterface();

	public String getEmpfromrole(int roleid) {
		return employeeServerInterface.getEmpfromrole(roleid);
	}

	public String getRoles() {
		return employeeServerInterface.getRoles();
	}

	public String getEmployee(int id) {
		return employeeServerInterface.getEmployee(id);
	}

}