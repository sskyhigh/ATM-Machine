import javax.swing.*;
import java.sql.*;
import javax.swing.JFrame;

public class LoginPanel {
    String user = "root";
    String location = "jdbc:mysql://localhost:3306/boa_credentials";
    String pass = "Magnum12!";
    private String usr;
    private String psw;
    private String username;

    public LoginPanel(String obtainUsername, String password) {
        this.usr = obtainUsername;
        this.psw = password;
        try {
            Connection connection = DriverManager.getConnection(location, user, pass);
            Statement statement = connection.createStatement();
            ResultSet help = statement.executeQuery("select * from boa_credentials.credentials");

            while (help.next()) {
                username = help.getString("Username");
                psw = help.getString("Password");
                if (!usr.equals(username)) {
                    try {
                        JOptionPane.showMessageDialog(null, "Wrong credentials");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        BackPage backPage = new BackPage();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
