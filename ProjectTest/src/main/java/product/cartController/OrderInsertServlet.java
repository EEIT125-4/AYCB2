package product.cartController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


//import member.MemberBean;
import product.cartDao.OrderDao;

import product.cartModel.OrderBean;
import product.cartService.OrderService;
import product.cartService.impl.OrderServiceImpl;


@WebServlet("/OrderInsertServlet")
public class OrderInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";   
	
//	DataSource ds = null;
//	Connection conn= null;
    

    public OrderInsertServlet() {
        super();
        
    }

	
//	public void init(ServletConfig config) throws ServletException {
//		
//		try {
//			InitialContext ctxt = new InitialContext();
//			ds=(DataSource)ctxt.lookup("java:comp/env/jdbc/EmployeeDB");
//			
//		} catch (NamingException e) {
//			
//			e.printStackTrace();
//			throw new ServletException(e);
//		}
//    	
//    }
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); 
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
					
			OrderService os = new OrderServiceImpl();
			
			
			int totalPrice = (Integer) request.getSession(true).getAttribute("totalPrice");
			
			int totalQtyOrder=(Integer) request.getSession(true).getAttribute("totalQtyOrdered");
//			MemberBean memberBean =((MemberBean)request.getSession(true).getAttribute("login_session"));
			
			java.util.Date date = new Date(); 
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());	
			
			OrderBean order = new OrderBean( null, "name", sqlDate, totalPrice, totalQtyOrder, "付款成功");
			//"name"= memberBean.getName
			
//			order.setCustomerId(memberBean.getName());
//			System.out.println("memberBean"+memberBean.getName());
//			order.setPrice(totalPrice);
//			order.setQuantity(totalQtyOrder);
			os.insertOrderitem(order);
			
			
			response.setHeader("Refresh","0.5;product/commit.jsp");
			request.getSession(true).removeAttribute("cart");//移除session	

		
		
//		ServletContext servletContext = getServletContext();
//		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/commit.jsp");
//		requestDispatcher.forward(request, response);
		
		}
}
