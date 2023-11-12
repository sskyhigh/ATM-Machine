package atm;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ManageAccount extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel userLabel = new JLabel("New Username");
    private JLabel passLabel = new JLabel("New Password");
    private JButton goBack;
    private JButton submitButton;
    private final JLabel imgLabel;
    private ImageIcon image;

    public ManageAccount(String username) {
        setTitle("Manage Account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null); // Center the frame on the screen
        setResizable(false);

        setLayout(null);

        // Create a label for the icon
        image = new ImageIcon(getClass().getResource("../graphics/settings.png"));
        Image icon = image.getImage();
        Image part = icon.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        image = new ImageIcon(part);
        imgLabel = new JLabel(image);
        imgLabel.setLayout(null);
        imgLabel.setBounds(160, 0, 320, 150);
        imgLabel.setVisible(true);

        // Create a panel for the input fields and submit button
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(null);
        inputPanel.setBackground(Color.WHITE);

        // Username input
        userLabel.setBounds(170, 5, 260, 40);
        inputPanel.add(userLabel);
        usernameField = new JTextField(20);
        inputPanel.add(usernameField);
        usernameField.setBounds(170, 40, 260, 40); // Set the bounds of the username field

        // Password input
        passLabel.setBounds(170, 75, 260, 40);
        inputPanel.add(passLabel);
        passwordField = new JPasswordField(20);
        inputPanel.add(passwordField);
        passwordField.setBounds(170, 110, 260, 40); // Set the bounds of the password field


        // go back button
        goBack = new JButton("Cancel");
        goBack.setFocusPainted(false);
        goBack.setBackground(Color.PINK);
        goBack.setForeground(Color.WHITE);
        goBack.setBounds(310, 165, 120, 40);
        inputPanel.add(goBack);

        goBack.addActionListener(e -> {
            try {
                new BackPage(username);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            dispose();
        });
        
        // Submit button
        submitButton = new JButton("Update");
        submitButton.setFocusPainted(false);
        submitButton.setBackground(Color.decode("#1F7AC4"));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBounds(170, 165, 120, 40);
        inputPanel.add(submitButton);

        submitButton.addActionListener(e -> {
            // Handle the submit action here
            String newUsername = usernameField.getText();
            String newPassword = String.valueOf(passwordField.getPassword());

            if (newUsername.isEmpty() || newPassword.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Username or password cannot be empty.");
                return;
            }
            // Update the user's username and password
            try {
                new UpdateCredentials(username, newUsername, newPassword);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        
        // Add the label and the panel to the frame
        add(imgLabel);
        add(inputPanel);
        inputPanel.setBounds(0, 150, 600, 300);

        setVisible(true);
    }
}
