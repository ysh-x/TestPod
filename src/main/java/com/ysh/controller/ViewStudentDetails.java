package com.ysh.controller;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.ysh.dao.MarkListDAO;
import com.ysh.exam.FileDecoder;
import com.ysh.exam.GeneratePersonalisedReport;
import com.ysh.model.StudentReportBean;
import com.ysh.security.*;
@Controller
public class ViewStudentDetails {

	@RequestMapping("/viewstudentdetails")
	public ModelAndView viewSutudentDetails(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, FileNotFoundException {
		int studentID;
		int testID;
		
		StudentReportBean studentBean = new StudentReportBean();
		String gettestID = (WebUtils.getCookie(request,"TID").getValue());
		testID = Integer.parseInt(CookieCracker.decrypt(gettestID));
	
		System.out.println(request.getParameter("viewRadio"));
		studentID = Integer.parseInt(request.getParameter("viewRadio"));
		System.out.println(request.getParameter("view"));
		
		ModelAndView view = new ModelAndView();
		
		MarkListDAO marklist = new MarkListDAO();
		studentBean = marklist.getStudentMarks(testID, studentID);
		view.setViewName("view_student_details");
		
		String location = "/home/ysh-mi/MajorProjects/TestPod/lib/files/" + studentID + "S.txt";
		System.out.println(location);
		
		FileDecoder deco = new FileDecoder();
		ArrayList<String> fileContents = deco.decode(location);
		
		GeneratePersonalisedReport reportGen = new GeneratePersonalisedReport();
		String report = reportGen.generatePersonalisedReport(studentBean);
		
		System.out.println(fileContents.toString());
		view.setViewName("view_student_details");
		view.addObject("student_bean",studentBean);
		view.addObject("report",report);
		view.addObject("file_contents",fileContents);

		return view;
		
	}
}
