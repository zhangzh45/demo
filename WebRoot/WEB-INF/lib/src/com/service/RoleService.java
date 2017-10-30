package com.service;

import java.util.List;

import com.bean.Role;
import com.dao.RoleDAO;
import com.dao.impl.EmployeeDAOImpl;

public interface RoleService {

	public abstract void setRoledao(RoleDAO roledao);
	
	public abstract void addRole(Role role);

	public abstract void updateRole(Role role);
	
	public abstract void deleteRole(Role role);

	public abstract List findByRoleName(String rolename);

	public abstract Role findById(int roleid);
	
	public abstract List<Role> getAllRole();
}
