package product.cartController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import product.cartDao.OrderDao;
import product.cartDao.impl.OrderDaoImpl;
import product.cartModel.OrderBean;
import product.cartService.OrderService;
import product.cartService.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HistoryServlet")
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
//	DataSource ds = null;
//	Connection conn = null;
//
//	InitialContext ctxt = null;

	public HistoryServlet() {
		super();
	}

//	@Override
//	public void init() throws ServletException {
//
//		try {
//			ctxt = new InitialContext();
//			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/EmployeeDB");
//			conn = ds.getConnection();
//		} catch (NamingException e) {
//
//			throw new ServletException(e);
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		String delete = request.getParameter("delete");
		

		if (delete != null) {
			DeleteProcess(request, response);
		} else if (request.getParameter("update") != null) {
			PackProcess(request, response);
		} else if (request.getParameter("confirmupdate") != null) {
			UpdateProcess(request, response);
		}
	}

	protected void DeleteProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("delete process");

		

			String pno = request.getParameter("delete");
			System.out.println("pno" + pno);
			int no = Integer.parseInt(pno);
			
			OrderService order = new OrderServiceImpl();
			if (order.deleteOrderitem(no)) {
				
				System.out.println("Get order SQL delete done!");
			}
	

		request.getRequestDispatcher("/historyOrders.jsp").forward(request, response);
	}

	protected void PackProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Pack process");


			String pno = request.getParameter("update");
			System.out.println("pno" + pno);
			int no = Integer.parseInt(pno);
			
			OrderService order = new OrderServiceImpl();
			
			OrderBean bean = order.selectUpdateitem(no);

			request.getSession(true).setAttribute("bean", bean);

	

		request.getRequestDispatcher("/updateOrder.jsp").forward(request, response);
	}

	protected void UpdateProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	

			int orderNo = Integer.parseInt(request.getParameter("order_No"));
			
			String customerId = request.getParameter("customer_Id");
			
			
			java.util.Date date = new Date(); 
			java.sql.Date orderTime = new java.sql.Date(date.getTime());
		
			int price = Integer.parseInt(request.getParameter("price"));
			
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			
			String status = request.getParameter("status");

			OrderService order = new OrderServiceImpl();

			OrderBean bean = new OrderBean(orderNo, customerId, orderTime, price, quantity, status);

			//order.updateOrderitem(bean);

			if (order.updateOrderitem(bean)) {
				System.out.println("Get order SQL update done!");
			}

	

		request.getRequestDispatcher("/historyOrders.jsp").forward(request, response);
	}

}
