<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<sql:setDataSource var="ds" dataSource="jdbc/EmployeeDB" />
<sql:query sql="select distinct brand_name from profinal" var="rs1"
	dataSource="${ds}" />
<sql:query sql="select distinct product_series from profinal" var="rs2"
	dataSource="${ds}" />
<sql:query sql="select distinct product_category from profinal"
	var="rs3" dataSource="${ds}" />

<%@include file="jspf/managerheader.jspf"%>
<div class="addbox">
	<div>
		<form action="Manager">
			<fieldset class="addfs">
				<legend class="addtitle">新增</legend>
				<input type="hidden" name="todo" value="add">
				<div class="adddiv">
					<label class="addlab">廠牌名稱:</label> <select class="addsel"
						name="brandname">
						<c:forEach var="brandname" items="${rs1.rows}">
							<option>${brandname.brand_name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="adddiv">
					<label class="addlab">產品系列:</label> <select class="addsel"
						name="productseries">
						<c:forEach var="series" items="${rs2.rows}">
							<option>${series.product_series}</option>
						</c:forEach>
					</select>
				</div>
				<div class="adddiv">
					<label class="addlab">產品種類:</label> <select class="addsel"
						name="productcate">
						<c:forEach var="cate" items="${rs3.rows}">
							<option>${cate.product_category}</option>
						</c:forEach>
					</select>
				</div>
				<div class="adddiv">
					<label class="addlab">產品名稱:</label> <input type="text"
						name="productname" class="addinput">
				</div>
				<div class="adddiv">
					<label class="addlab">產品價格:</label> <input type="text"
						name="productprice" class="addinput">
				</div>
				<div class="adddiv">
					<input type="submit" value="新增" class="addbtn">
				</div>
			</fieldset>
		</form>
	</div>
</div>
<%@include file="jspf/footer.jspf"%>
</body>
</html>