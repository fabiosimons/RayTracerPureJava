package Light;

import Utility.Color;
import Utility.Point3D;
import Utility.RayHit;
import Utility.Vector3D;

public abstract class Light {
    protected boolean shadows;

    public Light(){
    }
    public abstract Vector3D getDirection(RayHit rayHit);
    public abstract Color incidentRadiance(RayHit rayHit);
}
