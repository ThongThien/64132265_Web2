<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	<h1>
		Hello Nguyen Thong Thien
	</h1>
	<%= new Date().toString()%>
	<hr>
	<% int y = 2004;%>
	<% out.print(y); %>
</body>
</html>