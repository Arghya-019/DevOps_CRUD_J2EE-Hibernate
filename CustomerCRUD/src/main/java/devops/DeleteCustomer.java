package devops;
//import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import java.sql.*;


public class DeleteCustomer extends HttpServlet {
	
	private static final Logger LOGGER = Logger.getLogger(HexConnection.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//PrintWriter pw = response.getWriter();
		
		int check;
		//pw.println("trying to connect..");
		
		
		HttpSession s1 = request.getSession(false);
		AuthUsers user =(AuthUsers) s1.getAttribute("user");

try {		
		if (user != null) {
			
	    int paramID = Integer.parseInt(request.getParameter("id")); // Emp iD to be deleted
	    
		check = delete(paramID);
		
		}
		
		else
		{
			response.sendRedirect("login.jsp");
			return; // return from the method and stop the execution of the remnant of the code.
		} 
		
		if (check == 0) {
		
			request.getRequestDispatcher("GetData").forward(request, response);
		
		}
		

		else {

			//request.setAttribute("delete_success_message", "Customer data Deleted Successfully.");
			request.getRequestDispatcher("GetData").forward(request, response);
			}
	}
catch(Exception ex)
{
	LOGGER.error(ex);
}


	}
	
	public int delete(int paramID)
			throws ServletException, IOException {
		int check = 1;
	 	LOGGER.info("Deleting Customer Profile from Database..");
    	
        Session session = HibernateUtil.getSessionFactory().openSession();
       
        try {
    	   
        session.beginTransaction();
 
        Customer c1 = 
                (Customer)session.get(Customer.class,paramID); 
        session.delete(c1);
        
        session.flush();
        session.getTransaction().commit();
	}
        catch(HibernateException e)
        {
        	check = 0;
        	LOGGER.error(e);
        }
        
        finally {
        session.close();
        }
        
		return check;
	}
}
