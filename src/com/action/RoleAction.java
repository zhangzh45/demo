package com.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;

import com.model.Page;
import com.model.Role;
import com.service.PageService;
import com.service.RoleService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RoleAction extends ActionSupport implements ModelDriven<Role>,ApplicationAware{
	private RoleService roleService;
	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public RoleService getRoleService() {
		return roleService;
	}


	public Map<String, Object> getApplication() {
		return application;
	}


	public PageService getPageservice() {
		return pageservice;
	}

	private Role role=new Role();
	private Map<String,Object> application;
	private int page;//第几页
	private PageService pageservice;
	private Page pages;//包含分部信息的entry
	private String selectRole;
	private String info;
	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	public String getSelectRole() {
		return selectRole;
	}


	public void setSelectRole(String selectRole) {
		this.selectRole = selectRole;
	}

	public Page getPages() {
		return pages;
	}


	public void setPages(Page pages) {
		this.pages = pages;
	}


	public void setPageservice(PageService pageservice) {
		this.pageservice = pageservice;
	}

	
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.application=application;
		
	}

	public Role getModel() {
		// TODO Auto-generated method stub
		return role;
	}
	
	public String addRole(){
		try {
			roleService.addRole(role);
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		    clearMessages();
		    addActionMessage("添加失败！");
		    return ERROR;
		}
		
	}
	
	public String showAllRole(){
		try {
			 
			 String hql="from Role order by id desc";
			  this.pages=pageservice.queryForPage(hql,5,this.page);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String getAllRoleName(){
		Map<Integer,Role> rl=new HashMap<Integer,Role>(); 
		List<Role> list=roleService.getAllRole();
		for(Role r:list){
			rl.put(r.getRoleId(),r);
		}
		this.application.put("getAllRoleName", rl);
		return SUCCESS;
	}
	
	public String findRoleByName(){
		List<Role> list=roleService.findByRoleName(selectRole);
		this.pages = new Page();
	  	this.pages.setAllRow(1);
	  	this.pages.setCurrentPage(1);
	  	this.pages.setPageSize(1);
	  	this.pages.setTotalPage(1);
	  	this.pages.setList(list);
		return SUCCESS;
	}
	
	public String editRole(){
		Role rl=roleService.findById(role.getRoleId());
		this.role.setRoleName(rl.getRoleName());
		return SUCCESS;
	}
	public String updateRole(){
		try {
			roleService.updateRole(role);
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			clearMessages();
			addActionMessage("修改失败！");
			return ERROR;
		}
		
	}
	public String deleteRole(){
		try {
			Role rl=roleService.findById(role.getRoleId());
			roleService.deleteRole(rl);
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	public String exploreAddRole(){
		return INPUT;
	}
	
	public String checkRoleName(){
		List<Role> list=roleService.findByRoleName(role.getRoleName());
		if(list.size()>0){
			this.info="*职位名已存在！";
		}else{
			this.info="";
		}
		return SUCCESS;
	}
}
