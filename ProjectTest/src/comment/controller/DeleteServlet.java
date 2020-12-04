package comment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import comment.dao.CommentDaoImp;
import comment.model.CommentBean;
import comment.service.CommentService;
import comment.service.CommentServiceImpl;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet1")
public class DeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	DataSource ds = null;
	Connection conn = null;
	InitialContext ctxt = null;

	public DeleteServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		try {
			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/EmployeeDB");
		} catch (NamingException e) {
			throw new ServletException(e);
		}

	}
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		String delete = request.getParameter("delete");// upload傳入

		if (delete != null) {
			DeleteProcess(request, response);
		}
		if (request.getParameter("update") != null) {
			PackProcess(request, response);
		}
		if (request.getParameter("confirmupdate") != null) {
			UpdateProcess(request, response);
		}
	}

	protected void DeleteProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pno = request.getParameter("delete");	
		CommentBean discussionData = (CommentBean) request.getSession(true).getAttribute("dis_board");
		CommentServiceImpl cs = new CommentServiceImpl();
		try {
			cs.insertComment(discussionData);
			request.getRequestDispatcher("/Select.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}

	}

	protected void PackProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pno = request.getParameter("update");			
		CommentServiceImpl cs = new CommentServiceImpl();
		CommentBean discussionData = (CommentBean) request.getSession(true).getAttribute("dis_board");
		int id = discussionData.getId();
		try{
			cs.insertComment(discussionData);
			cs.selectUpdateitem(id);
			request.getSession(true).setAttribute("bean", id);

		} catch (Exception e) {
			System.out.println("error");

			e.printStackTrace();
		}

		request.getRequestDispatcher("/Commentupdate.jsp").forward(request, response);
	}

	protected void UpdateProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name").trim();
		String gender = request.getParameter("gender").trim();
		Integer age = Integer.parseInt(request.getParameter("age").trim());
		Integer status = Integer.parseInt(request.getParameter("status").trim());
//		MemberBean mb = (MemberBean) request.getSession(true).getAttribute("id");
		// JAVA的Date轉SQL的Date
		java.util.Date now = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(now.getTime());
		// SQL的Date轉JAVA的Date
		java.util.Date utilDate = new java.util.Date();
		utilDate.setTime(sqlDate.getTime());
		String commentTime = String.valueOf(utilDate);
		
		String contentBox = request.getParameter("content");
		Integer id = Integer.valueOf(request.getParameter("id"));
		CommentBean bean = new CommentBean(111,id, name, gender, age, status, commentTime, contentBox);
		CommentServiceImpl cs = new CommentServiceImpl();
		CommentBean discussionData = (CommentBean) request.getSession(true).getAttribute("dis_board");			
		try {
			
			cs.insertComment(discussionData);
			cs.updateComment(bean);
			request.getParameter("update");

		} catch (Exception e) {
			System.out.println("error");

			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath()+"/Select.jsp");
	}

}
