<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<title>Welcome</title>
</head>
<body>

	<h1>
		<!-- message source from /WEB-INF/messages.properties -->
		<s:message code="my.welcome" />, ${account}
	</h1>
</body>
</html>
