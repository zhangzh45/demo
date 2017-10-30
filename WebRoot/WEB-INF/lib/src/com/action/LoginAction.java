package com.action;



import java.util.Date; 

import com.bean.Employee;
import com.bean.Organization;
import com.bean.Position;
import com.bean.Role;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.EmployeeService;
import com.service.OrganizationService;
import com.service.PositionService;
import com.service.RoleService;
import com.sun.faces.util.Util;


public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String password;
    private EmployeeService employeeservice;
	private OrganizationService organService;
    private RoleService roleService;
    private PositionService positionService;
    
    public OrganizationService getOrganService() {
 		return organService;
 	}

 	public void setOrganService(OrganizationService organService) {
 		this.organService = organService;
 	}

 	public RoleService getRoleService() {
 		return roleService;
 	}

 	public void setRoleService(RoleService roleService) {
 		this.roleService = roleService;
 	}

 	public PositionService getPositionService() {
 		return positionService;
 	}

 	public void setPositionService(PositionService positionService) {
 		this.positionService = positionService;
 	}
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public EmployeeService getEmployeeservice() {
		return employeeservice;
	}

	public void setEmployeeservice(EmployeeService employeeservice) {
		this.employeeservice = employeeservice;
	}

	public void addActionError(String anErrorMessage){
		String s=anErrorMessage;
		System.out.println(s);
	}
	
	public void addActionMessage(String aMessage){
		String s=aMessage;
		System.out.println(s);
	}
	
	public void addFieldError(String fieldName,String errorMessage){
		String s=errorMessage;
		String f=fieldName;
		System.out.println(s);
		System.out.println(f);
	}
/*	private Date loginTime;
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}*/

	public String getPassword() {
		return password;
	} 
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String loginout() {
		ActionContext context = ActionContext.getContext();
		//context.getSession().remove(Constant.LOGIN_TIME);
		//context.getSession().remove(Constant.CURRENT_USER);
		return INPUT;
	}
	//admin login
	public String Identity(){			
		Employee emp = employeeservice.findById(2);
		emp.setFirstName("yu");
		emp.setLastName("liao");
		//employeeservice.updateEmployee(emp);
		
	 /*  employeeservice.updateEmployee(emp);
		employeeservice.deleteEmployee(emp);
	  Organization organ = new Organization();
		organ.setOrgId(8);
		organ.setOrgName("产品部");
		organ.setParentOrgId(5);
		organService.addOrganization(organ); */
	    Role  role = new Role();
	    role.setRoleName("产品经理");
	    roleService.addRole(role);
	  
	    Position pos = positionService.findById(4);
	    pos.setPosName("管理岗M2");
	   // positionService.updatePosition(pos);
		return SUCCESS;
	}
	
	//admin login
		public String Identity2(){			
			Employee emp = employeeservice.findById(id);
			if( emp.getPassword().equals(password)) {
				return SUCCESS;
			} else {
				return INPUT;
			}
		}
	

	
}
