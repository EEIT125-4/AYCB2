package product;

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


/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")  
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DataSource ds;
	
	ProductDB db;
  
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
		if(db==null) {
			
			db=new ProductDB();

			try {//JNDI
			      
			      InitialContext ctx = new InitialContext();
			      
			      ds = (DataSource)ctx.lookup("java:comp/env/jdbc/EmployeeDB");
			      if (ds == null)
			         throw new ServletException("Unknown DataSource 'jdbc/EmployeeDB'");
			  } catch (NamingException ex) {
			      ex.printStackTrace();
			  }
			
			  Connection conn = null;
		      Statement  stmt = null;
		    
		    
		    List <String> nameList =  new  ArrayList <String> () ;
		    List <Integer> priceList = new  ArrayList <Integer> ();
		    
		    try {
		       	      
		       conn = ds.getConnection();
		       stmt = conn.createStatement();
		       ResultSet rset = stmt.executeQuery("select product_Name, product_Price from profinal");
		      
		       while(rset.next()) {        	 
		    	   nameList.add(rset.getString("product_Name"));//add資料新增
		    	   priceList.add(rset.getInt("product_Price"));
		       }
		       
		       ProductDB.setProduct_Name((String[]) nameList.toArray(new String[0]));//List轉成字串陣列,new String[0])制式寫法
		       ProductDB.setProduct_Price((Integer[]) priceList.toArray(new Integer[0]));
		       //classDB的class方法
		    } catch (SQLException ex) {
		       ex.printStackTrace();
		    } finally {
		 
		       try {
		          if (stmt != null) stmt.close();
		          if (conn != null) conn.close();
		       } catch (SQLException ex) {
		           ex.printStackTrace();
		       }
		    }
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
		
		
		
		
		
		
		
		 // Retrieve找回 the current session, or create a new session if no session exists.
	      HttpSession session = request.getSession(true);//建session
	 
	      // Retrieve the shopping cart of the current session.
	      List<CartItem> theCart = (ArrayList<CartItem>) session.getAttribute("cart");
	      //theCart購物車
	      // For dispatching派遣 the next Page
	      String nextPage = "";
	      //下個頁面
	      String todo = request.getParameter("todo");

	      if (todo == null) {
	         nextPage = "/ShowAll.jsp"; 
	      } else if (todo.equals("shop")) {
	    	  
	    	  nextPage = "/ShowAll.jsp";
	      } else if (todo.equals("add")) {
	    	  System.out.println("product_No= "+request.getParameter("product_No"));
	    	  System.out.println("count= "+request.getParameter("count"));
	    	  //System.out.println(request.getParameter("product_No").getClass());
	         CartItem newCartItem = new CartItem(//建構子
	        		 
	        		 Integer.parseInt(request.getParameter("product_No")),
	                 Integer.parseInt(request.getParameter("count")));
	         if (theCart == null) { 
	            theCart = new ArrayList<>();
	            theCart.add(newCartItem);
	            session.setAttribute("cart", theCart);  // binds cart to session
	         } else {
	            // Check if this book is already in the cart.
	            boolean found = false; //旗標檢查用
	            Iterator iter = theCart.iterator();//轉結構,方便使用方法
	            while (!found && iter.hasNext()) {//假設沒找到就一筆一筆找,  !found->false變true
	               CartItem aCartItem = (CartItem)iter.next();
	               if (aCartItem.getProduct_No() == newCartItem.getProduct_No()) {
	                  aCartItem.setQtyOrdered(aCartItem.getQtyOrdered()
	                        + newCartItem.getQtyOrdered());//同一商品的話,數量加總
	                  found = true;
	               }
	            }
	            if (!found) { 
	               theCart.add(newCartItem);//沒找到相同的商品就新增
	            }
	         }
	        
	         nextPage = "/order.jsp";
	         
	      } else if (todo.equals("remove")) {
	 
	         int cartIndex = Integer.parseInt(request.getParameter("cartIndex"));
	         theCart.remove(cartIndex);//刪除某樣商品
	         
	         nextPage = "/order.jsp";
	      } else if (todo.equals("checkout")) {
	       
	    	  int totalPrice = 0; //計算總價,數字歸零
	         int totalQtyOrdered = 0; //總數量歸零
	         for (CartItem item: theCart) {
	            int price = item.getProduct_Price();
	            int qtyOrdered = item.getQtyOrdered();
	            totalPrice += price * qtyOrdered;
	            totalQtyOrdered += qtyOrdered;
	         }
	         
	         nextPage = "/checkout.jsp";
	         
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
