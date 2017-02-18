package com.bean;

public class Org {


		private Integer id;
		private String orgName;
		private Integer parentOrgId;

		// Constructors

		/** default constructor */
		public Org() {
		}

		/** full constructor */
		public Org(String orgName, Integer parentOrgId) {
			this.orgName = orgName;
			this.parentOrgId = parentOrgId;
		}

		// Property accessors

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}


		public String getOrgName() {
			return this.orgName;
		}

		public void setOrgName(String orgName) {
			this.orgName = orgName;
		}

		public Integer getParentOrgId() {
			return this.parentOrgId;
		}

		public void setParentOrgId(Integer parentOrgId) {
			this.parentOrgId = parentOrgId;
		}
}
