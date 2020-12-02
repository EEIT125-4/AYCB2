package member;

import java.lang.reflect.Member;
import java.sql.*;



public class registerDAO {

	private Connection conn;

	public registerDAO(Connection conn) {
		this.conn = conn;

	}

	public boolean insertregister(MemberBean memberdata) {
		try {
			String sqlString = "insert into member values('" + memberdata.getName() + "','" + memberdata.getAccount() + "','"
					+ memberdata.getPassword() + "','" + memberdata.getAddress() + "','" + memberdata.getPhone() + "','"
					+ memberdata.getBirth() + "','" + memberdata.getEmail() + "','" + memberdata.getGender() + "')";

			Statement stmt = conn.createStatement();
			System.out.println(sqlString);
			int updatecount = stmt.executeUpdate(sqlString);
			stmt.close();
			if (updatecount >= 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.err.println("CANT" + e);
			return false;
		}
	}

	public boolean updateregister(MemberBean memberdata) {
        try {
          String upadteString = 
        		  "UPDATE member SET password='"+memberdata.getPassword()+"',address='"
        				  +memberdata.getAddress()
        				  +"',phone='"+memberdata.getPhone()+"' WHERE email='"+memberdata.getEmail()+"'";
          
          //"update profinal set product_price=? where product_name=?"
                                               
      
          Statement stmt = conn.createStatement();
          System.out.println(upadteString);
    	    int updatecount = stmt.executeUpdate(upadteString);
          stmt.close();
          if (updatecount >= 1) return true;
          else                  return false;
    	  } catch (Exception e) {
    	    System.err.println("CANT" + e);
    		  return false;
        }
    }

	public boolean deleteregister(MemberBean memberdata) {
		try {
			String deleteregister = "DELETE FROM email" + "WHERE email = '" + memberdata.getEmail() + "' ";
			Statement stmt = conn.createStatement();
			int deletecount = stmt.executeUpdate(deleteregister);
			stmt.close();
			if (deletecount >= 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.err.println("刪除會員時發生錯誤: " + e);
			return false;
		}
	}

}
