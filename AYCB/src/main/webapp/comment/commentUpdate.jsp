<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
	response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
    response.setHeader("Pragma","no-cache"); // HTTP 1.0  
    response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
%>

<c:set var = "rs" value="${Result}"/>
	<c:set var = "commentId" value = "${rs.commentId}"/>
	<c:set var = "name" value = "${rs.name}"/>
	<c:set var = "gender" value = "${rs.gender}"/>
	<c:set var = "age" value = "${rs.age}"/>
	<c:set var = "commentTime" value = "${rs.commentTime}"/>
	<c:set var = "content" value = "${rs.contentBox}"/>
	<c:set var = "id" value = "${rs.id}"/>
	
	

<link rel="stylesheet" href="../css/comment.css" />

<jsp:useBean id="bean" class="comment.model.CommentBean" scope="session" />

<fieldset class="updateform">
	<legend class="title">編輯留言</legend>
	<form  action="./DeleteServlet1" method="post">
        <p>  
            <label class="t1" for="">名稱:</label>
            <input type="text" name="name" value="${name}">   
        </p>
        <p>   
            <label for="" class="t1">性別:</label>
            <input type="text" name="gender" value="${gender}">     
        </p>
        <p>
            <label for="" class="t1">年齡:</label>
            <input type="text" name="age" value="${age}">
        </p>
        <p>
            <label for="" class="t1"></label>
            <input type="hidden" name="commentTime" value="${commentTime}">
        </p>
        <p>
            <label for="" class="t1">留言內文:</label>
            <input type="text" name="content" value="${content}">
        </p>
        <p>
            <label class="t1"></label>
            <input type="hidden" name="status" value="<jsp:getProperty name="bean" property="status"/>">
        </p>
        
        <p>
            <label class="t1"></label>
            <input type="hidden" name="id" value="${id}">
        </p>
        <p>
            <label class="t1"></label>
            <input type="text" name="commentId" value="${commentId}">
        </p>
        <input type="submit" name="confirmupdate" value="送出">
    </form>
    
	</fieldset>
	
	