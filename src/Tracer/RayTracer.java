package Tracer;

import Utility.Color;
import Utility.Ray;
import World.Scene;

public abstract class RayTracer {
    protected Scene s;
    private Color color;


    public RayTracer(){
        this.s = null;
    }
    public RayTracer(Scene s){
        this.s = s;
    }
    public Color TraceRay(Ray ray){
        this.color = new Color(0.0f,0.0f,0.0f);
        return color;
    }

}
