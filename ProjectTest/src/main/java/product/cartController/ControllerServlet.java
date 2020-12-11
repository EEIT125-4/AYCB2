package product.cartController;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;

import product.cartModel.CartItem;
import product.cartModel.ProductDB;
import product.cartService.OrderService;
import product.cartService.impl.OrderServiceImpl;

@WebServlet("/ControllerServlet")  
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	DataSource ds;
	
	ProductDB db;
  

	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		System.out.println("init start");
		OrderService os = new OrderServiceImpl();
		
		db = os.getProductDB();
		
		System.out.println("db "+db);
	
	
	}	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);  
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 // Retrieve找回 the current session, or create a new session if no session exists.
	      HttpSession session = request.getSession(true);//建session
	 
	      // Retrieve the shopping cart of the current session.
	      @SuppressWarnings("unchecked")
		List<CartItem> theCart = (List<CartItem>) session.getAttribute("cart");
	      //theCart購物車
	      // For dispatching派遣 the next Page
	      String nextPage = "";
	      //下個頁面
	      String todo = request.getParameter("todo");

	      if (todo == null) {
	         nextPage = "/AllProductServlet"; 
	      } else if (todo.equals("shop")) {
	    	  
	    	  nextPage = "/AllProductServlet";
	      } else if (todo.equals("add")) {
	    	  System.out.println("productNo= "+request.getParameter("productno"));
	    	  System.out.println("count= "+request.getParameter("count"));
	    	  //System.out.println(request.getParameter("productNo").getClass());
	         CartItem newCartItem = new CartItem(//建構子
	        		 
	        		 Integer.parseInt(request.getParameter("productno")),
	                 Integer.parseInt(request.getParameter("count")));
	         if (theCart == null) { 
	            theCart = new ArrayList<>();
	            theCart.add(newCartItem);
	            session.setAttribute("cart", theCart);  // binds cart to session
	            System.out.println("cart"+theCart);
	         } else {
	            // Check if this book is already in the cart.
	            boolean found = false; //旗標檢查用
	            Iterator iter = theCart.iterator();//轉結構,方便使用方法
	            while (!found && iter.hasNext()) {//假設沒找到就一筆一筆找,  !found->false變true
	               CartItem aCartItem = (CartItem)iter.next();
	               if (aCartItem.getProductNo() == newCartItem.getProductNo()) {
	                  aCartItem.setQtyOrdered(aCartItem.getQtyOrdered()
	                        + newCartItem.getQtyOrdered());//同一商品的話,數量加總
	                  found = true;
	               }
	            }
	            if (!found) { 
	               theCart.add(newCartItem);//沒找到相同的商品就新增
	            }
	         }
	         System.out.println("準備前往購物車");
	         nextPage = "/product/order.jsp";
	         
	      } else if (todo.equals("remove")) {
	 
	         int cartIndex = Integer.parseInt(request.getParameter("cartIndex"));
	         theCart.remove(cartIndex);//刪除某樣商品
	         
	         nextPage = "/product/order.jsp";
	      } else if (todo.equals("checkout")) {
	       
	    	  int totalPrice = 0; //計算總價,數字歸零
	         int totalQtyOrdered = 0; //總數量歸零
	         for (CartItem item: theCart) {
	            Double price = item.getProductPrice();
	            int qtyOrdered = item.getQtyOrdered();
	            totalPrice += price * qtyOrdered;
	            totalQtyOrdered += qtyOrdered;
	         }
	         
	         nextPage = "/product/checkout.jsp";
	         
	         request.getSession(true).setAttribute("totalPrice", totalPrice);
	         request.getSession(true).setAttribute("totalQtyOrdered", totalQtyOrdered);

	         
	      } else if (todo.equals("commit")) {

	    	  
	    	  nextPage = "/OrderInsertServlet";	    	  	    	  
		    
	    	  	    	  	    	  
	      }
	 
	      ServletContext servletContext = getServletContext();
	      RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(nextPage);//派遣往外送至nextPage
	      requestDispatcher.forward(request, response);
	   }


	
}
