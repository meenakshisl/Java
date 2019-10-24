import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private BufferedImage img;

public ImagePanel(String path) {
    // load the background image
    try {
        img = ImageIO.read(new File(path));
    } catch(IOException e) {
        e.printStackTrace();
    }
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // paint the background image and scale it to fill the entire space
    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
}
}