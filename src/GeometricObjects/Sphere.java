package GeometricObjects;


import Utility.*;
import Utility.Color;

public class Sphere extends Object {
    private double radius;
    private Point3D center;

    public Sphere(){

    }
    public Sphere(double radius, Color color){
        setRadius(radius);
        setColor(color);
    }
    public Sphere(Point3D center, double radius, Color color){
        setRadius(radius);
        setColor(color);
        setCenter(center);
    }

    @Override
    public double Hit(Ray ray) {
        double a = ray.getDirection().dot(ray.getDirection());
        double b = 2 * ray.getDirection().dot(ray.getOrigin().sub(getCenter()));
        double c = ray.getOrigin().sub(getCenter()).dot(ray.getOrigin().sub(getCenter())) - getRadius() * getRadius();
        double t;
        double d = Math.pow(b, 2) - 4 * a * c;

        if (d < 0.0) {
            return 0.0;
        } else {
            t = (-b - (Math.sqrt(d)) / (2.0 * a));
            if (t > 10e-9) {
                return t;
            } else {
                //t = (-b + (Math.sqrt(d)) / ( 2.0 * a));
                // if(t > 10e-9){
                //     return t;
                // }
                return 0.0;
            }
        }
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
}
