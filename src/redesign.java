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

public class redesign extends JFrame implements ActionListener{
    private final JFrame frame = new JFrame("Main Panel");
    private final JButton getCash = new JButton("Get cash");
    private final JButton checkBalance = new JButton("Check balance");
    private final JButton viewButton = new JButton("View more..,");

    public redesign()throws IOException{
        getCash.setBounds(50,110,130,40);
        getCash.setFocusable(false);
        getCash.setBackground(Color.decode("#0052C2"));
        getCash.setForeground(Color.white);
        frame.add(getCash);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(465,400);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
