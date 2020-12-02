package product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.plaf.synth.SynthScrollBarUI;



public class OrderDAO {
	
	private Connection conn;

	public OrderDAO(Connection conn) {
		super();
		this.conn = conn;
		System.out.println("DAO!!!");
	}
	
	public ArrayList<OrderBean> selectOrderitem(String name) {
		List<OrderBean> list =new ArrayList<OrderBean>();
		OrderBean order = new OrderBean();
		try (
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from orders_item where customer_id ='"+name+"'");
			){
			while (rs.next()) {
				order.setOrder_No(rs.getInt("order_No"));
				order.setOrder_time(rs.getDate("order_time"));
				order.setPrice(rs.getInt("price"));
				order.setQuantity(rs.getInt("quantity"));
				order.setStatus(rs.getString("status"));
				list.add(order);
			}
			stmt.close();
			conn.close();
			System.out.println("DAO"+order.getCustomer_Id());
			return (ArrayList<OrderBean>) list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
				
	}
	
	
	public boolean insertOrderitem(OrderBean order) {
		
		
		try(
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select max(order_No) from orders_item");
			PreparedStatement pstmt = conn.prepareStatement("insert into orders_item values(?,?,?,?,?)");					
		) {
			Integer max =0;
			while (rs.next()) {
				max = rs.getInt(1);
				System.out.println("最大訂單號"+max);
			
			}
			max++;
			//pstmt.setInt(1, max);
			pstmt.setString(1, order.getCustomer_Id());
			System.out.println("getCustomer_Id"+order.getCustomer_Id());
			//pstmt.setString(1, "紀子雲");
			java.util.Date date = new Date(); 
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());			
			pstmt.setDate(2, sqlDate);
			pstmt.setInt(3, order.getPrice());
			pstmt.setInt(4, order.getQuantity());
			//pstmt.setString(6, order.getStatus());
			pstmt.setString(5,"付款成功");
			
			int updatecount = pstmt.executeUpdate();
			pstmt.clearParameters();		
			System.out.println("update"+updatecount);
		      if (updatecount >= 1) return true;
		      else                  return false;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
	
	}
	
	
	public boolean updateOrderitem (OrderBean order) {
		
		try (
			  PreparedStatement pstmt = conn.prepareStatement("update orders_item set customer_Id=?, order_time=?, price=?, quantity=?, status=? from orders_item where order_No = ?");				
		){
			System.out.println("innnnnnnnnnnnn");
			pstmt.setInt(6, order.getOrder_No());
			pstmt.setString(1, order.getCustomer_Id());
			java.sql.Date sqlDate = new java.sql.Date(order.getOrder_time().getTime());
			pstmt.setDate(2, sqlDate);
			pstmt.setInt(3, order.getPrice());
			pstmt.setInt(4, order.getQuantity());
			pstmt.setString(5, order.getStatus());
			System.out.println("outtttttttttt");
			
			int updatecount = pstmt.executeUpdate();
			pstmt.clearParameters();		
			System.out.println("update"+updatecount);
		      if (updatecount >= 1) return true;
		      else                  return false;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	
	public boolean deleteOrderitem (String pno) {
		
		try (
			  PreparedStatement pstmt = conn.prepareStatement("delete from orders_item where order_No = ?;");				
		){			
			Integer no =Integer.parseInt(pno) ;
			System.out.println(no);
			pstmt.setInt(1,no);
			int deletecount = pstmt.executeUpdate();
			pstmt.clearParameters();		
			System.out.println("delete"+deletecount);
			
			if (deletecount >= 1) {
		    	  System.out.println("刪除成功");
		    	  return true;
		      }else                  
		    	  return false;
						
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	public OrderBean selectUpdateitem(String pno) {
		
		OrderBean order = new OrderBean();
		try (
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from orders_item where order_No = '"+pno+"'");
			){
			while (rs.next()) {
				order.setOrder_No(rs.getInt("order_No"));
				order.setCustomer_Id(rs.getString("customer_Id"));
				order.setOrder_time(rs.getDate("order_time"));
				order.setPrice(rs.getInt("price"));
				order.setQuantity(rs.getInt("quantity"));
				order.setStatus(rs.getString("status"));
			}
			stmt.close();
			conn.close();
			System.out.println("DAO"+order.getCustomer_Id());
			return order;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
				
	}
	
}
