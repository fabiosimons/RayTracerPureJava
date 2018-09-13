package Engine;

import Projection.Camera;
import Projection.Orthographic;
import Projection.Pinhole;
import Sampling.JitteredSampling;
import Sampling.Sampler;
import Utility.Point3D;
import World.Scene;
import GUI.GUI;

public class Main {
    public static Scene s;
    public static Camera c;
    public static Sampler sampler;

    public static void main(String[] args){
        long start = System.currentTimeMillis();
        s = new Scene(600,600,1.0f);

        GUI gui = new GUI();





        sampler = new JitteredSampling(128);
        System.out.println("Program has executed, please be patient.");
        c = new Pinhole(new Point3D(0.0, 400.0,500.0),new Point3D(0.0,100.0,0.0), 60.0);
        //c = new Orthographic(600);
        c.render();
        long time = (System.currentTimeMillis() - start) / 1000;
        System.out.println("Finished.");
        System.out.println("Time Taken: " + time + " seconds ");
    }

}
