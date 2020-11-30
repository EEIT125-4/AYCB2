<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
response.setContentType("text/html;charset=UTF-8");
%>
<% response.setHeader("Refresh", "3;displaytest.jsp"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/comment.css" />
<title>留言成功</title>
<script>
window.alert("留言成功");
</script>

</head>
<%@include file="jspf/header.jspf"%>
<form class="arrow_box">
留言成功!
</form>

</body>
</html>