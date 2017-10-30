package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.EmpAccountRelation;

/**
 * A data access object (DAO) providing persistence and search support for
 * EmpAccountRelation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.dao.EmpAccountRelation
 * @author MyEclipse Persistence Tools
 */

public interface EmpAccountRelationDAO{
	// property constants
	public static final String EMP_ID = "empId";
	public static final String ACCOUNT_ID = "accountId";
	
	public abstract void save(EmpAccountRelation transientInstance);

	public abstract void delete(EmpAccountRelation persistentInstance);

	public abstract EmpAccountRelation findById(java.lang.Integer id);

	public abstract List findByExample(EmpAccountRelation instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByEmpId(Object empId);

	public abstract List findByAccountId(Object accountId);

	public abstract List findAll();

	public abstract EmpAccountRelation merge(EmpAccountRelation detachedInstance);

	public abstract void attachDirty(EmpAccountRelation instance);

	public abstract void attachClean(EmpAccountRelation instance) ;

}