package com.bean;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String roleName;
	private String roleDesc;
	private Set positions = new HashSet(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(String roleName, Set positions) {
		this.roleName = roleName;
		this.positions = positions;
	}
	
	// Property accessors

	public Role(Integer roleId, String roleName, String roleDesc, Set positions) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.positions = positions;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Set getPositions() {
		return this.positions;
	}

	@JSON 
	public void setPositions(Set positions) {
		this.positions = positions;
	}

}