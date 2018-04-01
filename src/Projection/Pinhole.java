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

public class Pinhole extends Camera {

    @Override
    public void render() {

    }

    @Override
    public Ray CreateRay(Point2D p) {
        return null;
    }
}
/**
    RayTracer tracer = new RayTracer();
    double distance;
    public Pinhole(Point3D eye, Point3D lookat, double FOV){
        this.eye = new Point3D(eye);
        this.lookat = lookat;
        this.distance = Scene.vp.verticalRes/2/Math.tan(Math.toRadians(FOV));
        computeUVW();
    }
    @Override
    public void render() {
        Color L = new Color();
        ViewPlane vp = Scene.vp;
        Ray ray = new Ray();
        int depth = 0;
        Point2D sp;
        Point2D pp = new Point2D();
        Sampler sample = new JitteredSampling(64);

        File image = new File("Traced.png");
        BufferedImage buffer = new BufferedImage(Scene.vp.getHorizontalRes(), Scene.vp.getVerticalRes(), BufferedImage.TYPE_INT_RGB);

        ray.setOrigin(eye);

        for (int i = 0; i < vp.getVerticalRes(); i++) {

            for (int j = 0; j < vp.getHorizontalRes(); j++) {

                for (int k = 0; k < Sampler.getSampleSets(); k++) {

                      for (int z = 0; z < Sampler.getSampleSets(); z++) {
                          sp = sample.GenerateSamples(i, j);
                          ray = CreateRay(i, j, pp, sp);
                          L.add(tracer.PerspectiveTracer(ray, depth));
                      }
                      }
                L.divide(Sampler.getNumOfSamples());
                buffer.setRGB(i,Scene.vp.getVerticalRes() - j - 1, L.toInt());
            }
        }
        try {
            ImageIO.write(buffer, "PNG", image);
        } catch (Exception e) {
            System.out.println("Can't output image");
        }
    }
    public Ray CreateRay(int i, int j, Point2D xy, Point2D sp){
       // xy.x =  (i - 0.5 * Scene.vp.getHorizontalRes()) ;
       // xy.y =  (j - 0.5 * Scene.vp.getVerticalRes());
        xy.x = sp.getX();
        xy.y = sp.getY();

        Vector3D direction = new Vector3D(u.multiplyAWithVector(xy.x).add(v.multiplyAWithVector(xy.y).sub(w.multiplyAWithVector(distance))));
        direction.normalise();

        Ray ray = new Ray(eye,direction);

        return ray;
    }
}
**/