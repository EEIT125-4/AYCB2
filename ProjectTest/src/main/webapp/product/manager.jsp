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
<link REL=STYLESHEET HREF="css/ManagerPage.css" TYPE="text/css">
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
						href="managerbrand?brand=${brand}">${brand}</a></li>
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
						href="managerseries?series=${series}">${series}</a></li>
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
						href="managercate?cate=${cate}">${cate}</a></li>
					<c:if test='${vs.last }'>
						<c:out value="</ul>" escapeXml='false' />
					</c:if>
				</c:forEach>
			</div>
		</div>
		<div class="rightoutbox">
			<div class="addproduct">
				<form action="manageradd.jsp">
					<button class="addproduct_btn" type="submit">
						<img src="image/add.png">
					</button>
				</form>
			</div>
			<c:forEach var="pro" items="${Products}">
				<div class="rightside">
					<div class="imgbox">
						<a href="managerdetail?no=${pro.productno}"><img
							class="proimg" src="image/${pro.productname}.png"></a>
					</div>
					<div class="proname">${pro.productname}</div>
					<div class="buttonbox">
						<div class="proprice">NT$ ${pro.productprice}</div>
						<div class="cart">
							<a href="maintain?todo=remove&productno=${pro.productno}"> <img class="cartimg" src="image/bg_cart_b.svg"></a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<%@include file="../jspf/footer.jspf"%>
	</div>
</div>
</div>
</body>
</html>