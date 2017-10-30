package com.service;

import java.util.List;

import com.bean.EmpAccountRelation;
import com.bean.Employee;
import com.dao.EmpAccountRelationDAO;
import com.dao.EmployeeDAO;

public interface EmpAccountRelationService {
	
	public abstract EmpAccountRelationDAO getEmpAccountRelationdao();
	
	public abstract void setEmpAccountRelationdao(EmpAccountRelationDAO empAccountRelationdao);

	public abstract void save(EmpAccountRelation empAccountRel);

	public abstract void delete(EmpAccountRelation empAccountRel);
	
	public abstract void update(EmpAccountRelation empAccountRel);

	public abstract EmpAccountRelation findById(java.lang.Integer id);

	public abstract List findByEmpId(Object empId);

	public abstract List findByAccountId(Object accountId);

	public abstract List findAll();

}
