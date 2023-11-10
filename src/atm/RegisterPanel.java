package atm;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.Properties;

public class RegisterPanel {
    public RegisterPanel(String obtainUsername, String pass) throws IOException,
            URISyntaxException {
        FileReader reader = new FileReader("credentials.properties");
        Properties credentials = new Properties();
        credentials.load(reader);
        System.out.println(credentials.getProperty("user"));
        System.out.println(credentials.getProperty("password"));
        System.out.println(credentials.getProperty("link"));

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
                // Create an SQL INSERT statement with placeholder
                String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";

                try (PreparedStatement preparedStatement =
                             connection.prepareStatement(insertQuery)) {
                    // Set values for the placeholder
                    preparedStatement.setString(1, obtainUsername);
                    preparedStatement.setString(2, hashPassword.hash(pass));

                    // Execute the INSERT statement
                    try {
                        int rowsAffected = preparedStatement.executeUpdate();

                        if (rowsAffected > 0) {
                            System.out.println("User Registered successfully!");
                            new BackPage(obtainUsername);
                        } else {
                            System.out.println("Data insertion failed.");
                        }
                    } catch (SQLIntegrityConstraintViolationException e) {
                        if (e.getErrorCode() == 1062) {
                            JOptionPane.showMessageDialog(null, "Error: Username already exists. " +
                                    "Please choose a different username.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            System.err.println("Error: Username already exists. Please choose a " +
                                    "different username.");
                            new Register();

                        } else {
                            e.printStackTrace();
                            System.err.println("Error executing the INSERT statement.");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.err.println("Error preparing the INSERT statement.");
                }

                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Connection to the database failed.");
        }
    }
}
