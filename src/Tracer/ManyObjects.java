package Tracer;

import Utility.Ray;
import Utility.RayHit;
import World.Scene;

import java.awt.*;

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
            return s.background_color;
        }
    }
}
