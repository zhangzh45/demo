package com.service;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.Employeecache;
import com.dao.EmployeecacheDAO;


public interface EmployeecacheService{

	public abstract EmployeecacheDAO getCacheDAO();

	public abstract void setCacheDAO(EmployeecacheDAO cacheDAO);
	
	public abstract void save(Employeecache empCache);

	public abstract void delete(Employeecache empCache);
	
	public abstract void update(Employeecache empCache);

	public abstract Employeecache findById(Integer id);

	public abstract List findByEmpId(Object empId);

	public abstract List findByName(Object name);

	public abstract List findByPassword(Object password);

	public abstract List findByOperation(Object operation);

	public abstract List findByOperationTime(Object operationTime);
	
	public abstract List findAll();
	
	public abstract List OrderByOperationTime();
	
	public abstract void deleteByEmpId(int empid);
	
	public abstract void deleteASet(List<Employeecache> cacheset);

}