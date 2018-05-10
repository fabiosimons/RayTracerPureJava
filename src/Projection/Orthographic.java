package Projection;

import Tracer.RayTracer;
import Utility.*;
import Utility.Color;
import World.Scene;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * ORTHOGRAPHIC RAY TRACING
 **/
public class Orthographic extends Camera {
    File image;
    BufferedImage buffer;
    double z;
    private Image img;

    public Orthographic(double z){
        this.z = z;
        image = new File("Traced.png");
        buffer = new BufferedImage(Scene.vp.getHorizontalRes(), Scene.vp.getVerticalRes(), BufferedImage.TYPE_INT_RGB);
    }
    @Override
    public void render() {
        RayTracer tracer = new RayTracer();
        Color pixelColour;
        for (int j = 0; j < Scene.vp.getVerticalRes(); j++) {
            for (int i = 0; i < Scene.vp.getHorizontalRes(); i++) {
                pixelColour = tracer.trace(i,j);
                buffer.setRGB(i,Scene.vp.getVerticalRes() - j - 1,pixelColour.toInt());
            }
        }
        GenerateImage();
    }
    @Override
    public Ray CreateRay(Point2D p) {
        double x = Scene.vp.getPixelSize() * p.getX();
        double y = Scene.vp.getPixelSize() * p.getY();
        return new Ray(new Point3D(x, y, z), new Vector3D(0.0,0.0,-1.0));
    }
    public void GenerateImage(){
        try {
            ImageIO.write(buffer, "PNG", image);
        } catch (Exception e) {
            System.out.println("Can't output image");
        }
        try {
            img = ImageIO.read(new File("traced.png"));
        } catch (Exception e) {
            System.out.println("Can't open image");
        }
        JFrame frame = new JFrame("Traced Image");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        frame.setSize(Scene.vp.getHorizontalRes(), Scene.vp.getVerticalRes());
        frame.setResizable(false);
        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        JLabel label = new JLabel();
        ImageIcon ii = new ImageIcon(img);
        label.setIcon(ii);
        panel.add(label);
        frame.pack();
    }
}

