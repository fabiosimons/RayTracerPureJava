package Light;

import Utility.*;

public abstract class Light {
    protected boolean shadows;

    public Light(){
    }
    public abstract Vector3D getDirection(RayHit rayHit);
    public abstract Color intensity(RayHit rayHit);
    public abstract boolean shadow(RayHit rayhit, Ray ray);
}
