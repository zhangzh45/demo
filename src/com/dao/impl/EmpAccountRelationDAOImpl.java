package com.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.EmpAccountRelation;
import com.dao.EmpAccountRelationDAO;

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

public class EmpAccountRelationDAOImpl extends HibernateDaoSupport implements EmpAccountRelationDAO{
	private static final Logger log = LoggerFactory
			.getLogger(EmpAccountRelationDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(EmpAccountRelation transientInstance) {
		log.debug("saving EmpAccountRelation instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(EmpAccountRelation persistentInstance) {
		log.debug("deleting EmpAccountRelation instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EmpAccountRelation findById(java.lang.Integer id) {
		log.debug("getting EmpAccountRelation instance with id: " + id);
		try {
			EmpAccountRelation instance = (EmpAccountRelation) getHibernateTemplate()
					.get("com.dao.EmpAccountRelation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(EmpAccountRelation instance) {
		log.debug("finding EmpAccountRelation instance by example");
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
		log.debug("finding EmpAccountRelation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from EmpAccountRelation as model where model."
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

	public List findByAccountId(Object accountId) {
		return findByProperty(ACCOUNT_ID, accountId);
	}

	public List findAll() {
		log.debug("finding all EmpAccountRelation instances");
		try {
			String queryString = "from EmpAccountRelation";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EmpAccountRelation merge(EmpAccountRelation detachedInstance) {
		log.debug("merging EmpAccountRelation instance");
		try {
			EmpAccountRelation result = (EmpAccountRelation) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EmpAccountRelation instance) {
		log.debug("attaching dirty EmpAccountRelation instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EmpAccountRelation instance) {
		log.debug("attaching clean EmpAccountRelation instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EmpAccountRelationDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (EmpAccountRelationDAOImpl) ctx.getBean("EmpAccountRelationDAO");
	}
}