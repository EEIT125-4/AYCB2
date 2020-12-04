package message.service;

import java.sql.Date;
import java.util.List;

import message.model.MessageBean;

public interface MessageService {
	boolean isDup(String id);

	int save(MessageBean mb);

	List<MessageBean> getAllMessages();

	MessageBean getMessage(int id);

	int deleteMessage(String id);

	int updateMessage(MessageBean mb);
	
	

}
