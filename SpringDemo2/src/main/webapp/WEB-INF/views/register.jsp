<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<title>Register</title>

<style>
.error {
	color: red;
}
input.error {
	background-color: pink;
}
</style>

</head>
<body>
	<h2>Register:</h2>
	<div>
		<sf:form method="post" commandName="userInfo">
			<sf:errors path="*" cssClass="error" element="div" />
			帳號：
			<sf:input type="text" path="account"  cssErrorClass="error"/>
			<br />
			密碼：
			<sf:input type="text" path="password"  cssErrorClass="error"/>
			<br />
			<input type="submit" value="register" />
		</sf:form>
	</div>
</body>
</html>
