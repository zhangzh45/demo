package com.dao;

import java.util.List;

import com.bean.Organization;

public interface OrganizationDAO {

	// property constants
	public static final String ORG_NAME = "orgName";
	public static final String PARENT_ORG_ID = "parentOrgId";

	public abstract boolean isOrgExist(String name);

	public abstract void save(Organization transientInstance);

	public abstract void delete(Organization persistentInstance);

	public abstract Organization findById(java.lang.Integer id);

	public abstract List findByExample(Organization instance);

	public abstract List<Object> findByProperty(String propertyName,
			Object value);

	public abstract List<Object> findByOrgId(String propertyName, Object value);

	public abstract List findByOrgName(Object orgName);

	public abstract List findByParentOrgId(Object parentOrgId);

	public abstract List findAll();

	public abstract Organization merge(Organization detachedInstance);

	public abstract void attachDirty(Organization instance);

	public abstract void attachClean(Organization instance);

}