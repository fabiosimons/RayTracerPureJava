package GeometricObjects;

import Utility.*;
import Utility.Color;

public class Plane extends Object {

    Point3D point;
    Normal normal;

    public Plane(Point3D point, Normal normal){
        this.point = new Point3D(point);
        this.normal = new Normal(normal);
    }
    public Color getColor(){
        return this.color;
    }

    @Override
    public double intersect(Ray ray, RayHit rayhit) {
        double t = point.sub(ray.getOrigin()).dot(normal) / ray.getDirection().dot(normal);

        if (t > 10E-9) {
            rayhit.normal = normal;
            rayhit.LocalHitPoint = ray.getOrigin().add(ray.getDirection().multiplyAWithVector(t));
            return t;
        } else {
            return 0.0;
        }
    }

    @Override
    public double shadowHit(Ray ray, RayHit rayHit) {
        double t = point.sub(ray.getOrigin()).dot(normal) / ray.getDirection().dot(normal);

        if (t > 10E-9) {
           return t;
        }
        return 0.0;
    }
}
