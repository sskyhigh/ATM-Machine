package atm;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class UpdateCredentials {

    public UpdateCredentials(String oldUsername, String newUsername, String newPassword) throws IOException {
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
        }

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            if (connection != null) {
                System.out.println("Connected to the database!");
                // Define the SQL query to update the user's credentials
                String updateQuery = "UPDATE users SET username = ?, password = ? WHERE username "
                        + "= ?";

                try (PreparedStatement preparedStatement =
                             connection.prepareStatement(updateQuery)) {
                    preparedStatement.setString(1, newUsername); // Set the new username
                    preparedStatement.setString(2, hashPassword.hash(newPassword));  // Set the
                    // new password
                    preparedStatement.setString(3, oldUsername); // Set the old username

                    // Execute the update statement
                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("User credentials updated successfully!");
                        JOptionPane.showMessageDialog(null, "User credentials updated " +
                                "successfully.", "Success", JOptionPane.INFORMATION_MESSAGE,
                                customImage.createCheckmarkImage());
                        try {
                            new BackPage(newUsername);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    } else {
                        System.out.println("No user found with the username: " + oldUsername);
                    }
                } catch (SQLIntegrityConstraintViolationException e) {
                    if (e.getErrorCode() == 1062) {
                        JOptionPane.showMessageDialog(null, "Error: Username already exists. " +
                                "Please choose a different username.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        System.err.println("Error: Username already exists. Please choose a " +
                                "different username.");
                        System.err.println("Error updating user credentials");
                        return;
                    } else {
                        e.printStackTrace();
                        System.err.println("Error executing the UPDATE statement.");
                    }
                }
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Connection to the database failed.");
        }
    }
}
