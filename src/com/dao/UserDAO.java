package com.dao;

import java.util.List;

import com.bean.User;

public interface UserDAO {

	// property constants
	public static final String PASSWORD = "password";

	public abstract void save(User transientInstance);

	public abstract void delete(User persistentInstance);

	public abstract User findById(java.lang.String id);

	public abstract List findByExample(User instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByPassword(Object password);

	public abstract List findAll();

	public abstract User merge(User detachedInstance);

	public abstract void attachDirty(User instance);

	public abstract void attachClean(User instance);

}