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

    // ADD TWO VECTORS
    public Vector3D add(Vector3D v){
        Vector3D vector = new Vector3D(
                (this.getX()+ v.getX()),
                (this.getY() + v.getY()),
                (this.getZ() + v.getZ())
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

    // MULTIPLICATION OF A VECTOR AND A DOUBLE
    public Vector3D multiplyAWithVector(double a){
        Vector3D vector = new Vector3D(
                (a * this.getX()),
                (a * this.getY()),
                (a * this.getZ())
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
