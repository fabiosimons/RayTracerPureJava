package Material;

import Utility.Color;
import Utility.RayHit;

public abstract class Material {
    public Material(){

    }
    public abstract Color shade(RayHit rayhit);

}
