package Projection;

import Sampling.JitteredSampling;
import Sampling.Sampler;
import Tracer.RayTracer;
import Utility.*;
import World.Scene;
import World.ViewPlane;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * PERSPECTIVE RAY TRACING
 */
public class Pinhole extends Camera {

    public Pinhole(Point3D eye, Point3D lookat, double FOV){
        this.eye = new Point3D(eye);
        this.lookat = new Point3D(lookat);
        this.distance = Scene.vp.getVerticalRes() / 2 / Math.tan(Math.toRadians(FOV));
        computeUVW();
    }

    @Override
    public void render() {
        File image = new File("Traced.png");
        BufferedImage buffer = new BufferedImage(Scene.vp.getHorizontalRes(),Scene.vp.getVerticalRes(), BufferedImage.TYPE_INT_RGB);
        RayTracer tracer = new RayTracer();
        Color pixelColour;

        for(int height = 0; height < Scene.vp.getVerticalRes(); height++){
            for(int width = 0; width < Scene.vp.getHorizontalRes(); width++){
                pixelColour = tracer.BasicTracer(width,height);
                buffer.setRGB(width,Scene.vp.getVerticalRes()-height-1,pixelColour.toInt());
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
        Ray ray;
        Vector3D direction =
               new Vector3D(u.multiplyAWithVector(p.getX()).add(v.multiplyAWithVector(p.getY())).sub(w.multiplyAWithVector(distance)));
        direction.normalise();

        eye.setX(eye.getX() * Scene.vp.getPixelSize());
        eye.setY(eye.getY() * Scene.vp.getPixelSize());
        eye.setZ(eye.getZ() * Scene.vp.getPixelSize());

        ray = new Ray(this.eye, direction);

        return ray;

    }
}