package Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

// THIS CLASS IS PURELY FOR VISUAL FEEDBACK NOTHING ELSE

public class RenderInRealTime extends JFrame {
    BufferedImage image;
    JPanel canvas;

    public RenderInRealTime(int width, int height) {
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new JPanel();
        canvas.setSize(width, height);
        add(canvas);
        getContentPane().add(canvas);
    }
    public void paint(Graphics g){
        g.drawImage(image,0,0,canvas);
        repaint();
    }
    public void setPixel(BufferedImage image){
        this.image = image;
    }
}