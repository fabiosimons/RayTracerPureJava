package GeometricObjects;


import Utility.Color;
import Utility.Ray;
import Utility.RayHit;


public abstract class Object {

    public Color color;
    public double tmin;
    public abstract double Hit(Ray ray);
}
