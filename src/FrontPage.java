import java.awt.*;
import javax.swing.*;

public class FrontPage {
    private final JFrame frame = new JFrame("Login panel");
    private final JLabel _username = new JLabel("Username: ");
    private final JLabel labelPassword = new JLabel("Password");
    private final JTextField userFiend = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final JButton login = new JButton("Login");
    private final JButton forgotPass = new JButton("Forgot");
    private String obtainUsername;
    private String password;

    public FrontPage() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 450);
        frame.setLayout(null);

        _username.setBounds(70, 100, 130, 30);
        _username.setForeground(Color.orange);
        _username.setFont(new Font(null, Font.BOLD, 16));

        labelPassword.setBounds(70, 100, 130, 30);
        labelPassword.setForeground(Color.orange);
        labelPassword.setFont(new Font(null, Font.BOLD, 16));

        frame.add(_username);
    }
}
