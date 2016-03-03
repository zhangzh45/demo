package com.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.Organization;

/**
 * A data access object (DAO) providing persistence and search support for
 * Organization entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.model.Organization
 * @author MyEclipse Persistence Tools
 */

public class OrganizationDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(OrganizationDAO.class);
	// property constants
	public static final String ORG_NAME = "orgName";
	public static final String PARENT_ORG_ID = "parentOrgId";

	protected void initDao() {
		// do nothing
	}

	public boolean isOrgExist(String name){
		
		String hql="from Organization d where d.OrgName=?";
		List<Organization> list=getHibernateTemplate().find(hql, name);
		if(list.size()>0){
			return true;
		}else{
			return false;
		}
	}
	public void save(Organization transientInstance) {
		log.debug("saving Organization instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Organization persistentInstance) {
		log.debug("deleting Organization instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Organization findById(java.lang.Integer id) {
		log.debug("getting Organization instance with id: " + id);
		try {
			Organization instance = (Organization) getHibernateTemplate().get(
					"com.model.Organization", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Organization instance) {
		log.debug("finding Organization instance by example");
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

	public List<Object> findByProperty(String propertyName, Object value) {
		log.debug("finding Organization instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Organization as model inner join model.employees where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Object> findByOrgId(String propertyName, Object value) {
		log.debug("finding Organization instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Organization as model inner join model.employees where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List findByOrgName(Object orgName) {
		return findByProperty(ORG_NAME, orgName);
	}

	public List findByParentOrgId(Object parentOrgId) {
		return findByProperty(PARENT_ORG_ID, parentOrgId);
	}

	public List findAll() {
		log.debug("finding all Organization instances");
		try {
			String queryString = "from Organization";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Organization merge(Organization detachedInstance) {
		log.debug("merging Organization instance");
		try {
			Organization result = (Organization) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Organization instance) {
		log.debug("attaching dirty Organization instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Organization instance) {
		log.debug("attaching clean Organization instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OrganizationDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (OrganizationDAO) ctx.getBean("OrganizationDAO");
	}
}