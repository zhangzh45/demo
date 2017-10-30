package com.dao;

import java.util.List;

import com.bean.Position;

public interface PositionDAO {

	// property constants
	public static final String EMP_ID = "empId";
	public static final String PRIVILEGE = "privilege";
	public static final String POS_NAME = "posName";

	public abstract void save(Position transientInstance);

	public abstract void delete(Position persistentInstance);

	public abstract Position findById(java.lang.Integer id);

	public abstract List findByExample(Position instance);

	public abstract List<Object> findByProperty(String propertyName,
			Object value);

	public abstract List findByRoleId(String propertyName, Object value);

	public abstract List findByEmpId(Object empId);

	public abstract List findByPrivilege(Object privilege);

	public abstract List findByPosName(Object posName);

	public abstract List findAll();

	public abstract Position merge(Position detachedInstance);

	public abstract void attachDirty(Position instance);

	public abstract void attachClean(Position instance);

	public abstract List<Object[]> getPositions();

}