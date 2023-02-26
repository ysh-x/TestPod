package com.ysh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.ysh.dao.MarkListDAO;
import com.ysh.security.CookieCracker;

import Core.ReportBean;
import Main.StudentMain;

@Controller
public class EvaluateScripts {
	@RequestMapping("/evaluatescript")
	public ModelAndView evaluateScripts(HttpServletRequest request, HttpServletResponse response)
			throws InvalidFormatException, IOException, ClassNotFoundException, SQLException {
		String gettestID = (WebUtils.getCookie(request, "TID").getValue());
		int testID = Integer.parseInt(CookieCracker.decrypt(gettestID));

		String getStudentID = (WebUtils.getCookie(request, "ID").getValue());
		int studentID = Integer.parseInt(CookieCracker.decrypt(getStudentID));

		ArrayList<String> answers = new ArrayList<String>();
		answers.add(request.getParameter("a1"));
		answers.add(request.getParameter("a2"));
		answers.add(request.getParameter("a3"));
		answers.add(request.getParameter("a4"));
		answers.add(request.getParameter("a5"));
		answers.add(request.getParameter("a6"));
		answers.add(request.getParameter("a7"));
		answers.add(request.getParameter("a8"));
		answers.add(request.getParameter("a9"));
		answers.add(request.getParameter("a10"));

		StudentMain student = new StudentMain();
		ReportBean studentReport = student.studentMain(answers, testID, studentID);
		
		List<Float> similarity = studentReport.getSimilarityIndex();
		List<Float> finalMarks = new ArrayList<Float>();
		Float total = 0.0f;
		
		for (Float similar : similarity) {
			finalMarks.add((float) (similar * 3.0));
			total += (float) (similar * 3.0);
		}

		MarkListDAO marks = new MarkListDAO();
		marks.updateStudentMarks(finalMarks, total, studentReport.getRemarks(), testID, studentID);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("test_successful");
		return view;
	}
}
