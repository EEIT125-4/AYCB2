package member;
import javax.servlet.*;

import java.io.*;

import java.sql.*;
import java.time.Year;
import java.util.Date;

//import javax.rmi.*;
import javax.naming.*;
import javax.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(CHARSET_CODE);
		response.setContentType(CONTENT_TYPE);

		// To prevent caching
		response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setDateHeader("Expires", -1); // Prevents caching at the proxy server

		if (request.getParameter("submit") != null)
			gotoSubmitProcess(request, response);
		else if (request.getParameter("confirm") != null) {
			System.out.println("confirm");
			gotoConfirmProcess(request, response);
			}
		else if (request.getParameter("update") != null) {
			System.out.println("go to update");
			gotoUpdateProcess(request, response);
		}
		
	}

	public void gotoSubmitProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in submit process");
		String name;
		int birthyear, birthmonth, birthday;
		String acc;
		String pwd;
		String address;
		String phone;
		String email;
		String gender;
		
			
		name = request.getParameter("name").trim();
		birthyear = Integer.parseInt(request.getParameter("byear").trim());
		birthmonth = Integer.parseInt(request.getParameter("bmonth").trim());
		birthday = Integer.parseInt(request.getParameter("bday").trim());
		acc = request.getParameter("acc").trim();
		pwd = request.getParameter("pwd").trim();
		phone = "";
		email = request.getParameter("email").trim();
		gender = request.getParameter("gender").trim();
		address = "";
		java.sql.Date date = new java.sql.Date(birthyear - 1900, birthmonth, birthday);
		MemberBean register_name = new MemberBean(name,acc, pwd, address,phone,date,email,gender);
		System.out.println("!!!!!");
		System.out.println("name"+register_name.getName());
		
		request.getSession(true).setAttribute("register_name", register_name);
		request.getRequestDispatcher("confirm11.jsp").forward(request, response);
	}

	public void gotoConfirmProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		System.out.println("in confirm");
		try {

			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/EmployeeDB");
			
			conn = ds.getConnection();
			System.out.println("request get register:"+request.getSession(true).getAttribute("register_name"));
			registerDAO registerDAO = new registerDAO(conn);
			MemberBean registerData = (MemberBean) request.getSession(true).getAttribute("register_name");
			if (registerDAO.insertregister(registerData)) {
				System.out.println("Get some SQL commands done!");
				request.getSession(true).invalidate();
				request.getRequestDispatcher("Home.jsp").forward(request, response);
			}
		} catch (NamingException ne) {
			System.out.println("Naming Service Lookup Exception");
		} catch (SQLException e) {
			System.out.println("Database Connection Error");
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("Connection Pool Error!");
			}
		}

	}
	public void gotoUpdateProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		System.out.println("update action");
		MemberBean memberBean=(MemberBean) request.getSession(true).getAttribute("login_session");
		
		System.out.println(memberBean);
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
	
		try {
			
			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/EmployeeDB");
			conn = ds.getConnection();
			registerDAO registerDAO = new registerDAO(conn);
			MemberBean a = (MemberBean) request.getSession(true).getAttribute("login_session");
		
			String address,phone,pwd = null;
			
			pwd = request.getParameter("pwd");
			//System.out.println(pwd);
			address=request.getParameter("useraddress");
			phone=request.getParameter("userphone");
			
			a.setPassword(pwd);
			a.setAddress(address);
			a.setPhone(phone);

			
			if (registerDAO.updateregister(a)) {
				System.out.println("Get some SQL commands done!");
				//request.getSession(true).invalidate();
				request.getRequestDispatcher("Home.jsp").forward(request, response);
			}
		} catch (NamingException ne) {
			System.out.println("Naming Service Lookup Exception");
		} catch (SQLException e) {
			System.out.println("Database Connection Error");
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("Connection Pool Error!");
			}
		}

	}
	
}