import javax.swing.*;
import java.sql.*;
import javax.swing.JFrame;

public class LoginPanel {
    String user = "root";
    String location = "jdbc:mysql://localhost:3306/boadatabase";
    String pass = "light is life";
    private String usr;
    private String psw;
    private String username, userpass;

    public LoginPanel(String obtainUsername, String password) throws ClassNotFoundException {
        usr = obtainUsername;
        psw = password;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(location, user, pass);
            Statement statement = con.createStatement();
            ResultSet help = statement.executeQuery("select * from boadatabase.users");

            while (help.next()) {
                username = help.getString("username");
                userpass = help.getString("password");
                
                if (usr.equals(username) && psw.equals(userpass)) {
                    try {
                    	new BackPage();
                    	break;
                    } catch (Exception e) {e.printStackTrace();}
                }
                else if (!help.next()){
                    try {
                    	JOptionPane.showMessageDialog(null, "Wrong credentials");
                        new FrontPage();
                    } catch (Exception exception) {exception.printStackTrace();}
                }
            }
        } catch (SQLException e) {e.printStackTrace();}
    }
}
