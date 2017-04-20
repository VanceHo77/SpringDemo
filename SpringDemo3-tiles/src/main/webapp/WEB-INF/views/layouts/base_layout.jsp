<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width" />
<title><tiles:insertAttribute name="title" /></title>
</head>

<body>
	<div id="wrapper">
		<tiles:insertAttribute name="header" />
		<div id="pageContent">
			<p>===========container===========</p>
			<tiles:insertAttribute name="container" />
			<p>===========container===========</p>
		</div>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>