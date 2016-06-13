package devops;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import java.sql.*;
import java.util.Properties;

public class DeleteCustomer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		int param_id = Integer.parseInt(request.getParameter("id")); // Emp iD to be deleted
		
		pw.println(param_id);
		int check = 0;
		pw.println("trying to connect..");
		Connection connection = null;
		// ResultSet rs;
		check = delete(param_id);
		if (check == 0) {
			request.setAttribute("delete_fail_message", "Failed to delete Customer Data");
			request.getRequestDispatcher("./view/display.jsp").forward(request, response);
		}

		else {

			request.setAttribute("delete_success_message", "Customer data Deleted Successfully.");
			request.getRequestDispatcher("./view/display.jsp").forward(request, response);
		}
	}

	public int delete(int param_id)
			throws ServletException, IOException {
		int check = 0;
	 	System.out.println("Maven + Hibernate + MySQL");
    	
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
 
        Customer c1 = 
                (Customer)session.get(Customer.class,param_id); 
        session.delete(c1);
        
        session.flush();
        session.getTransaction().commit();
        session.close();
		return check;
	}
}
