<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link REL=STYLESHEET HREF="css/member.css" TYPE="text/css">
<link rel="icon" href="image/logo.ico" type="image/x-icon">
<title>登入</title>
</head>
<%@include file="jspf/header.jspf"%>
<br>
<br>
<div style="position: relative; top: 200px;">
	<fieldset
		style="margin: auto; border: 3px solid black; width: 700px; border-radius: 5px">
		<legend
			style="background-color: lightgray; border-radius: 3px; width: 120px; margin: auto; font-size: 20px">會員資料整理</legend>
		<form action=".\RegisterServlet" method="post">
			<table>
				<tr>
					<td><a href="login.jsp"
						style="margin-left: 77px; font-size: 30px">登出</a></td>
					<td><a href="update.jsp"
						style="margin-left: 150px; font-size: 30px">編輯資料</a></td>
					<td><a href="Home.jsp"
						style="margin-left: 150px; font-size: 30px">主頁</a></td>
				<tr>
			</table>
		</form>
	</fieldset>
</div>
</body>
</html>

