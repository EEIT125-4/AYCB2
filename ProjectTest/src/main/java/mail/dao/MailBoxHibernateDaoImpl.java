//package mail.dao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.query.Query;
//
//import member.dao.MemberDao;
//import member.model.MemberBean;
//import tool.HibernateUtils;
//
//
//
//
//public class MailBoxHibernateDaoImpl implements MemberDao {
//	
//SessionFactory factory = HibernateUtils.getSessionFactory();
//	
//	@SuppressWarnings("unchecked")
//	@Override
//	public boolean isDup(String id) {
//		boolean result = false;
//		String hql = "FROM MemberBean m WHERE m.id = :id0";
//		Session session = factory.getCurrentSession();
//
//			Query<MemberBean> query = session.createQuery(hql);
//			List<MemberBean> list = query.setParameter("id0", id).getResultList();
//			if ( list.size() > 0) {
//				result = true;
//			}
//
//			
//		return result;
//	}
//
//	@Override
//	public int save(MemberBean mb) {
//		int count = 0;
//		Session session = factory.getCurrentSession();
//
//			session.save(mb);
//			count++;
//
//		return count;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<MemberBean> getAllMembers() {
//		List<MemberBean> list = new ArrayList<>();
//		String hql = "FROM MemberBean";
//		Session session = factory.getCurrentSession();
//
//			Query<MemberBean> query = session.createQuery(hql);
//			list = query.getResultList();
//
//		return list;
//	}
//
//	@Override
//	public MemberBean getMember(int pk) {
//		MemberBean mb = null;
//		Session session = factory.getCurrentSession();
//
//			mb = session.get(MemberBean.class, pk);
//
//		return mb;
//	}
//
//	@Override
//	public int deleteMember(int pk) {
//		int count = 0;
//		Session session = factory.getCurrentSession();
//			MemberBean mb = new MemberBean();
//			mb.setPk(pk);
//			session.delete(mb);
//			count++;
//
//		return count;
//	}
//
//	@Override
//	public int updateMember(MemberBean mb) {
//		int count = 0;
//		Session session = factory.getCurrentSession();
//			session.saveOrUpdate(mb);
//			count++;
//			
//		return count;
//	}
//
//}
