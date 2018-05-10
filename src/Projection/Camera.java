package Projection;

import Utility.Point2D;
import Utility.Point3D;
import Utility.Ray;
import Utility.Vector3D;

public abstract class Camera {
    protected Point3D eye;
    protected Point3D lookat;
    protected Vector3D up = new Vector3D(0.004,1.0,0.005);
    protected Vector3D u,v,w;
    protected double distance;

    public Camera(){

    }
    public void computeUVW(){
        w = new Vector3D(eye.sub(lookat));   // eye to lookout
        w.normalise();

        u = new Vector3D(up.cross(w));     // y direction
        u.normalise();

        v = new Vector3D(w.cross(u));
    }
    public abstract void render();
    public abstract Ray CreateRay(Point2D p);

}
