package GeometricObjects;

import Material.Material;
import Utility.*;
import Utility.Color;
import Texture.*;

public class Plane extends Object {

    Point3D point;
    Normal normal;

    public Plane(Point3D point, Normal normal, Material material, Texture texture){
        this.point = new Point3D(point);
        this.normal = new Normal(normal);
        this.material = material;
        this.texture = texture;
    }
    @Override
    public double intersect(Ray ray, RayHit rayhit) {
        double t = point.sub(ray.getOrigin()).dot(normal) / ray.getDirection().dot(normal);

        if (t > 10E-9) {
            rayhit.normal = normal;
            return t;
        } else {
            return 0.0;
        }
    }

    @Override
    public double shadowHit(Ray ray) {
        double t = point.sub(ray.getOrigin()).dot(normal) / ray.getDirection().dot(normal);
        if (t > 10E-9) {
           return t;
        }
        return 0.0;
    }
}
