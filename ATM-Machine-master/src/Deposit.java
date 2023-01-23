import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.BevelBorder;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.text.NumberFormatter;

public class Deposit implements ActionListener {

    private final JFrame frame = new JFrame("Deposit Page");
    private final JTextField insertAmount = new JTextField("");
    private final JLabel label = new JLabel("Deposit amount: ");
    private final JButton goBack = new JButton("Go back");
    private final JButton DepositButton = new JButton("Deposit");
    private final JButton[] amount = new JButton[5];
    NumberFormat format = NumberFormat.getInstance();
    NumberFormatter formatter = new NumberFormatter(format);
    JFormattedTextField formattedTextField = new JFormattedTextField(formatter);


    public Deposit() {

        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(true);
        formatter.setCommitsOnValidEdit(false);

        formattedTextField.setBounds(240, 230, 120, 30);
        label.setBounds(255, 190, 160, 35);

        frame.setSize(420, 420);
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

        DepositButton.setFocusable(false);
        DepositButton.setBounds(240, 320, 120, 35);
        DepositButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        DepositButton.addActionListener(this);

        for (int i = 0; i < 5; ++i) {
            frame.add(amount[i]);
        }

        frame.add(goBack);
        frame.add(DepositButton);
        frame.add(label);
        frame.add(formattedTextField);
    }

    @Override
    public void actionPerformed(ActionEvent clicked) {
        int num;
        if (clicked.getSource() == goBack) {
            try {
                BackPage backPage = new BackPage();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            frame.dispose();
        }
        if (clicked.getSource() == DepositButton) {
            try {
                int val = Integer.parseInt(formattedTextField.getText());
                if (val > 10000) {
                    JOptionPane.showMessageDialog(null, "Amount cannot cross $10000!");
                } else {
                    // code goes here.
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "invalid amount");

            }
        }
        if (clicked.getSource() == amount[0]) {
            try {
                formattedTextField.setText(amount[0].getText());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (clicked.getSource() == amount[1]) {
            try {
                formattedTextField.setText(amount[1].getText());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (clicked.getSource() == amount[2]) {
            try {
                formattedTextField.setText(amount[2].getText());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (clicked.getSource() == amount[3]) {
            try {
                formattedTextField.setText(amount[3].getText());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (clicked.getSource() == amount[4]) {
            try {
                formattedTextField.setText(amount[4].getText());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
