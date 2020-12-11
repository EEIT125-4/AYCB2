package comment.dao;

import java.util.ArrayList;

//專責與Comment Table之新增,修改,刪除與查詢


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import comment.model.CommentBean;
import tool.HibernateUtils;



public class CommentDaoImp implements  CommentDao {

	SessionFactory factory = HibernateUtils.getSessionFactory();

	//新增一筆留言
	@Override
	public int insertComment(CommentBean cb) {
		int count=0;
		Session session = factory.getCurrentSession();

			session.save(cb);
			count++;

		return count;
	}

	//查詢所有留言
	@SuppressWarnings("unchecked")
	@Override
	public List<CommentBean> selectAll() {
		List<CommentBean> list = new ArrayList<>();
		String hql = "FROM CommentBean order by commentTime desc";
		Session session = factory.getCurrentSession();


			Query<CommentBean> query = session.createQuery(hql);
			list = query.getResultList();
			System.out.println("dao impl list:"+list);

		return list;
	}
	

	// 刪除一筆留言
	@Override
	public int deleteComment(int id) {	
		int count = 0;
		Session session = factory.getCurrentSession();

			CommentBean cb = new CommentBean();
			cb.setCommentId(id);
			session.delete(cb);
			count++;
			System.out.println("dao delete"+count);

		return count;
	}
		

//選擇一筆需要更新的留言
	@SuppressWarnings("unchecked")
	@Override
	public CommentBean selectUpdateitem(Integer id) {


		Session session = factory.getCurrentSession();

		String hql = "FROM CommentBean Where commentId = :id1";
			CommentBean comment = (CommentBean) session.createQuery(hql)
					.setParameter("id1", id)
					.getSingleResult();

		return comment;
	}
	//更新留言
	
	@Override
	public Integer updateComment(CommentBean cb) {
		Integer count=0;
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(cb);
		count++;
		System.out.println("更新數:"+count);

		
		return count;
	}

}

