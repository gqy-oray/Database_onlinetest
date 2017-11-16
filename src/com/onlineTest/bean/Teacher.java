package com.onlineTest.bean;

public class Teacher extends User {

	public Teacher() {
	}

	public Teacher(String id, String name, String password, String departld, String sex, String phone, String email) {

		this.id = id;
		this.name = name;
		this.password = password;
		this.departid = departld;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
	}
}
