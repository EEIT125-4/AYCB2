<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", -1); // Prevents caching at the proxy server
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link REL=STYLESHEET HREF="css/member.css" TYPE="text/css">
<link rel="icon" href="image/logo.ico" type="image/x-icon">
<title>資料確認</title>
</head>
<%@include file="../jspf/header.jspf"%>
<div style="position: relative; top: 200px; ; left: 700px;">
	<form action="./RegisterServlet" method="post">
		<fieldset class="confirmfs">
			<legend style="font-size: 28px;">請再次確認個人資料</legend>
			<div>
				<label>姓名:</label> <label name=""><%=request.getParameter("name").trim()%></label>
			</div>
			<div>
				<label>性別:</label> <label><%=request.getParameter("gender").trim()%></label>
			</div>
			<div>
				<label>帳號:</label> <label><%=request.getParameter("acc").trim()%></label>
			</div>
			<div>
				<label>密碼:</label> <label><%=request.getParameter("pwd").trim()%></label>
			</div>
			<div>
				<label>信箱:</label> <label><%=request.getParameter("email").trim()%></label>
			</div>
			<div>
				<label>生日:</label> <label><%=request.getParameter("byear").trim()%>年<%=request.getParameter("bmonth").trim()%>月<%=request.getParameter("bday").trim()%>日</label>
			</div>
			<input type="submit" name="confirm" value="確認">
		</fieldset>
	</form>
</div>
</body>
</html>