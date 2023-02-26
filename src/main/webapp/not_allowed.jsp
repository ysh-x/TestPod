<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html" language="java"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TestPod | Permission Denied</title>
<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/resources/Assets/favicon.ico">
<link href="${pageContext.request.contextPath}/resources/CSS/error.css"
	rel="stylesheet">

</head>
<body>
	<div class="header">
		<h1 class="logo_text">TestPod</h1>
		<a href="./login.jsp" class="nav_btn">Login</a>
	</div>
	<div class="container">
		<div class="login_form">
			<br> <br> <br>
			<h1 class="logo_out">Permission Denied</h1><br>
			<p>You are not allowed to attend the test as per your administration. If you think it is a mistake, kindly contact the administrator.</p>
		</div>
	</div>
</body>
</html>