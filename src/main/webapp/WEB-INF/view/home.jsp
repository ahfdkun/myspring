<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<body>
	<h1><s:message code="spittr.welcome"/></h1>
	<a href="<c:url value="/register" />">注册</a>
</body>
</html>
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h1><s:message code="spittr.welcome"/></h1>
<a href='<c:url value="/spittles" />'>Spittles</a> |
<a href='<c:url value="/spitter/register" />'>Register</a>
<br/>
<!-- url属性会引用安全性约束 -->
<sec:authorize url="/spittles">
	<c:url value="/spittles" var="spittles_url" />
	<a href="${spittles_url}">Spittles</a>
</sec:authorize>