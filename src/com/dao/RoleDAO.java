package com.dao;

import java.util.List;

import com.bean.Role;

public interface RoleDAO {

	// property constants
	public static final String ROLE_NAME = "roleName";

	public abstract void save(Role transientInstance);

	public abstract void delete(Role persistentInstance);

	public abstract Role findById(java.lang.Integer id);

	public abstract List findByExample(Role instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByRoleName(Object roleName);

	public abstract List findAll();

	public abstract Role merge(Role detachedInstance);

	public abstract void attachDirty(Role instance);

	public abstract void attachClean(Role instance);

}