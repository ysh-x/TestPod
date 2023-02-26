package com.ysh.exam;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.ysh.dao.ExamDetailsDAO;
import com.ysh.dao.FacultyLogDAO;
import com.ysh.dao.MarkListDAO;
import com.ysh.model.CreateExamBean;

import Main.FacultyMain;

public class TenQuestionExam implements Exam {

	private String loc;

	public CreateExamBean createExam(CreateExamBean examBean)
			throws ClassNotFoundException, SQLException, InvalidFormatException, IOException {
		CreateExamBean bean = new CreateExamBean();
		FacultyLogDAO log = new FacultyLogDAO();

		if (log.ifExamPresent(examBean) == true) {
			bean.setTestID(-1);
			return bean;
		} else {

			int logResult = log.insertLog(examBean);

			ExamDetailsDAO exam = new ExamDetailsDAO();
			int examResult = exam.insertDetails(examBean);

			MarkListDAO marks = new MarkListDAO();
			int markResult = marks.batchInsert(examBean);
			System.out.println("" + logResult + examResult + markResult);

			FacultyMain facultyNLP = new FacultyMain(examBean.getAnswers(), examBean.getTestID());
			loc = facultyNLP.getFileLocation();

			bean.setFacultyID(examBean.getFacultyID());
			bean.setMaximumMarks(examBean.getMaximumMarks());
			bean.setSubjectName(examBean.getSubjectName());
			bean.setStudents(examBean.getStudents());
			bean.setTestID(examBean.getTestID());
			bean.setQuestions(examBean.getQuestions());
			bean.setAnswers(examBean.getAnswers());
			return bean;
		}
	}

	public ArrayList<String> getDetails(CreateExamBean bean) {
		ArrayList<String> ExamDetails = new ArrayList<String>();
		ExamDetails.add("1. Examination ID: [" + bean.getTestID() + "]");
		ExamDetails.add("2. Faculty ID: " + bean.getFacultyID());
		ExamDetails.add("3. Subject: " + bean.getSubjectName());
		ExamDetails.add("4. Maximum Marks: " + bean.getMaximumMarks());
		ExamDetails.add("5. List Of Students:" + bean.getStudents().toString());
		ExamDetails.add("");

		ExamDetails.add("6. Status Of Automation: ");
		ExamDetails.add("Status: Success");
		ExamDetails.add("Skeleton of the answer script saved at: " + loc);
		ExamDetails.add("");
		ExamDetails.add("");

		for (int i = 0; i < 10; i++) {
			ExamDetails.add("");
			ExamDetails.add("Question " + (i + 1));
			ExamDetails.add(bean.getQuestions().get(i));
			ExamDetails.add("Answer " + (i + 1));
			ExamDetails.add(bean.getAnswers().get(i));
			ExamDetails.add("");
		}
		return ExamDetails;
	}
}
