package Projection;

import Tracer.RayTracer;
import Utility.*;
import World.Scene;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * ORTHOGRAPHIC RAY TRACING
 **/
public class Orthographic extends Camera {
    File image;
    BufferedImage buffer;

    public Orthographic(){
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
        Ray ray = new Ray();
        ray.setOrigin(new Point3D(Scene.vp.getPixelSize() * p.getX(), Scene.vp.getPixelSize() * p.getY(), 100));
        ray.setDirection(new Vector3D(0.0,0.0,-1.0));
        return ray;
    }
    public void GenerateImage(){
        try {
            ImageIO.write(buffer, "PNG", image);
        } catch (Exception e) {
            System.out.println("Can't output image");
        }
    }
}

