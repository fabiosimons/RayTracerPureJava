package Utility;

import java.awt.*;

public class Point2D {

    public double x, y;

    public Point2D(){
        setX(0.0);
        setY(0.0);
    }
    public Point2D(double x, double y){
        setX(x);
        setY(y);
    }

    //SETTERS AND GETTERS
    public void setY(double y) {
        this.y = y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
}
