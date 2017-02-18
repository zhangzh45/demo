package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONStringer;
import org.apache.struts2.interceptor.ApplicationAware;



import com.bean.Page;
import com.bean.Role;
import com.service.PageService;
import com.service.RoleService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RoleAction extends ActionSupport implements ModelDriven<Role>,ApplicationAware{
	private RoleService roleService;
	private String roleNames;
	private Map<String,List<Role>> map =new HashMap<String, List<Role>>();

	public Map<String, List<Role>> getMap() {
		return map;
	}


	public void setMap(Map<String, List<Role>> map) {
		this.map = map;
	}


	public String getRoleNames() {
		return roleNames;
	}


	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}


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
	
	/*
	 * 
	 */
//	public String getAllRoles() {
//
//		List<Role> roleList = roleService.getAllRole();
//		
//		JSONArray json = new JSONArray();
//		
//		JSONStringer jsonstr = new JSONStringer();
//		
//		try {
//			
//			jsonstr.object();
//			
//			jsonstr.key("roles");
//			
//			jsonstr.array();
//			
//			for (Role r :roleList) {
//				
//				jsonstr.object();
//				
//				jsonstr.key("name").value(r.getRoleName());
//				
//				jsonstr.endObject();
//				
//			}
//			
//			jsonstr.endArray();
//			
//			jsonstr.endObject();
//			
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		System.out.println(jsonstr);
//		
//		return SUCCESS;
//	}
	
	/*
	 * @method 提供外部访问角色数据
	 * @return 返回json格式的数据
	 *
	 */
	public String getAllRole() {
		List<Role> roleList = roleService.getAllRole();
		List<Role> rl = new ArrayList<Role> ();
		for(Role r : roleList) {
			Role role = new Role();
			role.setRoleId(r.getRoleId());
			role.setRoleName(r.getRoleName());
			rl.add(role);
		}
		map.put("roles",rl);	
		return SUCCESS;
	}
}


