<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>會員資料管理</title>
</head>  
<body>
<p>&nbsp;</p>
<hr>
<div class='center' >
<h2>報名資料管理</h2>
<hr>
<a href='${pageContext.request.contextPath}/event/attendanceForm.jsp' >報名參加</a><br>
<a href='${pageContext.request.contextPath}/queryAllAttendance.do' >報名資料查詢</a><br>
<br>


<a href="javascript:history.back()">回上一頁</a>
</div>
</body>
</html>