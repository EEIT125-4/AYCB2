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
<title>查詢報名</title>
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
	<form action="Inquiry.jsp" method="post" name="form1">
		<fieldset>
			<label>Name:</label> <input type="text" name="name" /><br /> <label>Phone:</label>
			<input type="text" name="phone" /><br /> <input class="sub1"
				type="submit" name="Inquiry" value="查詢預約" "/>

			<!-- input type="submit" name="delete" value="取消預約"  formatcion="delete.jsp"/> -->

		</fieldset>

	</form>
</div>

</body>
</html>