package Texture;

import Utility.Color;
import Utility.RayHit;

public class NoTexture extends Texture {

    public NoTexture(Color color){
        this.color = color;
    }
    @Override
    public Color getColour(RayHit rayhit) {
        return this.color;
    }
}
