package event.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import event.dao.AttendanceDAO;
import event.dao.Impl.AttendanceHibernateDaoImpl;
import event.model.Attendance;
import tool.HibernateUtils;




public class AttendanceServiceImpl implements AttendanceService  {

	SessionFactory factory = HibernateUtils.getSessionFactory();
    AttendanceDAO dao = new AttendanceHibernateDaoImpl();
//	EventDAO edao = new EventHibernateDaoImpl();
	
	
	
	@Override
	public boolean isDup(String id) {
		boolean result = false;
		Session session = factory.getCurrentSession();
		Transaction tx = null; //留意選哪個Transaction
		try {
			tx = session.beginTransaction();
			result = dao.isDup(id);			
			tx.commit();
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return result;
		
		}
		
		
	


	@Override
	public int save(Attendance a) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null; //留意選哪個Transaction
		try {
			tx = session.beginTransaction();
			dao.save(a);
			count++;
			tx.commit();
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return count;
	}



	@Override
	public List<Attendance> getAllAttendance() {
		List<Attendance> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		Transaction tx = null; //留意選哪個Transaction
		try {
			tx = session.beginTransaction();
			list = dao.getAllAttendance();
			tx.commit();
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
		return list;
		
	}


	@Override
	public Attendance getAttendance(Integer Aid) {
		Attendance a = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null; //留意選哪個Transaction
		
		
		try {
			tx = session.beginTransaction();
			a = dao.getAttendance(Aid);
			tx.commit();
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return a;
	}


	@Override
	public int deleteAttendance(Integer MemberID) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null; //留意選哪個Transaction		
		try {
			tx = session.beginTransaction();
			dao.deleteAttendance(MemberID);
//			dao2.updateProduct(ipk); //有多個DAO的情況
			tx.commit();
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return count;
	}

	
	@Override
	public int updateAttendance(Attendance a) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null; //留意選哪個Transaction
		
		
		try {
			tx = session.beginTransaction();
			dao.updateAttendance(a);
			tx.commit();
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	return count;
	}

}
