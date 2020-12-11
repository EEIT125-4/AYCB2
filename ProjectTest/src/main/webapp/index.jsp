<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script src="js/Home.js" defer="defer"></script>
<title>All You Can Buy</title>
</head>
<%@include file="jspf/header.jspf"%>
<div class="adbox">
	<ul class="adbox_slides">
		<li><img src="image/ad1.jpg"></li>
		<li><img src="image/ad2.png"></li>
	</ul>
	<ul class="adbox_dot">
		<li id="1"></li>
		<li id="2"></li>
	</ul>
	<div id="prevbtn" class="adbox_btn">
		<i class="fa fa-chevron-left"></i>
	</div>
	<div id="nextbtn" class="adbox_btn">
		<i class="fa fa-chevron-right"></i>
	</div>
</div>
<%@include file="jspf/footer.jspf"%>
</body>
</html>