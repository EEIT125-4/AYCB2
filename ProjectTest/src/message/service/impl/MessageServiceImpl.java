package message.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import message.dao.MessageDao;
import message.dao.impl.MessageHibernateDaoImpl;
import message.model.MessageBean;
import message.service.MessageService;
import tool.HibernateUtils;



@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	SessionFactory factory = HibernateUtils.getSessionFactory();
	@Autowired
	MessageDao dao= new MessageHibernateDaoImpl();
	
	
	
	@Override
	public boolean isDup(String id) {
		boolean result = false;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			result = dao.isDup(id);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return result;	
	}


	@Override
	public int save(MessageBean mb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.save(mb);
			count++;
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<MessageBean> getAllMessages() {
		List<MessageBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			list = dao.getAllMessages();
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}	
		return list;
	}


	@Override
	public MessageBean getMessage(String id) {
		MessageBean mb = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			mb = dao.getMessage(id);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return mb;
	}


	@Override
	public int deleteMessage(String id) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.deleteMessage(id);
			count++;
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}		
		return count;
	}


	@Override
	public int updateMessage(MessageBean mb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.updateMessage(mb);
			count++;
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}	
		return count;
	}


	@Override
	public List<MessageBean> queryMessage(String sql) {
		List<MessageBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			list = dao.queryMessage(sql);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}	
		return list;
	}


}
