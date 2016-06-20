package devops;
 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
 
 
public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
     PrintWriter out = response.getWriter();
     

     String email = request.getParameter("email");
     String password = request.getParameter("password");
     
     
    // AuthUsers user = new AuthUsers(email,password);
             
     if (add(email,password) == 0) {
			request.setAttribute("add_fail_message", "Failed to Add new Customer.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		else {
			request.setAttribute("add_success_message", "New Customer Added to Database.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	public int add(String email,String password)
			throws ServletException, IOException {
		int check = 1;
	System.out.println("Maven + Hibernate + MySQL");
 	
     Session session = HibernateUtil.getSessionFactory().openSession();
     
     try {
     
     session.beginTransaction();
     AuthUsers au1 = new AuthUsers();
     
     au1.setEmail(email);
     au1.setPassword(password);
     
     session.saveOrUpdate(au1);
     session.flush();
     session.getTransaction().commit();
     
     }
     	
     
    catch(HibernateException e) {
 	 check = 0;
    }
     
     finally {
   
     session.close();
     }
     

			//check = prep.executeUpdate();

			//prep.close();
		
		return check;
	}
 
}