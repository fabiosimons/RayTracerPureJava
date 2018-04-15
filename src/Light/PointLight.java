package Light;

import Utility.*;
import World.Scene;

//NEEDS WORK, NOT ALL COLOURED SPHERES WORK IF IT ISNT A WHITE LIGHT;
//OKAY FOR NOW AS I ONLY INTEND TO WORK WITH WHITE LIGHT UNLESS THERE IS MORE TIME.

public class PointLight extends Light {
    private double ls;
    private Color color;
    protected Vector3D location;

    public PointLight(Color color, double ls, Vector3D location){
        super();
        setColor(color);
        setLs(ls);
        setLocation(location);
    }
    @Override
    public Vector3D getDirection(RayHit rayhit) {
        Vector3D vector = new Vector3D(location.sub(rayhit.hitPoint));
        vector.normalise();
        return vector;
    }
    @Override
    public Color intensity(RayHit rayhit) {
        color.multiplyWithDouble(ls);
        return color;
    }
    public void setLs(double ls){
        this.ls = ls;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public void setLocation(Vector3D location){
        this.location = location;
    }

    public Vector3D getLocation() {
        return location;
    }
    public boolean shadow(RayHit rayhit, Ray ray){
            double distance = distance(ray.getOrigin(), getLocation());
            for(GeometricObjects.Object o : Scene.objects){
                double temp = o.shadowHit(ray,rayhit);
                if (temp != 0 && temp < distance){
                    return true;
            }
        }

        return false;
    }
    public double distance(Point3D p, Vector3D v){
        return Math.sqrt(Math.pow(p.getX() - v.getX(),2) +
                Math.pow(p.getY() - v.getY(),2));

    }
}
