package message.dao;

import java.sql.Date;
import java.util.List;

import message.model.MessageBean;




public interface MessageDao {
	
	boolean isDup(String id);

	int save(MessageBean mb);

	List<MessageBean> getAllMessages();

	MessageBean getMessage(String pk);

	int deleteMessage(String pk);

	int updateMessage(MessageBean mb);
	
	String getNewId(Date date);
	
	List<MessageBean>queryMessage(String sql);
	
	List<String> queryMessageType();
	

}
