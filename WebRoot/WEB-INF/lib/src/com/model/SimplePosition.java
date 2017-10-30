package com.model;



public class SimplePosition implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8169311810303373889L;
	// Fields

		private Integer posId;
		private Integer orgId;
		private String orgName;
		private Integer roleId;
		private String roleName;
		private Integer empId;
		private String posName;
		
		public Integer getPosId() {
			return posId;
		}
		public void setPosId(Integer posId) {
			this.posId = posId;
		}
		public Integer getOrgId() {
			return orgId;
		}
		public void setOrgId(Integer orgId) {
			this.orgId = orgId;
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
		
		public String getOrgName() {
			return orgName;
		}
		public void setOrgName(String orgName) {
			this.orgName = orgName;
		}
		
		

}
