<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.ysh.security.CookieCracker"%>
<%@ page import="com.ysh.model.FacultyBean"%>
<%@ page import="com.ysh.model.FacultyLogBean"%>

<%@ page language="java" contentType="text/html" language="java"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TestPod | Faculty Dashboard</title>
<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/resources/Assets/favicon.ico">
<link href="${pageContext.request.contextPath}/resources/CSS/main.css"
	rel="stylesheet">

</head>
<body>
	<div class="header">
		<h1 class="logo_text">TestPod</h1>
		<a href="./create_new_test.jsp" class="nav_btn">Create A Test</a> <a
			href="./instructions.jsp" target="_blank" class="nav_btn">Instructions</a>

		<a href="./logout" class="nav_btn">Log Out</a>
	</div>
	<div class="container">
		<div class="card">
			<h2 class="card_header">Welcome Back, ${fac_bean.getName()}</h2>
			<h4 class="desc">${fac_bean.getName()}</h4>
			<h4 class="desc">${fac_bean.getDesignation()}</h4>
			<h4 class="desc">${fac_bean.getSchool()}</h4>
		</div>
		<div class="card">
			<form action="viewexamdetails" method="post">
				<h2 class="card_header">Tests Conducted</h2>
				<table>
					<tr>
						<th>Test ID</th>
						<th>Subject Name</th>
						<th>View</th>
					</tr>
					<c:forEach items="${fac_log_bean}" var="bean">
						<tr>
							<td>${bean.getTestID()}</td>
							<td>${bean.getSubject()}</td>
							<td><input type="radio" class="radio"
								value=${bean.getTestID() } name="view" /></td>
						</tr>
					</c:forEach>
				</table>
				<br> <br>
				<button type="submit" class="mainviewbtn">View</button>
			</form>
		</div>

	</div>
</body>
</html>