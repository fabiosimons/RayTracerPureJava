package GeometricObjects;

import Utility.Point3D;
import Utility.Ray;
import Utility.RayHit;

public class Triangle extends Object {
    @Override
    public double intersect(Ray ray, RayHit rayhit) {
        return 0;
    }

    @Override
    public double shadowHit(Ray ray, RayHit rayHit) {
        return 0;
    }
}
