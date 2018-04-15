package Material;

import BRDF.AmbientBRDF;
import BRDF.DiffuseBRDF;
import Utility.Color;
import Utility.RayHit;

public abstract class Material {

    public abstract Color shade(RayHit rayhit);

}
