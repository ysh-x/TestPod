
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
<title>TestPod | Student Report</title>
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
			<h2 class="card_header">Report Of Student
				${student_bean.getStudentID()}</h2>
		</div>

		<div class="card">
			<h2 class="card_header">Automated summary of the student's performance</h2>
			<h3>${report}</h3>
		</div>
		<div class="card">

			<h2 class="card_header">Evaluation Result</h2>
			<table>
				<tr>
					<th>Question Number</th>
					<th>Evaluated Marks</th>
					<th>Auto Generated Remarks</th>

				</tr>
				<c:forEach items="${student_bean.getMarks()}" varStatus="loop">
					<tr>
						<td><c:out value="${student_bean.getQSno()[loop.index]}" /></td>
						<td><c:out value="${student_bean.getMarks()[loop.index]}" /></td>
						<td><c:out value="${student_bean.getRemarks()[loop.index]}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	<div class="card">
			<h2 class="card_header">Step By Step Evaluation</h2>
			<c:forEach items="${file_contents}" var="f">
			<p class="step"><c:out value="${f}"/></p>
			</c:forEach>
		</div>


</body>
</html>