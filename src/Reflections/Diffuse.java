package Reflections;

import Utility.Color;
import Utility.RayHit;
import Utility.Vector3D;

public class Diffuse {
    private double coefficient;

    public Diffuse(double coefficient){
        this.coefficient = coefficient;

    }
    /**
     * To get diffuse reflection we use the equation:
     * diffuse coefficient * (direction towards each light source DOT surface normal)
     * @param rayhit
     * @param incomingRay
     * @return
     */
    public Color reflect(RayHit rayhit, Vector3D incomingRay) {
        return new Color(rayhit.texture.getColour(rayhit)
                .multiplyWithDouble(coefficient * (incomingRay.dot(rayhit.normal))));
    }




}
