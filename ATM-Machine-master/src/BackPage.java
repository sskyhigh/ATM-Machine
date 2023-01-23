import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.BevelBorder;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class BackPage extends Thread implements ActionListener, Runnable {

    private final JFrame frame = new JFrame("Main Panel");
    private final JButton manageAccounts = new JButton("Manage");
    private final JButton transactions = new JButton("Transactions");
    private final JButton balance = new JButton("Withdraw");
    private final JButton deposit = new JButton("Deposit");
    private final JButton logout = new JButton("LogOut");
    private final JButton help = new JButton("Support");
    private final JButton feedback = new JButton("Feedback");
    private final JLabel title = new JLabel("Welcome");
    //private final JLabel holder;
    //private final ImageIcon red;
    protected boolean isRunning;
    protected JLabel dateLabel;
    protected JLabel timeLabel;


    public BackPage() throws IOException {

        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        frame.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setPreferredSize(new Dimension(frame.getWidth(), 20));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        JLabel statusLabel = new JLabel("Application is running.");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);

        //red = new ImageIcon(getClass().getResource("lowres.jpg"));
        //holder = new JLabel(red);
        title.setBounds(180, 10, 120, 50);
        title.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        title.setForeground(Color.GREEN);

        manageAccounts.setFocusable(false);
        manageAccounts.setBounds(70, 75, 120, 35);
        manageAccounts.setBackground(Color.decode("#238636"));
        manageAccounts.setForeground(Color.BLACK);
        manageAccounts.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        manageAccounts.addActionListener(this);

        transactions.setFocusable(false);
        transactions.setBounds(275, 75, 120, 35);
        transactions.setBackground(Color.decode("#238636"));
        transactions.setForeground(Color.BLACK);
        transactions.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
        transactions.addActionListener(this);

        balance.setFocusable(false);
        balance.setBounds(70, 175, 120, 35);
        balance.setBackground(Color.decode("#238636"));
        balance.setForeground(Color.BLACK);
        balance.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        transactions.addActionListener(this);

        deposit.setFocusable(false);
        deposit.setBounds(275, 175, 120, 35);
        deposit.setBackground(Color.decode("#238636"));
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        deposit.addActionListener(this);

        logout.setFocusable(false);
        logout.setBounds(370, 0, 100, 30);
        logout.setBackground(Color.decode("#238636"));
        logout.setForeground(Color.BLACK);
        logout.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        logout.addActionListener(this);

        help.setFocusable(false);
        help.setBounds(275, 280, 120, 35);
        help.setBackground(Color.decode("#238636"));
        help.setForeground(Color.BLACK);
        help.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        help.addActionListener(this);

        feedback.setFocusable(false);
        feedback.setBounds(70, 280, 120, 35);
        feedback.setBackground(Color.decode("#238636"));
        feedback.setForeground(Color.BLACK);
        feedback.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        feedback.addActionListener(this);

        frame.setSize(475, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.add(title);
        frame.add(manageAccounts);
        frame.add(transactions);
        frame.add(balance);
        frame.add(deposit);
        frame.add(logout);
        frame.add(help);
        frame.add(feedback);
        //frame.add(holder);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == manageAccounts) {
            try {
                Withdrawal withdrawal = new Withdrawal();
            } catch (Exception exception) {exception.printStackTrace();}
            frame.dispose();
        }
        if (e.getSource() == transactions) {
            // do something here.
        }
        if (e.getSource() == balance) {
            // do something here.
        }
        if (e.getSource() == deposit) {
            try {Deposit deposit1 = new Deposit();} catch (Exception exception) {
                exception.printStackTrace();
            }
            frame.dispose();
        }
        if (e.getSource() == logout) {
            int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Log"
                    + " Out", JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                try {
                    FrontPage frontPage = new FrontPage();
                } catch (IOException | URISyntaxException ex) {throw new RuntimeException(ex);}
                frame.dispose();
            }
        }
        if (e.getSource() == help) {
            try {
                String url = "https://bit.ly/3EUv5QZ";
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
