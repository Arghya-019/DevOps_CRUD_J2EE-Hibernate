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

public class AddCustomer extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String contactNumber = request.getParameter("contactNumber");
		String alternateContactNumber = request.getParameter("alternateContactNumber");
		String specialty = request.getParameter("specialty");
		String qualificationSummary = request.getParameter("qualificationSummary");
		
		pw.println("trying to connect..");

		pw.println("Values Inputted");

		if (add(name, address, contactNumber, alternateContactNumber, specialty, qualificationSummary) == 0) {
			request.setAttribute("add_fail_message", "Failed to Add new Customer.");
			request.getRequestDispatcher("./view/add_new.jsp").forward(request, response);
		}

		else {
			request.setAttribute("add_success_message", "New Customer Added to Database.");
			request.getRequestDispatcher("./view/add_new.jsp").forward(request, response);
		}
	}

	public int add(String name, String address, String contactNumber, String alternateContactNumber, String specialty, String qualificationSummary)
			throws ServletException, IOException {
		int check = 0;
   	System.out.println("Maven + Hibernate + MySQL");
    	
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        Customer c1 = new Customer();
        
        c1.setName(name);
        c1.setAddress(address);
        c1.setContactNumber(contactNumber);
        c1.setAlternateContactNumber(alternateContactNumber);
        c1.setSpecialty(specialty);
        c1.setQualificationSummary(qualificationSummary);
        
        session.save(c1);
        session.flush();
        session.getTransaction().commit();
        session.close();
        

			//check = prep.executeUpdate();

			//prep.close();
		
		return check;
	}

}
