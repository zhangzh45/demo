package com.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import com.bean.EmpAccountRelation;
import com.bean.Employee;
import com.bean.Employeecache;
import com.bean.OrgEmpRelation;
import com.bean.Organization;
import com.bean.Page;
import com.bean.SimpleEmployee;
import com.dao.EmployeeDAO;
import com.dao.OrgEmpRelationDAO;
import com.dao.OrganizationDAO;
import com.service.EmpAccountRelationService;
import com.service.EmployeeService;
import com.service.EmployeecacheService;
import com.service.PageService;
import com.util.DESEncryptTools;
import com.util.HttpRequestUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	
	private static final long serialVersionUID = 1L;
	private String ajson;
	private EmployeeDAO employeedao;
	private OrganizationDAO organizationdao;
	private OrgEmpRelationDAO orgemprelationdao;
	public List<Object> empList = new ArrayList<Object>();
	public int treeId;
	static String key = "127.0.0.1"; // des加密的密钥
	private Map<String,List<SimpleEmployee>> simpleEmpMap = new HashMap<String, List<SimpleEmployee>>();
	private EmployeeService employeeservice;
	public EmployeecacheService cacheService;
	public EmpAccountRelationService empaccrelService;
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
	private String gend;
	private String gender;
	private String email;
	private String phone;
	private Integer id;
	
	public String findClient(){
		System.out.println("id:"+id+"\n");
		System.out.println("orgid:"+orgid+"\n");
		return INPUT;
	}

	public String addClient(){
		System.out.println("orgid:"+orgid+"\n");
		boolean added = false; 
		if(id != null){
			Employee list =  employeeservice.findById(id);
			if(list != null){
				added = true;
				clearErrorsAndMessages();
				addActionMessage("请勿重复提交");
				return ERROR;
			}
		}
		if(added == false){
			try{
				Employee empa = new Employee();
				if(id != null){
					empa = employeeservice.findById(id);
					empa.setAge(ag);
					empa.setFirstName(firstname);
					empa.setGender(gend);
					empa.setLastName(lastname);
					empa.setUserId(id);
					empa.setPassword("1234");
					employeeservice.updateEmployee(empa);
				}
				else{
					empa.setAge(ag);
					empa.setFirstName(firstname);
					empa.setGender(gend);
					empa.setLastName(lastname);
					employeeservice.addEmployee(empa);
					id = empa.getEmpId();
					empa.setUserId(id);
					empa.setPassword("1234");
					employeeservice.updateEmployee(empa);
				}
				int oeid = orgid + id;
				Organization orgtrue = new Organization();
				orgtrue = organizationdao.findById(orgid);
				OrgEmpRelation or = new OrgEmpRelation();
				or.setOeid(oeid);
				or.setEmployee(empa);
				or.setOrganization(orgtrue);
				orgemprelationdao.save(or);
				
				//对添加用户操作进行缓存
				Employeecache empCache = new Employeecache();
				empCache.setEmpId(empa.getEmpId());
				empCache.setName(empa.getLastName() + empa.getFirstName());
				empCache.setPassword(empa.getPassword());
				empCache.setOperation("create");
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				empCache.setOperationTime(df.format(new Date()));
				cacheService.save(empCache);
				
			}catch (Exception e) {
				e.printStackTrace();
				clearErrorsAndMessages();
				addActionMessage("添加失败！");
				return ERROR;
			}	
		}
		return SUCCESS;
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
		employee.setAbilities(c.getAbilities());
		employee.setAge(c.getAge());
		employee.setFirstName(c.getFirstName());
		employee.setLastName(c.getLastName());
		employee.setGender(c.getGender());
		employee.setOrganizations(c.getOrganizations());
		employee.setPositions(c.getPositions());
		employee.setPassword(c.getPassword());
		employee.setUserId(c.getUserId());
		return SUCCESS;
	}
	
	public String editClient(){
		return SUCCESS;
	}
	
	public String updateClient(){
		return updateEmployee();
	}
	
	public String updateEmployee(){
		Employee empedit = employeeservice.findById(id);
		String old_firstname = empedit.getFirstName();
		String old_lastname = empedit.getLastName();
		empedit.setAge(ag);
		empedit.setFirstName(firstname);
		empedit.setLastName(lastname);
		empedit.setGender(gend);
		employeeservice.updateEmployee(empedit);
		try {
			//对更新用户操作进行缓存(只有当名字改变时)
			if(!old_firstname.equals(firstname) || !old_lastname.equals(lastname)){
				Employeecache empCache = new Employeecache();
				empCache.setEmpId(empedit.getEmpId());
				empCache.setName(empedit.getLastName() + empedit.getFirstName());
				empCache.setPassword(empedit.getPassword());
				empCache.setOperation("update");
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				empCache.setOperationTime(df.format(new Date()));
				cacheService.save(empCache);
			}
			
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			clearMessages();
			addActionMessage("修改失败！");
			return ERROR;
		}
				
	}
	
	public String deleteEmployee(){
		Employee empdele = new Employee();
		empdele = employeedao.findById(id);
		try {
			List<OrgEmpRelation> oes = new ArrayList<OrgEmpRelation>();
			oes = orgemprelationdao.findByProperty("employee", empdele);
			for(int i = 0; i < oes.size(); i++){
				orgemprelationdao.delete(oes.get(i));
			}
			employeeservice.deleteEmployee(empdele);
			
			//对删除用户操作进行缓存
			Employeecache empCache = new Employeecache();
			empCache.setEmpId(empdele.getEmpId());
			empCache.setName(empdele.getLastName() + empdele.getFirstName());
			empCache.setPassword(empdele.getPassword());
			empCache.setOperation("delete");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			empCache.setOperationTime(df.format(new Date()));
			cacheService.save(empCache);
			
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
	 			json.add(map);
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
	
	public String getAllEmployee() {
		List<Employee> listEmp = employeeservice.findAll();
		List<SimpleEmployee> listSimpleEmp = new ArrayList<SimpleEmployee>();
		if ( listEmp != null && listEmp.size() > 0 ) {
			for ( Employee emp : listEmp ) {
				SimpleEmployee  simpleEmp = new SimpleEmployee();
				simpleEmp.setName(emp.getLastName()+emp.getFirstName());
				simpleEmp.setId(emp.getEmpId());
				String pwd;
				try {
					pwd = DESEncryptTools.encrypt(emp.getPassword(), key);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					pwd = "123456"; // 若加密失败
					e.printStackTrace();
				}
				simpleEmp.setPassword(pwd);
				listSimpleEmp.add(simpleEmp);
			}
			simpleEmpMap.put("employees", listSimpleEmp);
		}
		
		return SUCCESS;
	}

	public String findEmployee(){
		JSONObject empObj = new JSONObject();
		Employee empedit = employeeservice.findById(id);
		empObj.put("id", id);
		empObj.put("firstname", empedit.getFirstName());
		empObj.put("lastname", empedit.getLastName());
		empObj.put("gend", empedit.getGender());
		empObj.put("ag", empedit.getAge());
		ajson = empObj.toString();
		return SUCCESS;
	}
	
	
	public String employeeSynchronize(){
		List<Employeecache> emplist = new ArrayList<Employeecache>();
		emplist = cacheService.OrderByOperationTime();
		for(int i = 0; i < emplist.size(); i++){
			int empid = emplist.get(i).getEmpId();
			Employeecache empcache = emplist.get(i);
			List<Employeecache> formerOperations = cacheService.findByEmpId(empid);
			for(int k = 0; k < formerOperations.size(); k++){
				int fid = formerOperations.get(k).getId(), cid = empcache.getId();
				if(fid == cid){
					formerOperations.remove(k);
					break;
				}
			}
			if(empcache.getOperation().equalsIgnoreCase("delete")){
				for(int j = 0; j < formerOperations.size(); j++){
					if(formerOperations.get(j).getOperation().equalsIgnoreCase("create")){
						//不管，用户被创建后又被删除
						cacheService.deleteByEmpId(empid);
						i = -1;
						emplist = cacheService.OrderByOperationTime();
						break;
					}
					else{
						//最终需要删除这个用户，保留最新的删除记录
						cacheService.delete(formerOperations.get(j));
						j = -1;
						formerOperations = cacheService.findByEmpId(empid);
						formerOperations.remove(empcache);
					}
				}
				
			}
			else if(empcache.getOperation().equalsIgnoreCase("create")){
				//要创建用户，就只有一条创建记录
			}
			else if(empcache.getOperation().equalsIgnoreCase("update")){
				for(int j = 0; j < formerOperations.size(); j++){
					if(formerOperations.get(j).getOperation().equalsIgnoreCase("create")){
						//用最新的信息来创建用户
						empcache.setOperation("create");
						cacheService.update(empcache);
						cacheService.deleteASet(formerOperations);
						i = -1;
						emplist = cacheService.OrderByOperationTime();
						break;
					}
					else{
						//更新用户
						cacheService.delete(formerOperations.get(j));
						j = -1;
						formerOperations = cacheService.findByEmpId(empid);
						formerOperations.remove(empcache);
					}
				}
			}
		}
		System.out.println(cacheService.findAll().size());
		String result = synchronation();
		
		JSONObject res = new JSONObject();
		res.put("result", result);
		ajson = res.toString();
		return SUCCESS;
		
	}
	
	/***
	 * 将用户信息同步到rancher
	 * @return
	 */
	public String synchronation(){
		List<Employeecache> emps = cacheService.findAll();
		for(int i = 0; i < emps.size(); i++){
			Employeecache emp = emps.get(i);
			if(emp.getOperation().equalsIgnoreCase("create")){ //创建rancher账户
				if(createAccount(emp).equalsIgnoreCase(ERROR)){
					return ERROR;
				}
				else{
					cacheService.delete(emp);
					emps = cacheService.findAll();
					i = -1;
				}
			}
			else if(emp.getOperation().equalsIgnoreCase("delete")){ //删除rancher账户
				if(deleteAccount(emp).equalsIgnoreCase(ERROR)){
					return ERROR;
				}
				else{
					cacheService.delete(emp);
					emps = cacheService.findAll();
					i = -1;
				}
			}
			else if(emp.getOperation().equalsIgnoreCase("update")){ //更新rancher账户
				if(updateAccount(emp).equalsIgnoreCase(ERROR)){
					return ERROR;
				}
				else{
					cacheService.delete(emp);
					emps = cacheService.findAll();
					i = -1;
				}
			}
		}
		cacheService.deleteASet(emps);//同步完毕，删除操作缓存数据
		return SUCCESS;
	}
	
	
	/***
	 * 向rancher删除账户
	 * @param emp
	 * @return
	 */
	public String deleteAccount(Employeecache emp){
		List<EmpAccountRelation> list = empaccrelService.findByEmpId(emp.getEmpId());
		if(list.size() > 0){
			//String accountId = searchAccountId(emp.getName());
			String accountId = list.get(0).getAccountId();
			if(accountId != null){
				String accountURL = "http://222.200.180.59:8080/v2-beta/accounts/"+accountId;
				HttpRequestUtils hrutil = new HttpRequestUtils();
				String deactivateURL = accountURL + "?action=deactivate";   //先停用这个账户
				String deactivateResult = hrutil.sendToRancher(deactivateURL, null, "POST", false);
				if(deactivateResult != null){
					//state要为inactive
					while(getAccOrPassState(accountURL) != null && !getAccOrPassState(accountURL).equalsIgnoreCase("inactive")){
						try {
							Thread.sleep(1000); //轮询停用是否成功
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}  
					String deleteResult = hrutil.sendToRancher(accountURL, null, "DELETE", false);//在删除这个账户
					if(deleteResult != null){
						empaccrelService.delete(list.get(0));
						String passid = searchAccPassId(accountId);
						return deleteAccountPass(passid);
					}
				}
			}
		}
		return ERROR;
	}
	
	/***
	 * 向rancher更新账户
	 * @param emp
	 * @return
	 */
	public String updateAccount(Employeecache emp){
		List<EmpAccountRelation> list = empaccrelService.findByEmpId(emp.getEmpId());
		if(list.size() > 0){
			//String accountId = searchAccountId(emp.getName());
			String accountId = list.get(0).getAccountId();
			if(accountId != null){
				String accountURL = "http://222.200.180.59:8080/v2-beta/accounts/"+accountId;
				System.out.println(accountId+";"+accountId.substring(accountId.indexOf("a") + 1));
				HttpRequestUtils hrutil = new HttpRequestUtils();
				JSONObject paramObj = new JSONObject();
				paramObj.put("externalId", accountId.substring(accountId.indexOf("a") + 1));
				paramObj.put("externalIdType", "rancher_id");
				paramObj.put("kind", "user");
				paramObj.put("name", emp.getName());
				String editResult = hrutil.sendToRancher(accountURL, paramObj, "PUT", false); //修改名称
				if(editResult != null){
					String passid = searchAccPassId(accountId);
					System.out.println(passid);
					if(passid != null){
						deleteAccountPass(passid);  //删除原来的用户名和密码
						JSONObject paramObj1 = new JSONObject();
						paramObj1.put("name", emp.getName());
						paramObj1.put("publicValue", emp.getName());
						paramObj1.put("secretValue", emp.getPassword());
						paramObj1.put("accountId", accountId);
						String setAccountURL = "http://222.200.180.59:8080/v2-beta/passwords";
						String setResult = hrutil.sendToRancher(setAccountURL, paramObj1, "POST", false); //设置用户名和密码
						if(setResult != null){
							addActionMessage("更新成功！");
						}
						return SUCCESS;
					}
				}
			}
		}
		return ERROR;
	}
	
	/***
	 * 向rancher添加账户
	 * @param emp
	 * @return
	 */
	public String createAccount(Employeecache emp){
		String createAccountURL = "http://222.200.180.59:8080/v2-beta/accounts";
		JSONObject paramObj = new JSONObject();
		paramObj.put("name", emp.getName());
		paramObj.put("kind", "user");
		HttpRequestUtils hrutil = new HttpRequestUtils();
		String addResult = hrutil.sendToRancher(createAccountURL, paramObj, "POST", false);  //先添加账户
		if(addResult != null){
			JSONObject accountObj = JSONObject.fromObject(addResult);
			String accountId = accountObj.getString("id");
			System.out.println("accountId:"+accountId);
			JSONObject paramObj1 = new JSONObject();
			paramObj1.put("name", emp.getName());
			paramObj1.put("publicValue", emp.getName());
			paramObj1.put("secretValue", emp.getPassword());
			paramObj1.put("accountId", accountId);
			String setAccountURL = "http://222.200.180.59:8080/v2-beta/passwords";
			String setResult = hrutil.sendToRancher(setAccountURL, paramObj1, "POST", false); //设置用户名和密码
			if(setResult != null){
				addActionMessage("添加成功！");
				EmpAccountRelation empaccrel = new EmpAccountRelation();
				empaccrel.setEmpId(emp.getEmpId());
				empaccrel.setAccountId(accountId);
				empaccrelService.save(empaccrel);
				//需要添加环境权限
			}
			else return ERROR;
		}
		else{
			addActionMessage("添加失败！");
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 获取rancher平台上的对应账户id
	 * @param name 账户名字
	 * @return
	 */
	public String searchAccountId(String name){
		String searchAccountURL = "http://222.200.180.59:8080/v2-beta/accounts";
		HttpRequestUtils hrutil = new HttpRequestUtils();
		String searchResult = hrutil.sendToRancher(searchAccountURL, null, "GET", false);
		if(searchResult != null){
			JSONObject accountsObj = JSONObject.fromObject(searchResult);
			String accounts = accountsObj.getString("data");
			JSONArray acoountsArr = JSONArray.fromObject(accounts);
			for(int i = 0; i < acoountsArr.size(); i++){
				JSONObject accountObj = new JSONObject();
				accountObj = (JSONObject) acoountsArr.get(i);
				if(accountObj.getString("name").equals(name)){
					return accountObj.getString("id");
				}
			}
		}
		return null;
	}
	
	/**
	 * 获取账户或其密码的状态
	 * @param url
	 * @return
	 */
	public String getAccOrPassState(String url){
		//String searchAccountURL = "http://222.200.180.59:8080/v2-beta/accounts/" + accountid;
		HttpRequestUtils hrutil = new HttpRequestUtils();
		String searchResult = hrutil.sendToRancher(url, null, "GET", false);
		if(searchResult != null){
			JSONObject accountObj = JSONObject.fromObject(searchResult);
			String state = accountObj.getString("state");
			return state;
		}
		return null;
	}
	
	/**
	 * 删除账户密码
	 * @param passid
	 * @return
	 */
	public String deleteAccountPass(String passid){
		String passURL =  "http://222.200.180.59:8080/v2-beta/passwords/" + passid;
		String deactivatePassURL = passURL  + "/?action=deactivate";
		HttpRequestUtils hrutil = new HttpRequestUtils();
		String deactivateResult = hrutil.sendToRancher(deactivatePassURL, null, "POST", false);
		if(deactivateResult != null){
			//state要为inactive
			while(getAccOrPassState(passURL) != null && !getAccOrPassState(passURL).equalsIgnoreCase("inactive")){
				try {
					Thread.sleep(1000); //轮询停用是否成功
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			String deleteResult = hrutil.sendToRancher(passURL, null, "DELETE", false);//删除
			if(deleteResult != null){
				return SUCCESS;
			}
		}
		return ERROR;
	}
	
	
	/**
	 * 获取账户的密码id
	 * @param accountid
	 * @return
	 */
	public String searchAccPassId(String accountid){
		String searchPassURL = "http://222.200.180.59:8080/v2-beta/passwords";
		HttpRequestUtils hrutil = new HttpRequestUtils();
		String searchResult = hrutil.sendToRancher(searchPassURL, null, "GET", false);
		if(searchResult != null){
			JSONObject passwordsObj = JSONObject.fromObject(searchResult);
			String passwords = passwordsObj.getString("data");
			JSONArray passwordsArr = JSONArray.fromObject(passwords);
			for(int i = 0; i < passwordsArr.size(); i++){
				JSONObject accountObj = new JSONObject();
				accountObj = (JSONObject) passwordsArr.get(i);
				if(accountObj.getString("accountId").equals(accountid)){
					return accountObj.getString("id");
				}
			}
		}
		return null;
	}
	
	// getter setter
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

	public EmployeecacheService getCacheService() {
		return cacheService;
	}

	public void setCacheService(EmployeecacheService cacheService) {
		this.cacheService = cacheService;
	}
	
	public EmpAccountRelationService getEmpaccrelService() {
		return empaccrelService;
	}

	public void setEmpaccrelService(EmpAccountRelationService empaccrelService) {
		this.empaccrelService = empaccrelService;
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
	
	public Map<String, List<SimpleEmployee>> getSimpleEmpMap() {
		return simpleEmpMap;
	}
	public void setSimpleEmpMap(Map<String, List<SimpleEmployee>> simpleEmpMap) {
		this.simpleEmpMap = simpleEmpMap;
	}
	public OrgEmpRelationDAO getOrgemprelationdao() {
		return orgemprelationdao;
	}
	public void setOrgemprelationdao(OrgEmpRelationDAO orgemprelationdao) {
		this.orgemprelationdao = orgemprelationdao;
	}
	
}
