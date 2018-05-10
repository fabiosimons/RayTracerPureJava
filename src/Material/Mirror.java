package Material;

import Tracer.RecursiveTracer;
import Utility.*;

public class Mirror extends Material {
    private double reflectionRatio;
    private RecursiveTracer tracer;

    public Mirror(double reflectionratio){
        this.tracer = new RecursiveTracer();
        this.reflectionRatio = reflectionratio;

    }
    public Vector3D reflectedRay(Vector3D direction, Normal n) {
        // I - 2 * ( N . I ) * N
        return new Vector3D(direction.sub(n.multiplyAWithNormal(2 * (n.dot(direction)))));
    }

    @Override
    public Color getColour(RayHit rayhit) {
        Vector3D reflectedRay = reflectedRay(rayhit.ray.getDirection(), rayhit.normal);
        Ray reflect = new Ray(rayhit.hitPoint,reflectedRay);
        return tracer.TraceRay(reflect, rayhit).multiplyWithDouble(reflectionRatio);
    }
}
