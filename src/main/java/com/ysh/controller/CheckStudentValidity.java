package com.ysh.controller;

import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.ysh.dao.ExamDetailsDAO;
import com.ysh.dao.MarkListDAO;
import com.ysh.model.QuestionPaperBean;
import com.ysh.security.CookieCracker;

@Controller
public class CheckStudentValidity {

	@RequestMapping("/checkstudentvalidity")
	public ModelAndView checkStudentValidity(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException {
		ModelAndView view = new ModelAndView();
		MarkListDAO marklist = new MarkListDAO();
		String IDS = WebUtils.getCookie(request, "ID").getValue();
		int testID = Integer.parseInt(request.getParameter("id"));
		int studentID = Integer.parseInt(CookieCracker.decrypt(IDS));

		boolean status = marklist.isStudentPresent(testID, studentID);
		if (status == false) {
			view.setViewName("not_allowed");
			return view;
		} else {
			ExamDetailsDAO examPaper = new ExamDetailsDAO();
			QuestionPaperBean exampaper = examPaper.getQuestions(testID);
			int cookieAgeInSeconds = 86400;
			Cookie cookie = new Cookie("TID", CookieCracker.encrypt(Integer.toString(testID)));
			cookie.setMaxAge(cookieAgeInSeconds);
			response.addCookie(cookie);

			view.setViewName("student_exam");
			view.addObject("exam_paper", exampaper);
		}
		return view;

	}

}
