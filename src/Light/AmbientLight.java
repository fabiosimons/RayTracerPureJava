package Light;

import Utility.Color;
import Utility.RayHit;
import Utility.Vector3D;

public class AmbientLight extends Light {

    public double ls;
    public Color color;

    public AmbientLight(){
        super();
        ls = 1.0;
        color = new Color(255.0f,255.0f,255.0f);
    }

    @Override
    public Vector3D getDirection(RayHit rayhit) {
        return new Vector3D(0.0,0.0,0.0);
    }

    @Override
    public Color incidentRadiance(RayHit rayhit) {
        this.color.multiplyWithDouble(ls);
        return this.color;
    }

}
