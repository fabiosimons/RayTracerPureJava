package GeometricObjects;

import Utility.Color;
import Utility.Ray;
import Utility.RayHit;

public abstract class Object {

    public Color color;
    public abstract boolean Hit(Ray ray, double tmin, RayHit rayhit);

}
