package com.server;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;

import com.action.EmployeeAction;
import com.bean.Employee;
import com.bean.Position;
import com.bean.Role;
import com.dao.PositionDAO;
import com.dao.RoleDAO;
import com.service.EmployeeService;
import com.service.impl.EmployeeServiceImpl;


public class GetEmpInfo {
	private  static RoleDAO roledao;
	private  static PositionDAO positiondao;
	private  static EmployeeService employeeservice;

	public  RoleDAO getRoledao() {
		return roledao;
	}
	public  void setRoledao(RoleDAO roledao) {
		GetEmpInfo.roledao = roledao;
	} 
	public  PositionDAO getPositiondao() {
		return positiondao;
	}
	public  void setPositiondao(PositionDAO positiondao) {
		  this.positiondao = positiondao;
	}
	public  EmployeeService getEmployeeservice() {
		return employeeservice;
	}
	public  void setEmployeeservice(EmployeeService employeeservice) {
		GetEmpInfo.employeeservice = employeeservice;
	}
	
	/*
	 * 测试
	 */
//	public String  test(){
//	    String s=getEmployee(1);
//	    positiondao.findByEmpId(1);
//		getEmpfromrole(12);
//		return s;
//	}
	/*
	 * @method 根据角色获取对应的职员
	 * @roleId 为角色ID
	 * @return 返回职员列表
	 */
	public static  String getEmpfromrole(int roleid){
		try {
		List<Object> position = (List<Object>)positiondao.findByProperty("role.roleId", roleid);
		JSONArray json=new JSONArray();
		for (int i = 0; i< position.size();i++){
			Object[] o=(Object[]) position.get(i);
 			Employee employee =(Employee) o[1];
 				Map<String, String> map=new HashMap<String, String>();
 				map.put("empId", employee.getEmpId().toString());
 				map.put("empFirstName",employee.getFirstName());
 				map.put("empLastName", employee.getLastName());
 				map.put("userId", employee.getUserId().toString());
 				json.put(map);
		}
		return json.toString();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
		
	}
	
	/*
	 * @mehtod 获取所有角色
	 * @return 将角色对象转成json数据格式返回
	 */
	public static String getRoles(){
		List<Role> role = roledao.findAll();
		JSONArray json=new JSONArray();
 		for (int i=0; i<role.size();i++){
 			Map<String, String> map=new HashMap<String, String>();
 			map.put("roleid", role.get(i).getRoleId().toString());
 			map.put("rolename", role.get(i).getRoleName());
 			json.put(map);
 		}
 		return json.toString();
	}
	
	/*
	 * @method 查找指定的员工信息
	 * @arg id ：员工的ID
	 * @return 将员工具体信息转成json格式返回
	 */
	public static String getEmployee(int id){
    	  Employee emp=employeeservice.findById(id);
    	  JSONArray json=new JSONArray();
   		  Map<String, String> map=new HashMap<String, String>();
   		  map.put("empid", emp.getEmpId().toString());
   		  map.put("FirstName", emp.getFirstName());
   		  map.put("LastName", emp.getLastName());
   		  json.put(map);  
   		  return json.toString();
    }
	
	/*
	 * @mehtod 登录验证 
	 * @args userId：用户ID
	 * @return String 用户的登录密码
	 */
	public static String getPassword(int userId) {
		Employee emp=employeeservice.findById(userId);
		if (emp == null) return null;
		String password;
		password = emp.getPassword();
		return password;
		
	}
}
