package com.ysh.model;

import java.util.ArrayList;

public class CreateExamBean {

	private ArrayList<String> questions = new ArrayList<String>();
	private ArrayList<String> answers = new ArrayList<String>();
	private ArrayList<Integer> students = new ArrayList<Integer>();
	private int TestID;
	private int maximumMarks;
	private String subjectName;
	private int facultyID;

	public ArrayList<String> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<String> questions) {
		this.questions = questions;
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}

	public ArrayList<Integer> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Integer> students) {
		this.students = students;
	}

	public int getTestID() {
		return TestID;
	}

	public void setTestID(int testID) {
		TestID = testID;
	}

	public int getMaximumMarks() {
		return maximumMarks;
	}

	public void setMaximumMarks(int maximumMarks) {
		this.maximumMarks = maximumMarks;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(int facultyID) {
		this.facultyID = facultyID;
	}

	@Override
	public String toString() {
		return "CreateExamBean [questions=" + questions + ", answers=" + answers + ", students=" + students
				+ ", TestID=" + TestID + ", maximumMarks=" + maximumMarks + ", subjectName=" + subjectName
				+ ", facultyID=" + facultyID + "]";
	}
	
	
}
