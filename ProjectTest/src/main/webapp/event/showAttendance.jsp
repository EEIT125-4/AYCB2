<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>
<head>

	
<meta charset="UTF-8">
<title>活動資料</title>
</head>
<body>
	<p>&nbsp;</p>
	<hr>
	<div class='center'>
		<h1>活動資料</h1>
		<c:if test='${empty allAttendance}'>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		查無活動資料<br>
		</c:if>
		<c:if test='${not empty allAttendance}'>
			
			<table border='1'>
				<tr>
					<tr>
					<td>帳號</td>
					<td>活動ID</td>
					<td>mail</td>
					<td>電話號碼</td>
					<td>參加人數</td>
				</tr>
				
				<c:forEach var='Attendance' varStatus='vs' items='${allAttendance}'>
					
					<tr>
						  <td><a href='FindAttendance.do?key=${Attendance.aid}'>${Attendance.memberID}</a></td>
					     <td>${Attendance.eventID}</td> 
						<td>${Attendance.mailaddress}</td> 
 						<td>${Attendance.phone}</td>
						<td>${Attendance.pax}</td> 
					
					</tr>
				</c:forEach>
			</table>
			
		</c:if>
		<p />
		<a href="${pageContext.request.contextPath}/event/eventIndex.jsp">回到活動管理</a>

	</div>
</body>
</html>