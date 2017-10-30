package com.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Organization entity. @author MyEclipse Persistence Tools
 */

public class Organization implements java.io.Serializable {

	// Fields

	private Integer orgId;
	private String orgName;
	private Integer parentOrgId;
	private Set positions = new HashSet(0);
	private Set employees = new HashSet(0);

	// Constructors

	/** default constructor */
	public Organization() {
	}

	/** full constructor */
	public Organization(String orgName, Integer parentOrgId, Set positions,
			Set employees) {
		this.orgName = orgName;
		this.parentOrgId = parentOrgId;
		this.positions = positions;
		this.employees = employees;
	}

	// Property accessors

	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Integer getParentOrgId() {
		return this.parentOrgId;
	}

	public void setParentOrgId(Integer parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

	public Set getPositions() {
		return this.positions;
	}

	public void setPositions(Set positions) {
		this.positions = positions;
	}

	public Set getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set employees) {
		this.employees = employees;
	}

}