package Utility;

import World.Scene;


public class RayHit {
    public Color color;
    public Point3D hitPoint;
    public Scene s;
    public Normal normal;
    public boolean hit;

    public RayHit(){
        setHit(false);
        setColor(new Color(0.0f,0.0f,0.0f));
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
    public Color getColor(){
        return this.color;
    }
    public void setColor(Color color){
        this.color = color;

    }
}
