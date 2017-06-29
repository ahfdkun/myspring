<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Spittr</title>
</head>
<body>
	<h1>Register</h1>
	<form method="POST">
		First Name: <input type="text" name="firstName" /><br/>
		Last Name: <input type="text" name="lastName" /><br/>
		Username: <input type="text" name="username" /><br/>
		Password: <input type="password" name="password" /><br/>
		<input type="submit" value="Register" />
	</form>
</body>
</html>
