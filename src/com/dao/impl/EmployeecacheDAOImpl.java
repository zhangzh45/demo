package com.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.Employeecache;
import com.dao.EmployeecacheDAO;

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

public class EmployeecacheDAOImpl extends HibernateDaoSupport implements EmployeecacheDAO{
	private static final Logger log = LoggerFactory
			.getLogger(EmployeecacheDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Employeecache transientInstance) {
		log.debug("saving Employeecache instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Employeecache persistentInstance) {
		log.debug("deleting Employeecache instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Employeecache findById(java.lang.Integer id) {
		log.debug("getting Employeecache instance with id: " + id);
		try {
			Employeecache instance = (Employeecache) getHibernateTemplate()
					.get("com.dao.Employeecache", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Employeecache instance) {
		log.debug("finding Employeecache instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Employeecache instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Employeecache as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEmpId(Object empId) {
		return findByProperty(EMP_ID, empId);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByOperation(Object operation) {
		return findByProperty(OPERATION, operation);
	}

	public List findByOperationTime(Object operationTime) {
		return findByProperty(OPERATION_TIME, operationTime);
	}

	public List findAll() {
		log.debug("finding all Employeecache instances");
		try {
			String queryString = "from Employeecache";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Employeecache merge(Employeecache detachedInstance) {
		log.debug("merging Employeecache instance");
		try {
			Employeecache result = (Employeecache) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Employeecache instance) {
		log.debug("attaching dirty Employeecache instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Employeecache instance) {
		log.debug("attaching clean Employeecache instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EmployeecacheDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (EmployeecacheDAOImpl) ctx.getBean("EmployeecacheDAO");
	}

	public List OrderByOperationTime(){
		String hql="select distinct empcache from Employeecache empcache order by empcache.operationTime desc";
		return getHibernateTemplate().find(hql);
	}

	public void deleteByEmpId(int empid) {
		List<Employeecache> emplist = findByEmpId(empid);
		for(int i = 0; i < emplist.size(); i++){
			delete(emplist.get(i));
		}
	}
}