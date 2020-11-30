package comment;
import javax.servlet.*;

import java.io.*;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//import javax.rmi.*;
import javax.naming.*;
import javax.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */

public class Controller extends HttpServlet {
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

		request.setCharacterEncoding(CHARSET_CODE);
		response.setContentType(CONTENT_TYPE);

		// To prevent caching
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", -1);
		if (request.getParameter("submit") != null)
			gotoSubmitProcess(request, response);
		else if (request.getParameter("confirm") != null) {
			System.out.println("go to confirm");
			gotoConfirmProcess(request, response);
		}
	}

	public void gotoSubmitProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name;
		String gender;
		Integer age;
		Integer status;
		String commentTime;
		String contentBox = null;
		String id;

		name = request.getParameter("name").trim();
		gender = request.getParameter("gender").trim();
		age = Integer.parseInt(request.getParameter("age").trim());
		status = Integer.parseInt(request.getParameter("status").trim());
		// JAVA的Date轉SQL的Date
		java.util.Date now = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(now.getTime());
		// SQL的Date轉JAVA的Date
		java.util.Date utilDate = new java.util.Date();
		utilDate.setTime(sqlDate.getTime());
		
//		Date date = new Date(new java.util.Date().getTime());
		System.out.println("-------------------------");
		System.out.println("dateee"+utilDate);
		System.out.println(utilDate.toString());
		commentTime = String.valueOf(utilDate);
		System.out.println(commentTime);
		contentBox = request.getParameter("content");
		System.out.println(contentBox);
		id=request.getParameter("id");
		System.out.println(id);
		DiscussionBean dis_board = new DiscussionBean(id,name, gender, age, status, commentTime, contentBox);

		request.getSession(true).setAttribute("dis_board", dis_board);
		System.out.println(dis_board);

		request.getRequestDispatcher("/displaytest.jsp").forward(request, response);

	}

	public void gotoConfirmProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		System.out.println("into confirm");

		try {

			ctxt = new InitialContext();
			System.out.println("init");

			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/EmployeeDB");
			System.out.println("datasource");
			conn = ds.getConnection();
			System.out.println("get conn");

			CommentDAO commentDAO = new CommentDAO(conn);
			DiscussionBean discussionData = (DiscussionBean) request.getSession(true).getAttribute("dis_board");
			System.out.println("get bean");
			if (commentDAO.insertComment(discussionData)) {
				System.out.println("Get some SQL commands done!");
				
				request.getRequestDispatcher("/CommentThanks.jsp").forward(request, response);
			}
		} catch (NamingException ne) {
			System.out.println("Naming Service Lookup Exception");
		} catch (SQLException e) {
			e.getStackTrace();
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
