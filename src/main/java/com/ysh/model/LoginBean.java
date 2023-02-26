package com.ysh.model;

public class LoginBean {
	int ID;
	String password;
	String salt;
	
	public LoginBean(int iD, String password, String salt) {
		super();
		ID = iD;
		this.password = password;
		this.salt = salt;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
}
