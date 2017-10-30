package com.bean;

/**
 * Employeecache entity. @author MyEclipse Persistence Tools
 */

public class Employeecache implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer empId;
	private String name;
	private String password;
	private String operation;
	private String operationTime;

	// Constructors

	/** default constructor */
	public Employeecache() {
	}

	/** full constructor */
	public Employeecache(Integer empId, String name, String password,
			String operation, String operationTime) {
		this.empId = empId;
		this.name = name;
		this.password = password;
		this.operation = operation;
		this.operationTime = operationTime;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getOperationTime() {
		return this.operationTime;
	}

	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}
	
	public boolean equals(Employeecache employeecache){
        return this.id == employeecache.id;
    }

}