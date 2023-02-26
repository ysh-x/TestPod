package com.ysh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.ysh.exam.Exam;
import com.ysh.exam.ExamFactory;
import com.ysh.model.CreateExamBean;
import com.ysh.security.CookieCracker;

@Controller
public class CreateExamController {

	@RequestMapping("/create")
	public ModelAndView createController(HttpServletRequest request, HttpServletResponse response)
			throws InvalidFormatException, IOException, ClassNotFoundException, SQLException {
		ModelAndView view = new ModelAndView();
		ArrayList<String> questions = new ArrayList<String>();
		ArrayList<String> answers = new ArrayList<String>();
		ArrayList<Integer> students = new ArrayList<Integer>();
		int TestID;
		int maximumMarks;
		String subjectName;

		String encrpytedID = (WebUtils.getCookie(request, "ID").getValue());
		String ID = CookieCracker.decrypt(encrpytedID);

		String Temp = request.getParameter("id");
		maximumMarks = Integer.parseInt(request.getParameter("marks"));
		String studentList = request.getParameter("studentlist");
		subjectName = request.getParameter("subject");

		String Test = ID + Temp;
		TestID = Integer.parseInt(Test);
		String[] studentTemp = studentList.split(",");
		for (String x : studentTemp) {
			students.add(Integer.parseInt(x));
		}

		for (int i = 1; i <= 10; i++) {
			String temp = "q" + Integer.toString(i);
			questions.add(request.getParameter(temp));
		}
		for (int i = 1; i <= 10; i++) {
			String temp = "a" + Integer.toString(i);
			answers.add(request.getParameter(temp));
		}

		CreateExamBean examBean = new CreateExamBean();
		examBean.setTestID(TestID);
		examBean.setFacultyID(Integer.parseInt(ID));
		examBean.setSubjectName(subjectName);
		examBean.setQuestions(questions);
		examBean.setAnswers(answers);
		examBean.setMaximumMarks(maximumMarks);
		examBean.setStudents(students);

		ExamFactory examination = new ExamFactory();
		Exam exam = examination.createExam(examBean);
		CreateExamBean newBean = exam.createExam(examBean);

		if (newBean.getTestID() == -1) {
			System.out.println("1");
			view.setViewName("error");
			return view;
		} else {
			ArrayList<String> finalResult = exam.getDetails(newBean);
			view.setViewName("create_exam_success_page");
			view.addObject("result", finalResult);
			return view;
		}
	}
}
