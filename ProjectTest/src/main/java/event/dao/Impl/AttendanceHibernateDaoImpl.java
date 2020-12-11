package event.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import event.dao.AttendanceDAO;
import event.model.Attendance;
import tool.HibernateUtils;




//實作介面或繼承父類別,程式使用時直接寫父類別/介面名稱
public class AttendanceHibernateDaoImpl implements AttendanceDAO  {
//	String resource = "java:comp/env/jdbc/memberDB";
	
	SessionFactory factory = HibernateUtils.getSessionFactory();
	
		
	@SuppressWarnings("unchecked")
	@Override
	public boolean isDup(String id) {
		boolean result = false;
		String hql = "FROM Attendance a WHERE a.MemberID = :id0";
		Session session = factory.getCurrentSession();

			Query<Attendance> query = session.createQuery(hql);
			List<Attendance> list = query.setParameter("id0", id).getResultList();
			if ( list.size() > 0) {
				result = true;
			}
			
		return result;
	}

	@Override
	public int save(Attendance a) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.save(a);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Attendance> getAllAttendance() {
		List<Attendance> list = new ArrayList<>();
		String hql = "FROM Attendance";
		Session session = factory.getCurrentSession();

			Query<Attendance> query = session.createQuery(hql);
			list = query.getResultList();

		return list;
	}

	@Override
	public Attendance getAttendance(Integer Aid) {
		Attendance a = null;
		Session session = factory.getCurrentSession();

			a = session.get(Attendance.class, Aid);

		return a;
	}

	@Override
	public int deleteAttendance(Integer aid) {
		int count = 0;
		Session session = factory.getCurrentSession();

		 Attendance a = new Attendance();
			a.setAId(aid);
			session.delete(a);
			count++;

		return count;
	}

	@Override
	public int updateAttendance(Attendance a) {
		int count = 0;
		Session session = factory.getCurrentSession();
			session.saveOrUpdate(a);
			count++;

		return count;
	}

	
}
