package Light;

import Utility.Color;
import Utility.RayHit;
import Utility.Vector3D;

public class AmbientLight extends Light {

    private double ls;
    private Color color;


    public AmbientLight(Color color, double ls){
        super();
        setColor(color);
        setLs(ls);
    }
    @Override
    public Vector3D getDirection(RayHit rayhit) {
        return new Vector3D(0.0,0.0,0.0);
    }

    @Override
    public Color intensity(RayHit rayhit) {
        Color c = color.multiplyWithDouble(ls);
        return c;
    }
    public void setLs(double ls){
        this.ls = ls;
    }
    public void setColor(Color color){
        this.color = color;
    }

}
