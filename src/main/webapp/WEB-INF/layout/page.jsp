<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
<title>Spittr</title>
<style type="text/css">
    #header,#footer {text-align: center;}
</style>
</head>
<body>
	<div id="header">
		<t:insertAttribute name="header" /> <!-- 插入头部 -->
	</div>
	<div id="content">
		<t:insertAttribute name="body" /> <!-- 插入主体内容 -->
	</div>
	<div id="footer">
		<t:insertAttribute name="footer" /> <!-- 插入底部 -->
	</div>
</body>
</html>
