package product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";

	DataSource ds = null;

	public void init() throws ServletException {
		try {

			InitialContext ctxt = new InitialContext();

			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/EmployeeDB");
			if (ds == null)
				throw new ServletException("Unknown DataSource 'jdbc/EmployeeDB'");
		} catch (NamingException ex) {
			ex.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(CHARSET_CODE);
	    response.setContentType(CONTENT_TYPE);
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		List<String> brandnoList = new ArrayList<String>();
		List<Integer> productnoList = new ArrayList<Integer>();
		List<String> productnameList = new ArrayList<String>();
		List<String> seriesList = new ArrayList<String>();
		List<String> cateList = new ArrayList<String>();
		List<Integer> priceList = new ArrayList<Integer>();

		try {
			String brandno = request.getParameter("brandno");
			int productno = Integer.parseInt(request.getParameter("productno"));

			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select * from profinal where brand_no=? and product_no=?");
			pstmt.setString(1, brandno);
			pstmt.setInt(2, productno);		
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				brandnoList.add(rs.getString(1));
				productnoList.add(rs.getInt(4));
				productnameList.add(rs.getString(5));
				seriesList.add(rs.getString(6));
				cateList.add(rs.getString(7));
				priceList.add(rs.getInt(9));
			}
			ProductDetailDB.setBrand_No((String[]) brandnoList.toArray(new String[0]));
			ProductDetailDB.setProduct_No((Integer[]) productnoList.toArray(new Integer[0]));
			ProductDetailDB.setProduct_Name((String[]) productnameList.toArray(new String[0]));
			ProductDetailDB.setProduct_Series((String[]) seriesList.toArray(new String[0]));
			ProductDetailDB.setProduct_Category((String[]) cateList.toArray(new String[0]));
			ProductDetailDB.setProduct_Price((Integer[]) priceList.toArray(new Integer[0]));
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ProductDetail.jsp");
		rd.forward(request, response);
	}
}
