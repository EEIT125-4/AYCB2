<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/eventpage.css">
<title>新增會員資料</title>
</head>
<%@include file="../jspf/header.jspf"%>
<body>

	<div style=' position: relative; top: 200px;'>
		<div>
			<div
				style="float: left; width: 20%; text-align: center; margin-left: 220px;">

				<dl>
					<dt>
						<h2>預約活動</h2>
					</dt>
					<hr width=70% size=1 color=#BFBFBF
						style="FILTER: alpha(opacity = 100, finishopacity = 0, style = 3)">
					<dt class="a1">
						<A href="eventpage.html">
							<h2>活動介紹</h2>
						</A>
					</dt>
					<dt class="a1">
						<a
							href='${pageContext.request.contextPath}/event/attendanceForm.jsp'>
							<h2>報名參加</h2>
						</a>
					</dt>
					<dt class="a1">
						<A href='${pageContext.request.contextPath}/queryAllAttendance.do'>
							<h2>查詢報名</h2>
						</A>
					</dt>

				</dl>
			</div>
		</div>


		<div>

			<form action='../insertAttendance.do' method='POST'>
				<fieldset>
					<legend>
						<h2>報名資料</h2>
					</legend>
					<div class="form1">
						<label class="label1">帳號:</label> <input type='text'
							name='MemberID' value='${param.memberid}'> <br> <font
							color='red' size='-3'>${error.id}</font><br>
					</div>
					<div class="form1">
						<label class="label1">電話號碼:</label> <input type='text'
							name='Phone' value='${param.phone}'><br> <font
							color='red' size='-3'>${error.phone}</font><br>
					</div>
					<div class="form1">
						<label class="label1">mail:</label> <input type='text'
							name='Mailaddress' value='${param.Mailaddress}'><br>
						<font color='red' size='-3'>${error.mail}</font><br>
					</div>
					<div class="form1">
						<label class="label1">活動ID:</label> <input type='text'
							name='EventID' value='${param.eventid}'><br> <font
							color='red' size='-3'>${error.eid}</font><br>
					</div>
					<div class="form1">
						<label class="label1">參加人數:</label> <input type='text' name='Pax'
							value='${param.pax}'><br> <font color='red'
							size='-3'>${error.pax}</font><br>
					</div>


					<div class="sub">
						<input type='submit' name='name' value='提交'> <input
							type='reset' name='name' value='還原'><br>
					</div>

				</fieldset>
			</form>
			<a href='${pageContext.request.contextPath}/event/eventIndex.jsp'>回到報名管理</a>
		</div>
	</div>
</body>
<%@include file="../jspf/footer.jspf"%>
</html>