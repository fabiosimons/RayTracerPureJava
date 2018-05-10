package Tracer;

import Engine.Main;
import Sampling.RegularSampling;
import Sampling.Sampler;
import Utility.*;
import Utility.Color;
import World.Scene;

import static Engine.Main.c;


public class RayTracer{
    Color pixelColour;
    public static Scene s = Main.s;

    public Color trace(int x, int y) {
        pixelColour = new Color();
        RayHit rayhit;
        for (int row = 0; row < Main.sampler.getSampleSets(); row++) {
            for (int column = 0; column < Main.sampler.getSampleSets(); column++) {
                Point2D p = Main.sampler.GenerateSamples(row, column, x, y);
                Ray ray = Engine.Main.c.CreateRay(p);
                rayhit = s.traceObjects(ray);
                Color tempColour;
                if (rayhit.hit) {
                    rayhit.setRay(ray);
                    tempColour = rayhit.material.getColour(rayhit);
                } else {
                    tempColour = Scene.background_color;
                }
                pixelColour.add(tempColour);
            }
        }
        pixelColour = CorrectColour(pixelColour, Main.sampler.getNumOfSamples());
        return pixelColour;
    }

    public Color CorrectColour(Color colour, int samples){
        colour.divide(samples);
        if (colour.getR() > 1.0) {colour.setR(1.0f);}
        if(colour.getG() > 1.0) {colour.setG(1.0f);}
        if(colour.getB() > 1.0) {colour.setB(1.0f);}
        colour.convertTo255();
        return colour;
    }
}

