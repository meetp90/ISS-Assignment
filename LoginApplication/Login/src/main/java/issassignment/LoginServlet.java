package issassignment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			final String url = "jdbc:mysql://localhost/users";
		    final String USER = "root";
		    final String PASS = "root";
		    System.out.println("Connecting to a selected database...");
		      // Open a connection

		      try(Connection conn = DriverManager.getConnection(url, USER, PASS);) {		      
		         System.out.println("Connected database successfully...");
		         String n = request.getParameter("email");
		         String p = request.getParameter("password");
		         
		         //Check if user is registered and available in table
		         PreparedStatement ps = conn.prepareStatement("Select email from login where email=? and password=?");
		         ps.setString(1, n);
		         ps.setString(2, p);
		         ResultSet rs = ps.executeQuery();
		         if(rs.next()) {
		        	 RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
		        	 rd.forward(request, response);
		         }
		         else {
		        	PrintWriter pw=response.getWriter();
					pw.println("<font color=red size=18> <b>Login Failed!</b>");
					pw.println("<a href=login.jsp> Try Again</a>");
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
		
	}

}
