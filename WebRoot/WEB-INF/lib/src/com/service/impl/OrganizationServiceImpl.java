package com.service.impl;

import java.util.List;

import com.bean.Organization;
import com.dao.OrganizationDAO;
import com.service.OrganizationService;

public class OrganizationServiceImpl implements OrganizationService{

	private OrganizationDAO organizationdao;
	
	public OrganizationDAO getOrganizationdao() {
		return organizationdao;
	}

	public void setOrganizationdao(OrganizationDAO organizationdao) {
		this.organizationdao=organizationdao;
	}

	public void addOrganization(Organization organization) {
		organizationdao.save(organization);
	}

	public void updateOrganization(Organization organization) {
		organizationdao.attachDirty(organization);
	}

	public void deleteOrganization(Organization organization) {
		organizationdao.delete(organization);
	}

	public List findByParentOrgId(int parentorgid) {
		return organizationdao.findByParentOrgId(parentorgid);
	}

	public List findByOrgName(String orgname) {
		return organizationdao.findByOrgName(orgname);
	}

	public Organization findById(int organizationid) {
		return organizationdao.findById(organizationid);
	}

	public boolean isOrgExist(String orgname) {
		return organizationdao.isOrgExist(orgname);
	}

	public List<Organization>getallOrganization(){
		   return organizationdao.findAll();
	}
}
