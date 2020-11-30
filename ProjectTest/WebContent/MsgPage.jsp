<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="javax.sql.RowSet"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%><!-- 標準寫法,詳細參考網站https://www.javatpoint.com/jstl-sql-setdatasource-tag -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	boolean editable = false;
if (session.getAttribute("login_session") != null) {

	MemberBean member = (MemberBean) session.getAttribute("login_session");
	String userName = member.getName();

	System.out.println("msgPage got user" + userName);
	if (member.getName().equals("Kevin")) {
		editable = true;
	}

}

String type = request.getParameter("type");
String sql_type = (type != null && type != "") ? "msg_type like'" + type + "'" : "msg_type like '%%'";
System.out.println("sqltype:" + sql_type);
String sql_count = (request.getParameter("count") != null && request.getParameter("count") != "")
		? request.getParameter("count")
		: "";
System.out.println("sqlcount:" + sql_count);
String count = request.getParameter("count");
String sql_sort = (request.getParameter("sort") != null && request.getParameter("sort") != "")
		? request.getParameter("sort")
		: "";
System.out.println("sqlsort:" + sql_sort);
String sort = request.getParameter("sort");

//String sql_word=(request.getParameter("word")!=null && request.getParameter("word")!="")?"and msg_desc like'%"+request.getParameter("word")+"%'":"and msg_desc like '%%'";
String sql1="select "+sql_count+" * from message where "+sql_type+" order by msg_id "+sql_sort;
String word = request.getParameter("word");
String sql_word = (word != null && word != "")
		? " select*from message where msg_type like'%" + word + "%'" + " or msg_desc like'%" + word + "%'" + " or msg_title like '%" + word
		+ "%'" + " or msg_date like '%" + word + "%'"
		: "";

System.out.println("sql_word:" + sql_word);
%>

<sql:setDataSource var="ds" dataSource="jdbc/EmployeeDB" />

<sql:query var="rss" dataSource="${ds}">

<% if(word!=null && word!=""){ %>
<%=sql_word %>
<%} else {%>
<%=sql1 %>
<%} %>


</sql:query>

<%
	String check = "select " + sql_count + " * from message where " + sql_type + sql_word + " order by msg_id " + sql_sort;
System.out.println("check:" + check);
%>

<sql:query var="types" dataSource="${ds}"
	sql="select distinct msg_type from message" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://use.edgefonts.net/arizonia:n4:default.js"
	type="text/javascript"></script>
<link rel="stylesheet" href="css/message.css">
<title>MsgPage</title>
<style>
.reply {
	border: 1px solid black;
	border-radius: 15px;
	background-color: gray;
}
</style>
</head>

<%@include file="jspf/header.jspf"%>

<div class="mid">
	<aside id="left">
		<ul class="mid_ul">
			<li class="mid_ul_li"><a href="NewMsg.jsp">新增訊息</a></li>
			<li class="mid_ul_li"><select name="type" id="type">
					<%--onchange="alert(this.options[this.selectedIndex].text)" --%>
					<option value="" disabled selected hidden><%--sql_type --%></option>
					<option value="">All</option>
					<%--disabled selected hidden --%>
					<c:forEach var="type" items="${types.rows}">
						<option value="${type.msg_type}">${type.msg_type}</option>

					</c:forEach>
			</select></li>
			<li class="mid_ul_li"><select name="sort" id="sort">
					<option value="" disabled selected hidden>依時間排序<%--sql_sort--%></option>
					<option value="">All</option>
					<%--disabled selected hidden --%>
					<option value="asc">舊到新</option>
					<option value="desc">新到舊</option>


			</select></li>
			<li class="mid_ul_li"><select name="count" id="count">
					<option value="" disabled selected hidden>訊息筆數<%--sql_count --%></option>
					<option value="">All</option>
					<%--disabled selected hidden --%>
					<option value="top 10">最新10筆</option>
					<option value="top 20">最新20筆</option>
					<option value="top 50">最新50筆</option>
			</select></li>
		</ul>
		<input title="檢查內文時不檢查上面條件" id="word" type="text" name="word"
			placeholder="內容搜尋" style="width: 145px">
		<%--onfocus="alert('HI')" --%>

		<input type="button" value="篩選訊息" onclick="search()">

	</aside>

	<c:forEach var="row" items="${rss.rows}">


		<form action=".\MsgServlet" method="post">


			<article class="article">


				<h1 name="title" class="t1">${row.msg_title}</h1>
				<h2 name="type" class="t2">${row.msg_type}</h2>

				<input type="hidden" name="msg_id" value="${row.msg_id}"> <input
					class="editbtn" type=<%=(editable) ? "submit" : "hidden"%>
					name="submit" value="edit"> <input class="editbtn"
					type=<%=(editable) ? "submit" : "hidden"%> name="submit"
					value="delete"> <input class="editbtn2"
					type=<%=(editable) ? "button" : "hidden"%> name="reply"
					value="我要留言" ><%--onclick="replyClick()" --%>

				<figure class="msgfigure">
					<img class="img1" alt="圖片待補" title="${row.msg_title} "
						onerror="javascript:this.src='./image/noImage.jpg'" loading="lazy"
						src="${row.msg_imgpath}" />
					<figcaption class="msgfigcaption">${row.msg_title}</figcaption>
				</figure>
				<p class="msgp">${row.msg_id}</p>
				<p class="msgp">
					<textarea class="editable" name=title disabled>${row.msg_desc}</textarea>
				</p>

				<p>${row.msg_imgpath }</p>
				<p>會員回覆列</p>


			</article>


		</form>




	</c:forEach>

</div>
<%@include file="jspf/footer.jspf"%>

<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>

<script>

    
  
             
    //   
	function search() {

		//將各下拉選單中是哪一個被選到pick出來
		
		let select_type = type.value;//還不考慮多選
		let select_sort = sort.value;
		let select_count = count.value;
		let select_word = word.value;

		//window.alert(`type=${select_type},sort=${select_sort},count=${select_count}`);
	
		window.location.href = "MsgPage.jsp?type=" + select_type + "&sort="
				+ select_sort + "&count=" + select_count + "&word="
				+ select_word;

	}
	
      /*function replyClick() {
  		
  		
  		
  		alert("reply");
  		
  		let temp=document.getElementById("left");
  		
  		temp.append("<div>FFFFFFFF</div>");
  		//$(this).append('<div>FFFFFFFF</div>');
  	}*/



	

	$(document).ready(function(){
	    var type = document.getElementById('type');
		var sort = document.getElementById('sort');
		var count = document.getElementById('count');
		var word = document.getElementById('word');
      $('.editbtn2').click(function(){
    	  $("p").append('<p>test</p>');
               
                
                console.log('is click');
                
                                     
                })
	})

	

</script>
</body>
</html>