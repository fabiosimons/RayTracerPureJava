package GeometricObjects;

import Utility.Point3D;
import Utility.Ray;
import Utility.RayHit;

import java.awt.*;

//NEXT SHAPE CLASS TO BE IMPLEMENTED
public class Cylinder extends Object {
    private Point3D startPoint;
    private double radius;
    private Point3D endPoint;

    public Cylinder(){

    }
    public Cylinder(Point3D startpoint, Point3D endpoint, double radius){
        setStartPoint(startpoint);
        setRadius(radius);
        setEndPoint(endpoint);

    }
    @Override
    public double intersect(Ray ray, RayHit rayhit) {
        // equation of a cylinder
        // (q - p ( v, q - p) v ) ^ 2 - r ^ 2 ;
        // q = ray origin + direction * t

        Point3D axis = startPoint.sub(endPoint);
        return 0;
    }

    @Override
    public double shadowHit(Ray ray, RayHit rayHit) {
        return 0;
    }


    public void setEndPoint(Point3D endpoint){
        this.endPoint = endpoint;
    }
    public void setStartPoint(Point3D startpoint){
        this.startPoint = startpoint;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return this.radius;
    }


}
