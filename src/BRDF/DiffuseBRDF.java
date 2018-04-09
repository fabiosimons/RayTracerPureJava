package BRDF;

import Engine.Main;
import Utility.Color;
import Utility.RayHit;
import Utility.Vector3D;

public class DiffuseBRDF extends BRDFS {
    public Color colour;
    public double coefficient;

    /**
     * To get diffuse reflection we use the equation:
     * diffuse coefficient * (direction towards each light source DOT surface normal)
     * @param rayhit
     * @param reflectedRay
     * @param incomingRay
     * @return
     */
    @Override
    public Color Reflection(RayHit rayhit, Vector3D reflectedRay, Vector3D incomingRay) {
        double x = coefficient * (incomingRay.dot(rayhit.normal));
        return new Color(colour.multiplyWithDouble(x));
    }
    public void setColour(Color colour){
        this.colour = colour;
    }
    public void setCoefficient(double coefficient){
        this.coefficient = coefficient;
    }
}
