package com.onlineTest.bean;

public class Course {

	private String id;
	private String name;
	private int credit;
	private String departId;
	private String sno;

	public Course() {
	}

	public Course(String id, String name, int credit, String departId, String sno) {
		this.id = id;
		this.name = name;
		this.credit = credit;
		this.departId = departId;
		this.sno = sno;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getDepartId() {
		return departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

}
