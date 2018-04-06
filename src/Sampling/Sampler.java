package Sampling;

import Utility.Point2D;

import java.util.ArrayList;

public abstract class Sampler {
    public static int numOfSamples;
    public static int sampleSets;
    public static ArrayList<Point2D> diskSamples;

    public Sampler(int numOfSamples){
        setNumOfSamples(numOfSamples);
        setSampleSets(numOfSamples);
    }
    public abstract Point2D GenerateSamples(int row, int column, int x, int y);
    public void setNumOfSamples(int samples){
        this.numOfSamples = samples;

    }
    public void setSampleSets(int samples){
        this.sampleSets = (int) Math.sqrt(samples);
    }
    public static int getNumOfSamples(){
        return numOfSamples;
    }
    public static int getSampleSets(){
        return sampleSets;
    }
}
