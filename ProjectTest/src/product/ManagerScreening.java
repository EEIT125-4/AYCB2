package product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class ManagerScreening extends HttpServlet {
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
		
		Connection conn = null;

		String brandname = (String) request.getParameter("brandname");
		String series = (String) request.getParameter("series");
		String cate = (String) request.getParameter("cate");
		String keyword = request.getParameter("keyword");
		
		try {
			conn = ds.getConnection();

			if (brandname != null) {
				new ProductDAO(conn).brand(brandname);
			}else if (series != null) {
				new ProductDAO(conn).series(series);
			}else if (cate != null) {
				new ProductDAO(conn).cate(cate);
			}else if (keyword != null) {
				String sql = "select * from profinal where product_name like '%" + keyword + "%'";
				new ProductDAO(conn).search(sql);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ManagerScreening.jsp");
		rd.forward(request, response);
	}
}
