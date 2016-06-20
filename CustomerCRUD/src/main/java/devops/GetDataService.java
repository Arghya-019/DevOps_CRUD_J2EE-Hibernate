package devops;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GetDataService {
	public List<Customer> getList(AuthUsers auth1){
		
	      List<Customer> customers = new ArrayList<Customer>();
		  SessionFactory factory = HibernateUtil.getSessionFactory();
	      Session session = factory.openSession();
	 
	      if (auth1 == null || auth1.getEmail() == null) {
	    	  customers = null;
	      }
	      
	      
	      else {
	      Transaction tx = null;
	      try {
	          tx = session.getTransaction();
	          tx.begin();
	          customers = session.createQuery("from Customer").list();                       
	          tx.commit();
	      } catch (Exception e) {
	          if (tx != null) {
	              tx.rollback();
	          }
	          e.printStackTrace();
	      }
	      
	      finally {
	    	  session.flush();
	    	  session.close();
	      }
	      
	      }
	      
	      return customers;
	    
	}
	

}
