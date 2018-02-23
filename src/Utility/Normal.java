package Utility;

public class Normal {
    public double x, y, z;

    public Normal(){
        setX(0.0);
        setY(0.0);
        setZ(0.0);
    }
    public Normal(double x, double y, double z){
        setX(x);
        setY(y);
        setZ(z);
    }
    public Normal(Normal normal){
        setX(normal.getX());
        setY(normal.getY());
        setZ(normal.getZ());
    }

    // DOT PRODUCT
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

    // MINUS NORMAL
    public Normal invertNormal(Normal n){
        Normal normal = new Normal(-this.getX(), -this.getY(), -this.getZ());
        return normal;

    }
    public void equals(Vector3D v){
        setX(v.getX());
        setY(v.getY());
        setZ(v.getZ());
    }

    //add normal
    public Normal add(Normal n){
        Normal normal = new Normal(
                (this.getX() + n.getX()),
                this.getY() + n.getY(),
                this.getZ() + n.getZ());

        return normal;
    }
    public Vector3D add(Vector3D v){
        Vector3D  vector = new Vector3D (
                (this.getX() + v.getX()),
                this.getY() + v.getY(),
                this.getZ() + v.getZ());

        return vector;
    }

    // MULTIPLY NORMAL WITH A DOUBLE
    public Normal multiplyAWithNormal(double a){
        Normal normal = new Normal(
                (a * this.getX()),
                (a * this.getY()),
                (a * this.getZ())
        );
        return normal;
    }

    //

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
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setZ(double z) {
        this.z = z;
    }
}
