<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<a href='<s:url value="/" />'>
	<img alt="" src='<s:url value="/resources"/>/images/spittr_logo_50.png' border="0" />
</a>
<div style="text-align: center">
	<a href="<s:url value="/logout" />">退出</a>
	<form action="<s:url value="/signout" />" method="POST">
		<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}" />
		<input type="submit" value="退出" />
	</form>
</div>
