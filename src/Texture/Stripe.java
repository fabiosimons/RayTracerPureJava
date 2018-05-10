package Texture;

import Utility.Color;
import Utility.RayHit;

public class Stripe extends Texture {
    private Color color1;
    private Color color2;
    private double width;
    private int xyz;

    public Stripe(Color color1, Color color2, double width, int xyz){
        this.color1 = color1;
        this.color2 = color2;
        this.width = width;
        this.xyz = xyz;
    }

    public Color getColour(RayHit rayhit) {
        switch (xyz) {
            case 1:
                if (Math.sin(Math.PI * rayhit.hitPoint.getX() / width) > 0) {
                    return color1;
                } else {
                    return color2;
                }
            case 2:
                if (Math.sin(Math.PI * rayhit.hitPoint.getY() / width) > 0) {
                    return color1;
                } else {
                    return color2;
                }
            case 3:
                if (Math.sin(Math.PI * rayhit.hitPoint.getZ() / width) > 0) {
                    return color1;
                } else {
                    return color2;
                }
        }
        return color2;
    }
}
