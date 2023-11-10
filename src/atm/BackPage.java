package atm;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.*;

public class BackPage extends Thread implements ActionListener {
	private String username;
	private final JFrame frame = new JFrame("Main Panel");
	private final JButton manageAccounts = new JButton("Manage Account");
	private final JButton checkBalance = new JButton("Check Balance");
	private final JButton withdraw = new JButton("Withdraw");
	private final JButton deposit = new JButton("Deposit");
	private final JButton help = new JButton("Help");
	private final JButton feedback = new JButton("Feedback");
	private final JButton logout = new JButton("Logout");
	private final JLabel title;

	public BackPage(String username) {
		// Set up the frame
		this.username = username;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.setBackground(Color.WHITE);

		// Create a panel for the top section with the welcome message
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.decode("#0F4C81"));
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		title = new JLabel("Welcome, " + username);
		title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		title.setForeground(Color.WHITE);
		topPanel.add(title);

		// Create a panel for the buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 2, 15, 20));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
		buttonPanel.setBackground(Color.decode("#F0F0F0"));

		// Customize the buttons
		JButton[] buttons = {manageAccounts, checkBalance, withdraw, deposit, help, feedback};
		for (JButton button : buttons) {
			button.setFocusPainted(false);
			button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
			button.setBackground(Color.decode("#1F7AC4"));
			button.setForeground(Color.WHITE);
		}

		// Add action listeners to the buttons
		manageAccounts.addActionListener(this);
		checkBalance.addActionListener(this);
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
		logout.setForeground(Color.WHITE);
		logout.setBackground(Color.decode("#FFA500"));
		logout.addActionListener(this);

		// Set the icon property of the logout button
		URL logoutURL = getClass().getResource("../graphics/logout.png");
		ImageIcon logoutIcon = new ImageIcon(logoutURL);
		logout.setIcon(logoutIcon);
		logout.setHorizontalAlignment(SwingConstants.CENTER);
		logout.setVerticalAlignment(SwingConstants.BOTTOM);
		logout.setHorizontalTextPosition(SwingConstants.CENTER);
		logout.setVerticalTextPosition(SwingConstants.BOTTOM);
		frame.add(logout, BorderLayout.SOUTH);

		frame.add(logout, BorderLayout.SOUTH);

		// Load the icons for the buttons
		loadIcons();

		frame.setVisible(true);
	}

	// A method to load the icons for the buttons
	private void loadIcons() {
		// An array of icon file names
		String[] iconFiles = {"../graphics/manage.png", "../graphics/cash.png", "../graphics/deposit.png", "../graphics/withdraw.png", "../graphics/help.png", "../graphics/feedback.png"};
		// An array of buttons
		JButton[] buttons = {manageAccounts, checkBalance, withdraw, deposit, help, feedback};
		// A loop to load each icon and set it to the corresponding button
		for (int i = 0; i < iconFiles.length; i++) {
			// Get the URL of the icon file relative to the classpath
			URL iconURL = getClass().getResource(iconFiles[i]);
			// Create an ImageIcon object from the URL
			ImageIcon icon = new ImageIcon(iconURL);
			// Get the image from the ImageIcon object
			Image image = icon.getImage();
			// Resize the image to 32x32 pixels
			Image scaledImage = image.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
			// Create a new ImageIcon object from the resized image
			icon = new ImageIcon(scaledImage);
			// Set the icon property of the button to the ImageIcon object
			buttons[i].setIcon(icon);
			// Set the horizontal alignment of the button to center
			buttons[i].setHorizontalAlignment(SwingConstants.CENTER);
			// Set the vertical alignment of the button to bottom
			buttons[i].setVerticalAlignment(SwingConstants.BOTTOM);
			// Set the horizontal text position of the button to center
			buttons[i].setHorizontalTextPosition(SwingConstants.CENTER);
			// Set the vertical text position of the button to bottom
			buttons[i].setVerticalTextPosition(SwingConstants.BOTTOM);
		}
	}

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == withdraw) {
	            try {
	                new Withdrawal(username);
	            } catch (Exception exception) {exception.printStackTrace();}
	            frame.dispose();
	        }
	        if (e.getSource() == checkBalance) {
	            JOptionPane.showMessageDialog(null, "Availabe account balance: $" + GetBalance.Get(username), "Balance Inquiry!", JOptionPane.INFORMATION_MESSAGE, customImage.createCheckmarkImage());
	        }
	        if (e.getSource() == manageAccounts) {
				try {new ManageAccount(username);} catch (Exception exception) {
	                exception.printStackTrace();
	            }
	            frame.dispose();
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
