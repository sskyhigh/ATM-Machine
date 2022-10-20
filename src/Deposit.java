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

public class Deposit implements ActionListener {

    private final JFrame frame = new JFrame("Deposit Page");
    private final JButton goBack = new JButton("Go back");
    private final JButton DepositButton = new JButton("Deposit");

    public Deposit() {

        frame.setSize(420, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        
        goBack.setFocusable(false);
        goBack.setBounds(70, 75, 120, 35);
        goBack.setBackground(Color.decode("#238636"));
        goBack.setForeground(Color.BLACK);
        goBack.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        goBack.addActionListener(this);

        DepositButton.setFocusable(false);
        DepositButton.setBounds(275, 75, 120, 35);
        DepositButton.setBackground(Color.decode("#238636"));
        DepositButton.setForeground(Color.BLACK);
        DepositButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
        DepositButton.addActionListener(this);

        //frame.add(goBack);
        frame.add(DepositButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
