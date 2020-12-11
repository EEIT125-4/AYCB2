//package message.dao.impl;
//
//import java.sql.Date;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import message.dao.MessageDao;
//import message.model.MessageBean;
//import tool.HibernateUtils;
//
//
//@Transactional
//@Repository("messageTemplateDaoImpl")
//
//public class MessageTemplateDaoImpl implements MessageDao {
//	
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//	
//	@Override
//	public boolean isDup(String id) {
////		boolean result = false;
////		String hql = "FROM MessageBean m WHERE m.id = :id0";
////		Session session = factory.getCurrentSession();
////
////		Query<MessageBean> query = session.createQuery(hql);
////		List<MessageBean> list = query.setParameter("id0", id).getResultList();
////		if (list.size() > 0) {
////			result = true;
////		}
//		
//		String sql="select*From message_table where id=?";
//		BeanPropertyRowMapper<MessageBean>mapper
//		=new BeanPropertyRowMapper<MessageBean>(MessageBean.class);
//		
//		List<MessageBean> list=jdbcTemplate.query(sql,mapper,id);//只有一個?參數
//		
//		if(list.size()>0) {
//			return true;
//		}else {
//			return false;
//			
//		}
//	}
//	/**
//	 * 自訂編號方法
//	 */
//	@SuppressWarnings("unchecked")
//	@Override
//	public String getNewId(Date date) {
//		
//		String hql = "FROM MessageBean m WHERE m.date = :today order by m.id";
//		Session session = factory.getCurrentSession();
//
//		Query<MessageBean> query = session.createQuery(hql);
//		List<MessageBean> list = query.setParameter("today", date).getResultList();
//		
//		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
//		String tempID = f.format(date);
//			
//		if (list.size() > 0) {//如果今天已經有資料
//			Integer index=Integer.parseInt(list.get(list.size()-1).getMsg_id().substring(8))+1;
//			tempID+=index;
//			
//			System.out.println("tempID:"+tempID);
//
//		}else {
//			tempID+="001";
//			System.out.println("tempID:"+tempID);
//		}
//		System.out.println("result:"+tempID);
//		return tempID;
//	}
//	
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<MessageBean> getAllMessages() {
//		List<MessageBean> list = new ArrayList<>();
//		String hql = "FROM MessageBean";
//		Session session = factory.getCurrentSession();
//
//		Query<MessageBean> query = session.createQuery(hql);
//		list = query.getResultList();
//
//		return list;
//	}
//
//	@Override
//	public int save(MessageBean mb) {
//
//
////		mb.setMsg_id(newID);
////		int count = 0;
////		Session session = factory.getCurrentSession();
////
////		session.save(mb);
////		count++;
////
////		return count;
//		Date d=mb.getMsg_Date();
//		String newID=this.getNewId(d);
//		int count=0;
//		String sql="insert into message_table (id,content,date,imgpath,title,type,editDate) values(?,?,?,?,?,?,?)";
//		jdbcTemplate.update(sql,mb.getMsg_id(),mb.getMsg_desc(),mb.getMsg_Date(),mb.getMsg_imgpath(),mb.getMsg_title(),mb.getMsg_type(),mb.getEditDate());
//		count++;
//		return count;
//	}
//
//	@Override
//	public MessageBean getMessage(String pk) {
//
//		MessageBean mb = null;
//		Session session = factory.getCurrentSession();
//
//		mb = session.get(MessageBean.class, pk);
//
//		return mb;
//
//	}
//
//	@Override
//	public int deleteMessage(String id) {
//		int count = 0;
//		Session session = factory.getCurrentSession();
//		MessageBean mb = new MessageBean();
//		mb.setMsg_id(id);
//		session.delete(mb);
//		count++;
//
//		return count;
//		
//	}
//
//	@Override
//	public int updateMessage(MessageBean mb) {
//		int count = 0;
//		Session session = factory.getCurrentSession();
//		session.saveOrUpdate(mb);
//		count++;
//
//		return count;
//	}
//}
