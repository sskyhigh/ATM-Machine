package atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class TransactionManager {
	TransactionManager(String user, int transactionAmount, String transaction){
		String jdbcURL = "jdbc:mysql://localhost:3306/boa";
	    String username = "root";
	    String password = "password";

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        return; // Exit if the driver class is not found
	    }

	    try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
	        if (connection != null) {
	            System.out.println("Connected to the database!");

	            // Create an SQL SELECT statement to select the balance of the user
	            String selectQuery = "SELECT balance FROM users WHERE username = ?";
	            int oldBalance = 0;
	            int newBalance = 0;
				String transactionMessage = "";

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

	            // Calculate the new balance
	            if(transaction.equals("deposit")) {
	            	  newBalance = oldBalance + transactionAmount;
					  transactionMessage = "Amount deposited successfully.";
	            }
	            else if (transaction.equals("withdraw")) {
	            		if (oldBalance - transactionAmount < 0) {
	            			JOptionPane.showMessageDialog(null, "Withdrawal excceeded available Balance");
	            			return;
	            		}
	            		else {
	            			newBalance = oldBalance - transactionAmount;
							transactionMessage = "Amount wtihdrawn successfully. ";
	            		}
	            }
	            // Update the balance in the database
	            String updateQuery = "UPDATE users SET balance = ? WHERE username = ?";

	            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
					updateStatement.setInt(1, newBalance);
	                updateStatement.setString(2, user);

	                int rowsAffected = updateStatement.executeUpdate();

	                if (rowsAffected > 0) {
	                    System.out.println(transactionMessage);
	                    JOptionPane.showMessageDialog(null, transactionMessage);
	                } else {
	                    System.out.println("Transaction failed.");
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	                System.err.println("Error executing the UPDATE statement.");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.err.println("Connection to the database failed.");
	    }
	}

}
