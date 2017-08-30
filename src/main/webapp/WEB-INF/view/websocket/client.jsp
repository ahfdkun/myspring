<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<script src='<c:url value="/resources/js/sockjs-1.1.1.js"/>'></script>
<script src="<c:url value="/resources/js/stomp.js" />"></script>
<body>
	WebSocket Client...
</body>

<script type="text/javascript">

	var url = "http://" + window.location.host + "/myspring/macropolo";
	var sock = new SockJS(url);
	var stomp = Stomp.over(sock);
	
	var payload = JSON.stringify({'message':'Macro!'});
	
	stomp.connect({}, function() {
		/* stomp.send('/app/macro', {}, payload);
		stomp.subscribe('/app/macro', function(greeting){  
            console.log("/app/macro: " + JSON.parse(greeting.body).message);  
        });
		stomp.subscribe('/topic/macro', function(greeting){  
            console.log("/topic/macro: " + JSON.parse(greeting.body).message);  
        }); */
		
		stomp.send('/app/spittle', {}, payload);
		stomp.subscribe('/user/queue/notifications', function(greeting){  
            console.log("/user/queue/notifications: " + JSON.parse(greeting.body).message);  
        });
	});
</script>
</html>