package Texture;

import Utility.Color;
import Utility.RayHit;

public abstract class Texture {
    public Color color;
    public abstract Color getColour(RayHit rayhit);
}
