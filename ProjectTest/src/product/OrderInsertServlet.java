package product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

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


import member.MemberBean;
import product.cartDao.OrderDAO;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderInsertServlet")
public class OrderInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";   
	
	DataSource ds = null;
	Connection conn= null;
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public OrderInsertServlet() {
        super();
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		try {
			InitialContext ctxt = new InitialContext();
			ds=(DataSource)ctxt.lookup("java:comp/env/jdbc/EmployeeDB");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
    	
    }
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); 
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		
		
		
		try (
			Connection conn = ds.getConnection();			
		) {
			
			OrderDAO orderDao = new OrderDAO(conn);
			
			OrderBean order = new OrderBean();
			
			
			int totalPrice = (Integer) request.getSession(true).getAttribute("totalPrice");
			
			int totalQtyOrder=(Integer) request.getSession(true).getAttribute("totalQtyOrdered");
			MemberBean memberBean =((MemberBean)request.getSession(true).getAttribute("login_session"));
			order.setCustomerId(memberBean.getName());
			System.out.println("memberBean"+memberBean.getName());
			order.setPrice(totalPrice);
			order.setQuantity(totalQtyOrder);

			orderDao.insertOrderitem(order);
			
			response.setHeader("Refresh","0.5;commit.jsp");
			request.getSession(true).removeAttribute("cart");//移除session	

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		
//		ServletContext servletContext = getServletContext();
//		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/commit.jsp");
//		requestDispatcher.forward(request, response);
		
		}
}
