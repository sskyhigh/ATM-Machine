import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.*;
public class BackPage implements ActionListener{
    private final JFrame frame = new JFrame("Main Panel");
    private final JButton manageAccounts = new JButton("Manage Accounts");
    private final JButton transactions = new JButton("Transactions");
    private final JButton balance = new JButton("Balance");
    private final JButton deposit = new JButton("Deposit");

    public BackPage(){



        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
