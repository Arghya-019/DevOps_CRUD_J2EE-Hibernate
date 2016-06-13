package devops;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.junit.Test;

import java.sql.*;
import java.util.Properties;

import javax.servlet.http.*;

public class UpdateCustomer extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();

		int param_id = Integer.parseInt(request.getParameter("ID_to_update")); // Emp iD to be
																// updated
		pw.println(param_id);

		int check = 0;

		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String contactNumber = request.getParameter("contactNumber");
		String alternateContactNumber = request.getParameter("alternateContactNumber");
		String specialty = request.getParameter("specialty");
		String qualificationSummary = request.getParameter("qualificationSummary");
		
		pw.println("trying to connect..");


		check = update(name, address, contactNumber, alternateContactNumber, specialty, qualificationSummary, param_id);
		// ResultSet rs;

		if (check == 0) {
			request.setAttribute("update_fail_message", "Failed to Update Customer Data");
			request.getRequestDispatcher("./view/display.jsp").forward(request, response);
		}

		else {
			request.setAttribute("update_success_message", "Customer Data Updated Successfully");
			request.getRequestDispatcher("./view/display.jsp").forward(request, response);
		}
	}

	public int update(String name, String address, String contactNumber, String alternateContactNumber, String specialty, String qualificationSummary, int param_id)
			throws ServletException, IOException {
		int check = 0;
	   	System.out.println("Maven + Hibernate + MySQL");
	    	
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        
	        session.beginTransaction();
	 
	        Customer c1 = 
                    (Customer)session.get(Customer.class,param_id); 
	        c1.setName(name);
	        c1.setAddress(address);
	        c1.setContactNumber(contactNumber);
	        c1.setAlternateContactNumber(alternateContactNumber);
	        c1.setSpecialty(specialty);
	        c1.setQualificationSummary(qualificationSummary);
	        session.update(c1);
	        
	        session.flush();
	        session.getTransaction().commit();

		return check;
	}
	
}
