package atm;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class TransactionManager {
	String user;

	TransactionManager(String user, int transactionAmount, String transaction) throws IOException {
		this.user = user;
		FileReader reader = new FileReader("credentials.properties");
		Properties credentials = new Properties();
		credentials.load(reader);

		String jdbcURL = credentials.getProperty("link");
		String username = credentials.getProperty("user");
		String password = credentials.getProperty("password");

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        return; // Exit if the driver class is not found
	    }

	    try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
	        if (connection != null) {
	            System.out.println("Connected to the database!");
				int oldBalance = GetBalance.Get(user);
	            int newBalance = 0;
				String transactionMessage = "";

	            // Calculate the new balance
	            if(transaction.equals("deposit")) {
	            	  newBalance = oldBalance + transactionAmount;
					  transactionMessage = "Amount deposited successfully. New balance: ";
	            }
	            else if (transaction.equals("withdraw")) {
	            		if (oldBalance - transactionAmount < 0) {
	            			JOptionPane.showMessageDialog(null, "Withdrawal excceeded available balance. Available balance: " + oldBalance);
	            			return;
	            		}
	            		else {
	            			newBalance = oldBalance - transactionAmount;
							transactionMessage = "Amount wtihdrawn successfully. Remaining balance: ";
	            		}
	            }
				
				if (transaction.equals("deposit") || transaction.equals("withdraw"))
				{
					updateBalance(connection, user, newBalance, transactionMessage);
				}

				else {
					if (oldBalance - transactionAmount < 0) {
	            			JOptionPane.showMessageDialog(null, "Transfer amount excceeded available balance. Available balance: " + oldBalance);
	            			return;
	            		}
					else {
						Integer receiverOldBalance = GetBalance.Get(transaction); // in this case, transaction is the username of the receiver

						if (receiverOldBalance == null) { // this checkes whether or not the receiver account exists in the database
							JOptionPane.showMessageDialog(null, "The receiver does not exist. Transaction faild.");
							return;
						}
							int receiverNewBalance = receiverOldBalance + transactionAmount; // calculate receiver's balance
							newBalance = oldBalance - transactionAmount; // calculate sender's balance
							transactionMessage = "Funds transferred successfully! ";
							updateBalance(connection, user, newBalance, transactionMessage); // update the balance of the sender
							updateBalance(connection, transaction, receiverNewBalance, transactionMessage); // update the balance of the receiver
						}
				}
	            
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.err.println("Connection to the database failed.");
	    }
	}

	public void updateBalance(Connection connection, String user, int newBalance, String transactionMessage) {
		// Update the balance in the database
		String updateQuery = "UPDATE users SET balance = ? WHERE username = ?";
		try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
			updateStatement.setInt(1, newBalance);
			updateStatement.setString(2, user);

			int rowsAffected = updateStatement.executeUpdate();

			if (rowsAffected > 0) {
				if (this.user.equals(user)) // This if statement makes sure that the message is not shown when the receiver's balance is updated.
				{
					System.out.println(transactionMessage + newBalance);
					JOptionPane.showMessageDialog(null, transactionMessage + newBalance, "Success", JOptionPane.INFORMATION_MESSAGE, customImage.createCheckmarkImage());
				}
			} else {
				System.out.println("Transaction failed.");
				JOptionPane.showMessageDialog(null, "Transaction faild.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error executing the UPDATE statement.");
		}
	}

}
