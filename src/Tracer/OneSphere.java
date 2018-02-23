package Tracer;

import Utility.Color;
import Utility.Ray;
import World.Scene;

public class OneSphere extends RayTracer {

    public OneSphere(Scene s) {
        super(s);
    }

    @Override
    public Color TraceRay(Ray ray) {
        if(s.sphere.Hit(ray))
        {
            return(s.sphere.getColor());
        }
        return super.TraceRay(ray);
    }
}
