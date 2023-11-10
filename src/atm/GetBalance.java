package atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetBalance {
     public static int Get(String user){
		String jdbcURL = "jdbc:mysql://localhost:3306/boa";
	    String username = "root";
	    String password = "password";
        int oldBalance = 0;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        return 0; // Exit if the driver class is not found
	    }

	    try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
	        if (connection != null) {
	            System.out.println("Connected to the database!");

	            // Create an SQL SELECT statement to select the balance of the user
	            String selectQuery = "SELECT balance FROM users WHERE username = ?";

	            try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
	                selectStatement.setString(1, user);

	                try (ResultSet resultSet = selectStatement.executeQuery()) {
	                    if (resultSet.next()) {
	                        oldBalance = resultSet.getInt("balance");
	                    }
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                    System.err.println("Error retrieving old balance.");
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	                System.err.println("Error executing the SELECT statement.");
	            }
            }
            
        }
        catch (SQLException e) {
	        e.printStackTrace();
	        System.err.println("Connection to the database failed.");
	    }

        return oldBalance;
    }
}
