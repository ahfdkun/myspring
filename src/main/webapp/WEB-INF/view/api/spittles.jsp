<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<c:forEach items="${spittleList}" var="spittle">
	<li id="spittle_<c:out value="${spittle.message}" />">
		<div class="spittleMessage">
			<c:out value="${spittle.message}"></c:out>
		</div>
		<div>
			<span class="spittleTime"><c:out value="${spittle.time}" /></span>
			<span class="spittleLocation">(<c:out value="${spittle.latitude}"/>,<c:out value="${spittle.longitude}"/>)</span>
		</div>
	</li>
</c:forEach>