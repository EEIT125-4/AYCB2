package product.cartDao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import product.cartDao.OrderDao;
import product.cartModel.OrderBean;
import product.cartModel.ProductDB;
import product.model.ProductBean;
import tool.HibernateUtils;


public class OrderDaoImpl implements OrderDao {

	SessionFactory factory = HibernateUtils.getSessionFactory();
	
	@SuppressWarnings("unchecked")
	@Override
	public ProductDB getProductDB() {

		  Session session = factory.getCurrentSession();
		  String sql="FROM ProductBean";
		  List<ProductBean> products=new ArrayList<ProductBean>();
		  List<String> nameList = new ArrayList<String>();
		  List<Double> priceList = new ArrayList<Double>();
		  
		  Query<ProductBean> query1=session.createQuery(sql);
		  
		  products=query1.getResultList();
		  
		  System.out.println("products:"+products);
		  
		  for(ProductBean p:products) {
			  nameList.add(p.getProductname());
			  System.out.println(p.getProductname());
			  priceList.add(p.getProductprice());
			  System.out.println(p.getProductprice());
		  }
		  
		  ProductDB PD = new ProductDB();
		  
	       
		  PD.setProductName(nameList);
		  PD.setProductPrice(priceList);
		
//		  List<String> List = new ArrayList<>();
//		  String Hql = "SELECT p.productname FROM ProductBean p ";
//		  Query<String> query2=session.createQuery(Hql);
//		  List=query2.getResultList();
//		  for(String s:List) {
//			 System.out.println("name:"+s);
//		  }
//		  
		return PD;		
		  
//		  String Hql2 = "SELECT p.Product_Price FROM Product p ";
		  
		  
		  
		  
		  //Query<String> query = session.createQuery(Hql);
		  //nameList = query.getResultList();
		 // Query<Integer> query1 = session.createQuery(Hql2);
		  //priceList = query1.getResultList();
		  
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderBean> selectOrderitem(String name) {

		List<OrderBean> list = new ArrayList<OrderBean>();
		String hq1 = "FROM OrderBean o WHERE o.customerId = :name";
		Session session = factory.getCurrentSession();

		Query<OrderBean> query = session.createQuery(hq1);
		list = query.setParameter("name", name).getResultList();
		return list;

//		OrderBean order = new OrderBean();
//		try (
//				Statement stmt = conn.createStatement();
//				ResultSet rs = stmt.executeQuery("select * from orders_item where customer_id ='"+name+"'");
//			){
//			while (rs.next()) {
//				order.setOrderNo(rs.getInt("order_No"));
//				order.setOrdertime(rs.getDate("order_time"));
//				order.setPrice(rs.getInt("price"));
//				order.setQuantity(rs.getInt("quantity"));
//				order.setStatus(rs.getString("status"));
//				list.add(order);
//			}
//			stmt.close();
//			conn.close();
//			System.out.println("DAO"+order.getCustomerId());
		// return (List<OrderBean>) list;

	}

	@Override
	public boolean insertOrderitem(OrderBean order) {

		Session session = factory.getCurrentSession();
		session.save(order);
		return true;
//		try(
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery("select max(order_No) from orders_item");
//			PreparedStatement pstmt = conn.prepareStatement("insert into orders_item values(?,?,?,?,?)");					
//		) {
//			Integer max =0;
//			while (rs.next()) {
//				max = rs.getInt(1);
//				System.out.println("最大訂單號"+max);
//			
//			}
//			max++;
		// pstmt.setInt(1, max);
//			pstmt.setString(1, order.getCustomerId());
//			System.out.println("getCustomer_Id"+order.getCustomerId());
//			//pstmt.setString(1, "紀子雲");
//			java.util.Date date = new Date(); 
//			java.sql.Date sqlDate = new java.sql.Date(date.getTime());			
//			pstmt.setDate(2, sqlDate);
//			pstmt.setInt(3, order.getPrice());
//			pstmt.setInt(4, order.getQuantity());
//			//pstmt.setString(6, order.getStatus());
//			pstmt.setString(5,"付款成功");
//			
//			int updatecount = pstmt.executeUpdate();
//			pstmt.clearParameters();		
//			System.out.println("update"+updatecount);
//		      if (updatecount >= 1) return true;
//		      else                  return false;
//			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//			return false;
//		}

	}

	@Override
	public boolean updateOrderitem(OrderBean order) {

		Session session = factory.getCurrentSession();
		session.saveOrUpdate(order);
		return true;
//		try (
//			  PreparedStatement pstmt = conn.prepareStatement("update orders_item set customer_Id=?, order_time=?, price=?, quantity=?, status=? from orders_item where order_No = ?");				
//		){
//			System.out.println("innnnnnnnnnnnn");
//			pstmt.setInt(6, order.getOrderNo());
//			pstmt.setString(1, order.getCustomerId());
//			java.sql.Date sqlDate = new java.sql.Date(order.getOrdertime().getTime());
//			pstmt.setDate(2, sqlDate);
//			pstmt.setInt(3, order.getPrice());
//			pstmt.setInt(4, order.getQuantity());
//			pstmt.setString(5, order.getStatus());
//			System.out.println("outtttttttttt");
//			
//			int updatecount = pstmt.executeUpdate();
//			pstmt.clearParameters();		
//			System.out.println("update"+updatecount);
//		      if (updatecount >= 1) return true;
//		      else                  return false;
//			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//			return false;
//		}

	}

	@Override
	public boolean deleteOrderitem(int no) {

		Session session = factory.getCurrentSession();
		OrderBean order = new OrderBean();
		order.setOrderNo(no);
		session.delete(order);

		return true;

//		try (
//			  PreparedStatement pstmt = conn.prepareStatement("delete from orders_item where order_No = ?;");				
//		){			
//			Integer no =Integer.parseInt(pno) ;
//			System.out.println(no);
//			pstmt.setInt(1,no);
//			int deletecount = pstmt.executeUpdate();
//			pstmt.clearParameters();		
//			System.out.println("delete"+deletecount);
//			
//			if (deletecount >= 1) {
//		    	  System.out.println("刪除成功");
//		    	  return true;
//		      }else                  
//		    	  return false;
//						
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//			return false;
//		}
	}

	@Override
	public OrderBean selectUpdateitem(int ino) {

		OrderBean order = null;
		Session session = factory.getCurrentSession();
		order = session.get(OrderBean.class, ino);

		return order;
//		try (
//				Statement stmt = conn.createStatement();
//				ResultSet rs = stmt.executeQuery("select * from orders_item where order_No = '"+pno+"'");
//			){
//			while (rs.next()) {
//				order.setOrderNo(rs.getInt("order_No"));
//				order.setCustomerId(rs.getString("customer_Id"));
//				order.setOrdertime(rs.getDate("order_time"));
//				order.setPrice(rs.getInt("price"));
//				order.setQuantity(rs.getInt("quantity"));
//				order.setStatus(rs.getString("status"));
//			}
//			stmt.close();
//			conn.close();
//			System.out.println("DAO"+order.getCustomerId());
//			return order;
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//		return null;

	}

}
