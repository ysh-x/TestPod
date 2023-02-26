package com.ysh.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogOutController {
		
	@RequestMapping("/logout")
	public ModelAndView logOut(HttpServletRequest request, HttpServletResponse response) {

		Cookie cookie = new Cookie("ID", null);
		cookie.setMaxAge(0);
		cookie.setPath("/TestPod");
		cookie.setDomain("localhost");
		response.addCookie(cookie);
		
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("login");
		
		return modelView;
		
	}
}
