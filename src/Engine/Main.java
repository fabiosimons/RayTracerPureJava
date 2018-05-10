package Engine;

import Projection.Camera;
import Projection.Orthographic;
import Projection.Pinhole;
import Sampling.JitteredSampling;
import Sampling.Sampler;
import Utility.Point3D;
import World.Scene;

public class Main {
    public static Scene s;
    public static Camera c;
    public static Sampler sampler;

    public static void main(String[] args){
        long start = System.currentTimeMillis();
        s = new Scene(800,800,1.0f);

        sampler = new JitteredSampling(128);
        System.out.println("Program has executed, please be patient.");
        c = new Pinhole(new Point3D(0.0, 200.0,500.0),new Point3D(0.0,200.0,0.0), 60.0);
        //c = new Orthographic(600);
        c.render();
        long time = (System.currentTimeMillis() - start) / 1000;
        System.out.println("Finished.");
        System.out.println("Time Taken: " + time + " seconds ");
    }

}
