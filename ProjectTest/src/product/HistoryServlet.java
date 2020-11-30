package product;

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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/HistoryServlet")
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	DataSource ds = null;
	Connection conn= null;

	InitialContext ctxt=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	
    	try {
		 ctxt = new InitialContext();
			ds=(DataSource)ctxt.lookup("java:comp/env/jdbc/EmployeeDB");
			conn = ds.getConnection();
		} catch (NamingException e) {
			
			throw new ServletException(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType(CONTENT_TYPE);   
		PrintWriter out = response.getWriter();	
		String delete = request.getParameter("delete");
		OrderDAO order = new OrderDAO(conn);

		 if (delete!=null) {		 
		     DeleteProcess(request, response);
		}else if (request.getParameter("update")!=null) {
			 PackProcess(request, response);
	}else if (request.getParameter("confirmupdate")!=null) {
			 UpdateProcess(request, response);}
	}
	protected void DeleteProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("delete process");	
			
		try (Connection conn = ds.getConnection();){			
			
			String pno = request.getParameter("delete");
			System.out.println("pno"+pno);
			OrderDAO order = new OrderDAO(conn);
			if(order.deleteOrderitem(pno)) {
				System.out.println("Get some SQL commands done!");
			}
			System.out.println(request.getParameter("delete"));
			request.getParameter("delete");
			
		} catch (SQLException e) {
			System.out.println("error");
			
			e.printStackTrace();
		}

		request.getRequestDispatcher("/historyOrders.jsp").forward(request, response);
	}

	protected void PackProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Pack process");	
		
	try (Connection conn = ds.getConnection();){			
		
		String pno = request.getParameter("update");
		System.out.println("pno"+pno);
		OrderDAO order = new OrderDAO(conn);
		OrderBean bean =  order.selectUpdateitem(pno);

		request.getSession(true).setAttribute("bean",bean);
		
		
	} catch (SQLException e) {
		System.out.println("error");
		
		e.printStackTrace();
	}

	request.getRequestDispatcher("/updateOrder.jsp").forward(request, response);
}
	protected void UpdateProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try (Connection conn = ds.getConnection();){			
		
		int order_No = Integer.parseInt(request.getParameter("order_No"));
		String customer_Id = request.getParameter("customer_Id");
		Date order_time = new Date();
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String status = request.getParameter("status");
		
		OrderDAO order = new OrderDAO(conn);
		
		OrderBean bean = new OrderBean(order_No, customer_Id, order_time, price, quantity, status);
		
		order.updateOrderitem(bean);
		
		if(order.updateOrderitem(bean)) {
			System.out.println("Get some SQL commands done!");
		}
		System.out.println(request.getParameter("delete"));
		request.getParameter("delete");
		
	} catch (SQLException e) {
		System.out.println("error");
		
		e.printStackTrace();
	}

	request.getRequestDispatcher("/historyOrders.jsp").forward(request, response);
}

}
