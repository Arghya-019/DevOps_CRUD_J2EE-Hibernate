package devops;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
 
public class GetData  {     
      
	   
	public List<Customer> getList(){
		
      List<Customer> customers = new ArrayList<Customer>();
	  SessionFactory factory = HibernateUtil.getSessionFactory();
      Session session = factory.openSession();
 
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
      
      return customers;
      
	   }
    }
