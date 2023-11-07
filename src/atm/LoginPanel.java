package atm;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginPanel {
	
	public LoginPanel(String enteredUsername, String enteredPassword) throws IOException, URISyntaxException {
		String username = enteredUsername;
        String password = enteredPassword;

        // Call the checkLogin method to check the credentials
        boolean loginSuccessful = checkLogin(username, password);

        if (loginSuccessful) {
            System.out.println("Login successful!");
            new BackPage(username);
        } else {
            System.out.println("Login failed. Incorrect username or password.");
            JOptionPane.showMessageDialog(null, "Error: Username or Password is incorrect. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            new FrontPage();
        }
    }
	public boolean checkLogin(String enteredUsername, String enteredPassword) {
	    String jdbcURL = "jdbc:mysql://localhost:3306/boa";
	    String username = "root";
	    String password = "password";

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        return false;
	    }

	    try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
	        if (connection != null) {
	            System.out.println("Connected to the database!");

	            // Create an SQL SELECT query
	            String selectQuery = "SELECT * FROM users WHERE username = ? AND password = ?";
	            
	            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
	                preparedStatement.setString(1, enteredUsername);
	                preparedStatement.setString(2, enteredPassword);

	                try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                    return resultSet.next();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false; // Default to false in case of any error
	}
}
