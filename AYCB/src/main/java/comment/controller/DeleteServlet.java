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


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("this is do get");
		request.setAttribute("cheat", "cheat");
		SelectAll(request, response);
	
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("do post");
		request.setCharacterEncoding("UTF-8");
		response.setContentType(CONTENT_TYPE);
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
		
		Integer index=Integer.parseInt(request.getParameter("delete"));
		System.out.println("index:"+index);
		
		CommentService cs = new CommentServiceImpl();
		
		cs.deleteComment(index);
		
		try {
			List<CommentBean> cb = cs.selectAll();
			System.out.println(cb);
			request.getSession(true).setAttribute("dis_board", cb);
			if(request.getAttribute("cheat")!=null && request.getAttribute("cheat").equals("cheat")) {
				response.sendRedirect("/comment/select.jsp");
			}else {
			request.getRequestDispatcher("/comment/select.jsp").forward(request, response);}

		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}

	}

	protected void PackProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("packProcess");	
		CommentService cs = new CommentServiceImpl();

		Integer commentId = Integer.parseInt(request.getParameter("update"));
		CommentBean Result=cs.selectUpdateitem(commentId);
		request.getSession(true).setAttribute("Result", Result);
		
		request.getRequestDispatcher("/comment/commentUpdate.jsp").forward(request, response);
		
		
	}
	


	protected void UpdateProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name").trim();
		String gender = request.getParameter("gender").trim();
		Integer age = Integer.parseInt(request.getParameter("age").trim());
		Integer Id = Integer.parseInt(request.getParameter("id").trim());
		Integer commentId = Integer.parseInt(request.getParameter("commentId").trim());
		System.out.println("commentId:"+ commentId);
		Integer status =0;

		java.util.Date now = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(now.getTime());
		
		java.util.Date utilDate = new java.util.Date();
		utilDate.setTime(sqlDate.getTime());
		String commentTime = String.valueOf(utilDate);
		String contentBox = request.getParameter("content");

		CommentBean bean = new CommentBean(Id,commentId, name, gender, age, status, commentTime, contentBox);
		System.out.println("更改後:"+bean);

		CommentService cs = new CommentServiceImpl();
	
		try {
			

			cs.updateComment(bean);
			request.getParameter("update");

			List<CommentBean> cb = cs.selectAll();
			
			request.getSession(true).setAttribute("dis_board", cb);
			if(request.getAttribute("cheat")!=null && request.getAttribute("cheat").equals("cheat")) {
				response.sendRedirect("/comment/select.jsp");
			}else {
			request.getRequestDispatcher("/comment/select.jsp").forward(request, response);}
		} catch (Exception e) {
			System.out.println("error");

			e.printStackTrace();
			return;
		}


	}

	public void SelectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("do select all");
		
		CommentService cs=new CommentServiceImpl();
		List<CommentBean> cb = cs.selectAll();
		System.out.println(cb);
		request.getSession(true).setAttribute("dis_board", cb);
		
		System.out.println("checkPoint");
		request.getRequestDispatcher("/comment/select.jsp").include(request, response);}

	}

