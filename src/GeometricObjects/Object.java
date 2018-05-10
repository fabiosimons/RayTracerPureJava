package GeometricObjects;


import Material.Material;
import Utility.Color;
import Utility.Ray;
import Utility.RayHit;
import Texture.*;


public abstract class Object {

    public Color color;
    public Material material;
    public Texture texture;
    public abstract double intersect(Ray ray, RayHit rayhit);
    public abstract double shadowHit(Ray ray);
}
