package Material;

import BRDF.AmbientBRDF;
import BRDF.DiffuseBRDF;
import BRDF.PerfectSpecularBRDF;
import Light.Light;
import Tracer.RecursiveTracer;
import Utility.*;
import World.Scene;

public class Reflective extends Material {
    PerfectSpecularBRDF perfectSpecularBRDF;

    public Reflective(){
       perfectSpecularBRDF = new PerfectSpecularBRDF();
    }
    public void setCoefficient(double perfectspecular){
        perfectSpecularBRDF.setCoefficient(perfectspecular);
    }
    public void setColour(Color c){
        perfectSpecularBRDF.setColour(c);
    }
    public Vector3D reflectedRay(Vector3D direction ,Normal n){
        // I - 2 * ( N . I ) * N
       return new Vector3D(direction.sub(n.multiplyAWithNormal(2 * (n.dot(direction)))));
    }
    @Override
    public Color shade(RayHit rayhit) {
        Color temp;
        Vector3D reflectedRay = reflectedRay(rayhit.ray.getDirection(), rayhit.normal);
        //Vector3D outgoingRay = rayhit.ray.getDirection();
        RecursiveTracer tracer = new RecursiveTracer();
        Ray ray = new Ray(rayhit.hitPoint, reflectedRay);
        temp = tracer.TraceRay(ray, rayhit).multiplyWithDouble(0.8);

        return temp;
    }
}
