package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	private Connection conn;

	// 建構子
	public ProductDAO(Connection conn) {
		this.conn = conn;
	}

	// ALLProduct
//	public void allproduct() {
//		List<String> brandnoList = new ArrayList<String>();
//		List<String> brandnameList = new ArrayList<String>();
//		List<Integer> productnoList = new ArrayList<Integer>();
//		List<String> productnameList = new ArrayList<String>();
//		List<String> seriesList = new ArrayList<String>();
//		List<String> cateList = new ArrayList<String>();
//		List<Integer> priceList = new ArrayList<Integer>();
//		try {
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery("select * from profinal");
//			while (rs.next()) {
//				brandnoList.add(rs.getString(1));
//				brandnameList.add(rs.getString(2));
//				productnoList.add(rs.getInt(4));
//				productnameList.add(rs.getString(5));
//				seriesList.add(rs.getString(6));
//				cateList.add(rs.getString(7));
//				priceList.add(rs.getInt(9));
//			}
//			ProductDB.setBrand_No((String[]) brandnoList.toArray(new String[0]));
//			ProductDB.setBrand_Name((String[]) brandnameList.toArray(new String[0]));
//			ProductDB.setProduct_No((Integer[]) productnoList.toArray(new Integer[0]));
//			ProductDB.setProduct_Name((String[]) productnameList.toArray(new String[0]));
//			ProductDB.setProduct_Series((String[]) seriesList.toArray(new String[0]));
//			ProductDB.setProduct_Category((String[]) cateList.toArray(new String[0]));
//			ProductDB.setProduct_Price((Integer[]) priceList.toArray(new Integer[0]));
//			
//			rs.close();
//			stmt.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	// 新增
	public void addproduct(Product product) {
		String brand_no = null;
		String product_type = "保養品";
		String skintype = "all";
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"insert into profinal (brand_no, brand_name, product_type, product_no, product_name, product_series, product_category, skintype, product_price) values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			if (product.getBrand_Name().equals("Biotherm")) {
				brand_no = "B01";
			} else if (product.getBrand_Name().equals("LAB Series")) {
				brand_no = "L01";
			}

			pstmt.setString(1, brand_no);
			pstmt.setString(2, product.getBrand_Name());
			pstmt.setString(3, product_type);
			pstmt.setInt(4, addrow(product.getBrand_Name()));
			pstmt.setString(5, product.getProduct_Name());
			pstmt.setString(6, product.getProduct_Series());
			pstmt.setString(7, product.getProduct_Category());
			pstmt.setString(8, skintype);
			pstmt.setInt(9, product.getProduct_Price());
			pstmt.executeUpdate();

			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//
	public int addrow(String brand_name) {
		int count = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement("select product_no from profinal where brand_name=?");
			pstmt.setString(1, brand_name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				count = Integer.parseInt(rs.getString("product_no")) + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	//更新
	public void updateproduct(String product_price, String product_name) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("update profinal set product_price=? where product_name=?");
			pstmt.setString(1, product_price);
			pstmt.setString(2, product_name);
			pstmt.executeUpdate();

			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//刪除
	public void delproduct(String product_name) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("delete from profinal where product_name=?");
			pstmt.setString(1, product_name);
			pstmt.executeUpdate();

			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 廠商
	public void brand(String brandname) {
		List<String> brandnoList = new ArrayList<String>();
		List<String> brandnameList = new ArrayList<String>();
		List<Integer> productnoList = new ArrayList<Integer>();
		List<String> productnameList = new ArrayList<String>();
		List<String> seriesList = new ArrayList<String>();
		List<String> cateList = new ArrayList<String>();
		List<Integer> priceList = new ArrayList<Integer>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from profinal where brand_name=?");
			pstmt.setString(1, brandname);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				brandnoList.add(rs.getString(1));
				brandnameList.add(rs.getString(2));
				productnoList.add(rs.getInt(4));
				productnameList.add(rs.getString(5));
				seriesList.add(rs.getString(6));
				cateList.add(rs.getString(7));
				priceList.add(rs.getInt(9));
			}
			ScreeningDB.setBrand_No((String[]) brandnoList.toArray(new String[0]));
			ScreeningDB.setBrand_Name((String[]) brandnameList.toArray(new String[0]));
			ScreeningDB.setProduct_No((Integer[]) productnoList.toArray(new Integer[0]));
			ScreeningDB.setProduct_Name((String[]) productnameList.toArray(new String[0]));
			ScreeningDB.setProduct_Series((String[]) seriesList.toArray(new String[0]));
			ScreeningDB.setProduct_Category((String[]) cateList.toArray(new String[0]));
			ScreeningDB.setProduct_Price((Integer[]) priceList.toArray(new Integer[0]));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 系列
	public void series(String series) {
		List<String> brandnoList = new ArrayList<String>();
		List<String> brandnameList = new ArrayList<String>();
		List<Integer> productnoList = new ArrayList<Integer>();
		List<String> productnameList = new ArrayList<String>();
		List<String> seriesList = new ArrayList<String>();
		List<String> cateList = new ArrayList<String>();
		List<Integer> priceList = new ArrayList<Integer>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from profinal where product_series=?");
			pstmt.setString(1, series);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				brandnoList.add(rs.getString(1));
				brandnameList.add(rs.getString(2));
				productnoList.add(rs.getInt(4));
				productnameList.add(rs.getString(5));
				seriesList.add(rs.getString(6));
				cateList.add(rs.getString(7));
				priceList.add(rs.getInt(9));
			}
			ScreeningDB.setBrand_No((String[]) brandnoList.toArray(new String[0]));
			ScreeningDB.setBrand_Name((String[]) brandnameList.toArray(new String[0]));
			ScreeningDB.setProduct_No((Integer[]) productnoList.toArray(new Integer[0]));
			ScreeningDB.setProduct_Name((String[]) productnameList.toArray(new String[0]));
			ScreeningDB.setProduct_Series((String[]) seriesList.toArray(new String[0]));
			ScreeningDB.setProduct_Category((String[]) cateList.toArray(new String[0]));
			ScreeningDB.setProduct_Price((Integer[]) priceList.toArray(new Integer[0]));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 種類
	public void cate(String cate) {
		List<String> brandnoList = new ArrayList<String>();
		List<String> brandnameList = new ArrayList<String>();
		List<Integer> productnoList = new ArrayList<Integer>();
		List<String> productnameList = new ArrayList<String>();
		List<String> seriesList = new ArrayList<String>();
		List<String> cateList = new ArrayList<String>();
		List<Integer> priceList = new ArrayList<Integer>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from profinal where product_category=?");
			pstmt.setString(1, cate);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				brandnoList.add(rs.getString(1));
				brandnameList.add(rs.getString(2));
				productnoList.add(rs.getInt(4));
				productnameList.add(rs.getString(5));
				seriesList.add(rs.getString(6));
				cateList.add(rs.getString(7));
				priceList.add(rs.getInt(9));
			}
			ScreeningDB.setBrand_No((String[]) brandnoList.toArray(new String[0]));
			ScreeningDB.setBrand_Name((String[]) brandnameList.toArray(new String[0]));
			ScreeningDB.setProduct_No((Integer[]) productnoList.toArray(new Integer[0]));
			ScreeningDB.setProduct_Name((String[]) productnameList.toArray(new String[0]));
			ScreeningDB.setProduct_Series((String[]) seriesList.toArray(new String[0]));
			ScreeningDB.setProduct_Category((String[]) cateList.toArray(new String[0]));
			ScreeningDB.setProduct_Price((Integer[]) priceList.toArray(new Integer[0]));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 搜尋
	public void search(String sql) {
		List<String> brandnoList = new ArrayList<String>();
		List<String> brandnameList = new ArrayList<String>();
		List<Integer> productnoList = new ArrayList<Integer>();
		List<String> productnameList = new ArrayList<String>();
		List<String> seriesList = new ArrayList<String>();
		List<String> cateList = new ArrayList<String>();
		List<Integer> priceList = new ArrayList<Integer>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				brandnoList.add(rs.getString(1));
				brandnameList.add(rs.getString(2));
				productnoList.add(rs.getInt(4));
				productnameList.add(rs.getString(5));
				seriesList.add(rs.getString(6));
				cateList.add(rs.getString(7));
				priceList.add(rs.getInt(9));
			}
			ScreeningDB.setBrand_No((String[]) brandnoList.toArray(new String[0]));
			ScreeningDB.setBrand_Name((String[]) brandnameList.toArray(new String[0]));
			ScreeningDB.setProduct_No((Integer[]) productnoList.toArray(new Integer[0]));
			ScreeningDB.setProduct_Name((String[]) productnameList.toArray(new String[0]));
			ScreeningDB.setProduct_Series((String[]) seriesList.toArray(new String[0]));
			ScreeningDB.setProduct_Category((String[]) cateList.toArray(new String[0]));
			ScreeningDB.setProduct_Price((Integer[]) priceList.toArray(new Integer[0]));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
