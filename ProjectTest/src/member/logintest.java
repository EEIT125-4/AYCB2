package member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


/**
 * Servlet implementation class logintest
 */
@WebServlet("/logintest")
public class logintest extends HttpServlet {
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

		HttpSession session = request.getSession(true);

		String acc = request.getParameter("acc");
		String pwd = request.getParameter("pwd");

		List<User> login = new ArrayList<User>();

		try {
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from member where accout_id=?");
			pstmt.setString(1, acc);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setAccount(rs.getString("accout_id"));
				user.setPassword(rs.getString("password"));
				login.add(user);

				if (pwd.equals(rs.getString("password"))) {
					session.setAttribute("login", login);
					response.sendRedirect("Home.jsp");
				} else {
					response.sendRedirect("logintest.jsp");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
