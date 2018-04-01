package Projection;

import Utility.Point2D;
import Utility.Point3D;
import Utility.Ray;
import Utility.Vector3D;

public abstract class Camera {
    protected Point3D eye;
    protected Point3D lookat;
    protected Vector3D up = new Vector3D(0.0001234,1.0,0.01355);
    protected Vector3D u,v,w;
    protected double distance;

    public void computeUVW(){
        w = eye.sub(lookat);
        w.normalise();
        u = up.cross(w);
        u.normalise();
        v = w.cross(u);
    }
    public abstract void render();
    public abstract Ray CreateRay(Point2D p);

}
