package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Login
 */
@WebServlet("/MemberLogin")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		System.out.printf("user=%s pwd=%s", user, pwd);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();

		pw.println(user);
		pw.println(pwd);
		boolean login = false;
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;

		try {
			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/AYCB2");
			conn = ds.getConnection();
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			Statement statement = conn.createStatement();
			System.out.println("連結資料庫");
			ResultSet rs = statement.executeQuery("select*from member_table");
			String name = null;
			String account = null;
			String password = null;
			String address = null;
			String phone = null;
			Date birth = null;
			String email = null;
			String gender = null;

			while (rs.next()) {
				name = rs.getString("name");
				account = rs.getString("id");
				password = rs.getString("pwd");
				address = rs.getString("address");
				phone = rs.getString("phone");
				birth = rs.getDate("birth");
				email = rs.getString("email");
				gender = rs.getString("gender");

				if (user.equals(account) && pwd.equals(password)) {
					login = true;
					break;
				}

			}
			if (login) {
				MemberBean member = new MemberBean(name, account, password, address, phone, birth, email, gender);
				request.getSession(true).setAttribute("login_session", member);
				if(!account.equals("admin")) {
					response.sendRedirect("Home.jsp");
				}else {
					response.sendRedirect("ManagerPage.jsp");
				}
			} else {
				System.out.println("login fail");
				response.sendRedirect("./login.jsp");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {

			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("destroy");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		// 初始化後就不再調用

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);

	}

}
