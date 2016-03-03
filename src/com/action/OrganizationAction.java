package com.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.json.JSONArray;



import com.dao.OrganizationDAO;
import com.model.Organization;

import com.model.Org;
import com.service.OrganizationService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrganizationAction extends ActionSupport implements ModelDriven<Organization>,ApplicationAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  OrganizationService organizationService;
	private  OrganizationDAO organizationdao;
	

	private Organization organization=new Organization();
	private Map<String,Object>application;
	
	private String info;
	private String selectDepart;
	private String treeJson;
	public String getTreeJson() {
		return treeJson;
	}

	public void setTreeJson(String treeJson) {
		this.treeJson = treeJson;
	}

	public String getSelectDepart() {
		return selectDepart;
	}

	public OrganizationService getOrganizationService() {
		System.out.println("getservice");
		return organizationService;
	}
	public void setSelectDepart(String selectDepart) {
		this.selectDepart = selectDepart;
	}


	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.application=application;
	}
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
	public void setOrganizationService(OrganizationService organizationService) {
		System.out.println("setservice");
		this.organizationService = organizationService;
	}
	
	
	public Organization getModel() {
		// TODO Auto-generated method stub
		return this.organization;
	}
	
	public String checkDepartName() throws Exception {
		if(organizationService.isOrgExist(organization.getOrgName())){
		this.info="*�����Ѵ��ڣ�";
		}else{
		this.info="";
		}
		return SUCCESS;
	}
	
	
	
	public String addOrganization() {
		if(organizationService.isOrgExist(organization.getOrgName())){
			clearMessages();
			addActionMessage("what");
			return ERROR;
		}else{
			try {
				organizationService.addOrganization(organization);
				return SUCCESS;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					clearMessages();
					addActionMessage("what");
					return ERROR;
				}
			}
		
	}
	
	public String getAllDepartName(){
		Map<Integer,Organization> depart=new HashMap<Integer, Organization>();
		List<Organization> list=organizationService.getallOrganization();
		for(Organization d:list){
			depart.put(d.getOrgId(), d);
		}
		this.application.put("getAllDepartName", depart);
		return SUCCESS;
		
	}
	
	public String doGetOrgTree() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String sId = request.getParameter("id");
		if(sId!=null&&!"".equals(sId)){
		Integer.parseInt(sId);
		}
		//List<Object> lstPriv = (List<Object>)organizationdao.findByProperty("organization.parentOrgId", treeId);
		List<Organization> lstPriv = organizationService.getallOrganization();

		response.setCharacterEncoding("UTF-8");
		JSONArray json=new JSONArray();
		for (int i = 0; i< lstPriv.size();i++){
 			Organization employee =(Organization) lstPriv.get(i);
 		//	list.add(org);
 		//	 json.put(line);
 			Map<String, String> map=new HashMap<String, String>();
				map.put("id", employee.getOrgId().toString());
				map.put("pId",employee.getParentOrgId().toString());
				map.put("name", employee.getOrgName());
				json.put(map);
		}
		System.out.print(json);
	treeJson=json.toString();
//	treeJson=json;
		//response.getWriter().print(JSONArray.fromObject(list).toString());
		return SUCCESS;
	}
	
	public String editOrganization(){
		Organization dp=organizationService.findById(this.organization.getOrgId());
		this.organization.setOrgName(dp.getOrgName());
		return SUCCESS;
	}
	
	public String updateOrganization(){
		try {
			organizationService.updateOrganization(organization);
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			clearMessages();
			addActionMessage("����ʧ�ܣ�");
			return ERROR;
		}	
	}
	
	public String deleteOrganization(){
		try {
			Organization dp=organizationService.findById(this.organization.getOrgId());
			organizationService.deleteOrganization(dp);
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
			
			return ERROR;
		}
		
		
	}
	
	public String exploreAddDepart(){
		return INPUT;
	}

	public  OrganizationDAO getOrganizationdao() {
		return organizationdao;
	}

	public  void setOrganizationdao(OrganizationDAO organizationdao) {
		this.organizationdao = organizationdao;
	}

}
