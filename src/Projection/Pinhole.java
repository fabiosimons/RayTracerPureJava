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
 * PERSPECTIVE RAY TRACING
 */
public class Pinhole extends Camera {
    private File image;
    private BufferedImage buffer;
    private Vector3D direction;
    private Image img;

    public Pinhole(Point3D eye, Point3D lookat, double FOV){
        this.eye = new Point3D(eye);
        this.lookat = new Point3D(lookat);
        this.distance = getDistance(eye, lookat);
        computeUVW();
        image = new File("Traced.png");
        buffer = new BufferedImage(Scene.vp.getHorizontalRes(),Scene.vp.getVerticalRes(), BufferedImage.TYPE_INT_RGB);
    }
    @Override
    public void render() {
        RayTracer tracer = new RayTracer();
        Color pixelColour;
        for(int height = 0; height < Scene.vp.getVerticalRes(); height++){
            for(int width = 0; width < Scene.vp.getHorizontalRes(); width++){
                pixelColour = tracer.trace(width,height);
                buffer.setRGB(width,Scene.vp.getVerticalRes() - height - 1,pixelColour.toInt());
            }
        }
        GenerateImage();
    }
    @Override
    public Ray CreateRay(Point2D p) {

        direction =
               new Vector3D(u.multiplyAWithVector(p.getX())
                       .add(v.multiplyAWithVector(p.getY()))
                       .sub(w.multiplyAWithVector(distance)));
        direction.normalise();
        eye.setX(eye.getX() * Scene.vp.getPixelSize());
        eye.setY(eye.getY() * Scene.vp.getPixelSize());
        eye.setZ(eye.getZ() * Scene.vp.getPixelSize());
        return new Ray(this.eye, direction);
    }
    public double getDistance(Point3D p1, Point3D p2){
        double x = p1.getX() - p2.getX();
        double y = p1.getY() - p2.getY();
        double z = p1.getZ() - p2.getZ();

        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2));

    }
    public void GenerateImage() {
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