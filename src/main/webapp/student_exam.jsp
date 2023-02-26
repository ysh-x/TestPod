
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
<link href="${pageContext.request.contextPath}/resources/CSS/exam.css"
	rel="stylesheet">

</head>
<body>
	<div class="header">
		<h1 class="logo_text">TestPod</h1>
			<a href="./logout" class="nav_btn">Log Out</a>
	</div>
	<br>
	<div class="container">
		<form action="evaluatescript" method="post">
			<div class="card">
				<h2 class="card_header">Exam Details</h2>
				<table>
					<tr>
						<th>Test ID</th>
						<th>Faculty ID</th>
						<th>Subject Name</th>
					</tr>
					<tr>
					<td>${exam_paper.getTestID()}</td>
					<td>${exam_paper.getFacultyID()}</td>
					<td>${exam_paper.getSubjectName()}</td>
					</tr>
				</table>
			</div>
			<div class="card">
				<h2 class="card_header">${exam_paper.getQ1()}</h2>
				<textarea placeholder="Answer in dot-sepearted paragraph"
					rows="4" cols="50" name="a1"></textarea>
			</div>
			<div class="card">
				<h2 class="card_header">${exam_paper.getQ2()}</h2>
				<textarea placeholder ="Answer in dot-sepearted paragraph"
					rows="4" cols="50" name="a2"></textarea>
			</div>
			<div class="card">
				<h2 class="card_header">${exam_paper.getQ3()}</h2>
				<textarea placeholder="Answer in dot-sepearted paragraph" rows="4"
					cols="50" name="a3"></textarea>
			</div>
			<div class="card">
				<h2 class="card_header">${exam_paper.getQ4()}</h2>
				<textarea placeholder="Answer in dot-sepearted paragraph" rows="4"
					cols="50" name="a4"></textarea>
			</div>
			<div class="card">
				<h2 class="card_header">${exam_paper.getQ5()}</h2>
				<textarea placeholder="Answer in dot-sepearted paragraph"
					rows="4" cols="50" name="a5"></textarea>
			</div>
			<div class="card">
				<h2 class="card_header">${exam_paper.getQ6()}</h2>
				<textarea placeholder="Answer in dot-sepearted paragraph"
					rows="4" cols="50" name="a6"></textarea>
			</div>
			<div class="card">
				<h2 class="card_header">${exam_paper.getQ7()}</h2>
				<textarea placeholder="Answer in dot-sepearted paragraph"
					rows="4" cols="50" name="a7"></textarea>
			</div>
			<div class="card">
				<h2 class="card_header">${exam_paper.getQ8()}</h2>
				<textarea placeholder="Answer in dot-sepearted paragraph"
					rows="4" cols="50" name="a8"></textarea>
			</div>
			<div class="card">
				<h2 class="card_header">${exam_paper.getQ9()}</h2>
				<textarea placeholder="Answer in dot-sepearted paragraph"
					rows="4" cols="50" name="a9"></textarea>
			</div>
			<div class="card">
				<h2 class="card_header">${exam_paper.getQ10()}</h2>
				<textarea placeholder="Answer in dot-sepearted paragraph"
					rows="4" cols="50" name="a10"></textarea>
			</div>
			<div class="card">
				<button type="submit" name="submit" class="finalBtn">Submit
					Test</button>
			</div>
		</form>
	</div>
</body>
</html>