package comment.controller;

import javax.servlet.*;
import java.io.*;
import comment.model.CommentBean;
import comment.service.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

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
			gotoConfirmProcess(request, response);
		}
	}

	public void gotoSubmitProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name").trim();
		String gender = request.getParameter("gender").trim();
		Integer age = 12;// Integer.parseInt(request.getParameter("age").trim());
		Integer status = Integer.parseInt(request.getParameter("status").trim());
		// JAVA的Date轉SQL的Date
		java.util.Date now = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(now.getTime());
		// SQL的Date轉JAVA的Date
		java.util.Date utilDate = new java.util.Date();
		utilDate.setTime(sqlDate.getTime());

		String commentTime = String.valueOf(utilDate);
		String contentBox = request.getParameter("content");
		Integer id = 10;// Integer.parseInt(request.getParameter("id"));
		Integer commentId = 10;// Integer.parseInt(request.getParameter("memberID"));
		CommentBean comment = new CommentBean(id, commentId, name, gender, age, status, commentTime, contentBox);

		request.getSession(true).setAttribute("comment", comment);

		request.getRequestDispatcher("comment/displayTest.jsp").forward(request, response);

	}

	public void gotoConfirmProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommentServiceImpl cs = new CommentServiceImpl();
		CommentBean discussionData = (CommentBean) request.getSession(true).getAttribute("comment");

		try {
			cs.insertComment(discussionData);
			request.getRequestDispatcher("DeleteServlet1?product=product").forward(request, response);
			//request.getRequestDispatcher("CommentThanks.jsp").forward(request, response);
			//response.sendRedirect(request.getContextPath() + "/CommentThanks.jsp");
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/CommentCancel.jsp");

		}
	}

}
