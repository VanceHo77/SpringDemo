<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<title>Error page</title>
</head>
<body>
	<h1>Error page!</h1>

	<p>
		<a href='<c:url value="/"/>'>Go to home.jsp</a>
	</p>

</body>
</html>