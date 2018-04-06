package Engine;

import Projection.Camera;
import Projection.Orthographic;
import Projection.Pinhole;
import Sampling.JitteredSampling;
import Sampling.Sampler;
import Tracer.RayTracer;
import Utility.Point3D;
import World.Scene;

public class Main {
    public static Scene s;
    public static Camera c;
    RayTracer tracer;


    public static void main(String[] args){

        s = new Scene(1920,1080,1.0f);
        //c = new Orthographic();

        c = new Pinhole(new Point3D(-200.0, 200.0,100.0),new Point3D(50.0,0.0,0.0), 60.0);
        c.render();
    }
}
