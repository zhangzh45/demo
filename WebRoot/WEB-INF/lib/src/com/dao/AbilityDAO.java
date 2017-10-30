package com.dao;

import java.util.List;

import com.bean.Ability;

public interface AbilityDAO {

	// property constants
	public static final String ABI_NAME = "abiName";

	public abstract void save(Ability transientInstance);

	public abstract void delete(Ability persistentInstance);

	public abstract Ability findById(java.lang.Integer id);

	public abstract List findByExample(Ability instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByAbiName(Object abiName);

	public abstract List findAll();

	public abstract Ability merge(Ability detachedInstance);

	public abstract void attachDirty(Ability instance);

	public abstract void attachClean(Ability instance);

}