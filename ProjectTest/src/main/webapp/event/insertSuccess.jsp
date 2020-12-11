<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/eventpage.css">
<title>新增報名資料成功</title>
</head>
<%@include file="../jspf/header.jspf"%>
<body>
	<div style=' position: relative; top: 200px;'>
		<h1>新增報名資料成功</h1>
		<!-- 
本文件顯示會員資料新增成功的訊息，要顯示的會員資料由Controller放入『Session範圍』內
，成為Session物件的屬性物件，識別字串為mb, 我們將屬性物件內的帳號與姓名取出，放在
本文件中，一起送回給瀏覽器
-->
		親愛的:${a.memberID}<br> 您已成功報名 ,謝謝 <a
			href='${pageContext.request.contextPath}/event/eventIndex.jsp'>回到報名管理</a>
	</div>
</body>
<%@include file="../jspf/footer.jspf"%>
</html>