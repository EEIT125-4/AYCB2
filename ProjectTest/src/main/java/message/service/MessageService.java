package message.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import message.model.MessageBean;

@Service


public interface MessageService {
	boolean isDup(String id);

	int save(MessageBean mb);

	List<MessageBean> getAllMessages();

	MessageBean getMessage(String id);

	int deleteMessage(String id);

	int updateMessage(MessageBean mb);
	
	List<MessageBean>queryMessage(String sql);
	
	List<String> queryMessageType();
	
	

}
