package util;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;;


public class HibernateUtil {

	 private static SessionFactory sessionFactory = buildSessionFactory();

	    @SuppressWarnings("unused")
		private static SessionFactory buildSessionFactory() {
	        try {	            
	            AnnotationConfiguration  configuration = new AnnotationConfiguration().configure("hibernate.cfg.xml");
	            
	            sessionFactory = configuration.buildSessionFactory();
	            
	            return sessionFactory;
	            
	        }
	        catch (HibernateException he) {	            
	        	System.err.println("Initial SessionFactory creation failed." + he);	            
	        	throw new ExceptionInInitializerError(he);
	        }
	        catch (Throwable ex) {	            
	            System.err.println("Initial SessionFactory creation failed." + ex);	            
	            throw new ExceptionInInitializerError(ex);
	        }    
	    }
	   
		
		 
	    public static SessionFactory getSessionFactory() {   	
	        return sessionFactory;
	    }

	    
	    public void shutdown() {    
	        getSessionFactory().close();
	    }	    
}
