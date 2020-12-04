package comment.service;

//專責與Comment Table之新增,修改,刪除與查詢

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import comment.model.CommentBean;
import comment.util.HibernateUtils;


public class CommentServiceImpl implements CommentService {

	SessionFactory factory = HibernateUtils.getSessionFactory();

	//新增一筆留言
	@Override
	public int insertComment(CommentBean cb) {
		int count=0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(cb);
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

	//查詢所有留言
	@SuppressWarnings("unchecked")
	@Override
	public List<CommentBean> selectComment() {
		List<CommentBean> list = new ArrayList<>();
		String hql = "FROM CommentBean";
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query<CommentBean> query = session.createQuery(hql);
			list = query.getResultList();
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}	
		return list;
	}
	

	// 刪除一筆留言
	@Override
	public int deleteComment(int id) {	
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			CommentBean cb = new CommentBean();
			cb.setId(id);
			session.delete(cb);
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
		

//選擇一筆需要更新的留言
	@Override
	public CommentBean selectUpdateitem(int id) {

		CommentBean cb = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			cb = session.get(CommentBean.class, id);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return cb;
	}
	//更新留言
	@Override
	public int updateComment(CommentBean cb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(cb);
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
}


