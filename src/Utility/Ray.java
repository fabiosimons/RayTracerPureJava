package Utility;


public class Ray {
    private Point3D m_origin;
    private Vector3D m_direction;
    private Ray ray;

    public Ray(){

    }
    public Ray(Point3D origin, Vector3D direction){
        setOrigin(origin);
        setDirection(direction);
    }
    public Ray(Ray ray){
        setRay(ray);
    }

    //SETTERS AND GETTERS
    public void setRay(Ray ray){
        this.ray = ray;
    }
    public void setOrigin(Point3D origin){
        this.m_origin = origin;
    }
    public void setDirection(Vector3D direction){
        this.m_direction = direction;
    }
    public Vector3D getDirection(){
        return this.m_direction;
    }
    public Point3D getOrigin(){
        return this.m_origin;
    }
}
