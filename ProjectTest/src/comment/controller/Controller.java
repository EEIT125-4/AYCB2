package comment.controller;

import javax.servlet.*;

import java.beans.Expression;
import java.io.*;

import java.sql.*;

//import javax.rmi.*;
import javax.naming.*;
import javax.sql.*;

import comment.dao.CommentDaoImp;
import comment.model.CommentBean;
import comment.service.CommentService;
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
		Integer age = 12;//Integer.parseInt(request.getParameter("age").trim());
		Integer status = Integer.parseInt(request.getParameter("status").trim());
		// JAVA的Date轉SQL的Date
		java.util.Date now = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(now.getTime());
		// SQL的Date轉JAVA的Date
		java.util.Date utilDate = new java.util.Date();
		utilDate.setTime(sqlDate.getTime());

		String commentTime = String.valueOf(utilDate);
		String contentBox = request.getParameter("content");
		Integer id = 10;//Integer.parseInt(request.getParameter("id"));
		Integer memberID = 10;//Integer.parseInt(request.getParameter("memberID"));
		CommentBean dis_board = new CommentBean(id, memberID, name, gender, age, status, commentTime, contentBox);

		request.getSession(true).setAttribute("dis_board", dis_board);

		request.getRequestDispatcher("/displaytest.jsp").forward(request, response);

	}

	public void gotoConfirmProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CommentServiceImpl cs = new CommentServiceImpl();
		CommentBean discussionData = (CommentBean) request.getSession(true).getAttribute("dis_board");
		int ic = 0;
		try {
			ic=cs.insertComment(discussionData);
		} catch (Exception e) {
			if(ic==1) {
				response.sendRedirect(request.getContextPath()+"/CommentThanks.jsp");	
			}else if(ic==0){
				response.sendRedirect(request.getContextPath()+"/CommentCancel.jsp");
			}
		}
	}
}
