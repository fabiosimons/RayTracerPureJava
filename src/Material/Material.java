package Material;

import Utility.Color;
import Utility.RayHit;

public abstract class Material {
    public abstract Color getColour(RayHit rayhit);
}
