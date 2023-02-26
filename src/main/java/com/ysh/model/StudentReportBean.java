package com.ysh.model;

import java.util.ArrayList;

public class StudentReportBean {
	int testID;
	int studentID;
	int facultyID;
	float total;
	ArrayList<Float> marks = new ArrayList<Float>();
	ArrayList<String> remarks = new ArrayList<String>();
	ArrayList<Integer> QSno = new ArrayList<Integer>();
	
	public ArrayList<Integer> getQSno() {
		return QSno;
	}
	public void setQSno(ArrayList<Integer> qSno) {
		QSno = qSno;
	}
	public int getTestID() {
		return testID;
	}
	public void setTestID(int testID) {
		this.testID = testID;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public int getFacultyID() {
		return facultyID;
	}
	public void setFacultyID(int facultyID) {
		this.facultyID = facultyID;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public ArrayList<Float> getMarks() {
		return marks;
	}
	public void setMarks(ArrayList<Float> marks) {
		this.marks = marks;
	}
	public ArrayList<String> getRemarks() {
		return remarks;
	}
	public void setRemarks(ArrayList<String> remarks) {
		this.remarks = remarks;
	}	
	
	
}
