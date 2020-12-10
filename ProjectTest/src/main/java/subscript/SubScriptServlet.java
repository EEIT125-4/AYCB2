//package subscript;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.hibernate.Session;
//
//import member.model.MemberBean;
//import message.service.MessageService;
//import message.service.impl.MessageServiceImpl;
//
///**
// * Servlet implementation class SubScriptServlet
// */
//@WebServlet("/SubScriptServlet")
//public class SubScriptServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
//	private static final String CHARSET_CODE = "UTF-8";
//       
//
//    public SubScriptServlet() {
//        super();
//       
//    }
//
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//		request.setCharacterEncoding(CHARSET_CODE);
//		response.setContentType(CONTENT_TYPE);
//		System.out.println("do post Subscriptservlet");
//		response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
//		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
//		response.setDateHeader("Expires", -1); // Prevents caching at the proxy server
//		
//		MemberBean mb=(MemberBean)request.getSession().getAttribute("login_session");
//		MessageService ms=new MessageServiceImpl();
//		//查找會員的訂閱類型
//		
//		
//		
//		
//		
//	}
//
//}
