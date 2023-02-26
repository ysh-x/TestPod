package com.ysh.model;

public class FacultyLogBean {
	int testID;
	int ID;
	String subject;
	

	public FacultyLogBean(int testID, int iD, String subject) {
		super();
		this.testID = testID;
		ID = iD;
		this.subject = subject;
	}
	
	public int getTestID() {
		return testID;
	}
	public void setTestID(int testID) {
		this.testID = testID;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
