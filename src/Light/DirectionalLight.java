package Light;

import Utility.Color;
import Utility.RayHit;
import Utility.Vector3D;

public class DirectionalLight extends Light {
    private Color color;
    public double ls;
    public Vector3D direction;

    public DirectionalLight(){
        setLS(1.0);
        setColour(new Color(0.0f,0.0f,0.0f));
    }
    @Override
    public Vector3D getDirection(RayHit rayhit){
        return new Vector3D(direction.sub(rayhit.hitPoint));
    }
    @Override
    public Color intensity(RayHit rayHit) {
        return null;
    }
    public void setLS(double ls){
        this.ls = ls;
    }
    public void setColour(Color colour){
        this.color = colour;
    }
}
