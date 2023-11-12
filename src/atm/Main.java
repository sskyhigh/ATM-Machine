package atm;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) throws IOException, URISyntaxException  {

		SwingUtilities.invokeLater(() -> {
            try {
				new FrontPage();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
        });
	}
}
