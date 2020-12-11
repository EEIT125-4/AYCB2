 package event.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import event.dao.EventDAO;
import event.model.Event;
import tool.HibernateUtils;




//實作介面或繼承父類別,程式使用時直接寫父類別/介面名稱
public class EventHibernateDaoImpl implements EventDAO {
//	String resource = "java:comp/env/jdbc/memberDB";
	
	SessionFactory factory = HibernateUtils.getSessionFactory();
	
	//@Autowired
	//SessionFactory factory;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean isDup(String id) {
		boolean result = false;
		String hql = "FROM Event e WHERE e.id = :id0";
		Session session = factory.getCurrentSession();

			Query<Event> query = session.createQuery(hql);
			List<Event> list = query.setParameter("id0", id).getResultList();
			if ( list.size() > 0) {
				result = true;
			}
			
		return result;
	}

	@Override
	public int save(Event e) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.save(e);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getAllEvent() {
		List<Event> list = new ArrayList<>();
		String hql = "FROM Event";
		Session session = factory.getCurrentSession();

			Query<Event> query = session.createQuery(hql);
			list = query.getResultList();

		return list;
	}

	@Override
	public Event getEvent(int pk) {
		Event e = null;
		Session session = factory.getCurrentSession();

			e = session.get(Event.class, pk);

		return e;
	}

	@Override
	public int deleteEvent(int pk) {
		int count = 0;
		Session session = factory.getCurrentSession();

		Event e = new Event();
			e.setEventID(pk);
			session.delete(e);
			count++;

		return count;
	}

	@Override
	public int updateEvent(Event e) {
		int count = 0;
		Session session = factory.getCurrentSession();

			session.saveOrUpdate(e);
			count++;

		return count;
	}

	
}
