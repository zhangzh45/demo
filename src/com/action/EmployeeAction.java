package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import com.dao.EmployeeDAO;
import com.dao.OrgEmpRelationDAO;
import com.dao.OrganizationDAO;
import com.model.Employee;
import com.model.OrgEmpRelation;
import com.model.Organization;
import com.model.Page;
import com.service.EmployeeService;
import com.service.OrganizationService;
import com.service.PageService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{

	public List<Object> empList = new ArrayList<Object>();
	private String ajson;
	public int treeId;
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeedao;
	private OrganizationDAO organizationdao;
	private OrgEmpRelationDAO orgemprelationdao;
	public OrgEmpRelationDAO getOrgemprelationdao() {
		return orgemprelationdao;
	}
	public void setOrgemprelationdao(OrgEmpRelationDAO orgemprelationdao) {
		this.orgemprelationdao = orgemprelationdao;
	}


	private EmployeeService employeeservice;
	private int page;
	private Page pages;
	private PageService pageservice;
	private String info;
	private Employee employee=new Employee();
	private String firstname;
	private String lastname;
	private String age;
	private int ag;
	private int orgid;
	public int getOrgid() {
		return orgid;
	}
	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}
	public int getAg() {
		return ag;
	}
	public void setAg(int ag) {
		this.ag = ag;
	}


	private String gend;
	public String getGend() {
		return gend;
	}
	public void setGend(String gend) {
		this.gend = gend;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}


	private String gender;
	private Integer id;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int gettreeId() {
		return treeId;
	}
	public void settreeId(int treeId) {
		this.treeId = treeId;
	}
	public OrganizationDAO getOrganizationdao() {
		return organizationdao;
	}
	public void setOrganizationdao(OrganizationDAO organizationdao) {
		this.organizationdao = organizationdao;
	}
	public EmployeeDAO getEmployeedao() {
		System.out.println("getdao");
		return employeedao;
	}
	public void setEmployeedao(EmployeeDAO employeedao) {
		this.employeedao = employeedao;
	}
	
	public EmployeeService getEmployeeservice() {
		return employeeservice;
	}
	public void setEmployeeservice(EmployeeService employeeservice) {
		this.employeeservice = employeeservice;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
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
	public String exploreAddClient(){
		return INPUT;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	public String getAjson() {
		return ajson;
	}
	public void setAjson(String ajson) {
		this.ajson = ajson;
	}
	public List<Object> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Object> empList) {
		this.empList = empList;
	}
	public String addClient(){
		Employee list =  employeeservice.findById(id);
		if(list != null){
			clearErrorsAndMessages();
			addActionMessage("请勿重复提交");
			return ERROR;
		}else{
		try {
			int oeid = orgid + id;
			Employee empa = new Employee();
			empa.setAge(ag);
			empa.setFirstName(firstname);
			empa.setGender(gend);
			empa.setLastName(lastname);
			empa.setEmpId(id);
			employeeservice.addEmployee(empa);
			Organization orgtrue = new Organization();
			orgtrue = organizationdao.findById(orgid);
			OrgEmpRelation or = new OrgEmpRelation();
			or.setOeid(oeid);
			or.setEmployee(empa);
			or.setOrganization(orgtrue);
			orgemprelationdao.save(or);
			return SUCCESS;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			clearErrorsAndMessages();
			addActionMessage("添加失败！");
			return ERROR;
		}
		}
		}	
	
	public String addEmployee(int  empId){
		Employee list=employeeservice.findById(empId);
		if(list!= null){
			clearMessages();
			addActionMessage("employee added");
			return ERROR;
		}else{
		try {
			
			employeeservice.addEmployee(employee);
			return SUCCESS;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			clearMessages();
			addActionMessage("exception");
			return ERROR;
		}
		}		
	}
	
	public String showAllEmployee(){
		try {
			 String hql="from Employee order by customerId desc";
			  this.pages=pageservice.queryForPage(hql,5,this.page);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		  
		  return SUCCESS;
	}
	
	public String findById(){
		Employee list=employeeservice.findById(employee.getEmpId());
		this.pages = new Page();
	  	this.pages.setAllRow(1);
	  	this.pages.setCurrentPage(1);
	  	this.pages.setPageSize(1);
	  	this.pages.setTotalPage(1);
		return SUCCESS;
	}
	
	
	public String exploreAddEmployee(){
		return INPUT;
	}

	public String editEmployee(){
		Employee c=employeeservice.findById(employee.getEmpId());
		employee.setEmpId(c.getEmpId());
		employee.setabilities(c.getabilities());
		employee.setAge(c.getAge());
		employee.setFirstName(c.getFirstName());
		employee.setLastName(c.getLastName());
		employee.setGender(c.getGender());
		employee.setorganizations(c.getorganizations());
		employee.setpositions(c.getpositions());
		employee.setPassword(c.getPassword());
		employee.setUserId(c.getUserId());
		return SUCCESS;
	}
	
public String editClient(){
		
		return SUCCESS;
	}
	
	public String updateEmployee(){
		Employee empedit = employeeservice.findById(id);
		empedit.setAge(ag);
		empedit.setFirstName(firstname);
		empedit.setLastName(lastname);
		empedit.setGender(gend);
		try {
			employeeservice.updateEmployee(empedit);
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			clearMessages();
			addActionMessage("ds");
			return ERROR;
		}
				
	}
	
	public String deleteEmployee(){
		Employee empdele = new Employee();
		empdele = employeedao.findById(id);
		try {
			employeeservice.deleteEmployee(empdele);
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ERROR;
		}
			
	}
	
	public  String getEmpfromorg(){
			int id=this.treeId;
			//Organization org;
			JSONArray json=new JSONArray();
		  List<Object>  org =  organizationdao.findByProperty("id",id);
		    for (int i=0;i<org.size();i++){
		    	Map<String, String> map=new HashMap<String, String>();
		    	Object[] o=(Object[]) org.get(i);
	 			Employee empl =(Employee) o[1];
	 			empList.add(empl);
	 			map.put("id", empl.getEmpId().toString());
	 			map.put("firstname", empl.getFirstName());
	 			map.put("lastname", empl.getLastName());
	 			map.put("gender", empl.getGender());
	 			map.put("age", empl.getAge().toString());
	 			json.put(map);
		    }
		     ajson=json.toString();
			return SUCCESS;
		}
		
	
	public String checkIdentityId(){
		Employee list=employeeservice.findById(employee.getEmpId());
		if(list!=null){
			this.info="ss";
		}else{
			this.info="checkindentityid";
		}
		return SUCCESS;
	}
}
