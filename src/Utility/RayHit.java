package Utility;

import World.Scene;
import Material.*;
import java.util.Vector;


public class RayHit {
    public Color color;
    public Point3D LocalHitPoint;
    public Point3D hitPoint;
    public Material material;
    public Scene s;
    public Normal normal;
    public boolean hit;
    public int depth; // IMPLEMENTED LATER FOR RECURSIVE RAY TRACING
    public Ray ray;
    public Vector3D direction;


    public RayHit(Scene s){
        setHit(false);
        setColor(new Color(0.0f,0.0f,0.0f));
        material = null;
        setScene(s);
        setDepth(0);

    }
    public RayHit(RayHit r){
        setHit(r.hit);
        setHitPoint(r.hitPoint);
        setLocalHitPoint(r.LocalHitPoint);
        setNormal(r.normal);
        setMaterial(r.material);
        setRay(r.ray);
        setDepth(r.depth);
        setDirection(r.direction);
        setScene(r.s);
    }
    public void setHit(boolean hit) {
        this.hit = hit;
    }
    public boolean Hit(){
        return this.hit;
    }
    public void setScene(Scene s){
        this.s = s;
    }
    public void setNormal(Normal n){
        this.normal = n;
    }
    public Color getColor(){
        return this.color;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public void setHitPoint(Point3D hitpoint) {
        this.hitPoint = hitpoint;
    }
    public void setLocalHitPoint(Point3D localHitPoint){
        this.LocalHitPoint = localHitPoint;
    }
    public void setRay(Ray r){
        this.ray = r;
    }
    public void setDepth(int depth){
        this.depth = depth;
    }
    public void setDirection(Vector3D direction){
        this.direction = direction;
    }
    public void setMaterial(Material material) {
        this.material = material;
    }
    public Material getMaterial(){
        return this.material;
    }
}
