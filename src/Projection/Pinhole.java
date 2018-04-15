package Projection;


import Tracer.RayTracer;
import Utility.*;
import Utility.Color;
import World.Scene;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * PERSPECTIVE RAY TRACING
 */
public class Pinhole extends Camera {
    private File image;
    private BufferedImage buffer;

    public Pinhole(Point3D eye, Point3D lookat, double FOV){
        this.eye = new Point3D(eye);
        this.lookat = new Point3D(lookat);
        this.distance = Scene.vp.getVerticalRes() / 2 / Math.tan(Math.toRadians(FOV));
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
                buffer.setRGB(width,Scene.vp.getVerticalRes()-height-1,pixelColour.toInt());
            }
        }
        GenerateImage();
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

    public void GenerateImage() {
        try {
            ImageIO.write(buffer, "PNG", image);
        } catch (Exception e) {
            System.out.println("Can't output image");
        }
    }
}