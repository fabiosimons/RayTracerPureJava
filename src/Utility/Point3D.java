package Utility;

public class Point3D {
    private double x,y,z;

    public Point3D(){
        setX(0.0);
        setY(0.0);
        setZ(0.0);
    }
    public Point3D(double x, double y, double z){
        setX(x);
        setY(y);
        setZ(z);
    }
    public Point3D(Point3D point){
        setX(point.getX());
        setY(point.getY());
        setZ(point.getZ());
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

    //SUBTRACT
    public Point3D sub(Vector3D v){
        Point3D point = new Point3D(
                (this.getX()- v.getX()),
                (this.getY() - v.getY()),
                (this.getZ() - v.getZ())
        );
        return point;
    }
    public Vector3D sub(Point3D p){
        Vector3D vector = new Vector3D(
                (this.getX()- p.getX()),
                (this.getY() - p.getY()),
                (this.getZ() - p.getZ())
        );
        return vector;
    }

    //ADD
    public Point3D add(Vector3D v){
        Point3D point = new Point3D(
                (this.getX() + v.getX()),
                (this.getY() + v.getY()),
                (this.getZ() + v.getZ())
        );
        return point;
    }

    // MODULUS AND MODULUS SQUARED
    public double mod(){
        double x = (this.getX() * this.getX()) +
                (this.getY() * this.getY()) +
                (this.getZ() * this.getZ());
        x = Math.pow(x, 0.5);
        return x;
    }
    public double modSquared(){
        double x = (this.getX() * this.getX()) +
                (this.getY() * this.getY()) +
                (this.getZ() * this.getZ());
        return x;
    }

    // MULTIPLICATION OF A point AND A DOUBLE
    public Point3D multiplyAWithPoint(double a){
        Point3D point = new Point3D(
                (a * this.getX()),
                (a * this.getY()),
                (a * this.getZ())
        );
        return point;
    }

    // SETTERS AND GETTERS
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setZ(double z){
        this.z = z;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getZ(){
        return this.z;
    }
}
