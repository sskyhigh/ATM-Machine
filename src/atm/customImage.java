package atm;

import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;

public class customImage {
    
    public static Icon createCheckmarkImage() {
        // Create a custom checkmark icon using a BufferedImage
        int size = 35; // Icon size
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();

        g.setColor(Color.GREEN);
        g.setStroke(new BasicStroke(6)); // Line thickness
        g.drawLine(10, 18, 14, 22);
        g.drawLine(16, 22, 24, 10);
        g.dispose();

        return new ImageIcon(image);
    }
}
