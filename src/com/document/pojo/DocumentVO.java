package com.document.pojo;

import java.sql.Date;

public class DocumentVO {

		private int id;
		private String name;
		private String tel;
		private String sex;
		private Date joindate;
		private String address;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public Date getJoindate() {
			return joindate;
		}
		public void setJoindate(Date joindate) {
			this.joindate = joindate;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
		
		
}
