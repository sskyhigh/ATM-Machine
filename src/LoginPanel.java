import javax.swing.*;
import java.sql.*;
import javax.swing.JFrame;

public class LoginPanel {
    String user = "root";
    String location = "jdbc:mysql://localhost:3306/boa_credentials";
    String pass = "Magnum12!";
    private String usr;
    private String psw;

    public LoginPanel(String obtainUsername, String password) {
        this.usr = obtainUsername;
        this.psw = password;
        try {
            Connection connection = DriverManager.getConnection(location, user, pass);
            Statement statement = connection.createStatement();
            ResultSet help = statement.executeQuery("select * from boa_credentials.credentials");

            while (help.next()) {
                String username = help.getString("Username");
                String pass = help.getString("Password");

                if (usr.equals(username) && psw.equals(pass)) {
                    try {
                        BackPage backPage = new BackPage();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect user or psw");
                }
                //System.out.printf("%s %s\n", username, pass);
            }
            System.out.println("Connected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
