package Tracer;

import Sampling.JitteredSampling;
import Sampling.RegularSampling;
import Sampling.Sampler;
import Utility.*;
import Utility.Color;
import World.Scene;
import GeometricObjects.Object;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static Tracer.Main.c;

public class RayTracer {
    Color pixelColour;
    Sampler sample = new JitteredSampling(4);

    public Color traceRay(int x, int y) {
        File image = new File("Traced.png");
        BufferedImage buffer = new BufferedImage(Scene.vp.getHorizontalRes(), Scene.vp.getVerticalRes(), BufferedImage.TYPE_INT_RGB);

        pixelColour = new Color();
        boolean hit = false;

        for (int row = 0; row < Sampler.sampleSets; row++) {
            for (int column = 0; column < Sampler.sampleSets; column++) {
                Point2D p = sample.GenerateSamples(row, column, x, y);
                Ray ray = c.CreateRay(p);

                double tmin = Double.MAX_VALUE;
                Color tempColour = Scene.background_color;

                for (Object o : Scene.objects) {
                    double temp = o.Hit(ray);
                    if (temp != 0.0 && temp < tmin) {
                        hit = true;
                        tmin = temp;
                        tempColour = o.color;
                    }
                }

                pixelColour.add(tempColour);
            }
        }
        return pixelColour;
    }
}
    /**
    public Color OrthographicTracer(int i, int j) {
        pixelColour = new Color();
        for(int k = 0; k < Sampler.getSampleSets(); k++) {
            for (int z = 0; z < Sampler.getSampleSets(); z++) {
                Color tempColour = Scene.background_color;
                Point2D xy = sample.GenerateSamples(i, j);
                Ray ray = new Ray(new Point3D(xy.x, xy.y, 100), new Vector3D(0.0, 0.0, -1.0));

                double tmin = Double.MAX_VALUE;
                for(Object o: Scene.objects){
                    double temp = o.Hit(ray);
                    if(temp != 0.0 && temp < tmin){
                        tempColour = o.color;
                        tmin = temp;
                    }
                }
                pixelColour.add(tempColour);
            }
        }
        return pixelColour;
    }
    public Color PerspectiveTracer(Ray ray, int depth){
        pixelColour = Scene.background_color;

        double tmin = Double.MAX_VALUE;
        for (Object o : Scene.objects) {
            double temp = o.Hit(ray);
            if (temp != 0 && temp < tmin) {
                pixelColour = o.color;
                tmin = temp;
            }
        }
        return pixelColour;
    }
     **/

