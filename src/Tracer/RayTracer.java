package Tracer;

import Engine.Main;
import Sampling.RegularSampling;
import Sampling.Sampler;
import Utility.*;
import Utility.Color;
import World.Scene;

import static Engine.Main.c;


public class RayTracer {
    Color pixelColour;
    public static Scene s = Main.s;
    public static Sampler sample = new RegularSampling(64);

    public Color BasicTracer(int x, int y) {
        pixelColour = new Color();
        RayHit rayhit;

        for (int row = 0; row < Sampler.getSampleSets(); row++) {
            for (int column = 0; column < Sampler.getSampleSets(); column++) {
                Point2D p = sample.GenerateSamples(row, column, x, y);
                Ray ray = Engine.Main.c.CreateRay(p);
                rayhit = s.traceObjects(ray);
                Color tempColour;

                if (rayhit.hit) {
                    rayhit.setRay(ray);
                    tempColour = rayhit.material.shade(rayhit);
                } else {
                    tempColour = Scene.background_color;
                }

                pixelColour.add(tempColour);
            }
        }
        pixelColour.divide(Sampler.getNumOfSamples());
        pixelColour = checkBoundary(pixelColour);

        return pixelColour;
    }

    public Color checkBoundary(Color pixelColour){
        if (pixelColour.getR() > 255.0)
            pixelColour.setR(255.0f);
        if(pixelColour.getG() > 255.0)
            pixelColour.setG(255.0f);
        if(pixelColour.getB() > 255.0)
            pixelColour.setB(255.0f);

        return pixelColour;
    }
}

