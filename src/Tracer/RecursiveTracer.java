package Tracer;

import Utility.Color;
import Utility.Ray;
import Utility.RayHit;
import World.Scene;

public class RecursiveTracer{
    private int depth = 3;

    public Color TraceRay(Ray ray, RayHit rayhit) {
        if(rayhit.depth > this.depth) // incase of two reflective objects endlessly recursing
        {
            rayhit.depth = 0;
            return new Color();
        }
        else
            {
                rayhit.depth++;
                rayhit = Scene.traceObjects(ray);
                if(rayhit.hit) {
                    rayhit.setRay(ray);
                    return rayhit.getMaterial().shade(rayhit);
                }else{
                    return Scene.background_color;

            }
        }
    }
}
