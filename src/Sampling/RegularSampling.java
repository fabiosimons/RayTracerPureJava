package Sampling;

import Utility.Point2D;
import World.Scene;

public class RegularSampling extends Sampler {

    public RegularSampling(int numOfSamples) {
        super(numOfSamples);
        System.out.println("Regular Sampling enabled");
    }
    @Override
    public Point2D GenerateSamples(int row, int column, int x, int y) {

        double i = x - Scene.vp.getHorizontalRes() / 2 + (column + 0.5) / numOfSamples;
        double j = y - Scene.vp.getVerticalRes() / 2 + (row + 0.5) / numOfSamples;

        return new Point2D(i, j);
    }

}
