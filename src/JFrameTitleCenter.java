import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
public class JFrameTitleCenter {

    public void createAndShowGUI() {

        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(300, 200));
        frame.setTitle("Online Banking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addComponentListener(new ComponentAdapter() {
                                       @Override
                                       public void componentResized(ComponentEvent e) {
                                           titleAlign(frame);
                                       }
                                   }
        );

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private void titleAlign(JFrame frame) {
        Font font = frame.getFont();
        String currentTitle = frame.getTitle().trim();
        FontMetrics fm = frame.getFontMetrics(font);
        int frameWidth = frame.getWidth();
        int titleWidth = fm.stringWidth(currentTitle);
        int spaceWidth = fm.stringWidth(" ");
        int centerPos = (frameWidth / 2) - (titleWidth / 2);
        int spaceCount = centerPos / spaceWidth;
        String pad = "";
        pad = String.format("%" + (spaceCount - 14) + "s", pad);
        frame.setTitle(pad + currentTitle);
    }
}
