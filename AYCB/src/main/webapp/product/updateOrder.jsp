<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>]
<%@ page import="product.*" %>

<% 
	response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
    response.setHeader("Pragma","no-cache"); // HTTP 1.0  
    response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
%>
<%@include file="../jspf/header.jspf"%>

<jsp:useBean id="bean" class="product.cartModel.OrderBean" scope="session" />
<fieldset style="margin: auto;position: relative;top: 200px;width: 300px;border-radius: 15px;font-weight: 300;font-size: large">
	<legend style="font-weight: 600;font-size: x-large;text-align: center;">訂單修改</legend>
	<form  action="HistoryServlet" method="post">
        <p>  
            <label class="t1" for="">orderNo:</label>
            <input type="text" name="orderNo" value="<jsp:getProperty name="bean" property="orderNo"/>" readonly>   
        </p>
        <p>   
            <label for="" class="t1">customerId:</label>
            <input type="text" name="customerId" value="<jsp:getProperty name="bean" property="customerId"/>" readonly>     
        </p>
        <p>
            <label for="" class="t1">orderTime:</label>
            <input type="text" name="orderTime" value="<jsp:getProperty name="bean" property="orderTime"/>" readonly>
        </p>
        <p>
            <label for="" class="t1">price:</label>
            <input type="text" name="price" value="<jsp:getProperty name="bean" property="price"/>">
        </p>
        <p>
            <label for="" class="t1">quantity:</label>
            <input type="text" name="quantity" value="<jsp:getProperty name="bean" property="quantity"/>" autofocus>
        </p>
        <p>
            <label class="t1">status:</label><select name="status">
            <option ><jsp:getProperty name="bean" property="status"/></option>
            <option                >------------</option>
            <option value="付款成功">付款成功</option>
            <option value="付款失敗">付款失敗</option>
           	</select>
        </p>
        <div style="text-align: center;" >
        <input type="submit" name="confirmupdate" value="送出">
        </div>
    </form>
    
	</fieldset>
	
	
<%@include file="../jspf/footer.jspf"%>