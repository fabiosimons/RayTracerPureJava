package Tracer;

import Utility.Color;
import Utility.Ray;
import Utility.RayHit;
import World.Scene;

public class ManyObjects extends RayTracer {
    RayHit r;

    public ManyObjects(Scene s){
        super(s);
    }

    @Override
    public Color TraceRay(Ray ray) {
        r = s.HitObjects(ray);
        if(r.Hit()){
            return r.getColor();
        }
        else{
            return super.TraceRay(ray);
        }

    }
}
