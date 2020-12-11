package event;
// DAO: Database Access Object

import java.sql.*;

import event.EventBean;

public class EventDAO {

  private Connection conn;


  public EventDAO(Connection conn) {
		this.conn = conn;
  }

 

  public boolean insertEvent(EventBean eventData) {
    try {
      String sql = "insert into Event values('"
    		  +eventData.getName()+"','"
    		  + eventData.getPhone()+"','"
	                  	   	+eventData.getMailaddress()+"','"
                            + eventData.getEventname()+"','" 
                            + eventData.getEventdate()+ "')";
                           
      Statement stmt = conn.createStatement();
      System.out.println(sql);
	    int updatecount = stmt.executeUpdate(sql);
      stmt.close();
      if (updatecount >= 1) return true;
      else                  return false;
	  } catch (Exception e) {
	    System.err.println(e);
		  return false;
    }
  }
  
 public boolean updateEvent(EventBean eventData) {
	    try {
	    	
	    	String upadteString = " UPDATE Event " 
	    	          +"SET phone='" +eventData.getPhone()+"' "
	    	          +" ,mailaddress='"+eventData.getMailaddress()+"' "
	    	          +" ,Eventname='"+eventData.getEventname()+"' "
	    	          +" ,Eventdate='"+eventData.getEventdate()+"' "
	    	          +" WHERE name='"+eventData.getName()+"'";
	       //	+"and"+" phone='" +eventData.getPhone()+"'"+"and"+" Eventname='" +eventData.getEventname()+"'" 
	    	          
	    	          
	    	      
	    	                                               
	    	      
	    	          Statement stmt = conn.createStatement();
	    	          System.out.println(upadteString);
	    	    	    int updatecount = stmt.executeUpdate(upadteString);
	    	          stmt.close();
	    	          if (updatecount >= 1) return true;
	    	          else                  return false;
	    	    	  } catch (Exception e) {
	    	    	    System.err.println("CANT" + e);
	    	    		  return false;	
//	      String sql = "update Event set Phone=?,Mailaddress=?,Eventname=?,Eventdate=? where Name=?" ;   
//	      PreparedStatement ps = conn.prepareStatement(sql);
//	      ps.setString(1, eventData.getPhone());
//	      ps.setString(2, eventData.getMailaddress());
//	      ps.setString(3, eventData.getEventname());
//	      ps.setString(4, eventData.getEventdate());
//	      ps.setString(5, eventData.getName());
//	      ps.executeUpdate();   
//	    }catch (Exception e) {
//			e.printStackTrace();
//	     }
	    }
}
}