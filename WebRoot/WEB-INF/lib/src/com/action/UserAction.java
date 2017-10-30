package com.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;



import com.bean.Employee;
import com.bean.User;
import com.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<Employee>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private UserDAO userdao;
	private String ajson;
	public String getAjson() {
		return ajson;
	}
	public void setAjson(String ajson) {
		this.ajson = ajson;
	}
	public UserDAO getUserdao() {
		return userdao;
	}
	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	public String addUser(){
		try {
			User users = userdao.findById(username);
			if(users==null){
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			userdao.save(u);
			return SUCCESS;}
			else{return ERROR;}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			clearErrorsAndMessages();
			addActionMessage("���ʧ�ܣ�");
			return ERROR;
		}
		}
	public String deleteUser(){
		User user = new User();
		user = userdao.findById(username);
		try {
			userdao.delete(user);
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ERROR;
		}			
	}
	public String exploreAddUser(){
		return INPUT;
	}
	public String showUsers(){
		JSONArray json=new JSONArray();
		List <User> users = userdao.findAll(); 
	    for (int i=0;i<users.size();i++){
	    	Map<String, String> map=new HashMap<String, String>();
	    	User u= users.get(i);
 			map.put("username", u.getUsername());
 			map.put("password", u.getPassword());
 			json.put(map);
	    }
	     ajson=json.toString();
		return SUCCESS;
	}
	
	public String userKind(){
		return INPUT;
	}
	
	public Employee getModel() {
		// TODO Auto-generated method stub
		return null;
	}
}
