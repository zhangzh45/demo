package com.service;

import java.util.List;

import com.dao.EmployeeDAO;
import com.dao.RoleDAO;
import com.model.Role;

public interface RoleService {

	public abstract void setRoledao(RoleDAO roledao);
	
	public abstract void addRole(Role role);

	public abstract void updateRole(Role role);
	
	public abstract void deleteRole(Role role);

	public abstract List findByRoleName(String rolename);

	public abstract Role findById(int roleid);
	
	public abstract List<Role> getAllRole();
}
