package com.service;

import java.util.List;

import com.bean.Organization;
import com.dao.OrganizationDAO;

public interface OrganizationService {
	
	public abstract void setOrganizationdao(OrganizationDAO organizationdao);

	public abstract void addOrganization(Organization organization);
	
	public abstract void updateOrganization(Organization organization);
	
	public abstract void deleteOrganization(Organization organization);
	
	public abstract  List findByParentOrgId(int parentorgid);
	
	public abstract List findByOrgName(String orgname);
	
	public abstract Organization findById(int organizationid);

	public abstract boolean isOrgExist(String orgname);
	
	public abstract List<Organization>getallOrganization();
}
