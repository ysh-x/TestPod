package com.ysh.model;

public class FacultyBean {
	int ID;
	String name;
	String designation;
	String school;

	public FacultyBean(int iD, String name, String designation, String school) {
		super();
		ID = iD;
		this.name = name;
		this.designation = designation;
		this.school = school;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

}
