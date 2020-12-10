package event;

import javax.servlet.*;
//import javax.servlet.http.*;
//import java.io.PrintWriter;
//import java.io.IOException;
import java.io.*;

import java.sql.*;
//import javax.rmi.*;
import javax.naming.*;
import javax.sql.*;

import event.EventBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	 private static final String CHARSET_CODE = "UTF-8";
	 public void init(ServletConfig config) throws ServletException
	 {
	   super.init(config);
	 }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    request.setCharacterEncoding(CHARSET_CODE);
	    response.setContentType(CONTENT_TYPE);

	    // To prevent caching 
	   response.setHeader("Cache-Control","no-cache"); 
	   response.setHeader("Pragma","no-cache"); 
	   response.setDateHeader ("Expires", -1);
	   if (request.getParameter("submit")!=null)
	     gotoSubmitProcess(request, response);
	   else if (request.getParameter("confirm")!=null)
	     gotoConfirmProcess(request, response);
   else if (request.getParameter("modify")!=null) {
	   System.out.println("modify");
     gotoModifyProcess(request, response);}
	}
	
	 public void gotoSubmitProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	  {
	    String name;
	    String phone;
	    String mailaddress;
	    String eventname;
	    String eventdate;
	   
	    name = request.getParameter("name").trim();
	    phone = request.getParameter("phone").trim();
	    mailaddress = request.getParameter("mailaddress").trim();
	    eventname = request.getParameter("eventname").trim();
	    eventdate = request.getParameter("eventdate").trim();	    
	    EventBean reg_member =  new EventBean(name,phone, mailaddress, eventname,eventdate);
	    request.getSession(true).setAttribute("reg_member",reg_member);
	    System.out.println(reg_member);
	    request.getRequestDispatcher("/DisplayRegisterForm.jsp").forward(request,response);
	  }

	  public void gotoConfirmProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	  {

	    DataSource ds = null;
	    InitialContext ctxt = null;
	    Connection conn = null;
	    
	    try {
     
	      ctxt = new InitialContext();
	      ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/EmployeeDB");	  
	      conn = ds.getConnection();
	      
	      
	      EventDAO eventDAO = new EventDAO(conn);
	      EventBean eventData = (EventBean)request.getSession(true).getAttribute("reg_member");
	      if (eventDAO.insertEvent(eventData))
	        {
	          System.out.println("Get some SQL commands done!");
	          request.getSession(true).invalidate();
	          request.getRequestDispatcher("/eventpage.jsp").forward(request,response);
	        }
	      
	    } catch (NamingException ne) {
	      System.out.println("Naming Service Lookup Exception");  
	    } catch (SQLException e) {
	    e.getStackTrace();
	      System.out.println("Database Connection Error"); 
	    } finally {
	      try {
	        if (conn != null) conn.close();
	      } catch (Exception e) {
	        System.out.println("Connection Pool Error!");
	      }
	    }
	           
	  }
	  public void gotoModifyProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	  {
		  System.out.println("modifying");
	    DataSource ds = null;
	    InitialContext ctxt = null;
	    Connection conn = null;
	    
	    try {
   
	      ctxt = new InitialContext();

 
	      ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/EmployeeDB");	  
	      conn = ds.getConnection();
	      
	      EventDAO eventDAO= new EventDAO(conn); 
	      
	      EventBean eventData = (EventBean)request.getSession(true).getAttribute("reg_member");
	      
	      String phone, mailaddress, eventname,eventdate;
	       
		  phone = request.getParameter("phone").trim();//接前端按鈕
		  mailaddress = request.getParameter("mailaddress").trim();
		  eventname = request.getParameter("eventname").trim();
		  eventdate = request.getParameter("eventdate").trim();
	     String name=request.getParameter("name").trim();
	      //初始設定
		  eventData.setPhone(phone);
		  eventData.setMailaddress(mailaddress);
		  eventData.setEventname(eventname);
		  eventData.setEventdate(eventdate);
		  eventData.setName(name);
	      
	      if (eventDAO.updateEvent(eventData))
	        {
	          System.out.println("Get some SQL commands done!");
	          request.getSession(true).invalidate();
	          request.getRequestDispatcher("/eventpage.jsp").forward(request,response);
	        }else {
	        	
	        	System.out.println("update fail");
	        }
	      
	    } catch (NamingException ne) {
	      System.out.println("Naming Service Lookup Exception");  
	    } catch (SQLException e) {
	    e.getStackTrace();
	      System.out.println("Database Connection Error"); 
	    } finally {
	      try {
	        if (conn != null) conn.close();
	      } catch (Exception e) {
	        System.out.println("Connection Pool Error!");
	      }
	    }
	           
	  }

}
