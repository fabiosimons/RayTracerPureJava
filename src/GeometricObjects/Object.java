package GeometricObjects;


import Material.Material;
import Utility.Color;
import Utility.Ray;
import Utility.RayHit;


public abstract class Object {

    public Color color;
    public Material material;
    public abstract double Hit(Ray ray, RayHit rayhit);
}
