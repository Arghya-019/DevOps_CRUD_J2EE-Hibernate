package devops;
 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import devops.*;
import java.io.PrintWriter;  
  


public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
     String email1 = request.getParameter("email");   
     String password = request.getParameter("password");
     LoginService loginService = new LoginService();
     boolean result = loginService.authenticateUser(email1, password);
     AuthUsers user = loginService.getUserByEmail(email1);
     if(result == true){
         request.getSession().setAttribute("user", user);      
         response.sendRedirect("display.jsp");
     }
     else{
         //response.sendRedirect("error.jsp");
    	 request.setAttribute("login_fail_message", "Credentials Invalid");
		 request.getRequestDispatcher("login.jsp").forward(request, response);
     }
}
 
}