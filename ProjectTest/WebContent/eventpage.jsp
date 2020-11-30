<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link REL=STYLESHEET HREF="css/eventpage.css" TYPE="text/css">
<link rel="icon" href="image/logo.ico" type="image/x-icon">
<title>預約活動</title>
</head>
<%@include file="jspf/header.jspf"%>
<div style="position: relative; top: 200px;">
	<div
		style="float: left; width: 20%; text-align: center; margin-left: 220px;">
		<dl>
			<dt>
				<h2>預約活動</h2>
			</dt>
			<hr width=70% size=1 color=#BFBFBF
				style="FILTER: alpha(opacity = 100, finishopacity = 0, style = 3)">
			<dt class="a1">
				<A href="eventpage.jsp">
					<h2>活動介紹</h2>
				</A>
			</dt>
			<dt class="a1">
				<A href="eventform.jsp">
					<h2>報名活動</h2>
				</A>
			</dt>
			<dt class="a1">
				<A href="input.jsp">
					<h2>查詢報名</h2>
				</A>
			</dt>
			<dt class="a1">
				<A href="deleteinput.jsp">
					<h2>取消報名</h2>
				</A>
			</dt>
			<dt class="a1">
				<A href="updateinput.jsp">
					<h2>更改報名資料</h2>
				</A>
			</dt>
		</dl>
	</div>
	<div style="float: left; width: 50%;">
		<div class="event" data-event="1">
			<h2>CHANEL</h2>
			<h3>專屬VIP 手作唇膏體驗會</h3>
			<p>
				提供會員專業資訊，專職美容師授課，北部有中心授課，中南部則在各區域辦公室的教室授課，另可
				至專櫃上免費彩妝，該公司亦會機動性配合百貨公司辦美容講座<span id="dots">...</span><span
					id="more">。至該公司上課所 有彩妝品及工具都提供。講習內容包括：日常肌膚護理、美研化妝常識及技巧、解
					答個人問題、香水知識。採11人左右小班制，報名費500元，於上課後送五百元等值
					購物禮卷、美研隨身包及不同季節的產品樣品組合。上課時間共二天四小時。其彩 妝課另包括美妍妝、宴會新娘妝、盛妝、手部按摩與指甲修飾。</span>
			</p>
			<button style="border: none; background-color: transparent;"
				onclick="myFunction()" id="myBtn">Read more</button>
		</div>
		<div class="event" data-event="2">
			<h2>客製教學－1對1彩妝教學</h2>
			<h3>肌膚護理&化妝技巧四小時全教妳</h3>
			<p>
				提供會員專業資訊，專職美容師授課，北部有中心授課，中南部則在各區域辦公室的教室授課，另可
				至專櫃上免費彩妝，該公司亦會機動性配合百貨公司辦美容講座<span id="dots">...</span><span
					id="more">。至該公司上課所 有彩妝品及工具都提供。講習內容包括：日常肌膚護理、美研化妝常識及技巧、解
					答個人問題、香水知識。採11人左右小班制，報名費500元，於上課後送五百元等值
					購物禮卷、美研隨身包及不同季節的產品樣品組合。上課時間共二天四小時。其彩 妝課另包括美妍妝、宴會新娘妝、盛妝、手部按摩與指甲修飾。</span>
			</p>
			<button style="border: none; background-color: transparent;"
				onclick="myFunction()" id="myBtn">Read more</button>
		</div>
		<div class="event" data-event="3">
			<h2>DIY手做保養品</h2>
			<h3>設計專屬於你的保養品</h3>
			<p>
				提供會員專業資訊，專職美容師授課，北部有中心授課，中南部則在各區域辦公室的教室授課，另可
				至專櫃上免費彩妝，該公司亦會機動性配合百貨公司辦美容講座<span id="dots">...</span><span
					id="more">。至該公司上課所 有彩妝品及工具都提供。講習內容包括：日常肌膚護理、美研化妝常識及技巧、解
					答個人問題、香水知識。採11人左右小班制，報名費500元，於上課後送五百元等值
					購物禮卷、美研隨身包及不同季節的產品樣品組合。上課時間共二天四小時。其彩 妝課另包括美妍妝、宴會新娘妝、盛妝、手部按摩與指甲修飾。。</span>
			</p>
			<button style="border: none; background-color: transparent;"
				onclick="myFunction()" id="myBtn">Read more</button>
		</div>
		<div class="event" data-event="4">
			<h2>產品成分講座</h2>
			<h3>教你讀懂產品成分、功效、適用膚質</h3>
			<p>
				提供會員專業資訊，專職美容師授課，北部有中心授課，中南部則在各區域辦公室的教室授課，另可
				至專櫃上免費彩妝，該公司亦會機動性配合百貨公司辦美容講座<span id="dots">...</span><span
					id="more">。至該公司上課所 有彩妝品及工具都提供。講習內容包括：日常肌膚護理、美研化妝常識及技巧、解
					答個人問題、香水知識。採11人左右小班制，報名費500元，於上課後送五百元等值
					購物禮卷、美研隨身包及不同季節的產品樣品組合。上課時間共二天四小時。其彩 妝課另包括美妍妝、宴會新娘妝、盛妝、手部按摩與指甲修飾。。</span>
			</p>
			<button style="border: none; background-color: transparent;"
				onclick="myFunction()" id="myBtn">Read more</button>
		</div>
		<div class="event" data-event="5">
			<h2>新品體驗活動</h2>
			<h3>最新上市搶先體驗</h3>
			<p>
				提供會員專業資訊，專職美容師授課，北部有中心授課，中南部則在各區域辦公室的教室授課，另可
				至專櫃上免費彩妝，該公司亦會機動性配合百貨公司辦美容講座<span id="dots">...</span><span
					id="more">。至該公司上課所 有彩妝品及工具都提供。講習內容包括：日常肌膚護理、美研化妝常識及技巧、解
					答個人問題、香水知識。採11人左右小班制，報名費500元，於上課後送五百元等值
					購物禮卷、美研隨身包及不同季節的產品樣品組合。上課時間共二天四小時。其彩 妝課另包括美妍妝、宴會新娘妝、盛妝、手部按摩與指甲修飾。。</span>
			</p>
			<button style="border: none; background-color: transparent;"
				onclick="myFunction()" id="myBtn">Read more</button>
		</div>
		<div class="event" data-event="6">
			<h2>ESTEE LAUDER</h2>
			<h3>在家也能自己做肌膚護理</h3>
			<p>
				提供會員專業資訊，專職美容師授課，北部有中心授課，中南部則在各區域辦公室的教室授課，另可
				至專櫃上免費彩妝，該公司亦會機動性配合百貨公司辦美容講座<span id="dots">...</span><span
					id="more">。至該公司上課所 有彩妝品及工具都提供。講習內容包括：日常肌膚護理、美研化妝常識及技巧、解
					答個人問題、香水知識。採11人左右小班制，報名費500元，於上課後送五百元等值
					購物禮卷、美研隨身包及不同季節的產品樣品組合。上課時間共二天四小時。其彩 妝課另包括美妍妝、宴會新娘妝、盛妝、手部按摩與指甲修飾。。</span>
			</p>
			<button style="border: none; background-color: transparent;"
				onclick="myFunction()" id="myBtn">Read more</button>
		</div>
	</div>
</div>
<script>
function myFunction() {
    var dots = document.getElementById("dots");
    var moreText = document.getElementById("more");
    var btnText = document.getElementById("myBtn");

    if (dots.style.display === "none") {
        dots.style.display = "inline";
        btnText.innerHTML = "Read more";
        moreText.style.display = "none";
    } else {
        dots.style.display = "none";
        btnText.innerHTML = "Read less";
        moreText.style.display = "inline";
    }
} 
</script>
</body>

</html>