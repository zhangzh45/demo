package com.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.Ability;

/**
 * A data access object (DAO) providing persistence and search support for
 * Ability entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.Ability
 * @author MyEclipse Persistence Tools
 */

public class AbilityDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(AbilityDAO.class);
	// property constants
	public static final String ABI_NAME = "abiName";

	protected void initDao() {
		// do nothing
	}

	public void save(Ability transientInstance) {
		log.debug("saving Ability instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Ability persistentInstance) {
		log.debug("deleting Ability instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ability findById(java.lang.Integer id) {
		log.debug("getting Ability instance with id: " + id);
		try {
			Ability instance = (Ability) getHibernateTemplate().get(
					"com.bean.Ability", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Ability instance) {
		log.debug("finding Ability instance by example");
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
		log.debug("finding Ability instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Ability as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAbiName(Object abiName) {
		return findByProperty(ABI_NAME, abiName);
	}

	public List findAll() {
		log.debug("finding all Ability instances");
		try {
			String queryString = "from Ability";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Ability merge(Ability detachedInstance) {
		log.debug("merging Ability instance");
		try {
			Ability result = (Ability) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Ability instance) {
		log.debug("attaching dirty Ability instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ability instance) {
		log.debug("attaching clean Ability instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AbilityDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AbilityDAO) ctx.getBean("AbilityDAO");
	}
}