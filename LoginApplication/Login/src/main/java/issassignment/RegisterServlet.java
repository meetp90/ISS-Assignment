package issassignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			final String url = "jdbc:mysql://localhost/users";
		    final String USER = "omkar";
		    final String PASS = "omkar123";
		    System.out.println("Connecting to a selected database...");
		      // Open a connection
		    Connection conn=null;
		      try {
		    	 conn = DriverManager.getConnection(url, USER, PASS);
		         System.out.println("Connected database successfully...");
		         String n = request.getParameter("root");
		         String p = request.getParameter("root");
		         
		         //Check if user is registered and available in table
		         PreparedStatement ps = conn.prepareStatement("insert into login(email,password) values (?,?)");
		         ps.setString(1, n);
		         ps.setString(2, p);
		         int cnt = ps.executeUpdate();
		         if(cnt>0) {
		        	 RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		         }
		         else {
		        	PrintWriter pw=response.getWriter();
					pw.println("<font color=red size=18> <b>Succesfully Registered!</b>");
					pw.println("<a href=login.jsp> Click here to login</a>");
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		    	  try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
		
	}

}
