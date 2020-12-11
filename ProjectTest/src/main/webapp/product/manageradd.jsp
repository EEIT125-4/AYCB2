<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link REL=STYLESHEET HREF="css/inside.css" TYPE="text/css">
<link REL=STYLESHEET HREF="css/ManagerAdd.css" TYPE="text/css">
<title>Manager</title>
</head>
<%@include file="../jspf/managerheader.jspf"%>
<div class="addbox">
	<div>
		<form action="maintain">
			<input type="hidden" name="todo" value="add">
			<fieldset class="addfs">
				<legend class="addtitle">新增</legend>
				<div class="adddiv">
					<label class="addlab">廠牌名稱:</label> <input type="text"
						name="brandname" class="addinput">
				</div>
				<div class="adddiv">
					<label class="addlab">產品類型:</label> <select class="addsel"
						name="producttype">
						<option>保養品</option>
						<option>彩妝</option>
					</select>
				</div>
				<div class="adddiv">
					<label class="addlab">產品名稱:</label> <input type="text"
						name="productname" class="addinput">
				</div>
				<div class="adddiv">
					<label class="addlab">產品系列:</label> <input type="text"
						name="productseries" class="addinput">
				</div>
				<div class="adddiv">
					<label class="addlab">產品種類:</label> <input type="text"
						name="productcategory" class="addinput">
				</div>
				<div class="adddiv">
					<label class="addlab">產品價格:</label> <input type="text"
						name="productprice" class="addinput">
				</div>
				<div class="adddiv">
					<label class="addlab">產品圖片:</label> 
					<input type="file" name="productimg">
				</div>
				<div class="adddiv">
					<input type="submit" value="新增" class="addbtn">
				</div>
			</fieldset>
		</form>
	</div>
</div>
<%@include file="../jspf/footer.jspf"%>
</body>
</html>