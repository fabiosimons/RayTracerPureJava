package Reflections;

import Utility.Color;
import Utility.RayHit;
import Utility.Vector3D;

public class Specular {
    private double coefficient;
    private int shininess;

    public Specular(double coefficient, int shininess){
        this.coefficient = coefficient;
        this.shininess = shininess;
    }
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
    public Color reflect(RayHit rayhit, Vector3D reflectedRay, Vector3D incomingRay) {
        Color c = new Color();
        double rDotReflected = reflectedRay.dot(rayhit.normal.multiplyAWithNormal(2).multiplyAWithNormal(incomingRay.dot(rayhit.normal)).sub(incomingRay));
        // needs to be more than 0 otherwise it will just return black and we've already accounted for this.
        if(rDotReflected > 0.0){
            c = rayhit.texture.getColour(rayhit).multiplyWithDouble(coefficient * Math.pow(rDotReflected, shininess));
        }
        return c;
    }




}
