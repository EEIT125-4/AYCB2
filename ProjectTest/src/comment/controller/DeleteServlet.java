package comment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	public DeleteServlet() {
		super();
	}

	/*@Override
	public void init() throws ServletException {
		try {
			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/comment");
		} catch (NamingException e) {
			throw new ServletException(e);
		}

	}*/
	//@SuppressWarnings("unused")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("this is do get");
		request.setAttribute("cheat", "cheat");
		//doPost(request, response);
		SelectAll(request, response);
	
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("do post");
		request.setCharacterEncoding("UTF-8");
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		String delete = request.getParameter("delete");// upload傳入

		if(request.getAttribute("cheat")!=null && request.getAttribute("cheat").equals("cheat")) {
			SelectAll(request, response);
			
		}
		if (delete != null) {
			DeleteProcess(request, response);
		}
		if (request.getParameter("update") != null) {
			PackProcess(request, response);
		}
		if (request.getParameter("confirmupdate") != null) {
			UpdateProcess(request, response);
		}
		if (request.getParameter("product") != null) {
			SelectAll(request, response);
		}
	}

	

	protected void DeleteProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pno = request.getParameter("delete");	
		Integer index=Integer.parseInt(request.getParameter("delete"));
		System.out.println("index:"+index);
		//CommentBean cb = (CommentBean) request.getSession(true).getAttribute("dis_board");
		CommentService cs = new CommentServiceImpl();
		//CommentBean cb=cs.selectUpdateitem(index);
		cs.deleteComment(index);
		
		try {
			List<CommentBean> cb = cs.selectAll();
			System.out.println(cb);
			request.getSession(true).setAttribute("dis_board", cb);
			if(request.getAttribute("cheat")!=null && request.getAttribute("cheat").equals("cheat")) {
				response.sendRedirect("/commentJSP/Select.jsp");
			}else {
			request.getRequestDispatcher("/commentJSP/Select.jsp").forward(request, response);}
//			response.sendRedirect("Select.jsp");
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}

	}

	protected void PackProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pno = request.getParameter("update");			
		CommentServiceImpl cs = new CommentServiceImpl();
//		Integer up=Integer.parseInt(request.getParameter("delete"));
//		CommentBean discussionData = (CommentBean) request.getSession(true).getAttribute("dis_board");
//		Integer id = discussionData.getCommentId();
		Integer commentId = Integer.parseInt(request.getParameter("update"));
		List<CommentBean> Result=cs.selectUpdateitem(commentId);
		request.getSession(true).setAttribute("Result", Result);
		request.getRequestDispatcher("Commentupdate.jsp").forward(request, response);
		}
	
//		request.getSession().setAttribute("name",name);
//		request.getSession().getAttribute("name");

	protected void UpdateProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name").trim();
		String gender = request.getParameter("gender").trim();
		Integer age = Integer.parseInt(request.getParameter("age").trim());
		Integer Id = Integer.parseInt(request.getParameter("id").trim());
		Integer commentId = Integer.parseInt(request.getParameter("commentId").trim());
		System.out.println("commentId:"+ commentId);
		Integer status =0;
//				Integer.parseInt(request.getParameter("status").trim());
		
		// JAVA的Date轉SQL的Date
		java.util.Date now = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(now.getTime());
		// SQL的Date轉JAVA的Date
		java.util.Date utilDate = new java.util.Date();
		utilDate.setTime(sqlDate.getTime());
		String commentTime = String.valueOf(utilDate);
		String contentBox = request.getParameter("content");
//		Integer id = Integer.valueOf(request.getParameter("id"));
//		Integer commentId = Integer.valueOf(request.getParameter("commentId"));

		CommentBean bean = new CommentBean(Id,commentId, name, gender, age, status, commentTime, contentBox);
		System.out.println("更改後:"+bean);
//		CommentBean bean = new CommentBean(pId, pCommentID, pName, pGender, pAge, pStatus, pCommentTime, pContentBox)
		CommentService cs = new CommentServiceImpl();
//		CommentBean discussionData = (CommentBean) request.getSession(true).getAttribute("dis_board");			
		try {
			
//			cs.insertComment(discussionData);
			cs.updateComment(bean);
			request.getParameter("update");

			List<CommentBean> cb = cs.selectAll();
			//System.out.println(cb);
			request.getSession(true).setAttribute("dis_board", cb);
			if(request.getAttribute("cheat")!=null && request.getAttribute("cheat").equals("cheat")) {
				response.sendRedirect("/commentJSP/Select.jsp");
			}else {
			request.getRequestDispatcher("/commentJSP/Select.jsp").forward(request, response);}
		} catch (Exception e) {
			System.out.println("error");

			e.printStackTrace();
			return;
		}

//		response.sendRedirect(request.getContextPath()+"/commentJSP/Select.jsp");
	}

	public void SelectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("do select all");
		
		CommentService cs=new CommentServiceImpl();
		List<CommentBean> cb = cs.selectAll();
		System.out.println(cb);
		request.getSession(true).setAttribute("dis_board", cb);
		
		System.out.println("checkPoint");
		request.getRequestDispatcher("/commentJSP/Select.jsp").include(request, response);}

	}

