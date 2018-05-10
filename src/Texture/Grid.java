package Texture;

import Utility.Color;
import Utility.RayHit;

public class Grid extends Texture {
    private Color color1;
    private Color color2;
    private int size;

    public Grid(Color color1, Color color2, int size){
        this.color1 = color1;
        this.color2 = color2;
        this.size = size;
    }
    @Override
    public Color getColour(RayHit rayhit) {
        double rand = -0.000000023;
        double x = rayhit.hitPoint.getX() + rand;
        double y = rayhit.hitPoint.getY() + rand;
        double z = rayhit.hitPoint.getZ() + rand;
        int xyz = (int) Math.floor(x / size) +  (int) Math.floor(y / size) + (int) Math.floor(z / size);
        if((xyz) % 2 == 0){
            return color1;
        } else {
            return color2;
        }
    }
}
