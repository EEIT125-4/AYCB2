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
<title>報名活動</title>
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
	<div>
	<form action=".\EventServlet" method="POST">
		<fieldset>
			<legend>
				<h2>報名資料</h2>
			</legend>
			<div class="form1">
				<label for="a1" class="label1">姓名:</label> <input type="text"
					id="a1" name="name" placeholder="guest" size="10" autofocus
					autocomplete="off"><br>
			</div>
			<div class="form1">
				<label for="p1" class="label1">電話:</label> <input type="text"
					id="p1" name="phone" maxlength="10"><br>
			</div>
			<div class="form1">
				<label for="ma1" class="label1">email:</label> <input type="email"
					name="mailaddress" id="ma1">
			</div>
			<div class="form1">
				<label for="" class="label1">活動名稱</label> <select name="eventname">
					<option>選擇活動名稱</option>
					<option>專屬VIP 手作唇膏體驗會</option>
					<option>肌膚護理&化妝技巧四小時全教妳</option>
					<option>設計專屬於你的保養品</option>
					<option>產品成分講座</option>
					<option>最新上市搶先體驗</option>
					<option>在家也能自己做肌膚護理</option>
				</select>
			</div>
			<div class="form1">
				<label for="" class="label1">參加活動日期</label> <input type="date"
					name="eventdate">
			</div>
			<div class="sub">
				<input type="submit" name="submit" value="送出"> <input
					type="reset" name="clear" value="清除">
			</div>
		</fieldset>
	</form>
	</div>
</div>

</body>
</html>