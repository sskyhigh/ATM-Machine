package atm;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BackPage extends Thread implements ActionListener {
		private String username;
		private final JFrame frame = new JFrame("Main Panel");
	    private final JButton manageAccounts = new JButton("Manage Accounts");
	    private final JButton transactions = new JButton("Transactions");
	    private final JButton withdraw = new JButton("Withdraw");
	    private final JButton deposit = new JButton("Deposit");
	    private final JButton logout = new JButton("Log Out");
	    private final JButton help = new JButton("Help");
	    private final JButton feedback = new JButton("Feedback");
	    private final JLabel title;

	    public BackPage(String username) {
	        // Set up the frame
	    	this.username = username;
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(600, 400);
	        frame.setLayout(new BorderLayout());

	        // Create a panel for the top section with the welcome message
	        JPanel topPanel = new JPanel();
	        topPanel.setBackground(Color.decode("#238636"));
	        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	        title = new JLabel("Welcome, " + username);
	        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
	        title.setForeground(Color.WHITE);
	        topPanel.add(title);

	        // Create a panel for the buttons
	        JPanel buttonPanel = new JPanel();
	        buttonPanel.setLayout(new GridLayout(3, 2, 10, 10));
	        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

	        // Customize the buttons
	        JButton[] buttons = {manageAccounts, transactions, withdraw, deposit, help, feedback};
	        for (JButton button : buttons) {
	            button.setFocusPainted(false);
	            button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
	        }

	        // Add action listeners to the buttons
	        manageAccounts.addActionListener(this);
	        transactions.addActionListener(this);
	        withdraw.addActionListener(this);
	        deposit.addActionListener(this);
	        help.addActionListener(this);
	        feedback.addActionListener(this);

	        // Add the buttons to the button panel
	        for (JButton button : buttons) {
	            buttonPanel.add(button);
	        }

	        // Add the panels to the frame
	        frame.add(topPanel, BorderLayout.NORTH);
	        frame.add(buttonPanel, BorderLayout.CENTER);

	        // Customize the logout button
	        logout.setFocusPainted(false);
	        logout.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
	        logout.setForeground(Color.RED);
	        logout.addActionListener(this);
	        frame.add(logout, BorderLayout.SOUTH);

	        frame.setVisible(true);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == withdraw) {
	            try {
	                new Withdrawal(username);
	            } catch (Exception exception) {exception.printStackTrace();}
	            frame.dispose();
	        }
	        if (e.getSource() == transactions) {
	            // do something here.
	        }
	        if (e.getSource() == manageAccounts) {
	            // do something here.
	        }
	        if (e.getSource() == deposit) {
	            try {new Deposit(username);} catch (Exception exception) {
	                exception.printStackTrace();
	            }
	            frame.dispose();
	        }
	        if (e.getSource() == logout) {
	            int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Log"
	                    + " Out", JOptionPane.YES_NO_OPTION);
	            if (n == 0) {
	                try {
	                    new FrontPage();
	                } catch (IOException | URISyntaxException ex) {throw new RuntimeException(ex);}
	                frame.dispose();
	            }
	        }
	        if (e.getSource() == help) {
	            try {
	                String url = "https://runcat.us";
	                Desktop.getDesktop().browse(URI.create(url));
	            } catch (IOException ioException) {System.out.println(ioException.getMessage());}
	        }
	        if (e.getSource() == feedback) {
	            try {
	                String url = "https://forms.gle/e9G5vLM6J6AiGJ8i8";
	                Desktop.getDesktop().browse(URI.create(url));
	            } catch (IOException ioException) {System.out.println(ioException.getMessage());}
	        }
	    }

}
