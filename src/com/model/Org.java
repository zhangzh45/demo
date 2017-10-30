package com.model;

public class Org {


		private Integer orgId;
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

		public Integer getOrgId() {
			return this.orgId;
		}

		public void setOrgId(Integer orgId) {
			this.orgId = orgId;
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
