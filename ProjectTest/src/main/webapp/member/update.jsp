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
<jsp:useBean id="login_session" class="member.MemberBean" scope="session" />
<%@include file="../jspf/header.jspf"%>
<div style="position: relative; top: 200px;">
	<form action=".\RegisterServlet" method="post">
		<fieldset
			style="margin: auto; border: 3px solid black; width: 550px;border-radius: 6px;">
			<legend
				style="background-color: lightgray; border-radius: 3px; width: 100px; margin: auto;">會員資料更新</legend>
			<table>
				<tr>
					<td>姓名:</td>
					<td><input name="usename"
						value=<jsp:getProperty name="login_session" property="name"/>></td>
				</tr>
				<tr>
					<td>聯絡地址:</td>
					<td><input name="useraddress"
						value=<jsp:getProperty name="login_session" property="address" />></td>
				</tr>
				<tr>
					<td>聯絡電話:</td>
					<td><input name="userphone"
						value=<jsp:getProperty name="login_session" property="phone" />></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><input name="useremail" disabled="disabled"
						value=<jsp:getProperty name="login_session" property="email" />></td>
				</tr>

				<tr>
					<td>密碼:</td>
					<td><input name="pwd"
						value=<jsp:getProperty name="login_session" property="password" />>
				<tr>
					<td>
			</table>
			<input type="submit" name="update" value="確認更新"
				style="margin-left: 280px">
		</fieldset>
	</form>
</div>
</body>
</html>