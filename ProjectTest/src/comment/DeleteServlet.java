package comment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	DataSource ds = null;
	Connection conn = null;
	InitialContext ctxt = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		try {
			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/EmployeeDB");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("do post:delet");
		request.setCharacterEncoding("UTF-8");
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		String delete = request.getParameter("delete");// upload傳入

		System.out.println("xxxx" + delete);
		System.out.print(delete);
		if (delete != null) {
			System.out.println("哭阿" + request.getParameter("delete"));
			DeleteProcess(request, response);
		}
		if (request.getParameter("update") != null) {
			PackProcess(request, response);
		}
		if (request.getParameter("confirmupdate") != null) {
			System.out.println("goto confirmUpdate");
			UpdateProcess(request, response);
		}
	}

	protected void DeleteProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("delete process");

		try {
			conn = ds.getConnection();
			String pno = request.getParameter("delete");
			System.out.println("pno" + pno);
			CommentDAO commentDao = new CommentDAO(conn);
			if (commentDao.deleteComment(pno)) {
				System.out.println("Get some SQL commands done!");
			}
//			String action = "刪除";
//			request.setAttribute("action", action);
			request.getRequestDispatcher("Select.jsp").forward(request, response);
//			response.sendRedirect("Select.jsp");
			conn.close();
		} catch (SQLException e) {
			System.out.println("error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void PackProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Pack process");

		try (Connection conn = ds.getConnection();) {
			System.out.println("get conn");

			String pno = request.getParameter("update");
			System.out.println("pno" + pno);
			CommentDAO order = new CommentDAO(conn);
			System.out.println("get order");
			DiscussionBean bean = order.selectUpdateitem(pno);

			request.getSession(true).setAttribute("bean", bean);

		} catch (SQLException e) {
			System.out.println("error");

			e.printStackTrace();
		}

		request.getRequestDispatcher("/Commentupdate.jsp").forward(request, response);
	}

	protected void UpdateProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.err.println("in comfirm update");

		try (Connection conn = ds.getConnection();) {

			String name;
			String gender;
			Integer age;
			Integer status;
			String commentTime;
			String contentBox;
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
			commentTime = String.valueOf(utilDate);
			
			System.out.println("comment time"+commentTime);
			contentBox = request.getParameter("content");
			System.out.println("contentBox"+contentBox);
			id = request.getParameter("id");
			System.out.println(id);
			DiscussionBean bean = new DiscussionBean(id, name, gender, age, status, commentTime, contentBox);

			CommentDAO order = new CommentDAO(conn);
			order.updateComment(bean);

			if (order.updateComment(bean)) {
				System.out.println("Get some SQL commands done!");
			}
			System.out.println(request.getParameter("update"));
			request.getParameter("update");

		} catch (SQLException e) {
			System.out.println("error");

			e.printStackTrace();
		}

		request.getRequestDispatcher("/Select.jsp").forward(request, response);
	}

}
