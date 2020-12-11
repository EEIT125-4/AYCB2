<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*, product.*, product.cartModel.CartItem"  %>
<%
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0  
response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link REL=STYLESHEET HREF="css/cart.css" TYPE="text/css">
<title>購物車</title>
</head>
<%@include file="../jspf/header.jspf"%>
	
	<fieldset>
      <h3><strong>購物清單</strong></h3>
      <table id="tab" border="1" cellspacing="0" cellpadding="5">
         <tr>
            <th>商品</th>
            <th>內容</th>
            <th>價格</th>
            <th>數量</th>
            
         </tr>
         <%
         // Scriptlet 1: Display the items in shopping cart
         List<CartItem> theCart = (ArrayList<CartItem>) session.getAttribute("cart");
         for (CartItem item : theCart) {
         %>
         <tr>
            <td align="right" valign="middle"><img class="img" src="image/<%=item.getProductName()%>.png"></td>
            <td align="left" valign="middle"><%= item.getProductName()%></td>
            <td align="right">$<%= item.getProductPrice()%></td>
            <td align="right"><%= item.getQtyOrdered()%></td>
           
         </tr>
         <%
         } // for
         %>
         <tr>
            <th align="right" colspan="2">總計</th>
            <th align="right">$<%= request.getSession(true).getAttribute("totalPrice")%></th>
            <th align="right"><%= request.getSession(true).getAttribute("totalQtyOrdered")%></th>
         </tr>
      </table>
      <br />
 	  <div style="text-align: center;" >
      <form name="checkoutForm" action="ControllerServlet" method="POST">
         <input type="hidden" name="todo" value="commit"><!-- hidden隱藏欄位 -->
         <input type="submit" value="送出訂單">
         
      </form>
      </div>
      </fieldset>
<%@include file="../jspf/footer.jspf"%>