package com.ysh.controller;

import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.ysh.dao.FacultyLogDAO;
import com.ysh.dao.MarkListDAO;
import com.ysh.model.FacultyLogBean;
import com.ysh.security.CookieCracker;
import java.util.*;

@Controller
public class ViewExamDetails {
	
	@RequestMapping("/viewexamdetails")
	public ModelAndView viewExamDetails(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("view_exam_details");
		
		String encrpytedID = (WebUtils.getCookie(request,"ID").getValue());
		String ID = CookieCracker.decrypt(encrpytedID);
		
		int examID = Integer.parseInt(request.getParameter("view"));
		int facultyID = Integer.parseInt(ID);
		
		int cookieAgeInSeconds = 86400;
		Cookie cookie = new Cookie("TID", CookieCracker.encrypt(Integer.toString(examID)));
		cookie.setMaxAge(cookieAgeInSeconds);
		response.addCookie(cookie);
		
		MarkListDAO marks = new MarkListDAO();
		ArrayList<Integer> students = marks.getStudents(examID);
		System.out.println(students.toString());
		ArrayList<Float> total = marks.getMarks(examID);
		int attended = (total.size() - Collections.frequency(total, 0.0f));
		float maxMarks = Collections.max(total);
		float classAvg = 0.0f;
		
		for(float x : total) {
			classAvg += x;
		}
		
		classAvg = ((classAvg/total.size()));
		
		FacultyLogDAO facultyLog = new FacultyLogDAO();
		FacultyLogBean logBean = facultyLog.getExamDetails(examID,facultyID);
		view.addObject("attended",attended);
		view.addObject("max_marks", maxMarks);
		view.addObject("class_avg",classAvg);
		view.addObject("student_bean", students);
		view.addObject("log_bean", logBean);
		return view;
	}

}
