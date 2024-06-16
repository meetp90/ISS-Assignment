import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Assignment11 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/students";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            // Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                System.out.println("Connected to the database successfully!");
                
                Statement stmt = connection.createStatement();
    			
    			ResultSet rs = stmt.executeQuery("select * from students");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Unable to connect to the database. Please try again later");
            e.printStackTrace();
        }
    }
}