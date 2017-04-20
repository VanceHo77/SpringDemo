<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<title>ShowDemo</title>
</head>
<body>
	<h2>Demo list:</h2>
	<div>
		<select>
			<c:forEach items="${demos}" var="d">
				<option>${d.message}</option>
			</c:forEach>
		</select>
	</div>
</body>
</html>
