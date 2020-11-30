package product;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import sun.net.www.content.text.plain;

public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";

	DataSource ds = null;

	public void init() throws ServletException {
		try {

			InitialContext ctxt = new InitialContext();

			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/EmployeeDB");
			if (ds == null)
				throw new ServletException("Unknown DataSource 'jdbc/EmployeeDB'");
		} catch (NamingException ex) {
			ex.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(CHARSET_CODE);
	    response.setContentType(CONTENT_TYPE);
		
		String NextPage = "";
		String todo = request.getParameter("todo");

		try {
			Connection conn = ds.getConnection();

			if (todo == null) {
				NextPage = "ManagerPage.jsp";
			} else if (todo.equals("add")) {
				Product product = new Product(request.getParameter("brandname"), request.getParameter("productseries"),
						request.getParameter("productcate"), request.getParameter("productname"),
						Integer.parseInt(request.getParameter("productprice")));
				new ProductDAO(conn).addproduct(product);
				NextPage = "ManagerPage.jsp";
			} else if (todo.equals("remove")) {
				new ProductDAO(conn).delproduct(request.getParameter("productname"));
				NextPage = "ManagerPage.jsp";
			}else if(todo.equals("update")) {
				new ProductDAO(conn).updateproduct(request.getParameter("productprice"), request.getParameter("productname"));
				NextPage = "ManagerPage.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ManagerPage.jsp");
		rd.forward(request, response);
	}

}
