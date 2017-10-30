package com.dao;

import java.util.List;

import com.bean.OrgEmpRelation;

public interface OrgEmpRelationDAO {

	public abstract void save(OrgEmpRelation transientInstance);

	public abstract void delete(OrgEmpRelation persistentInstance);

	public abstract OrgEmpRelation findById(java.lang.Integer id);

	public abstract List findByExample(OrgEmpRelation instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract OrgEmpRelation merge(OrgEmpRelation detachedInstance);

	public abstract void attachDirty(OrgEmpRelation instance);

	public abstract void attachClean(OrgEmpRelation instance);

}