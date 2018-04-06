package Engine;

import Utility.Color;
import World.Scene;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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