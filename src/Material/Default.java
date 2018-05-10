package Material;

import Texture.Texture;
import Utility.Color;
import Utility.RayHit;

public class Default extends Material {

    public Default(){ }
    @Override
    public Color getColour(RayHit rayhit) {
        return rayhit.texture.getColour(rayhit);
    }
}
