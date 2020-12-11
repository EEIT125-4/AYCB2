//package subscript.dao;
//
//import java.sql.Date;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//
//import member.model.MemberBean;
//import message.model.MessageBean;
//import subscript.model.Follow;
//import subscript.model.FollowPK;
//import tool.HibernateUtils;
//
//public class FollowDao {
//
//	
//	SessionFactory factory = HibernateUtils.getSessionFactory();
//
////	@SuppressWarnings("unchecked")
////	
////	public boolean isDup(String id) {
////		boolean result = false;
////		String hql = "FROM FollowBean m WHERE m.id = :id0";
////		Session session = factory.getCurrentSession();
////
////		Query<MessageBean> query = session.createQuery(hql);
////		List<MessageBean> list = query.setParameter("id0", id).getResultList();
////		if (list.size() > 0) {
////			result = true;
////		}
////
////		return result;
////	}
//	
//	
////送回全部會員ID下的全部訂閱清單
//	
//	
//	@SuppressWarnings("unchecked")
//	
//	public List<Follow> getAllFollowList() {
//		List<Follow> list = new ArrayList<>();
//		String hql = "FROM Follow";
//		Session session = factory.getCurrentSession();
//
//		Query<Follow> query = session.createQuery(hql);
//		list = query.getResultList();
//
//		return list;
//	}
//
//	
//	public int save(Follow follow) {
//		
//		
//		int count = 0;
//		Session session = factory.getCurrentSession();
//
//		session.save(follow);
//		count++;
//
//		return count;
//		
//		/**
//		 * 希望能在儲存一筆訊息的同時,所有訂閱這個type的用戶也+1
//		 * 
//		 * 
//		 */
//		
//		
//	}
//
//	/*
//	 * 取得特定會員的訂閱狀態
//	 */
//	@SuppressWarnings("unchecked")
//	public List<Follow> getUserFollows(String pk) {
//
//		
//		
//		String hql = "FROM Follow f WHERE f.memberPK = :pk";
//		Session session = factory.getCurrentSession();
//
//		
//		Query<Follow> query = session.createQuery(hql);
//		List<Follow> list = query.setParameter("pk", pk).getResultList();
//			return list;
//
//	}
//
//	//會員取消訂閱
//	public int unsubscribe(MemberBean member,String type) {
//		int count = 0;
//		Session session = factory.getCurrentSession();
//		Follow follow = new Follow();
//		FollowPK pk=new FollowPK();
//		pk.setMember(member);
//		pk.setScriptType(type);
//		follow.setFollowPK(pk);
//		
//		session.delete(follow);
//		count++;
//
//		return count;
//		
//	}
//
//
//	public int updateMessage(MessageBean mb) {
//		int count = 0;
//		Session session = factory.getCurrentSession();
//		session.saveOrUpdate(mb);
//		count++;
//
//		return count;
//	}
//}
