package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.Employeecache;

/**
 * A data access object (DAO) providing persistence and search support for
 * Employeecache entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.dao.Employeecache
 * @author MyEclipse Persistence Tools
 */

public interface EmployeecacheDAO{
	// property constants
	public static final String EMP_ID = "empId";
	public static final String NAME = "name";
	public static final String PASSWORD = "password";
	public static final String OPERATION = "operation";
	public static final String OPERATION_TIME = "operationTime";

	public abstract void save(Employeecache transientInstance);

	public abstract void delete(Employeecache persistentInstance);

	public abstract Employeecache findById(java.lang.Integer id);

	public abstract List findByExample(Employeecache instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByEmpId(Object empId);

	public abstract List findByName(Object name);

	public abstract List findByPassword(Object password);

	public abstract List findByOperation(Object operation);

	public abstract List findByOperationTime(Object operationTime);

	public abstract List findAll();
	
	public abstract List OrderByOperationTime();
	
	public abstract void deleteByEmpId(int empid);

	public abstract Employeecache merge(Employeecache detachedInstance);

	public abstract void attachDirty(Employeecache instance);

	public abstract void attachClean(Employeecache instance);
}