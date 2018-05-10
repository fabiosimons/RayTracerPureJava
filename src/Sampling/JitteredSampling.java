package Sampling;

import GeometricObjects.Object;
import Utility.Color;
import Utility.Point2D;
import World.Scene;

import java.util.Random;

public class JitteredSampling extends Sampler {


    public JitteredSampling(int numOfSamples) {
        super(numOfSamples);
        System.out.println("Random Sampling enabled");
    }

    @Override
    public Point2D GenerateSamples(int row, int column, int x, int y) {
        Random rand = new Random();
        double i = x - Scene.vp.getVerticalRes() / 2 + (column + rand.nextDouble()) / getSampleSets();
        double j = y - Scene.vp.getHorizontalRes() / 2 + (row + rand.nextDouble()) / getSampleSets();
        return new Point2D(i, j);
    }
}

