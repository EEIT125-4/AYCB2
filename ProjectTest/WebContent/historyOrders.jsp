<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!-- c核心 http://java.sun.com/jsp/jstl/sql標準寫法 -->
<sql:setDataSource var="ds" dataSource="jdbc/EmployeeDB" />
<!-- ds定義是dataSource -->
<% 
String user="";
boolean editable=false;
if(session.getAttribute("login_session")!=null){
	MemberBean member=(MemberBean)session.getAttribute("login_session");
	 user=member.getName();
	System.out.println("msgPage got user"+user);
	editable=true;}
	
	%>



<sql:query var="rs1" dataSource="${ds}" >

select * from orders_item where customer_id = '<%=user%>';

</sql:query>   
<%
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0  
response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
%>   
 <%@include file="jspf/header.jspf"%> 

<fieldset style="margin: auto;position: relative;top: 200px;width: 600px;border: 1px solid transparent;">
 <form action="HistoryServlet" method="POST">
	<h3>查詢交易歷史清單</h3>
  <table style="margin: auto;" border="1" >
    <th>order_No</th>
    <th>customer_id</th>
    <th>order_time</th>
    <th>price</th>
    <th>quantity</th>
    <th>status</th>
    <th>update</th>
    <th>delete</th>
    <c:forEach var="row" items="${rs1.rows}">
    <!-- row一筆資料 -->
    <tr>
    <td style="text-align:center;">${row.order_No}</td>
    <td style="text-align:center;">${row.customer_id}</td>
    <td style="text-align:center;">${row.order_time}</td>
    <td style="text-align:center;">${row.price}</td>
    <td style="text-align:center;">${row.quantity}</td>
    <td style="text-align:center;">${row.status}</td>
    <td style="text-align:center;"><button style="width:auto;height:auto;margin-top: 0px;" name="update" value="${row.order_No}">更新</button></td>
    <td style="text-align:center;"><button style="width:auto;height:auto;margin-top: 0px;" name="delete" value="${row.order_No}">刪除</button></td>
    </tr>
    </c:forEach>
  </table>
  </form> 
  </fieldset>
<%@include file="jspf/footer.jspf"%>