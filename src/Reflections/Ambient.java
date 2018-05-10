package Reflections;

import Utility.Color;
import Utility.RayHit;

public class Ambient {
    private double coefficient;


    public Ambient(double coefficient){
        this.coefficient = coefficient;
    }

    public Color reflect(RayHit rayhit) {
        return new Color(rayhit.texture.getColour(rayhit).multiplyWithDouble(coefficient));
    }
}
