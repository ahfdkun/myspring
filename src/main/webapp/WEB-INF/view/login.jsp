<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Login Page</title>
</head>
<body onload='document.f.username.focus();'>
	<h3>登录页面</h3>
	<form name='f' action='<c:url value='/login' />' method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input type="checkbox" name="remember-me" id="remember-me" />Remember me</td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit" value="登录" /></td>
			</tr>
			<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}" />
		</table>
	</form>
</body>
</html>