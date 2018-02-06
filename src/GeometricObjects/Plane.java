package GeometricObjects;

import Utility.*;

public class Plane extends Object {

    Point3D point;
    Normal normal;

    public Plane(Point3D point, Normal normal, Color color){
        this.point = new Point3D(point);
        this.normal = new Normal(normal);
        this.color = new Color(color);

    }

    @Override
    public boolean Hit(Ray ray) {
        double t = point.sub(ray.getOrigin()).dot(normal)/ray.getDirection().dot(normal);

        if(t > 10E-9) {
            return true;
        }else{
            return false;
        }
    }
}
