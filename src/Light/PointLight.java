package Light;

import Utility.Color;
import Utility.RayHit;
import Utility.Vector3D;

//NEEDS WORK, NOT ALL COLOURED SPHERES WORK IF IT ISNT A WHITE LIGHT;
//OKAY FOR NOW AS I ONLY INTEND TO WORK WITH WHITE LIGHT UNLESS THERE IS MORE TIME.

public class PointLight extends Light {
    private double ls;
    private Color color;
    private Vector3D location;

    public PointLight(Color color, double ls, Vector3D location){
        setColor(color);
        setLs(ls);
        setLocation(location);
    }
    @Override
    public Vector3D getDirection(RayHit rayhit) {
        Vector3D vector = new Vector3D(location.sub(rayhit.hitPoint));
        vector.normalise();
        return vector;
    }
    @Override
    public Color intensity(RayHit rayhit) {
        color.multiplyWithDouble(ls);
        return color;
    }
    public void setLs(double ls){
        this.ls = ls;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public void setLocation(Vector3D location){
        this.location = location;
    }
}
