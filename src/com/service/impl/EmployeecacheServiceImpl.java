package com.service.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.Employeecache;
import com.dao.EmployeeDAO;
import com.dao.EmployeecacheDAO;
import com.service.EmployeecacheService;


public class EmployeecacheServiceImpl implements EmployeecacheService{
	private EmployeecacheDAO cacheDAO;

	public EmployeecacheDAO getCacheDAO() {
		return cacheDAO;
	}

	public void setCacheDAO(EmployeecacheDAO cacheDAO) {
		this.cacheDAO = cacheDAO;
	}

	public void save(Employeecache empCache){
		cacheDAO.save(empCache);
	}

	public void delete(Employeecache empCache){
		cacheDAO.delete(empCache);
	}
	
	public void update(Employeecache empCache){
		cacheDAO.attachDirty(empCache);
	}

	public Employeecache findById(Integer id){
		return cacheDAO.findById(id);
	}

	public List findByEmpId(Object empId){
		return cacheDAO.findByEmpId(empId);
	}

	public List findByName(Object name){
		return cacheDAO.findByName(name);
	}

	public List findByPassword(Object password){
		return cacheDAO.findByPassword(password);
	}

	public List findByOperation(Object operation){
		return cacheDAO.findByOperation(operation);
	}

	public List findByOperationTime(Object operationTime){
		return cacheDAO.findByOperationTime(operationTime);
	}

	public List findAll() {
		return cacheDAO.findAll();
	}

	public List OrderByOperationTime() {
		return cacheDAO.OrderByOperationTime();
	}

	public void deleteByEmpId(int empid){
		cacheDAO.deleteByEmpId(empid);
	}

	public void deleteASet(List<Employeecache> cacheset) {
		if(cacheset != null){
			for(int i = 0; i < cacheset.size(); i++){
				cacheDAO.delete(cacheset.get(i));
			}
		}
	}
}