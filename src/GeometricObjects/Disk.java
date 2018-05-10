package GeometricObjects;

import Material.Material;
import Utility.Normal;
import Utility.Point3D;
import Utility.Ray;
import Utility.RayHit;
import Texture.*;

public class Disk extends Object {
    Point3D center;
    double radius;
    Normal normal;

    public Disk(Point3D center, double radius, Normal normal, Material material, Texture texture){
        this.center = center;
        this.radius = radius;
        this.normal = normal;
        this.material = material;
        this.texture = texture;
    }
    @Override
    public double intersect(Ray ray, RayHit rayhit) {
        double t = center.sub(ray.getOrigin()).dot(normal) / ray.getDirection().dot(normal);

        if(t < 10E-9){
            return 0;
        }

        Point3D hit = ray.getOrigin().add(ray.getDirection().multiplyAWithVector(t));

        if(distance(center, hit) <  (radius)){
            rayhit.normal = this.normal;
            return t;
        }

        return 0;
    }
    public double distance(Point3D p1, Point3D p2){
        double x = Math.pow(p1.getX() - p2.getX(), 2);
        double y = Math.pow(p1.getY() - p2.getY(), 2);
        double z = Math.pow(p1.getZ() - p2.getZ(), 2);
        return Math.sqrt(x + y + z);
    }
    @Override
    public double shadowHit(Ray ray) {
        double t = center.sub(ray.getOrigin()).dot(normal) / ray.getDirection().dot(normal);

        if(t < 10E-9){
            return 0;
        }
        Point3D hit = ray.getOrigin().add(ray.getDirection().multiplyAWithVector(t));

        if(distance(center, hit) <  (radius)){
            return t;
        }
        return 0;
    }

}
