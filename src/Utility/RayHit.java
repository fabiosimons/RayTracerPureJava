package Utility;

import World.Scene;

import java.awt.*;

public class RayHit {
    private Color color;
    private Point3D hitPoint;
    private Scene s;
    private boolean hit;

    public RayHit(Scene s){
        setHit(false);
        setColor(new Color(0,0,0));
        setHitPoint();
    }


    public void setHit(boolean hit) {
        this.hit = hit;
    }
    public void setHitPoint(){
    }
    public boolean Hit(){
        return this.hit;
    }
    public void setScene(){
    }
    public Color getColor(){
        return this.color;
    }
    public void setColor(Color color){
        this.color = color;

    }
}
