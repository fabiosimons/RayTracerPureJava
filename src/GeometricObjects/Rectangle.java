package GeometricObjects;

import Material.Material;
import Utility.*;
import Texture.*;

public class Rectangle extends Object {
    private Point3D bottomleft;
    private Normal normal;
    private Vector3D aEdge, bEdge;
    private double a,b;

    public Rectangle(Point3D bottomleft, Point3D topLeft, Point3D bottomright
                     , Normal normal, Material material, Texture texture){
        this.bottomleft = bottomleft;
        this.normal = normal;
        this.material = material;
        this.texture = texture;
        this.aEdge = new Vector3D(bottomright.sub(bottomleft));
        this.bEdge = new Vector3D(topLeft.sub(bottomleft));
        this.a = Math.pow(distance(aEdge), 2);
        this.b = Math.pow(distance(bEdge), 2);
    }

    @Override
    public double intersect(Ray ray, RayHit rayhit) {
        double t = bottomleft.sub(ray.getOrigin()).dot(normal) / ray.getDirection().dot(normal);

        if(t < 10E-9){
            return 0;
        }

        Point3D p = ray.getOrigin().add(ray.getDirection().multiplyAWithVector(t));
        Vector3D hitloc = new Vector3D(p.sub(bottomleft));

        double hita = hitloc.dot(aEdge);
        double hitb = hitloc.dot(bEdge);

        if((hita < 0.0 || hita > a) || (hitb < 0.0 || hitb > b)){
            return 0;
        }

        rayhit.normal = this.normal;
        return t;
    }

    public double distance(Vector3D v){
        double x = Math.pow(v.getX(),2);
        double y = Math.pow(v.getY(),2);
        double z = Math.pow(v.getZ(),2);
        return Math.sqrt(x + y + z);
    }
    @Override
    public double shadowHit(Ray ray) {
        double t = bottomleft.sub(ray.getOrigin()).dot(normal) / ray.getDirection().dot(normal);
        if(t < 10E-9){
            return 0;
        }
        Point3D p = ray.getOrigin().add(ray.getDirection().multiplyAWithVector(t));
        Vector3D hitloc = new Vector3D(p.sub(bottomleft));

        double hita = hitloc.dot(aEdge);
        double hitb = hitloc.dot(bEdge);

        if((hita < 0.0 || hita > a) || (hitb < 0.0 || hitb > b)){
            return 0;
        }
        return t;
    }
}
