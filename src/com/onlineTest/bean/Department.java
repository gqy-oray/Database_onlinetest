package com.onlineTest.bean;

public class Department {
	private String departId;
	private String departName;

	public Department() {
	}

	public Department(String departId, String departName) {
		this.departId = departId;
		this.departName = departName;
	}

	public String getDepartId() {
		return departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

}
