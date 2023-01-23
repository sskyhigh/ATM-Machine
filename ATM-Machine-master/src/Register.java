import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.sql.*;

public class Register implements ActionListener {
    private final JFrame frame = new JFrame("Register Panel");
    private final JLabel _username = new JLabel("User ID: ");
    private final JLabel labelPassword = new JLabel("Password:");
    private final JLabel back;
    private final JLabel loginHelp = new JLabel("Login help");
    private final JLabel forgot_Pass = new JLabel("Forgot ID/Password?");
    private final JLabel logging_in = new JLabel("Problem logging in?");
    private final JLabel notAMember = new JLabel("Already a member?");
    private final JLabel enrollNow = new JLabel("Login now");
    private final JLabel learnMore = new JLabel("Learn more about Online Banking");
    private final JLabel service = new JLabel("Service Agreement");
    private final JTextField userField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final JButton login = new JButton("Register");
    private final JPanel statusPanel = new JPanel();
    private String obtainUsername;
    private String password;
    private JLabel support = new JLabel("Don't have email?");
    private JCheckBox checkBox = new JCheckBox("Save this user ID");
    private ImageIcon image;
    private JSeparator separator = new JSeparator();
    private JSeparator separator2 = new JSeparator();

    public Register() throws IOException, URISyntaxException {

        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        frame.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setPreferredSize(new Dimension(frame.getWidth(), 16));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        JLabel statusLabel = new JLabel("Application is running.");
        JLabel time = new JLabel();
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);
        statusPanel.add(time);

        image = new ImageIcon(getClass().getResource("cover.png"));
        Image help = image.getImage();
        Image part = help.getScaledInstance(250, 50, java.awt.Image.SCALE_SMOOTH);
        image = new ImageIcon(part);
        back = new JLabel(image);
        back.setLayout(null);
        back.setBounds(160, -10, 290, 90);
        back.setVisible(true);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(null);

        _username.setBounds(50, 70, 130, 30);
        _username.setForeground(Color.decode("#d4001a"));
        _username.setFont(new Font(null, Font.PLAIN, 16));

        userField.setBounds(50, 105, 180, 25);
        userField.addActionListener(this);

        labelPassword.setBounds(50, 170, 130, 30);
        labelPassword.setForeground(Color.black);
        labelPassword.setFont(new Font(null, Font.PLAIN, 16));

        loginHelp.setBounds(350, 70, 130, 30);
        loginHelp.setForeground(Color.decode("#d4001a"));
        loginHelp.setFont(new Font(null, Font.PLAIN, 16));

        passwordField.setBounds(50, 200, 180, 25);
        passwordField.addActionListener(this);
        support.setForeground(Color.blue);
        support.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String url = "https://secure.bankofamerica.com/auth/forgot/reset-entry/";
                    Desktop.getDesktop().browse(URI.create(url));
                } catch (IOException ioException) {System.out.println(ioException.getMessage());}
            }
        });
        checkBox.setBounds(46, 140, 180, 25);
        checkBox.setFocusable(false);

        notAMember.setBounds(350, 160, 200, 50);
        notAMember.setFont(new Font(null, Font.PLAIN, 16));
        notAMember.setForeground(Color.decode("#d4001a"));

        support.setBounds(50, 230, 180, 25);
        separator.setBounds(350, 105, 130, 30);
        separator2.setBounds(350, 206, 130, 30);

        // blue - "#0077be"
        login.setBounds(50, 260, 100, 25);
        login.setBackground(Color.decode("#0077be"));
        login.setForeground(Color.white);
        login.setFocusable(false);
        login.addActionListener(this);

        forgot_Pass.setBounds(350, 110, 130, 30);
        forgot_Pass.setForeground(Color.decode("#36C"));
        forgot_Pass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String url = "https://secure.bankofamerica.com/auth/forgot/reset-entry/";
                    Desktop.getDesktop().browse(URI.create(url));
                } catch (IOException e1) {System.out.println(e1.getMessage());}
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                try {
                    String url = "https://secure.bankofamerica.com/auth/forgot/reset-entry/";
                    Desktop.getDesktop().browse(URI.create(url));
                } catch (IOException e1) {System.out.println(e1.getMessage());}
            }
        });


        logging_in.setBounds(350, 135, 130, 30);
        logging_in.setForeground(Color.decode("#36C"));
        logging_in.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String url =
                            "https://www.bankofamerica" + ".com/customer-service/contact-us" +
                                    "/bank-of-america-login-issues/";
                    Desktop.getDesktop().browse(URI.create(url));
                } catch (IOException e1) {System.out.println(e1.getMessage());}
            }
        });

        enrollNow.setBounds(350, 210, 130, 30);
        enrollNow.setForeground(Color.decode("#36C"));
        enrollNow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    FrontPage frontPage = new FrontPage();
                } catch (Exception E) {System.out.println(E.getMessage());}
                frame.dispose();
            }
        });

        learnMore.setBounds(350, 235, 220, 30);
        learnMore.setForeground(Color.decode("#36C"));
        learnMore.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String url =
                            "https://www.bankofamerica" + ".com/online-banking/mobile-and" +
                                    "-online-banking-features/";
                    Desktop.getDesktop().browse(URI.create(url));
                } catch (IOException e1) {System.out.println(e1.getMessage());}
            }
        });

        service.setBounds(349, 260, 220, 30);
        service.setForeground(Color.decode("#36C"));
        service.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String url =
                            "https://www.bankofamerica.com/online-banking/service-agreement" +
                                    ".go";
                    Desktop.getDesktop().browse(URI.create(url));
                } catch (IOException e1) {System.out.println(e1.getMessage());}
            }
        });

        frame.add(separator);
        frame.add(loginHelp);
        frame.add(back);
        frame.add(checkBox);
        frame.add(_username);
        frame.add(userField);
        frame.add(labelPassword);
        frame.add(passwordField);
        frame.add(support);
        frame.add(login);
        //frame.add(back);
        frame.add(logging_in);
        frame.add(notAMember);
        frame.add(forgot_Pass);
        frame.add(separator2);
        frame.add(learnMore);
        frame.add(enrollNow);
        frame.add(service);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == login) {
            obtainUsername = userField.getText();
            password = String.valueOf(passwordField.getPassword());
            try {
            	Class.forName("com.mysql.jdbc.Driver");
            	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/boadatabase", "root", "light is life");
            	Statement stmt = con.createStatement();
            	System.out.println("inserting!");
            	String sql = "Insert into users (username, password) values (?, ?)";
            	PreparedStatement myStmt = con.prepareStatement(sql);
            	myStmt.setString(1, obtainUsername);
            	myStmt.setString(2, password);
            	myStmt.execute();
                LoginPanel loginPanel = new LoginPanel(obtainUsername, password);
            } catch (Exception e) {System.out.println(e);}
            frame.dispose();
        }
    }

    public void textAction(KeyEvent event) {
        if (event.getSource().equals(KeyEvent.VK_ENTER)) {
            obtainUsername = userField.getText();
            password = String.valueOf(passwordField.getPassword());
            try {
            	Class.forName("com.mysql.jdbc.Driver");
            	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/boadatabase", "root", "light is life");
            	Statement stmt = con.createStatement();
            	System.out.println("inserting!");
            	String sql = "Insert into users (username, password) values (?, ?)";
            	PreparedStatement myStmt = con.prepareStatement(sql);
            	myStmt.setString(1, obtainUsername);
            	myStmt.setString(2, password);
            	myStmt.execute();
                new LoginPanel(obtainUsername, password);
            } catch (Exception e) {System.out.println(e);}
            frame.dispose();
        }
    }
}

