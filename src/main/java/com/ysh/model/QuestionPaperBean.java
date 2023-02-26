package com.ysh.model;

public class QuestionPaperBean {
	int ID;
	int testID;
	int facultyID;
	String subjectName;
	String Q1;
	String Q2;
	String Q3;
	String Q4;
	String Q5;
	String Q6;
	String Q7;
	String Q8;
	String Q9;
	String Q10;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getTestID() {
		return testID;
	}
	public void setTestID(int testID) {
		this.testID = testID;
	}
	public int getFacultyID() {
		return facultyID;
	}
	public void setFacultyID(int facultyID) {
		this.facultyID = facultyID;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getQ1() {
		return Q1;
	}
	public void setQ1(String q1) {
		Q1 = q1;
	}
	public String getQ2() {
		return Q2;
	}
	public void setQ2(String q2) {
		Q2 = q2;
	}
	public String getQ3() {
		return Q3;
	}
	public void setQ3(String q3) {
		Q3 = q3;
	}
	public String getQ4() {
		return Q4;
	}
	public void setQ4(String q4) {
		Q4 = q4;
	}
	public String getQ5() {
		return Q5;
	}
	public void setQ5(String q5) {
		Q5 = q5;
	}
	public String getQ6() {
		return Q6;
	}
	public void setQ6(String q6) {
		Q6 = q6;
	}
	public String getQ7() {
		return Q7;
	}
	public void setQ7(String q7) {
		Q7 = q7;
	}
	public String getQ8() {
		return Q8;
	}
	public void setQ8(String q8) {
		Q8 = q8;
	}
	public String getQ9() {
		return Q9;
	}
	public void setQ9(String q9) {
		Q9 = q9;
	}
	public String getQ10() {
		return Q10;
	}
	public void setQ10(String q10) {
		Q10 = q10;
	}
	@Override
	public String toString() {
		return "QuestionPaperBean [ID=" + ID + ", testID=" + testID + ", facultyID=" + facultyID + ", subjectName="
				+ subjectName + ", Q1=" + Q1 + ", Q2=" + Q2 + ", Q3=" + Q3 + ", Q4=" + Q4 + ", Q5=" + Q5 + ", Q6=" + Q6
				+ ", Q7=" + Q7 + ", Q8=" + Q8 + ", Q9=" + Q9 + ", Q10=" + Q10 + "]";
	}	
	
}
