import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        // Database URL
        String url = "jdbc:mysql://localhost:3306/cafe_management"; // Replace 'your_database_name' with your actual database name
        // Database credentials
        String user = "root"; // Replace with your database username if it's different
        String password = ""; // Replace with your database password

        try {
            // Establish the connection
            Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
