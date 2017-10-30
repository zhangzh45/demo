package com.service.impl;

import java.util.List;

import com.bean.EmpAccountRelation;
import com.bean.Employee;
import com.dao.EmpAccountRelationDAO;
import com.dao.EmployeeDAO;
import com.service.EmpAccountRelationService;

public class EmpAccountRelationServiceImpl implements EmpAccountRelationService{
	
	public EmpAccountRelationDAO empAccountRelationdao;
	
	
	public  EmpAccountRelationDAO getEmpAccountRelationdao() {
		return empAccountRelationdao;
	}
	public void setEmpAccountRelationdao(EmpAccountRelationDAO empAccountRelationdao){
		this.empAccountRelationdao = empAccountRelationdao;
	}

	public void save(EmpAccountRelation empAccountRel){
		empAccountRelationdao.save(empAccountRel);
	}

	public void delete(EmpAccountRelation empAccountRel){
		empAccountRelationdao.delete(empAccountRel);
	}
	
	public void update(EmpAccountRelation empAccountRel){
		empAccountRelationdao.attachDirty(empAccountRel);
	}

	public EmpAccountRelation findById(java.lang.Integer id){
		return empAccountRelationdao.findById(id);
	}

	public List findByEmpId(Object empId){
		return empAccountRelationdao.findByEmpId(empId);
	}

	public List findByAccountId(Object accountId){
		return empAccountRelationdao.findByAccountId(accountId);
	}

	public List findAll(){
		return empAccountRelationdao.findAll();
	}

}
