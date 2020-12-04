<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!-- c核心 http://java.sun.com/jsp/jstl/sql標準寫法 -->
<%-- <sql:setDataSource var="ds" dataSource="jdbc/EmployeeDB" /> --%>
 <!-- ds定義是dataSource -->
<%-- <sql:query sql="select * from comment"  var="comment" dataSource="${ds}" />    --%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/comment.css" />

<title>留言紀錄</title>
</head>
<%@include file="jspf/header.jspf"%>
<fieldset style="margin: auto;position: relative;top: 200px;width: 1200px;border: 1px solid transparent;">

		<div style="float: left; width:20%; text-align: center;">

			<dl class="disscussarea">
				<dt>
					<h2>討論區</h2>
				</dt>
				<hr width=70% size=1 color=#BFBFBF style="FILTER: alpha(opacity = 100, finishopacity = 0, style = 3)">
				
				<dt>
					<A class="a1" href="DisplayBoard.jsp">
						<h2>留言專區</h2>
					</A>
				</dt>
				<dt>
					<A class="a1" href="article.jsp">
						<h2>美誌分享</h2>
					</A>
				</dt>
				<dt>
					<A class="a1" href="#">
						<h2>影音專區</h2>
					</A>
				</dt>
			</dl>
		</div>
		</div>

	<h2>查詢留言紀錄</h2>
	<FORM ACTION=".\DeleteServlet" method="Post">
  <table class="selectrecord">
  	<th class="title1">id</th>
    <th class="title1" style="width:50px">name</th>
    <th class="title1">gender</th>
    <th class="title1">age</th>
    <th class="title1">status</th>
    <th class="title1">commentTime</th>
    <th class="title1">contentBox</th>
    <th class="title1">update</th>
    <th class="title1" style="width:50px";>delete</th>
    
   
  	<!-- Select -->
    <c:forEach var="row" items="${comment.rows}">
    <!-- row一筆資料 -->
    <tr>
    <td class="row" style="text-align:center;">${row.id}</td>
    <td class="row" style="text-align:center;">${row.name}</td>
    <td class="row" style="text-align:center;">${row.gender}</td>
    <td class="row" style="text-align:center;">${row.age}</td>
    <td class="row" style="text-align:center;">${row.status}</td>
    <td class="row" style="text-align:center;">${row.commentTime}</td>
    <td class="row" style="text-align:center;">${row.contentBox}</td>
    <td class="row" style="text-align:center;"><button style="width:auto; height:auto ;margin-top:0px;"name="update" value="${row.id}">更新</button></td>
    
    <td class="row" style="text-align:center;"><button style="width:auto; height:auto ;margin-top:0px;" name="delete" value="${row.name}">刪除</button></td>
    </tr>
    </c:forEach>
  </table>
  </FORM>
</body>
  </fieldset>

</html>