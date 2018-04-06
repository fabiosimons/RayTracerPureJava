package Projection;

import Sampling.Sampler;
import Tracer.RayTracer;
import Utility.*;
import World.Scene;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Orthographic extends Camera {
    @Override
    public void render() {
        File image = new File("Traced.png");
        BufferedImage buffer = new BufferedImage(Scene.vp.getHorizontalRes(), Scene.vp.getVerticalRes(), BufferedImage.TYPE_INT_RGB);
        RayTracer tracer = new RayTracer();
        Color pixelColour;

        for (int j = 0; j < Scene.vp.getVerticalRes(); j++) {
            for (int i = 0; i < Scene.vp.getHorizontalRes(); i++) {
                pixelColour = tracer.BasicTracer(i,j);
                buffer.setRGB(i,Scene.vp.getVerticalRes() - j - 1,pixelColour.toInt());
            }
        }
        try {
            ImageIO.write(buffer, "PNG", image);
        } catch (Exception e) {
            System.out.println("Can't output image");
        }
    }
    @Override
    public Ray CreateRay(Point2D p) {
        Ray ray = new Ray();
        ray.setOrigin(new Point3D(Scene.vp.getPixelSize() * p.getX(), Scene.vp.getPixelSize() * p.getY(), 100));
        ray.setDirection(new Vector3D(0.0,0.0,-1.0));
        return ray;
    }
}

