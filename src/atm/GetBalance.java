package atm;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class GetBalance {
    public static Integer Get(String user) throws IOException {
        FileReader reader = new FileReader("credentials.properties");
        Properties credentials = new Properties();
        credentials.load(reader);

        String jdbcURL = credentials.getProperty("link");
        String username = credentials.getProperty("user");
        String password = credentials.getProperty("password");
        Integer oldBalance = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null; // Exit if the driver class is not found
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
                        oldBalance = -1;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.err.println("Error executing the SELECT statement.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Connection to the database failed. " + e);
        }
        return oldBalance;
    }
}
