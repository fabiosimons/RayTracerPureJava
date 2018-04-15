package GeometricObjects;

import Utility.Ray;
import Utility.RayHit;
import Utility.Vector3D;

public class Cube extends Object {

    public Cube(Vector3D min, Vector3D max){


    }
    @Override
    public double intersect(Ray ray, RayHit rayhit) {
        return 0;
    }

    @Override
    public double shadowHit(Ray ray, RayHit rayHit) {
        return 0;
    }
}
