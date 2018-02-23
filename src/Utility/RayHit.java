package Utility;

import World.Scene;

public class RayHit {
    private Color color;
    public Point3D hitPoint;
    public Normal normal;
    private Scene s;
    private boolean hit;

    public RayHit(Scene s){
        setHit(false);
        setColor(new Color());
        setNormal(new Normal());
        setHitPoint(new Point3D());
        setScene(s);
    }


    public void setNormal(Normal normal){
        this.normal = normal;
    }
    public void setHit(boolean hit) {
        this.hit = hit;
    }
    public void setHitPoint(Point3D hitpoint){
        this.hitPoint = hitpoint;
    }
    public boolean Hit(){
        return this.hit;
    }
    public void setScene(Scene s){
        this.s = s;
    }
    public Color getColor(){
        return this.color;
    }
    public void setColor(Color color){
        this.color = color;

    }
}
