package Material;

import Tracer.RecursiveTracer;
import Utility.*;

public class Refractive extends Material{
    private double refractiveIndex;

    public Refractive(double refractiveIndex){
        this.refractiveIndex = refractiveIndex;

    }
    public Vector3D refractedRay(Ray ray, Normal normal){
        double index = 1;  // air refractive index
        double rIndex = refractiveIndex;
        Normal n = normal;
        double cos = ray.getDirection().dot(n);
        if(cos < 0){  // outside
            cos = -cos;
        }
        else {
            n = n.invertNormal();
            double temp = rIndex;
            rIndex = index;
            index = temp;
        }
        double nIndex = index / rIndex;
        return ray.getDirection().multiplyAWithVector(nIndex)
                .add(n.multiplyAWithNormal(nIndex * cos - 1 - Math.pow(nIndex,2) * 1 - cos * cos));
    }

    @Override
    public Color getColour(RayHit rayhit) {
        Vector3D refractedRay = refractedRay(rayhit.ray, rayhit.normal);
        RecursiveTracer tracer = new RecursiveTracer();
        Ray ray = new Ray(rayhit.hitPoint, refractedRay);
        Color temp = tracer.TraceRay(ray, rayhit);
        return temp;
    }


}
