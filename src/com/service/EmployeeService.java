package com.service;

import java.util.List;
import com.dao.EmployeeDAO;
import com.model.Employee;

public interface EmployeeService {
	
	public abstract EmployeeDAO getEmployeedao();
	
	public abstract void setEmployeedao(EmployeeDAO employeedao);

	public abstract void addEmployee(Employee employee);

	public abstract void updateEmployee(Employee employee);
	
	public abstract void deleteEmployee(Employee employee);
	
	public abstract List findByAge(String age);
	
	public abstract List findByGender(String gender);
	
	public abstract List findByUserId(int userid);
	
	public abstract Employee findById(int employeeid);
}
