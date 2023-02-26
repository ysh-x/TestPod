package com.ysh.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.ysh.dao.FacultyDAO;
import com.ysh.dao.FacultyLogDAO;
import com.ysh.model.FacultyBean;
import com.ysh.model.FacultyLogBean;
import com.ysh.security.CookieCracker;
@Controller
public class BackController {
	
		@RequestMapping("/backtodashboard")
		public ModelAndView backController(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, ClassNotFoundException, SQLException {
			FacultyDAO fac = new FacultyDAO();
			FacultyLogDAO facLog = new FacultyLogDAO();
			ModelAndView view = new ModelAndView();
			String encrpytedID = (WebUtils.getCookie(request,"ID").getValue());
			String ID = CookieCracker.decrypt(encrpytedID);
			
			FacultyBean facBean = fac.getDetails(Integer.parseInt(ID));
			List<FacultyLogBean> facLogBean = facLog.getDetails(Integer.parseInt(ID));
			
			
			view.setViewName("faculty_dashboard");
			view.addObject("fac_log_bean",facLogBean);
			view.addObject("fac_bean",facBean);
			return view;

		}
}
