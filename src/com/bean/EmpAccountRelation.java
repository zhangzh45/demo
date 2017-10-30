package com.bean;

/**
 * EmpAccountRelation entity. @author MyEclipse Persistence Tools
 */

public class EmpAccountRelation implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer empId;
	private String accountId;

	// Constructors

	/** default constructor */
	public EmpAccountRelation() {
	}

	/** full constructor */
	public EmpAccountRelation(Integer empId, String accountId) {
		this.empId = empId;
		this.accountId = accountId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmpId() {
		return this.empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getAccountId() {
		return this.accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

}