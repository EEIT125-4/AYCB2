<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", -1); // Prevents caching at the proxy server
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-Hant-TW">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/comment.css" />

<title>留言內容確認</title>
</head>
<%-- <%@include file="jspf/header.jspf"%> --%>
	<div>
		<div
			style="float: left; width: 20%; text-align: center; margin-left: 220px; position: relative; top: 200px;">

			<dl>
				<dt>
					<h2>討論區</h2>
				</dt>
				<hr width=70% size=1 color=#BFBFBF style="FILTER: alpha(opacity = 100, finishopacity = 0, style = 3)">
				<dt>
					<A class="a1" href="./DeleteServlet1">
						<h2>查詢留言</h2>
					</A>
				</dt>
				<dt>
					<A class="a1" href="${pageContext.request.contextPath}/comment/article.jsp">
						<h2>美誌分享</h20>
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
		<jsp:useBean id="comment" class="comment.model.CommentBean" scope="session" />
	
  <form action="./Controller" method="post">
   <fieldset class="confirmbox">
    <legend>
    <h2>留言內容如下:</h2>
    </legend>
     <table >
      <tr>
       <td style="width: 100px;">姓名:</td>
       <td><jsp:getProperty name="comment" property="name" /></td>
      </tr>
      <tr >
       <td>性別:</td>
       <td><jsp:getProperty name="comment" property="gender" /></td>
      </tr>
      <tr >
       <td>年齡:</td>
       <td><jsp:getProperty name="comment" property="age" /></td>
      </tr>
      <tr>
       <td>留言內容:</td>
       <td><jsp:getProperty name="comment" property="contentBox" /></td>
      </tr>
      <tr>
       <td>留言日期:</td>
       <td><jsp:getProperty name="comment" property="commentTime" />
       </td>
      </tr>

     </table>
     <div>
      <input type="submit" name="confirm" value="確認">
     </div>
   </fieldset>
  </form> 
</body>

</html>
