<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script src="js/inside.js" defer="defer"></script>
<link REL=STYLESHEET HREF="css/inside.css" TYPE="text/css">
<link REL=STYLESHEET HREF="css/ProductDetail.css" TYPE="text/css">
<title>All You Can Buy</title>
</head>
<%@include file="../jspf/header.jspf"%>
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
				<form name="AddForm" action="ControllerServlet" method="POST">
					<input type="hidden" name="todo" value="add">
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
						<div class="infoprice">NT$：${D.productprice}</div>
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
								<div class="infobtn">
									<input class="btn" type="submit" value="加入購物車"> <input
										type="hidden" name="productno" value="${D.productno}">
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