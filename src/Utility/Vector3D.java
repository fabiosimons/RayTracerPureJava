package Utility;

import java.util.Vector;

public class Vector3D {
    double x, y, z;

    public Vector3D(double x, double y, double z){
        setX(x);
        setY(y);
        setZ(z);
    }
    public Vector3D(Point3D point){
        setX(point.getX());
        setY(point.getY());
        setZ(point.getZ());
    }
    public Vector3D(Vector3D vector){
        setX(vector.getX());
        setY(vector.getY());
        setZ(vector.getZ());
    }
    public Vector3D(Normal normal){
        setX(normal.getX());
        setY(normal.getY());
        setZ(normal.getZ());
    }

    // ADD TWO VECTORS
    public Vector3D add(Vector3D v){
        Vector3D vector = new Vector3D(
                (this.getX()+ v.getX()),
                (this.getY() + v.getY()),
                (this.getZ() + v.getZ())
        );

        return vector;
    }
    public Vector3D add(Normal n){
        Vector3D vector = new Vector3D(
                (this.getX()+ n.getX()),
                (this.getY() + n.getY()),
                (this.getZ() + n.getZ())
        );

        return vector;
    }

    // SUBTRACT
    public Vector3D sub(Vector3D v){
            Vector3D vector = new Vector3D(
                    (this.getX()- v.getX()),
                    (this.getY() - v.getY()),
                    (this.getZ() - v.getZ())
            );
            return vector;
        }

    public Vector3D sub(Point3D p){
        Vector3D vector = new Vector3D(
                (this.getX()- p.getX()),
                (this.getY() - p.getY()),
                (this.getZ() - p.getZ())
        );
        return vector;
    }
    public Vector3D sub(Normal n){
        Vector3D vector = new Vector3D(
                (this.getX()- n.getX()),
                (this.getY() - n.getY()),
                (this.getZ() - n.getZ())
        );
        return vector;
    }

    // MULTIPLICATION OF A VECTOR AND A DOUBLE
    public Vector3D multiplyAWithVector(double a){
        Vector3D vector = new Vector3D(
                (a * this.getX()),
                (a * this.getY()),
                (a * this.getZ())
        );
        return vector;
    }

    // DIVIDE WITH DOUBLE
    public Vector3D divideWithDouble(double a){
        Vector3D vector = new Vector3D(
                (this.getX() / a),
                (this.getY() / a),
                (this.getZ() /a )
        );
        return vector;
    }

    //DOT PRODUCT
    public double dot(Vector3D v){
        double x =
                    (this.getX() * v.getX()) +
                    (this.getY() * v.getY()) +
                    (this.getZ() * v.getZ());

        return x;
    }
    public double dot(Point3D p){
        double x =
                (this.getX() * p.getX()) +
                (this.getY() * p.getY()) +
                (this.getZ() * p.getZ());

        return x;
    }
    public double dot(Normal n){
        double x =
                 (this.getX() * n.getX()) +
                 (this.getY() * n.getY()) +
                         (this.getZ() * n.getZ());

        return x;
    }

    //CROSS PRODUCT
    public Vector3D cross(Vector3D v){
        Vector3D vector = new Vector3D(((this.getY() * v.getZ()) - (this.getZ() * v.getY())),
                                       ((this.getZ() * v.getX()) - (this.getX() * v.getZ())),
                                       ((this.getX() * v.getY()) - (this.getY() * v.getX()))
        );

        return vector;

    }
    public void normalise(){
        double length = Math.sqrt(  Math.pow(getX(),2) +
                                    Math.pow(getY(),2) +
                                    Math.pow(getZ(),2));

        setX(getX()/length);
        setY(getY()/length);
        setZ(getZ()/length);
    }
    public Vector3D inverse(){
        return new Vector3D(-getX(),-getY(),-getZ());
    }
    public String toString(){
        return "X : " + getX() + " Y : " + getY()+ " Z: " + getZ();
    }

// SETTERS AND GETTERS
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getZ(){
        return this.z;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setZ(double z){
        this.z = z;
    }
}
