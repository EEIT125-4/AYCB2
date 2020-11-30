<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link REL=STYLESHEET HREF="css/eventpage.css" TYPE="text/css">
<link rel="icon" href="image/logo.ico" type="image/x-icon">
<title>報名資料確認</title>
</head>
<%@include file="jspf/header.jspf"%>
<div style="position: relative; top: 200px;">
	<div
		style="float: left; width: 20%; text-align: center; margin-left: 220px;">
		<dl>
			<dt>
				<h2>預約活動</h2>
			</dt>
			<hr width=70% size=1 color=#BFBFBF
				style="FILTER: alpha(opacity = 100, finishopacity = 0, style = 3)">
			<dt class="a1">
				<A href="eventpage.jsp">
					<h2>活動介紹</h2>
				</A>
			</dt>
			<dt class="a1">
				<A href="eventform.jsp">
					<h2>報名活動</h2>
				</A>
			</dt>
			<dt class="a1">
				<A href="input.jsp">
					<h2>查詢報名</h2>
				</A>
			</dt>
			<dt class="a1">
				<A href="deleteinput.jsp">
					<h2>取消報名</h2>
				</A>
			</dt>
			<dt class="a1">
				<A href="updateinput.jsp">
					<h2>更改報名資料</h2>
				</A>
			</dt>
		</dl>
	</div>
	<jsp:useBean id="reg_member" class="event.EventBean"
		scope="session" />

	<form action=".\EventServlet" method="post">
		<fieldset>
			<legend>
				<h2>報名資料確認</h2>
			</legend>
			<table>
				<tr>
					<td>姓名:</td>
					<td><jsp:getProperty name="reg_member" property="name" /></td>
				</tr>
				<tr>
					<td>聯絡電話</td>
					<td><jsp:getProperty name="reg_member" property="phone" /></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><jsp:getProperty name="reg_member" property="mailaddress" /></td>
				</tr>
				<tr>
					<td>活動名稱:</td>
					<td><jsp:getProperty name="reg_member" property="eventname" /></td>
				</tr>
				<tr>
					<td>報名日期:</td>
					<td><jsp:getProperty name="reg_member" property="eventdate" />
					</td>
				</tr>
			</table>
			<div>
				<input type="submit" name="confirm" value="確認">
			</div>
		</fieldset>
	</form>
</div>
</body>
</html>