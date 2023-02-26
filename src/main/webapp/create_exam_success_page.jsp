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
<title>TestPod | Create New Test Successful</title>
<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/resources/Assets/favicon.ico">
<link href="${pageContext.request.contextPath}/resources/CSS/exam.css"
	rel="stylesheet">

</head>
<body>
	<div class="header">
		<h1 class="logo_text">TestPod</h1>
		<a href="./backtodashboard" class="nav_btn">Back</a> <a
			href="./logout" class="nav_btn">Log Out</a>
	</div>
	<div class="container">
		<div class="card">
			<h2 class="card_header">Test Create Successful | Exam Details</h2>

			<c:forEach var="resultView" items="${result}">
				<h4 class="examdetails">${resultView}</h4>
			</c:forEach>
		</div>
		<div class="card">
			<a href="./backtodashboard" class="anchor_button">Back To Dashboard</a>
		</div>

	</div>
</body>
</html>