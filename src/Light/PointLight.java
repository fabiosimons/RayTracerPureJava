package Light;

import Utility.Color;
import Utility.RayHit;
import Utility.Vector3D;

//NEEDS WORK, NOT ALL COLOURED SPHERES WORK IF IT ISNT A WHITE LIGHT;
//OKAY FOR NOW AS I ONLY INTEND TO WORK WITH WHITE LIGHT UNLESS THERE IS MORE TIME.

public class PointLight extends Light {
    public double ls;
    public Color color;
    public Vector3D location;


    @Override
    public Vector3D getDirection(RayHit rayhit) {
        Vector3D vector = location.sub(rayhit.hitPoint);
        vector.normalise();
        return vector;
    }

    @Override
    public Color incidentRadiance(RayHit rayhit) {
        color.multiplyWithDouble(ls);
        return color;
    }
}
