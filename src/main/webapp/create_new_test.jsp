
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
		<a href="./backtodashboard" class="nav_btn">Back</a> <a
			href="./logout" class="nav_btn">Log Out</a>
	</div>
	<br>
	<div class="container">
		<form action="create" method="post">
			<div class="card">
				<h2 class="card_header">Create A New Test</h2>
				<input type="text" required placeholder="Test ID" name="id" /> <input
					type="text" required placeholder="Name Of The Subject"
					name="subject" /> <input type="text" required
					placeholder="Maximum Marks Per Question" name="marks">
				<textarea required placeholder="List Of Students Attending The Test"
					rows="4" cols="50" name="studentlist"></textarea>
			</div>
			<div class="card">
				<input type="text" required placeholder="Question 1" name="q1">
				<textarea required placeholder="Answer in dot-sepearted paragraph"
					rows="4" cols="50" name="a1"></textarea>
			</div>
			<div class="card">
				<input type="text" required placeholder="Question 2" name="q2">
				<textarea required placeholder="Answer in dot-sepearted paragraph"
					rows="4" cols="50" name="a2"></textarea>
			</div>
			<div class="card">
				<input type="text" required placeholder="Question 3" name="q3">
				<textarea placeholder="Answer in dot-sepearted paragraph" rows="4"
					cols="50" name="a3"></textarea>
			</div>
			<div class="card">
				<input type="text" required placeholder="Question 4" name="q4">
				<textarea placeholder="Answer in dot-sepearted paragraph" rows="4"
					cols="50" name="a4"></textarea>
			</div>
			<div class="card">
				<input type="text" required placeholder="Question 5" name="q5">
				<textarea required placeholder="Answer in dot-sepearted paragraph"
					rows="4" cols="50" name="a5"></textarea>
			</div>
			<div class="card">
				<input type="text" required placeholder="Question 6" name="q6">
				<textarea required placeholder="Answer in dot-sepearted paragraph"
					rows="4" cols="50" name="a6"></textarea>
			</div>
			<div class="card">
				<input type="text" required placeholder="Question 7" name="q7">
				<textarea required placeholder="Answer in dot-sepearted paragraph"
					rows="4" cols="50" name="a7"></textarea>
			</div>
			<div class="card">
				<input type="text" required placeholder="Question 8" name="q8">
				<textarea required placeholder="Answer in dot-sepearted paragraph"
					rows="4" cols="50" name="a8"></textarea>
			</div>
			<div class="card">
				<input type="text" required placeholder="Question 9" name="q9">
				<textarea required placeholder="Answer in dot-sepearted paragraph"
					rows="4" cols="50" name="a9"></textarea>
			</div>
			<div class="card">
				<input type="text" required placeholder="Question 10" name="q10">
				<textarea required placeholder="Answer in dot-sepearted paragraph"
					rows="4" cols="50" name="a10"></textarea>
			</div>
			<div class="card">
				<button type="submit" name="submit" class="finalBtn">Create
					Test</button>
			</div>
		</form>
	</div>
</body>
</html>