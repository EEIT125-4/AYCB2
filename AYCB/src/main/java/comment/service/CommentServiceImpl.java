package comment.service;

//專責與Comment Table之新增,修改,刪除與查詢

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import comment.dao.CommentDao;
import comment.dao.CommentDaoImp;
import comment.model.CommentBean;
import tool.HibernateUtils;



public class CommentServiceImpl implements CommentService {
	
	SessionFactory factory = HibernateUtils.getSessionFactory();
	
	CommentDao dao= new CommentDaoImp();
	
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
	@Override
	public List<CommentBean> selectAll() {
		System.out.println("dao"+dao);
		List<CommentBean> list = new ArrayList<>();
		
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			list=dao.selectAll();
			System.out.println("dao result"+list);
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
			dao.deleteComment(id);
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
	public CommentBean selectUpdateitem(Integer commentId) {

		Session session = factory.getCurrentSession();
		Transaction tx = null;
		CommentBean cb=null;
		try {
			tx = session.beginTransaction();
			cb = dao.selectUpdateitem(commentId);
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
			dao.updateComment(cb);
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


