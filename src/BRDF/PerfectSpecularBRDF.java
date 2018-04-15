package BRDF;

import Utility.Color;
import Utility.Normal;
import Utility.RayHit;
import Utility.Vector3D;

import java.util.Vector;

public class PerfectSpecularBRDF extends BRDFS {
    private double coefficient;
    private Color colour;
    public Vector3D incomingRay;

    /**
     * similar to specular reflection except the rays are checked towards objects as well as light sources
     * @param rayhit
     * @param reflectedRay
     * @param incomingRay
     * @return
     */
    @Override
    public Color Reflection(RayHit rayhit, Vector3D reflectedRay, Vector3D incomingRay) {
        return new Color();
    }
    public Color ReflectionR(RayHit rayhit, Vector3D outgoingRay) {
        return new Color();
    }

    public void setCoefficient(double coefficient){
        this.coefficient = coefficient;
    }
    public void setColour(Color colour){
        this.colour = colour;
    }
    public void setIncomingRay(Vector3D incomingRay){
        this.incomingRay = incomingRay;
    }
}
