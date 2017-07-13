<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>Profile</title>
</head>
<body>
	<h1>Your Profile</h1>
	<h1>欢迎<security:authentication htmlEscape="false" property="principal.username"/>!</h1>
	authorities: <security:authentication htmlEscape="false" property="authorities"/> <br/>
	Credentials: <security:authentication htmlEscape="false" property="Credentials"/> <br/>
	details: <security:authentication htmlEscape="false" property="details"/> <br/>
	principal: <security:authentication htmlEscape="false" property="principal"/> <br/>
	username: ${spitter.username} <br/>
	firstName: ${spitter.firstName} <br/>
	lastName: ${spitter.lastName} <br/>
</body>
</html>
