package BRDF;

import Utility.Color;
import Utility.RayHit;
import Utility.Vector3D;

public class Lambertian extends BRDF {
    private double coefficient;    // diffuse coefficient
    private Color colour;    // diffuse colour
   // private double distributionFactor = this.coefficient * 1 / Math.PI;

    public Lambertian(){

    }

    @Override
    public Color Distribution() {
        return new Color(colour.multiplyWithDouble(coefficient * 1 / Math.PI));
    }
    @Override
    public Color rho() {
        return new Color(colour.multiplyWithDouble(coefficient));
    }
    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public void setColour(Color c) {
        this.colour = c;
    }
    public String toString(){
        return " RGB: " + colour.getR() + colour.getG() + colour.getB()+ " Coefficient: " + this.coefficient;
    }
}
