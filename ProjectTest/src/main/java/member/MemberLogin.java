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

import member.Service.MemberService;
import member.Service.MemberServiceImpl;


@WebServlet("/MemberLogin")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public MemberLogin() {
		super();
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		System.out.printf("user=%s pwd=%s", user, pwd);
		

		
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			MemberService ms=new MemberServiceImpl();
	

			if (ms.identify(user, pwd)) {
			
				
				if(!user.equals("admin")) {
					response.sendRedirect("Home.jsp");
				}else {
					response.sendRedirect("ManagerPage.jsp");
				}
			} else {
				
				//Kevin->凱:錯誤請顯示訊息
				System.out.println("login fail");
				response.sendRedirect("member/login.jsp");
			}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
