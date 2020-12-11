<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/inside.js" defer="defer"></script>
<script src="js/manager.js" defer="defer"></script>
<link REL=STYLESHEET HREF="css/inside.css" TYPE="text/css">
<link REL=STYLESHEET HREF="css/ProductDetail.css" TYPE="text/css">
<link REL=STYLESHEET HREF="css/ManagerDetail.css" TYPE="text/css">
<title>Manager</title>
</head>
<%@include file="../jspf/managerheader.jspf"%>
<div class="contentoutbox">
	<div class="contentbox">
		<div class="leftside">
			<div class="condition">條件篩選</div>
			<div class="category">
				<div class="catediv">
					廠商分類<a id="a1" class="catea" href="#" onclick="show1()">+</a>
				</div>
				<c:forEach var="brand" varStatus='vs' items="${Brands}">
					<c:if test='${vs.first }'>
						<c:out value="<ul id='ul1' class='cateul'>" escapeXml='false' />
					</c:if>
					<li class="cateul_li"><a class="cateul_li_a"
						href="BrandServlet?brand=${brand}">${brand}</a></li>
					<c:if test='${vs.last }'>
						<c:out value="</ul>" escapeXml='false' />
					</c:if>
				</c:forEach>
				<div class="catediv">
					系列分類<a id="a2" class="catea" href="#" onclick="show2()">+</a>
				</div>
				<c:forEach var="series" varStatus='vs' items="${series}">
					<c:if test='${vs.first }'>
						<c:out value="<ul id='ul2' class='cateul'>" escapeXml='false' />
					</c:if>
					<li class="cateul_li"><a class="cateul_li_a"
						href="SeriesServlet?series=${series}">${series}</a></li>
					<c:if test='${vs.last }'>
						<c:out value="</ul>" escapeXml='false' />
					</c:if>
				</c:forEach>
				<div class="catediv">
					種類分類<a id="a3" class="catea" href="#" onclick="show3()">+</a>
				</div>
				<c:forEach var="cate" varStatus='vs' items="${cates}">
					<c:if test='${vs.first }'>
						<c:out value="<ul id='ul3' class='cateul'>" escapeXml='false' />
					</c:if>
					<li class="cateul_li"><a class="cateul_li_a"
						href="CateServlet?cate=${cate}">${cate}</a></li>
					<c:if test='${vs.last }'>
						<c:out value="</ul>" escapeXml='false' />
					</c:if>
				</c:forEach>
			</div>
		</div>
		<div class="rightoutbox">
			<c:forEach var="D" items="${Detail}">
				<div class="funbox">
					<form>
						<input id="update" class="funbtn" type="button" value="更新">
					</form>
				</div>
				<form name="UpdateForm" action="maintain" method="POST">
					<div class="rightside">
						<div class="imgbox">
							<a href="#"><img src="image/${D.productname}.png"></a>
						</div>
					</div>
					<div class="infobox">
						<div class="infoname">${D.productname}</div>
						<div class="infono">商品編號：${D.brandno}${D.productno}</div>
						<hr>
						<div class="infoseries">系列：${D.productseries}</div>
						<div class="infocate">種類：${D.productcategory}</div>
						<hr>
						<div id="infoprice" class="infoprice">NT$：${D.productprice}</div>
						<div id="updatebox" class="updatebox">
							<input type="hidden" name="todo" value="update"> 
							<input type="hidden" name="productno" value="${D.productno}">
							<input type="hidden" name="brandno" value="${D.brandno}">
							<input type="hidden" name="brandname" value="${D.brandname}">
							<input type="hidden" name="producttype" value="${D.producttype}">
							<input type="hidden" name="productname" value="${D.productname}">
							<input type="hidden" name="productseries" value="${D.productseries}">
							<input type="hidden" name="productcategory" value="${D.productcategory}">
							<input type="hidden" name="skintype" value="${D.skintype}">
							<input class="updatetext" type="text" name="productprice">
							<input type="submit" class="updatebtn" value="更新">
						</div>
						<div>
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
					</div>
				</form>
			</c:forEach>
		</div>
		<%@include file="../jspf/footer.jspf"%>
	</div>
</div>
</div>

</body>
</html>