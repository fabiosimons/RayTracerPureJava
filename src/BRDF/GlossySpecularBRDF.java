package BRDF;

import Utility.Color;
import Utility.Normal;
import Utility.RayHit;
import Utility.Vector3D;

public class GlossySpecularBRDF extends BRDFS {
    public Color colour;
    public double coefficient;
    public double shininessConstant;


    /**
     * specular reflection equation is:
     * Specular Coefficient * (perfect reflected ray of light direction DOT direction towards camera) ^ shininess constant
     * to get the "perfect reflected ray of light direction" we must use the equation:
     * rayOfLight = 2 * ( direction towards each light source DOT surface normal) * surface normal - direction towards each light source.
     * @param rayhit
     * @param reflectedRay
     * @param incomingRay
     * @return
     */
    @Override
    public Color Reflection(RayHit rayhit, Vector3D reflectedRay, Vector3D incomingRay) {
        Color c = new Color();
        double x = 2 * reflectedRay.dot(rayhit.normal);
        Normal normal = rayhit.normal.multiplyAWithNormal(x);
        Vector3D minusIncomingRay =
               new Vector3D(-incomingRay.getX(),-incomingRay.getY(),-incomingRay.getZ());
        Vector3D r = minusIncomingRay.add(normal);
        double RmDotV = r.dot(reflectedRay);

        // needs to be more than 0 otherwise it will just return black and we've already accounted for this.
        if(RmDotV > 0.0){
            c = colour.multiplyWithDouble(coefficient * Math.pow(RmDotV,shininessConstant));
        }
        return c;
    }
    public void setColour(Color colour){
        this.colour = colour;
    }
    public void setCoefficient(double coefficient){
        this.coefficient = coefficient;
    }
    public void setShininessConstant(double shininessConstant){
        this.shininessConstant = shininessConstant;
    }

}
