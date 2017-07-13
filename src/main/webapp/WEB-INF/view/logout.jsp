<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Login Page</title>
</head>
<body>
	<form name="M" action='<c:url value='/signout' />' method="POST">
		<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}" />
	</form>
</body>

<script type="text/javascript">
	if (confirm("确定退出吗？")) {
		document.M.submit();
	}
</script>
</html>