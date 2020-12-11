package tool;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {

	private static SessionFactory sessionFactory = buildSessionFactory();
	static {
		
	}
	private static SessionFactory buildSessionFactory() {
		try {
			
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
	                .configure("hibernate.cfg.xml").build();
			                    
			                    
	        Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
	        SessionFactory sessionFactory  = metadata.getSessionFactoryBuilder().build();
	        return sessionFactory; 
			
		} catch (Throwable ex) {
			System.err.println("sessionFactory:" + ex.getMessage());
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

}