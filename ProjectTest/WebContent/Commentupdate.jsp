<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
    response.setHeader("Pragma","no-cache"); // HTTP 1.0  
    response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
%>
<link rel="stylesheet" href="css/comment.css" />

<jsp:useBean id="bean" class="old.DiscussionBean" scope="session" />

<fieldset class="updateform">
	<legend class="title">編輯留言</legend>
	<form  action="DeleteServlet" method="post">
        <p>  
            <label class="t1" for="">名稱:</label>
            <input type="text" name="name" value="<jsp:getProperty name="bean" property="name"/>">   
        </p>
        <p>   
            <label for="" class="t1">性別:</label>
            <input type="text" name="gender" value="<jsp:getProperty name="bean" property="gender"/>">     
        </p>
        <p>
            <label for="" class="t1">年齡:</label>
            <input type="text" name="age" value="<jsp:getProperty name="bean" property="age"/>">
        </p>
        <p>
            <label for="" class="t1"></label>
            <input type="hidden" name="commentTime" value="<jsp:getProperty name="bean" property="commentTime"/>">
        </p>
        <p>
            <label for="" class="t1">留言內文:</label>
            <input type="text" name="content" value="<jsp:getProperty name="bean" property="contentBox"/>">
        </p>
        <p>
            <label class="t1"></label>
            <input type="hidden" name="status" value="<jsp:getProperty name="bean" property="status"/>">
        </p>
        
        <p>
            <label class="t1"></label>
            <input type="hidden" name="id" value="<jsp:getProperty name="bean" property="id"/>">
        </p>
        <input type="submit" name="confirmupdate" value="送出">
    </form>
    
	</fieldset>
	
	