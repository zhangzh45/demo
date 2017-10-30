package com.service.impl;

import java.util.List;

import com.bean.Role;
import com.dao.RoleDAO;
import com.service.RoleService;

public class RoleServiceImpl implements RoleService{

	private RoleDAO roledao;
	
	public RoleDAO getRoledao() {
		return roledao;
	}

	public void setRoledao(RoleDAO roledao) {
		this.roledao=roledao;
	}
	
	public void addRole(Role role) {
		roledao.save(role);
	}

	public void updateRole(Role role) {
		roledao.attachDirty(role);
	}

	public void deleteRole(Role role) {
		roledao.delete(role);
	}

	public List findByRoleName(String rolename) {
		return roledao.findByRoleName(rolename);
	}

	public Role findById(int roleid) {
		return roledao.findById(roleid);
	}

	public List<Role> getAllRole(){
		return roledao.findAll();
	}
	
}
