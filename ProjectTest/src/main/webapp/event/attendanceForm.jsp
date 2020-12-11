<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>新增會員資料</title>
</head>
<body>
<p>&nbsp;</p>
<hr>
<div class='center'>
<H1>新增報名資料</H1>
<form  action='../insertAttendance.do'  method='POST'  >
帳號:<input type='text'      name='MemberID'   value='${param.memberid}'> <br> 
<font color='red' size='-3'>${error.id}</font><br><br>

電話號碼:<input type='text'  name='Phone' value='${param.phone}'><br>
<font color='red' size='-3'>${error.phone}</font><br><br>

mail:<input type='text'   name='Mailaddress' value='${param.Mailaddress}'><br>
<font color='red' size='-3'>${error.mail}</font><br><br>

活動ID:<input type='text'   name='EventID' value='${param.eventid}'><br>
<font color='red' size='-3'>${error.eid}</font><br><br>

參加人數:<input type='text'   name='Pax' value='${param.pax}'><br>
<font color='red' size='-3'>${error.pax}</font><br><br>

<input type='submit'      name='name' value='提交' >
<input type='reset'      name='name' value='還原' ><br><br>	


<a href='${pageContext.request.contextPath}/event/eventIndex.jsp'>回到報名管理</a>
</form>
</div>
</body>
</html>