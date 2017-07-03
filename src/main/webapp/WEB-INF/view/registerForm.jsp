<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Spittr</title>
	<style type="text/css">
	   span.error { color: red; }
	   div.error { background-color: #ffcccc; border: 2px solid red; }
	   label.error { color: red; }
	   input.error { background-color: #ffcccc; border: 2px solid red; }
	</style>
</head>
<body>
	<h1>Register</h1>
	<sf:form method="POST" commandName="spitter" enctype="multipart/form-data">
	   <%-- <sf:errors path="*" element="div" cssClass="error" /> --%>
	   <sf:label path="firstName" cssErrorClass="error">First Name: </sf:label><sf:input path="firstName" cssErrorClass="error"/><sf:errors path="firstName" element="span" cssClass="error" /><br/>
	   Last Name: <sf:input path="lastName" /><sf:errors path="lastName" element="span" cssClass="error" /><br/>
	   Username: <sf:input path="username" /><sf:errors path="username" element="span" cssClass="error" /><br/>
	   Password: <sf:password path="password" /><sf:errors path="password" element="span" cssClass="error" /><br/>
	   ProfilePicture: <input type="file" name="profilePicture" accept="image/jpeg,image/png,image/gif" /><br/>
	   <input type="submit" value="Register" />
	</sf:form>
    
</body>
</html>
