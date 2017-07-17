<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h2>Spittle</h2>
<div class="spittleView">
	<sec:authorize access="isAuthenticated() and principal.username == 'ahfdkun'">
		<c:url value="/spittles" var="spittle_url" />
		<sf:form action="${spittle_url}" commandName="spittle" method="POST">
			Message: <sf:input path="message"/><br/>
			Latitude: <sf:input path="latitude"/><br/>
			Longitude: <sf:input path="longitude"/><br/>
			<input type="submit" value="submit" />
		</sf:form>
	</sec:authorize>
</div>