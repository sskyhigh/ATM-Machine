package atm;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class WithdrawalDeposit implements ActionListener {
		
	private String username;
    private String transactionType;
	private final JFrame frame = new JFrame();
    private final JLabel label = new JLabel();
    private final JButton goBack = new JButton("Go back");
    private final JButton withdrawButton = new JButton();
    private final JButton[] amount = new JButton[5];
    NumberFormat format = NumberFormat.getInstance();
    NumberFormatter formatter = new NumberFormatter(format);
    JFormattedTextField formattedTextField = new JFormattedTextField(formatter);


    public WithdrawalDeposit(String username, String transactionType) {
    	
    	this.username = username;
        this.transactionType = transactionType;
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(true);
        formatter.setCommitsOnValidEdit(false);

        formattedTextField.setBounds(240, 230, 120, 30);
        label.setText(transactionType + " amount: ");
        label.setBounds(255, 190, 160, 35);

        frame.setTitle(transactionType + " Page");
        frame.setSize(420, 450);
		frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);

        amount[0] = new JButton("100");
        amount[0].setBounds(30, 200, 60, 35);
        amount[0].addActionListener(this);

        amount[1] = new JButton("200");
        amount[1].setBounds(110, 200, 60, 35);
        amount[1].addActionListener(this);

        amount[2] = new JButton("500");
        amount[2].setBounds(30, 260, 60, 35);
        amount[2].addActionListener(this);

        amount[3] = new JButton("750");
        amount[3].setBounds(110, 260, 60, 35);
        amount[3].addActionListener(this);

        amount[4] = new JButton("1000");
        amount[4].setBounds(30, 320, 140, 35);
        amount[4].addActionListener(this);


        goBack.setFocusable(false);
        goBack.setBounds(290, 0, 120, 35);
        goBack.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        goBack.addActionListener(this);

        withdrawButton.setText(transactionType);
        withdrawButton.setFocusable(false);
        withdrawButton.setBounds(240, 320, 120, 35);
        withdrawButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        withdrawButton.addActionListener(this);

        for (int i = 0; i < 5; ++i) frame.add(amount[i]);

        frame.add(goBack);
        frame.add(withdrawButton);
        frame.add(label);
        frame.add(formattedTextField);
    }

    @Override
    public void actionPerformed(ActionEvent clicked) {
        if (clicked.getSource() == goBack) {
            try {
                new BackPage(username);
            } catch (Exception exception) {exception.printStackTrace();}
            frame.dispose();
        }
        if (clicked.getSource() == withdrawButton) {
            try {
                int val = Integer.parseInt(formattedTextField.getText());
                if (val > 10000) JOptionPane.showMessageDialog(null, "Amount cannot cross $10000!");
                else {
                    if (transactionType.equals("Withdraw")) {
                        new TransactionManager(username, val, "withdraw");
                    }
                    else {
                        new TransactionManager(username, val, "deposit");
                    }
                	
                }
            } catch (Exception exception) {JOptionPane.showMessageDialog(null, "Invalid amount. Try inserting digits.");}
        }
        if (clicked.getSource() == amount[0]) {
            try {
                formattedTextField.setText(amount[0].getText());
            } catch (Exception exception) {exception.printStackTrace();}
        }
        if (clicked.getSource() == amount[1]) {
            try {
                formattedTextField.setText(amount[1].getText());
            } catch (Exception exception) {exception.printStackTrace();}
        }
        if (clicked.getSource() == amount[2]) {
            try {
                formattedTextField.setText(amount[2].getText());
            } catch (Exception exception) {exception.printStackTrace();}
        }
        if (clicked.getSource() == amount[3]) {
            try {
                formattedTextField.setText(amount[3].getText());
            } catch (Exception exception) {exception.printStackTrace();}
        }
        if (clicked.getSource() == amount[4]) {
            try {
                formattedTextField.setText(amount[4].getText());
            } catch (Exception exception) {exception.printStackTrace();}
        }
    }
}