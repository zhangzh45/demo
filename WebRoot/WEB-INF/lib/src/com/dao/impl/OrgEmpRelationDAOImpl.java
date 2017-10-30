package com.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.OrgEmpRelation;
import com.dao.OrgEmpRelationDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrgEmpRelation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bean.OrgEmpRelation
 * @author MyEclipse Persistence Tools
 */

public class OrgEmpRelationDAOImpl extends HibernateDaoSupport implements OrgEmpRelationDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OrgEmpRelationDAOImpl.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.dao.OrgEmpRelationDAO#save(com.model.OrgEmpRelation)
	 */
	public void save(OrgEmpRelation transientInstance) {
		log.debug("saving OrgEmpRelation instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.OrgEmpRelationDAO#delete(com.model.OrgEmpRelation)
	 */
	public void delete(OrgEmpRelation persistentInstance) {
		log.debug("deleting OrgEmpRelation instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.OrgEmpRelationDAO#findById(java.lang.Integer)
	 */
	public OrgEmpRelation findById(java.lang.Integer id) {
		log.debug("getting OrgEmpRelation instance with id: " + id);
		try {
			OrgEmpRelation instance = (OrgEmpRelation) getHibernateTemplate()
					.get("com.dao.OrgEmpRelation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.OrgEmpRelationDAO#findByExample(com.model.OrgEmpRelation)
	 */
	public List findByExample(OrgEmpRelation instance) {
		log.debug("finding OrgEmpRelation instance by example");
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

	/* (non-Javadoc)
	 * @see com.dao.OrgEmpRelationDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding OrgEmpRelation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from OrgEmpRelation as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.OrgEmpRelationDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all OrgEmpRelation instances");
		try {
			String queryString = "from OrgEmpRelation";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.OrgEmpRelationDAO#merge(com.model.OrgEmpRelation)
	 */
	public OrgEmpRelation merge(OrgEmpRelation detachedInstance) {
		log.debug("merging OrgEmpRelation instance");
		try {
			OrgEmpRelation result = (OrgEmpRelation) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.OrgEmpRelationDAO#attachDirty(com.model.OrgEmpRelation)
	 */
	public void attachDirty(OrgEmpRelation instance) {
		log.debug("attaching dirty OrgEmpRelation instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.OrgEmpRelationDAO#attachClean(com.model.OrgEmpRelation)
	 */
	public void attachClean(OrgEmpRelation instance) {
		log.debug("attaching clean OrgEmpRelation instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OrgEmpRelationDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (OrgEmpRelationDAO) ctx.getBean("OrgEmpRelationDAO");
	}
}