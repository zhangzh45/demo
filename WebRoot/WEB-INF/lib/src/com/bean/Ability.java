package com.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Ability entity. @author MyEclipse Persistence Tools
 */

public class Ability implements java.io.Serializable {

	// Fields

	private Integer abiId;
	private String abiName;
	private Set employees = new HashSet(0);

	// Constructors

	/** default constructor */
	public Ability() {
	}

	/** full constructor */
	public Ability(String abiName, Set employees) {
		this.abiName = abiName;
		this.employees = employees;
	}

	// Property accessors

	public Integer getAbiId() {
		return this.abiId;
	}

	public void setAbiId(Integer abiId) {
		this.abiId = abiId;
	}

	public String getAbiName() {
		return this.abiName;
	}

	public void setAbiName(String abiName) {
		this.abiName = abiName;
	}

	public Set getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set employees) {
		this.employees = employees;
	}

}