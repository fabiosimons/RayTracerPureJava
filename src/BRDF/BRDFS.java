package BRDF;

import Utility.Color;
import Utility.RayHit;
import Utility.Vector3D;

public abstract class BRDFS {

    public abstract Color Reflection(RayHit rayhit, Vector3D reflectedRay, Vector3D incomingRay);
}
