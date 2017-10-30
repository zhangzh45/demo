package com.bean;



public class SimplePosition implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8169311810303373889L;
	// Fields

		private Integer id;
		private Integer depId;
		private String depName;
		private Integer roleId;
		private String roleName;
		private Integer empId;
		private String posName;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
	
		public Integer getDepId() {
			return depId;
		}
		public void setDepId(Integer depId) {
			this.depId = depId;
		}
		public String getDepName() {
			return depName;
		}
		public void setDepName(String depName) {
			this.depName = depName;
		}
		
		public Integer getRoleId() {
			return roleId;
		}
		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}
		public Integer getEmpId() {
			return empId;
		}
		public void setEmpId(Integer empId) {
			this.empId = empId;
		}
		public String getPosName() {
			return posName;
		}
		public void setPosName(String posName) {
			this.posName = posName;
		}
		
		public String getRoleName() {
			return roleName;
		}
		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}
		
		
	
	
		

}
