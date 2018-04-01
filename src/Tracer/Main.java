package Tracer;

import Projection.Camera;
import Projection.Orthographic;
import Projection.Pinhole;
import Sampling.JitteredSampling;
import Sampling.Sampler;
import Utility.Point3D;
import World.Scene;

public class Main {
    Scene s;
    static Camera c;
    RayTracer tracer;


    public static void main(String[] args){

        Scene s = new Scene(800,800,2.0f);
        c = new Orthographic();

        //Camera c = new Pinhole(new Point3D(0.0,0.0,100),new Point3D(0.0,0.0,0.0), 100);
        c.render();
    }
}
