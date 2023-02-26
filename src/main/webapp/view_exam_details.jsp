
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
<title>TestPod | Test Dashboard</title>
<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/resources/Assets/favicon.ico">
<link href="${pageContext.request.contextPath}/resources/CSS/main.css"
	rel="stylesheet">

</head>
<body>
	<div class="header">
		<h1 class="logo_text">TestPod</h1>
		<a href="./backtodashboard" class="nav_btn">Back</a> <a
			href="./instructions.jsp" target="_blank" class="nav_btn">Instructions</a>
		<a href="./logout" class="nav_btn">Log Out</a>
	</div>
	<br>
	<div class="container">
		<div class="card">
			<table>
				<tr>
					<th>Name</th>
					<th>Description</th>
				</tr>
				<tr>
					<td>Test ID</td>
					<td>${log_bean.getTestID()}</td>
				</tr>
				<tr>
					<td>Faculty ID</td>
					<td>${log_bean.getID()}</td>
				</tr>
				<tr>
					<td>Subject Name</td>
					<td>${log_bean.getSubject()}</td>
				</tr>
			</table>
		</div>
		<div class="card">
			<h2 class="card_header">Test Statistics</h2>
			<table>
				<tr>
					<th>Name</th>
					<th>Description</th>
				</tr>
				<tr>
					<td>Number Of Students Attended</td>
					<td><c:out value="${attended}"/></td>
				</tr>
				<tr>
					<td>Maximum Marks</td>
					<td><c:out value="${max_marks}"/></td>
				</tr>
				<tr>
					<td>Class Average</td>
					<td>${class_avg}</td>
				</tr>
			</table>
		</div>
		<div class="card">
			<form action="viewstudentdetails" method="post">
				<h2 class="card_header">Students Attended</h2>
				<table>
					<tr>
						<th>Student ID</th>
						<th>View</th>
					</tr>
					<c:forEach items="${student_bean}" var="bean">
						<tr>
							<td>${bean}</td>
							<td><input type="radio" class="radio" value=${bean
								} name="viewRadio" /></td>
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