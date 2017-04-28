<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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
		<sf:form method="post" commandName="userInfo" enctype="multipart/form-data">
			<sf:errors path="*" cssClass="error" element="div" />
			帳號：
			<sf:input type="text" path="account"  cssErrorClass="error" value="Vance"/>
			<br />
			密碼：
			<sf:input type="text" path="password"  cssErrorClass="error" value="123456"/>
			<br />
			<br />
			照片：<sf:input type="file" path="userImg"/>
			<input type="submit" value="register" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</sf:form>
	</div>
</body>
</html>
