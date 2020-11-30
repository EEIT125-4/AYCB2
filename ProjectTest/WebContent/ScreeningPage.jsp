<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="product.*"%>
<%@page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<sql:setDataSource var="ds" dataSource="jdbc/EmployeeDB" />
<sql:query sql="select distinct brand_name from profinal" var="rs1"
	dataSource="${ds}" />
<sql:query sql="select distinct product_series from profinal" var="rs2"
	dataSource="${ds}" />
<sql:query sql="select distinct product_category from profinal"
	var="rs3" dataSource="${ds}" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script src="js/inside.js" defer="defer"></script>
<link REL=STYLESHEET HREF="css/inside.css" TYPE="text/css">
<title>All You Can Buy</title>
</head>
<%@include file="jspf/header.jspf"%>
<div class="contentoutbox">
	<div class="contentbox">
		<div class="leftside">
			<div class="condition">條件篩選</div>
			<div class="category">
				<div class="catediv">
					廠商分類<a id="a1" class="catea" href="#" onclick="show1()">+</a>
				</div>
				<ul id="ul1" class="cateul">
					<c:forEach var="brandname" items="${rs1.rows}">
						<li class="cateul_li"><a class="cateul_li_a"
							href="Screening?brandname=${brandname.brand_name}">${brandname.brand_name}</a></li>
					</c:forEach>
				</ul>
				<div class="catediv">
					系列分類<a id="a2" class="catea" href="#" onclick="show2()">+</a>
				</div>
				<ul id="ul2" class="cateul">
					<c:forEach var="series" items="${rs2.rows}">
						<li class="cateul_li"><a class="cateul_li_a"
							href="Screening?series=${series.product_series}">${series.product_series}</a></li>
					</c:forEach>
				</ul>
				<div class="catediv">
					種類分類<a id="a3" class="catea" href="#" onclick="show3()">+</a>
				</div>
				<ul id="ul3" class="cateul">
					<c:forEach var="cate" items="${rs3.rows}">
						<li class="cateul_li"><a class="cateul_li_a"
							href="Screening?cate=${cate.product_category}">${cate.product_category}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="rightoutbox">
			<%
				for (int i = 0; i < ScreeningDB.size(); i++) {
			%>
			<div class="rightside">
				<div class="imgbox">
					<a
						href="ProductDetail?brandno=<%=ScreeningDB.getBrand_No(i)%>&productno=<%=ScreeningDB.getProduct_No(i)%>"><img
						class="proimg" src="image/<%=ScreeningDB.getProduct_Name(i)%>.png"></a>
				</div>
				<div class="proname"><%=ScreeningDB.getProduct_Name(i)%></div>
				<div class="buttonbox">
					<div class="proprice">
						NT$
						<%=ScreeningDB.getProduct_Price(i)%></div>
					<div class="cart">
						<a href=""><img class="cartimg" src="image/bg_cart_b.svg">
					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>
		<%@include file="jspf/footer.jspf"%>
	</div>
</div>
</div>
</body>
</html>