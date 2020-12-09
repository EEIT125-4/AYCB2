package comment.dao;

import java.util.ArrayList;

//專責與Comment Table之新增,修改,刪除與查詢


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import comment.model.CommentBean;
import comment.util.HibernateUtils;


public class CommentDaoImp implements  CommentDao {

	SessionFactory factory = HibernateUtils.getSessionFactory();

	//新增一筆留言
	@Override
	public int insertComment(CommentBean cb) {
		int count=0;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			session.save(cb);
			count++;
//			tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
		return count;
	}

	//查詢所有留言
	@SuppressWarnings("unchecked")
	@Override
	public List<CommentBean> selectAll() {
		List<CommentBean> list = new ArrayList<>();
		String hql = "FROM CommentBean order by commentTime desc";
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			Query<CommentBean> query = session.createQuery(hql);
			list = query.getResultList();
			System.out.println("dao impl list:"+list);
//			tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}	
		return list;
	}
	

	// 刪除一筆留言
	@Override
	public int deleteComment(int id) {	
		int count = 0;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			CommentBean cb = new CommentBean();
			cb.setCommentId(id);
			session.delete(cb);
			count++;
			System.out.println("dao delete"+count);
//			tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}		
		return count;
	}
		

//選擇一筆需要更新的留言
	@SuppressWarnings("unchecked")
	@Override
	public List<CommentBean> selectUpdateitem(Integer id) {

//		CommentBean cb = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction()
		String hql = "FROM CommentBean Where commentId = :id1";
			List<CommentBean> list = session.createQuery(hql)
					.setParameter("id1", id)
					.getResultList();
//			tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
		return list;
	}
	//更新留言
	
	@Override
	public Integer updateComment(CommentBean cb) {
		Integer count=0;
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(cb);
		count++;
		System.out.println("更新比數:"+count);
		//		String hql="UPDATE comment SET name=:name, gender=:gender"
//				+ ", age=:age, commentTime=:commentTime, contentBox=:contentBox, status=:status, id=:id WHERE commentId = :commentId";
//		count = session.createQuery(hql)
//				.setParameter("name", cb.getName())
//				.setParameter("gender", cb.getGender())
//				.setParameter("age", cb.getAge())
//				.setParameter("commentTime", cb.getCommentTime())
//				.setParameter("contentBox", cb.getContentBox())
//				.setParameter("commentId", cb.getCommentId())
//				.setParameter("status", cb.getStatus())
//				.setParameter("id", cb.getId())
//				.executeUpdate();
		
		return count;
	}

}

