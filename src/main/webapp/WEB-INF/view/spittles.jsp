<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<script src='<c:url value="/resources/js/sockjs-1.1.1.js"/>'></script>
<script src="<c:url value="/resources/js/stomp.js" />"></script>
<ul>
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
</ul>
<script type="text/javascript">

	var url = "http://" + window.location.host + "/myspring/macropolo";
	var sock = new SockJS(url);
	var stomp = Stomp.over(sock);
	
	stomp.connect({}, function() {
		stomp.subscribe('/topic/spittlefeed', function(greeting){  
            console.log("/topic/spittlefeed: " + greeting.body);
        });
	});
</script>