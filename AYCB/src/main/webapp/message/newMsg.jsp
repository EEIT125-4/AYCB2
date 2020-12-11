<%@page import="message.model.MessageBean"%>
<%@page import="message.*"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%><!-- 標準寫法,詳細參考網站https://www.javatpoint.com/jstl-sql-setdatasource-tag -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	MessageBean editBean = (MessageBean) request.getAttribute("edit_msg");
	if(editBean!=null){
		System.out.println("editBean:"+editBean.getMsg_imgpath());
		}else{
			System.out.println("no bean");
		}	

%>


<!DOCTYPE html>
<html lang="en">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://use.edgefonts.net/arizonia:n4:default.js"
	type="text/javascript"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/message.css">
<title>NewMsg</title>

<style>
.preview {
	width: 300px;
	height: 300px;
	background-size: cover;
}
</style>

</head>
<%@include file="../jspf/header.jspf"%>


	<div class="mid">
		<%-- <aside id="left"><%=editBean.getMsg_title()%></aside>--%>
		<main>
			<div>
				<form action="../MsgServlet" method="post"
					enctype="multipart/form-data">

					<fieldset>

						<%
							String hint = "",
							id = "",
							title = "",
							type = "",
							desc = "",
							imgPath = "",
							action = "";
						if (editBean != null) {
							hint = "編輯";
							id = editBean.getMsg_id();
							title = editBean.getMsg_title();
							type = editBean.getMsg_type();
							desc = editBean.getMsg_desc();
							imgPath = editBean.getMsg_imgpath();
							action = "更新";

						} else {
							hint = "發佈新訊息";
							action = "送出";
						}
						%>

						<legend><%=hint%></legend>
						<table>
							<tr>
								<td>標題</td>
								<td><input type="text" name="title" placeholder="填入標題名稱"
									value=<%=title%>></td>
							</tr>

							<tr>
								<td>分類</td>
								<td><input type="text" name="type" placeholder="填入分類名稱"
									value=<%=type%>></td>
							</tr>
							<tr>
								<td>訊息內容</td>
								<td><textarea name="desc" cols="100" rows="10"
										placeholder="填入內容"><%=desc%></textarea></td>
							</tr>
							<tr>
								<td>上傳圖片</td>
								<td><input id="file" type="file" name="file"></td>
							</tr>
							<tr>
								<td>圖片預覽</td>
								<td>
						<%if (editBean != null && !editBean.equals("")) {%> 
						<img id="demo" class="preview" src='<%=imgPath%>' alt=<%=imgPath%> onerror="javascript:this.src='./image/noImage.jpg'"> 
						<%} else {%><img id="demo" class="preview"> <%}%>

								</td>
								</tr>
							<tr>

								<td colspan="2">
								<input type="hidden" name="id" value=<%=id%>> 
								<input type="hidden" name="path" value=<%=imgPath%>> 
								
								<input type="submit" name="submit"
									value=<%=action%>> <input type="reset" value="清除">
								</td>
							</tr>
						</table>
					</fieldset>
				</form>
			</div>
		</main>
	</div>
<%@include file="../jspf/footer.jspf"%>


	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>

	<script>
		$('#file').change(function() {

			var file = $('#file')[0].files[0];
			var reader = new FileReader;
			reader.onload = function(e) {
				$('#demo').attr('src', e.target.result);
			};
			reader.readAsDataURL(file);
		});
	</script>





</body>

</html>