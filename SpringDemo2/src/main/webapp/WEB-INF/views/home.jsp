<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<h2>Demo Object:</h2>
	<div>
		<p>${demo.message}</p>
		<p>經度:${demo.latitude}</p>
		<p>緯度:${demo.longitude}</p>
	</div>
	<h2>Demo list:</h2>
	<div>
		<select>
			<c:forEach items="${demos}" var="d">
				<option>${d.message}</option>
			</c:forEach>
		</select>
	</div>
	<p>
		<a href='<c:url value="/show?start=0&size=3"/>'>Go to show.jsp, by
			use @RequestParam</a>
	</p>
	<p>
		<a href='<c:url value="/show/0/3"/>'>Go to show.jsp, by use
			@PathVariable</a>
	</p>
	<p>
		<a href='<c:url value="/register"/>'>Go to register.jsp</a>
	</p>
	<p>
		<%-- HTML轉義，使頁面直接顯示出/demo/springDemo?max=1&count=2 --%>
		<s:url value="/springDemo" htmlEscape="true">
			<s:param name="max" value="1"></s:param>
			<s:param name="count" value="2"></s:param>
		</s:url>
	</p>
	<p>
		<%-- HTML轉義，使頁面可以顯示出<h1>Hello</h1> --%>
		<s:escapeBody htmlEscape="true">
			<h1>Hello</h1>
		</s:escapeBody>
	</p>
</body>
</html>