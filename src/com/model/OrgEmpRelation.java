package com.model;


/**
 * OrgEmpRelation entity. @author MyEclipse Persistence Tools
 */

public class OrgEmpRelation implements java.io.Serializable {

	// Fields

	private Integer oeid;
	private Organization organization;
	private Employee employee;

	// Constructors

	/** default constructor */
	public OrgEmpRelation() {
	}

	/** minimal constructor */
	public OrgEmpRelation(Integer oeid) {
		this.oeid = oeid;
	}

	/** full constructor */
	public OrgEmpRelation(Integer oeid, Organization organization,
			Employee employee) {
		this.oeid = oeid;
		this.organization = organization;
		this.employee = employee;
	}

	// Property accessors

	public Integer getOeid() {
		return this.oeid;
	}

	public void setOeid(Integer oeid) {
		this.oeid = oeid;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}