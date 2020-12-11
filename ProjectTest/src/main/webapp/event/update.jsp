<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<style>
</style>

<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/eventpage.css">
<title>修改報名資料</title>
<script type="text/javascript">
	function confirmDelete(memberID) {
		var result = confirm("確定取消參加(帳號:" + memberID + ")?");
		if (result) {
			document.forms[1].finalDecision.value = "DELETE";
			return true;
		}
		return false;
	}
	function confirmUpdate(memberID) {
		var result = confirm("確定送出此筆記錄(帳號:" + memberID + ")?");
		if (result) {
			document.forms[1].finalDecision.value = "UPDATE";
			return true;
		}
		return false;
	}
</script>
</head>
<%@include file="../jspf/header.jspf"%>

<body>
	<p>&nbsp;</p>
	<hr>
	<div class='center' style=' position: relative; top: 200px;'>
		<H1 class='center'>更新報名資料</H1>
		<hr>
		<p>
		<Form class='center' Action="AttendanceUpdate.do" method="POST">
			<input type="hidden" name="aid" value="${a.aid}"> <input
				type="hidden" name="MemberID" value="${a.memberID}"> <input
				type="hidden" name="finalDecision" value="">
			<Table>
				<TR>
					<TD align="RIGHT">活動ID：</TD>
					<TD align="LEFT"><input type="text" name="EventID"
						value="${a.eventID}${param.eventID}" size="30"> <font
						color='red' size='-3'>${error.eid}</font></TD>
				</TR>
				<TR>
					<TD align="RIGHT">Phone：</TD>
					<TD align="LEFT"><input type="text" name="Phone"
						value="${a.phone}${param.phone}"> <font color='red'
						size='-3'>${error.phone}</font></TD>
				</TR>
				<TR>
					<TD align="RIGHT">mail：</TD>
					<TD align="LEFT"><input type="text" name="Mailaddress"
						value="${a.mailaddress}${param.mailaddress}"> <font
						color='red' size='-3'>${error.mail}</font></TD>
				</TR>


				<TR>
					<TD align="RIGHT">pax：</TD>
					<TD align="LEFT"><input type="text" name="Pax"
						value="${a.pax}${param.pax}"> <font color='red' size='-3'>${error.pax}</font>
					</TD>
				</TR>

				<TR>
					<TD colspan="2" align="center"><input type="submit" value="更新"
						name='updateBtn' onclick="return confirmUpdate('${a.memberID}');">
						<input type="submit" value="刪除" name='deleteBtn'
						onclick="return confirmDelete('${a.memberID}');"></TD>
				</TR>
			</Table>
			<c:if test="${not empty requestScope.modify}">
				<c:remove var="member" scope="request" />
			</c:if>
		</Form>
		<p />
		<small>&lt;&lt;<a href="javascript:history.back()">回上一頁</a>&gt;&gt;
		</small>
	</div>
</body>
<%@include file="../jspf/footer.jspf"%> 

</html>
