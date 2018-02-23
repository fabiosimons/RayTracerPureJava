package GeometricObjects;


import Utility.*;
import Utility.Color;

public class Sphere extends Object {
    private double radius;
    private Point3D m_center;

    public Sphere(double radius, Color color){
        setRadius(radius);
        setColor(color);
    }
    @Override
    public boolean Hit(Ray ray) {
        double a = ray.getDirection().dot(ray.getDirection());
        double b = 2 * ray.getDirection().dot(ray.getOrigin().sub(getCenter()));
        double c = ray.getOrigin().sub(getCenter()).dot(ray.getOrigin().sub(getCenter())) - getRadius() * getRadius();
        double t;
        double d = Math.pow(b,2) - 4 * a * c;

        if(d < 0.0){
            return false;
        }
        else {
            t = (-b - (Math.sqrt(d)) / ( 2.0 * a));
            if(t > 10e-9){
                return true;
            }
            t = (-b + (Math.sqrt(d)) / ( 2.0 * a));
            if(t > 10e-9){
                return true;
            }
        }
        return false;
    }

    public void setCenter(Point3D center){
        this.m_center = center;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public Point3D getCenter(){
        return this.m_center;
    }
    public double getRadius(){
        return this.radius;
    }
    public Color getColor(){
        return this.color;
    }
}
