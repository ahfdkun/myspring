<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<body>
	<h1><s:message code="spittr.welcome"/></h1>
	<a href="<c:url value="/register" />">注册</a>
</body>
</html>
