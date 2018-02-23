package GeometricObjects;

import Utility.*;

public class Sphere extends Object {
    private double radius;
    private Point3D m_center;

    public Sphere(double radius, Color color){
        setRadius(radius);
        setColor(new Color(color));
    }

    @Override
    public boolean Hit(Ray ray, double tmin, RayHit rayhit) {
       /* double t = 0;
        double a = ray.getDirection().dot(ray.getDirection());
        double b = 2 * ray.getDirection().dot(ray.getOrigin().sub(getCenter()));
        double c = ray.getOrigin().sub(getCenter()).dot(ray.getOrigin().sub(getCenter())) - getRadius() * getRadius();
        double d = Math.pow(b,2) - 4 * a * c;

        if(d < 0.0){
            return false;
        }
        else {
            t = (-b - (Math.sqrt(d)) / ( 2.0 * a));
            if(t > 10e-9){
                tmin = t;
                rayhit.setNormal();
                return true;
            }
            t = (-b + (Math.sqrt(d)) / ( 2.0 * a));
            if(t > 10e-9){
                return true;
            }
        }
        return false;
        */
        double t;
        Vector3D temp = ray.getOrigin().sub(getCenter());
        double a = ray.getDirection().dot(ray.getDirection());
        double b = 2.0 * temp.dot(ray.getDirection());
        double c = temp.dot(temp) - getRadius() * getRadius();
        double d = b * b - 4.0 * a * c;

        if (d < 0.0){
            return false;
        }
        else {
            double e = Math.sqrt(d);
            double x = 2.0 * a;
            t = (-b - e) / x;

            if(t > 10e-6){
                tmin = t;
                rayhit.normal.equals(temp.add(ray.getDirection().multiplyAWithVector(t)));
                rayhit.setHitPoint(ray.getOrigin().add(ray.getDirection().multiplyAWithVector(t)));
                return true;
            }
            t = (-b + e) / x;

            if(t > 10e-6){
                tmin = t;
                rayhit.normal.equals(temp.add(ray.getDirection().multiplyAWithVector(t)));
                rayhit.setHitPoint(ray.getOrigin().add(ray.getDirection().multiplyAWithVector(t)));
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
