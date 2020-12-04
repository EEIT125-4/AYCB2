package message.dao.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import message.dao.MessageDao;
import message.model.MessageBean;
import tool.HibernateUtils;



//實作介面或繼承父類別,程式使用時直接寫父類別/介面名稱
public class MessageHibernateDaoImpl implements MessageDao {

	SessionFactory factory = HibernateUtils.getSessionFactory();

	@SuppressWarnings("unchecked")
	@Override
	public boolean isDup(String id) {
		boolean result = false;
		String hql = "FROM MessageBean m WHERE m.id = :id0";
		Session session = factory.getCurrentSession();

		Query<MessageBean> query = session.createQuery(hql);
		List<MessageBean> list = query.setParameter("id0", id).getResultList();
		if (list.size() > 0) {
			result = true;
		}

		return result;
	}
	/**
	 * 邏輯是抓出日期為今天的訊息有幾筆,有一筆以上就取最大編碼往下
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String getNewId(Date date) {
		
		String hql = "FROM MessageBean m WHERE m.date = :today order by m.id";
		Session session = factory.getCurrentSession();

		Query<MessageBean> query = session.createQuery(hql);
		List<MessageBean> list = query.setParameter("today", date).getResultList();
		
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		String tempID = f.format(date);
			
		if (list.size() > 0) {//如果有資料
			Integer index=Integer.parseInt(list.get(list.size()-1).getMsg_id().substring(8))+1;
			tempID+=index;
			
			System.out.println("有資料:"+tempID);

		}else {
			tempID+="001";
			System.out.println("無資料:"+tempID);
		}
		System.out.println("result:"+tempID);
		return tempID;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<MessageBean> getAllMessages() {
		List<MessageBean> list = new ArrayList<>();
		String hql = "FROM MessageBean";
		Session session = factory.getCurrentSession();

		Query<MessageBean> query = session.createQuery(hql);
		list = query.getResultList();

		return list;
	}

	@Override
	public int save(MessageBean mb) {
		Date d=mb.getMsg_Date();
		String newID=this.getNewId(d);
		mb.setMsg_id(newID);
		int count = 0;
		Session session = factory.getCurrentSession();

		session.save(mb);
		count++;

		return count;
	}

	@Override
	public MessageBean getMessage(int id) {

		MessageBean mb = null;
		Session session = factory.getCurrentSession();

		mb = session.get(MessageBean.class, id);

		return mb;

	}

	@Override
	public int deleteMessage(String id) {
		int count = 0;
		Session session = factory.getCurrentSession();
		MessageBean mb = new MessageBean();
		mb.setMsg_id(id);
		session.delete(mb);
		count++;

		return count;
		
	}

	@Override
	public int updateMessage(MessageBean mb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(mb);
		count++;

		return count;
	}
}
