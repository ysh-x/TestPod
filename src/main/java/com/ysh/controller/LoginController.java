package com.ysh.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ysh.security.SHA256;
import com.ysh.dao.FacultyDAO;
import com.ysh.dao.FacultyLogDAO;
import com.ysh.dao.LoginDAO;
import com.ysh.dao.LoginStudentDAO;
import com.ysh.model.FacultyBean;
import com.ysh.model.FacultyLogBean;
import com.ysh.model.LoginBean;
import com.ysh.validate.LoginValidate;
import com.ysh.security.CookieCracker;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public ModelAndView loginController(HttpServletRequest request, HttpServletResponse response)
			throws NumberFormatException, ClassNotFoundException, SQLException {
		ModelAndView view = new ModelAndView();
		LoginValidate validate = new LoginValidate();
		String ID = request.getParameter("id");
		String password = request.getParameter("password");

		int check = validate.validate(ID, password);

		if (check == 1) {
			LoginDAO dao = new LoginDAO();
			if (dao.isUserPresent(Integer.parseInt(ID))) {
				LoginBean user = dao.getLoginDetails(Integer.parseInt(ID));
				boolean finalCheck = SHA256.verifyUserPassword(password, user.getPassword(), user.getSalt());

				if (finalCheck == true) {
					int cookieAgeInSeconds = 86400;
					Cookie cookie = new Cookie("ID", CookieCracker.encrypt(ID.toString()));
					cookie.setMaxAge(cookieAgeInSeconds);
					response.addCookie(cookie);
					
					FacultyDAO fac = new FacultyDAO();
					FacultyLogDAO facLog = new FacultyLogDAO();
					
					FacultyBean facBean = fac.getDetails(Integer.parseInt(ID));
					List<FacultyLogBean> facLogBean = facLog.getDetails(Integer.parseInt(ID));
					
					
					view.setViewName("faculty_dashboard");
					view.addObject("fac_log_bean",facLogBean);
					view.addObject("fac_bean",facBean);
					return view;

				} else {
					view.setViewName("login_invalid_error");
					return view;

				}
			} else {
				view.setViewName("login_invalid_error");
				return view;
			}

		} else if (check == 2) {
			LoginStudentDAO dao = new LoginStudentDAO();
			String IDD = ID.substring(1, ID.length());
			if (dao.isUserPresent(Integer.parseInt(IDD))) {

				LoginBean user = dao.getLoginDetails(Integer.parseInt(IDD));
				boolean finalCheck = password.equals(user.getPassword()) ? true : false;
				if (finalCheck == true) {
					int cookieAgeInSeconds = 86400;
					Cookie cookie = new Cookie("ID", CookieCracker.encrypt(IDD.toString()));
					cookie.setMaxAge(cookieAgeInSeconds);
					response.addCookie(cookie);
					view.setViewName("student_dashboard");
					return view;

				} else {
					view.setViewName("login_invalid_error");
					return view;

				}
			} else {
				view.setViewName("login_invalid_error");
				return view;
			}

		} else {
			view.setViewName("login_error");
			return view;
		}

	}
}
