package event.dao;
import java.util.List;

import event.model.Attendance;



public interface AttendanceDAO {
	
			boolean isDup(String id);
			
			
	        //新增
		    int save(Attendance a);
		    
		    //刪除
	        int deleteAttendance(Integer aid);
	        
	        //修改
	        int updateAttendance(Attendance a);
			
	        List<Attendance> getAllAttendance();

			Attendance getAttendance(Integer Aid);
	        
	        

			

		  
		


	


}
