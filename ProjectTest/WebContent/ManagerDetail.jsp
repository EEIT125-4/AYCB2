<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="product.*"%>
<%@page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<sql:setDataSource var="ds" dataSource="jdbc/EmployeeDB" />
<sql:query sql="select distinct brand_name from profinal" var="rs1"
	dataSource="${ds}" />
<sql:query sql="select distinct product_series from profinal" var="rs2"
	dataSource="${ds}" />
<sql:query sql="select distinct product_category from profinal"
	var="rs3" dataSource="${ds}" />

<%@include file="jspf/managerheader.jspf"%>
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
							href="ManagerScreening?brandname=${brandname.brand_name}">${brandname.brand_name}</a></li>
					</c:forEach>
				</ul>
				<div class="catediv">
					系列分類<a id="a2" class="catea" href="#" onclick="show2()">+</a>
				</div>
				<ul id="ul2" class="cateul">
					<c:forEach var="series" items="${rs2.rows}">
						<li class="cateul_li"><a class="cateul_li_a"
							href="ManagerScreening?series=${series.product_series}">${series.product_series}</a></li>
					</c:forEach>
				</ul>
				<div class="catediv">
					種類分類<a id="a3" class="catea" href="#" onclick="show3()">+</a>
				</div>
				<ul id="ul3" class="cateul">
					<c:forEach var="cate" items="${rs3.rows}">
						<li class="cateul_li"><a class="cateul_li_a"
							href="ManagerScreening?cate=${cate.product_category}">${cate.product_category}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="rightoutbox">
			<%
				for (int i = 0; i < ProductDetailDB.size(); i++) {
			%>
			<div class="funbox">
				<form>
					<input id="update" class="funbtn" type="button" value="更新">
				</form>
			</div>
			<form name="UpdateForm" action="Manager" method="POST">
				<div class="rightside">
					<div class="imgbox">
						<a href="#"><img
							src="image/<%=ProductDetailDB.getProduct_Name(i)%>.png"></a>
					</div>
				</div>
				<div class="infobox">
					<div class="infoname"><%=ProductDetailDB.getProduct_Name(i)%></div>
					<div class="infono">
						商品編號：<%=ProductDetailDB.getBrand_No(i)%><%=ProductDetailDB.getProduct_No(i)%></div>
					<hr>
					<div class="infoseries">
						系列：<%=ProductDetailDB.getProduct_Series(i)%></div>
					<div class="infocate">
						種類：<%=ProductDetailDB.getProduct_Category(i)%></div>
					<hr>
					<div id="infoprice" class="infoprice">
						NT$：<%=ProductDetailDB.getProduct_Price(i)%></div>
					<div id="updatebox" class="updatebox">
						<input type="hidden" name="todo" value="update"> <input
							type="hidden" name="productname"
							value="<%=ProductDetailDB.getProduct_Name(i)%>"> <input
							class="updatetext" type="text" name="productprice"> <input
							type="submit" class="updatebtn" value="更新">
					</div>
					<div class="infocount">
						數量 :
						<div class="selbox">
							<select name="count" class="countsel">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
							</select>
						</div>
					</div>
				</div>
			</form>
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