package member.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import member.MemberBean;
import member.Dao.RegisterDaoImpl;
import tool.HibernateUtils;



public class MemberServiceImpl implements MemberService    {

	SessionFactory factory = HibernateUtils.getSessionFactory();
	//@Autowired
	//MemberDao dao
	
	
	
	
	RegisterDaoImpl dao = new RegisterDaoImpl();
	

	@Override
	public boolean isDup(String account) {
		boolean result = false;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			result = dao.isDup(account);
			
			
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
	public int insertregester(MemberBean mb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.insertregister(mb);
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

	
	
//	@Override
//	public List<MemberBean> getAllMembers() {
//		
//		List<MemberBean> list = new ArrayList<>();
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			list = dao.getAllMembers();
//			tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}	
//		return list;
//	}

	

//	@Override
//	public MemberBean getMember(int account) {
//		MemberBean mb = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			mb = dao.getMember(account);
//			tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		return mb;
//	}

	
//
//	@Override
//	public int deleteMember(int account) {
//		int count = 0;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			dao.deleteMember(account);
//			count++;
//			tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}		
//		return count;
//	}

	
	
	
	@Override
	public int updateregister(MemberBean mb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.updateregister(mb);
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
