<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="spittleView">
	<sf:form action="/myspring/spittles" commandName="spittle" method="POST">
		Message: <sf:input path="message"/><br/>
		Latitude: <sf:input path="latitude"/><br/>
		Longitude: <sf:input path="longitude"/><br/>
		<input type="submit" value="submit" />
	</sf:form>
</div>