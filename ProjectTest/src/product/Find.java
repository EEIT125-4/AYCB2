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

public class Find extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		Connection conn = null;

		try {
			conn = ds.getConnection();
//			new ProductDAO(conn).allproduct();
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
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ManagerPage.jsp");
		rd.forward(request, response);
	}
}
