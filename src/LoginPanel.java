import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.Driver;

import java.sql.*;

public class LoginPanel {
    String user = "root";
    String location = "jdbc:mysql://localhost:3306/boa_credentials";
    String pass = "Magnum12!";

    public LoginPanel() {
        try {
            Connection connection = DriverManager.getConnection(location, user, pass);
            Statement statement = connection.createStatement();
            ResultSet help = statement.executeQuery("select * from boa_credentials.credentials");

            while (help.next()) {
                String username = help.getString("Username");
                String pass = help.getString("Password");
                System.out.printf("%s %s\n", username, pass);
            }
            System.out.println("Connected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
