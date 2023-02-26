<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html" language="java"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TestPod | Student Login</title>
<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/resources/Assets/favicon.ico">
<link href="${pageContext.request.contextPath}/resources/CSS/style.css"
	rel="stylesheet">

</head>
<body>
	<div class="header">
		<h1 class="logo_text">TestPod</h1>
		<a href="./instructions_for_students.jsp" target = "_blank" class="nav_btn">Instructions</a>
	</div>
	<div class="container">
		<div class="login_form">
			<form action="checkstudentvalidity" method="post">
				<br> <br> <br>
				<h1 class="logo_out">Examination Center</h1>
				<input class="text" required type="text"
					placeholder="Test Identification Number" name="id"><br>
				<button type="submit" onclick="check()">Submit</button>
			</form>
		</div>
	</div>
</body>
</html>