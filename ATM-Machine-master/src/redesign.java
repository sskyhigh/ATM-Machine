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

public class redesign extends JFrame implements ActionListener {
    private final JFrame frame = new JFrame("Main Panel");
    private final JButton getCash = new JButton("Get cash");
    private final JButton makeDeposit = new JButton("Make Deposit");
    private final JButton checkBalance = new JButton("Check balance");
    private final JButton viewMore = new JButton("View More");
    private final JButton Cancel = new JButton("Cancel");
    private ImageIcon image;
    private final JLabel back;

    public redesign() throws IOException {
        image = new ImageIcon(getClass().getResource("cover.png"));
        Image help = image.getImage();
        Image part = help.getScaledInstance(250, 50, java.awt.Image.SCALE_SMOOTH);
        image = new ImageIcon(part);
        back = new JLabel(image);
        back.setLayout(null);
        back.setBounds(90, 0, 290, 90);
        back.setVisible(true);

        getCash.setBounds(50, 110, 130, 40);
        getCash.setFocusable(false);
        getCash.setBackground(Color.decode("#0052C2"));
        getCash.setForeground(Color.white);
        getCash.addActionListener(this);

        makeDeposit.setBounds(220, 110, 130, 40);
        makeDeposit.setFocusable(false);
        makeDeposit.setBackground(Color.decode("#0052C2"));
        makeDeposit.setForeground(Color.white);
        makeDeposit.addActionListener(this);

        checkBalance.setBounds(50, 200, 130, 40);
        checkBalance.setFocusable(false);
        checkBalance.setBackground(Color.decode("#0052C2"));
        checkBalance.setForeground(Color.white);
        checkBalance.addActionListener(this);

        viewMore.setBounds(220, 200, 130, 40);
        viewMore.setFocusable(false);
        viewMore.setForeground(Color.blue);
        viewMore.addActionListener(this);

        Cancel.setBounds(140, 280, 130, 40);
        Cancel.setFocusable(false);
        Cancel.setBackground(Color.decode("#C41230"));
        Cancel.setForeground(Color.white);
        Cancel.addActionListener(this);

        frame.add(back);
        frame.add(getCash);
        frame.add(makeDeposit);
        frame.add(checkBalance);
        frame.add(viewMore);
        frame.add(Cancel);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(465, 400);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Cancel) {
            try {
                FrontPage frontPage = new FrontPage();
            } catch (IOException ex) {throw new RuntimeException(ex);} catch (
                    URISyntaxException ex) {throw new RuntimeException(ex);}
        }
        frame.dispose();
    }
}
