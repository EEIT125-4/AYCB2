 package event.dao;

import java.util.List;

import event.model.Event;



public interface EventDAO {


		boolean isDup(String id);
		
		
        //新增
	    int save(Event e);
	    
	    //刪除
        int deleteEvent(int pk);
        
        //修改
        int updateEvent(Event e);
		
        List<Event> getAllEvent();

		Event getEvent(int pk);


}
