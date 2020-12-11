<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", -1); // 不想要暫存 Prevents caching at the proxy server
%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/comment.css" />
<title>留言板</title>
</head>
<%@include file="../jspf/header.jspf"%>
<div>
	<div
		style="float: left; width: 20%; text-align: center; margin-left: 220px; position: relative; top: 200px;">

		<dl>
			<dt>
				<h2>討論區</h2>
			</dt>
			<hr width=70% size=1 color=#BFBFBF
				style="FILTER: alpha(opacity = 100, finishopacity = 0, style = 3)">
			<dt>
				<A class="a1" href="../DeleteServlet1"><h2>查詢留言</h2></A>
			</dt>

			<dt>
				<A class="a1" href="article.jsp">
					<h2>美誌分享</h2>
				</A>
			</dt>
			<dt>
				<A class="a1" href="#">
					<h2>影音專區</h2>
				</A>
			</dt>
		</dl>
	</div>
</div>
<div id="content">
	<div id="post" style="margin-top: 60px;">

		<H1 class="board" style="border-radius: 10px" ALIGN="CENTER">留言佈告欄</H1>

		<FORM ACTION="../Controller" method="Post">
			<Fieldset class="discussionbox">
				<div>
					<label>會員名稱：</label> <input type="text" id="shangtian" name="name"
						placeholder="請點擊改變">
				</div>

				<div>
					Gender: <input type="radio" id="male" name="gender" value="男">
					<label for="male"> Male</label> <input type="radio" id="female"
						name="gender" value="女"> <label for="female">Female</label>
					<input type="radio" id="other" name="gender" value="其他"
						checked="checked"> <label for="other">Other</label><BR>
				</div>


				<div>
					Age:<label for="age">(between 0 and 100):</label> <input
						type="number" id="age" name="age" min="0" max="100">
					<%!int st = 0;%>

					<label for="status"></label> <input type="hidden" name="status"
						value=<%=st%>> <label for="id"></label> <input
						type="hidden" name="id"> <label for="commentTime"></label>
					<input type="hidden" name="commentTime">
				</div>
				<label for="contentBox"></label>
				<textarea name="content" id="contentBox" class="transition"></textarea>

				<INPUT id="postBt" type="submit" name="submit" value="發表留言" /> <INPUT
					id="clear" type="reset" name="clear" value="清除" />
			</Fieldset>
		</FORM>

	</div>

</div>
</html>
<!-- <!-- <script> -->

<!-- // 	var named = name; -->

<!-- // 	function delete1(id) { -->
<!-- // 		localStorage.removeItem(id); -->
<!-- // 		this.Storage.writeData(); -->
<!-- // 	} -->
<!-- // 	function prom() { -->

<!-- // 		var name = prompt("請輸入您的名字");//將輸入的內容賦給變量 name ， -->
<!-- // 		named = name; -->

<!-- // 		//這里需要注意的是，prompt有兩個參數，前面是提示的話，后面是當對話框出來后，在對話框里的默認值 -->
<%-- // 		console.log(`named:${named}`); --%>
<!-- // 		if (named)//如果返回的有內容 -->

<!-- // 		{ -->

<!-- // 			alert("歡迎您：" + name) -->
<!-- // 			document.getElementById("shangtian").style.display = "none"; -->
<!-- // 			document.getElementById("ritian").value = named; -->

<!-- // 		} else { -->
<!-- // 			document.getElementById("ritian").value = "匿名發言者"; -->
<!-- // 		} -->

<!-- // 	} -->
<!-- // 	var Storage = { -->
<!-- // 		saveData : function()//保存數據 -->
<!-- // 		{ -->

<!-- // 			var data = document.querySelector("#post textarea"); -->
<!-- // 			if (data.value != "") { -->
<!-- // 				console.log(data.value); -->
<!-- // 				console.log("exist"); -->
<!-- // 				var time = new Date().getTime() + Math.random() * 5;//getTime是Date對象中的方法，作用是返回 1970年01月01日至今的毫秒數 -->
<!-- // 				console.log(time); -->
<!-- // 				if (named) { -->

<!-- // 					localStorage.setItem(time, data.value + "|" + named + "|" -->
<!-- // 							+ this.getDateTime());//將毫秒數存入Key值中，可以降低Key值重復率 -->
<!-- // 				} else { -->
<!-- // 					localStorage.setItem(time, data.value + "|" + "匿名發言者" + "|" -->
<!-- // 							+ this.getDateTime());//將毫秒數存入Key值中，可以降低Key值重復率 -->
<!-- // 				} -->

<!-- // 				data.value = ""; -->
<!-- // 				this.writeData(); -->
<!-- // 			} else { -->
<!-- // 				alert("請填寫您的留言！"); -->
<!-- // 			} -->
<!-- // 		}, -->
<!-- // 		writeData : function()//輸出數據 -->
<!-- // 		{ -->
<!-- // 			var dataHtml = "", data = ""; -->
<!-- // 			for (var i = localStorage.length - 1; i >= 0; i--)//效率更高的循環方法 -->
<!-- // 			{ -->
<!-- // 				data = localStorage.getItem(localStorage.key(i)).split("|"); -->

<!-- // 				//dataHtml += "<p><span class=\"msg\">" + data[0] + "</span><span class=\"datetime\">" + data[1] + "</span><span>" + data[2]+"</span></p>"; -->
<!-- // 				dataHtml += "<span style=>" -->
<!-- // 						+ data[1] -->
<!-- // 						+ "<span style=\"float:right\">" -->
<!-- // 						+ data[2] -->
<!-- // 						+ "</span><p><span class=\"msg\">" -->
<!-- // 						+ data[0] -->
<!-- // 						+ "<input style=\"float:right;border:none;border-radius:5px;\" id=\"clearBt\" type=\"button\" onclick=\"delete1(" -->
<!-- // 						+ localStorage.key(i) + ");\" value=\"刪除\"/>" -->
<!-- // 						+ "</span></p>"; -->
<!-- // 			} -->
<!-- // 			document.getElementById("comment").innerHTML = dataHtml;//dataHtml -->
<!-- // 		}, -->
<!-- // 		getDateTime : function()//獲取日期時間，例如 2012-03-08 12:58:58 -->
<!-- // 		{ -->
<!-- // 			var isZero = function(num)//私有方法，自動補零 -->
<!-- // 			{ -->
<!-- // 				if (num < 10) { -->
<!-- // 					num = "0" + num; -->
<!-- // 				} -->
<!-- // 				return num; -->
<!-- // 			} -->

<!-- // 			var d = new Date(); -->
<!-- // 			return d.getFullYear() + "-" + isZero(d.getMonth() + 1) + "-" -->
<!-- // 					+ isZero(d.getDate()) + " " + isZero(d.getHours()) + ":" -->
<!-- // 					+ isZero(d.getMinutes()) + ":" + isZero(d.getSeconds()); -->
<!-- // 		} -->
<!-- // 	} -->

<!-- // 	window.onload = function() { -->
<!-- // 		Storage.writeData();//當打開頁面的時候，先將localStorage中的數據輸出一邊，如果沒有數據，則輸出空 -->
<!-- // 		document.getElementById("postBt").onclick = function() { -->
<!-- // 			Storage.saveData(); -->
<!-- // 		}//發表評論按鈕添加點擊事件，作用是將localStorage中的數據輸出 -->
<!-- // 		/*document.getElementById("clearBt").onclick = function() { -->
<!-- // 			Storage.clearData(); -->
<!-- // 		}//清空所有已保存的數據*/ -->
<!-- // 	} -->
<!-- <!-- </script> -->




