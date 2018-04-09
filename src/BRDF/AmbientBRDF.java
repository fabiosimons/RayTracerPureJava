package BRDF;

import Utility.Color;
import Utility.RayHit;
import Utility.Vector3D;

public class AmbientBRDF extends BRDFS{
    public double coefficient;
    public Color colour;

    @Override
    public Color Reflection(RayHit rayhit, Vector3D reflectedRay, Vector3D incomingRay) {
        return new Color(colour.multiplyWithDouble(coefficient));
    }
    public Color ReflectionWithoutRay(){
        return new Color(colour.multiplyWithDouble(coefficient));
    }
    public void setColour(Color c){
        this.colour = c;
    }
    public void setCoefficient(double coefficient){
        this.coefficient = coefficient;
    }
}
