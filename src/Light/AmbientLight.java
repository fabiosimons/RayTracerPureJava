package Light;

import Utility.Color;
import Utility.Ray;
import Utility.RayHit;
import Utility.Vector3D;

public class AmbientLight extends Light {
    private double intensity;
    private Color color;


    public AmbientLight(Color color, double intensity){
        setColor(color);
        setIntensity(intensity);
    }
    @Override
    public Vector3D getDirection(RayHit rayhit) {
        return new Vector3D(0.0,0.0,0.0);
    }

    @Override
    public Color intensity(RayHit rayhit) {
        Color c = color.multiplyWithDouble(intensity);
        return c;
    }

    @Override
    public boolean shadow(RayHit rayhit, Ray ray) {
        return false;
    }

    @Override
    public Color getColor() {
        return null;
    }

    public void setIntensity(double intensity){
        this.intensity = intensity;
    }
    public void setColor(Color color){
        this.color = color;
    }

}
