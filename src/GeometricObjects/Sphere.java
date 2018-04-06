package GeometricObjects;


import Utility.*;
import Utility.Color;
import Material.*;

public class Sphere extends Object {
    private double radius;
    private Point3D center;

    public Sphere(){

    }
    public Sphere(double radius, Material material){
        setRadius(radius);
        setMaterial(material);
    }
    public Sphere(Point3D center, double radius){
        setRadius(radius);
        setCenter(center);
    }

    @Override
    public double Hit(Ray ray, RayHit rayhit) {
        double a = ray.getDirection().dot(ray.getDirection());
        double b = 2 * ray.getOrigin().sub(getCenter()).dot(ray.getDirection());
        double c = ray.getOrigin().sub(getCenter()).dot(ray.getOrigin().sub(getCenter())) - getRadius() * getRadius();
        double t;
        double d = b * b - 4 * a * c;

        if (d < 0.0) {
            return 0.0;
        } else {
            t = (-b - Math.sqrt(d)) / (2.0 * a);
            if (t > 10e-9) {

                Vector3D x = new Vector3D(ray.getOrigin().sub(getCenter()));
                Vector3D y = new Vector3D(ray.getDirection().multiplyAWithVector(t));
                rayhit.normal = new Normal(x.add(y).divideWithDouble(getRadius()));
                rayhit.LocalHitPoint = ray.getOrigin().add(ray.getDirection().multiplyAWithVector(t));
                return t;
            }
                t = (-b - Math.sqrt(d)) / (2.0 * a);
                if (t > 10e-9) {

                    Vector3D x = new Vector3D(ray.getOrigin().sub(getCenter()));
                    Vector3D y = new Vector3D(ray.getDirection().multiplyAWithVector(t));
                    rayhit.normal = new Normal(x.add(y).divideWithDouble(getRadius()));
                    rayhit.LocalHitPoint = ray.getOrigin().add(ray.getDirection().multiplyAWithVector(t));
                    return t;
                }
            }

            return 0.0;
        }

    public void setCenter(Point3D center){
        this.center = center;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public Point3D getCenter(){
        return this.center;
    }
    public double getRadius(){
        return this.radius;
    }
    public Color getColor(){
        return this.color;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
    public Material getMaterial(){
        return material;
    }
}
