package World;

import GeometricObjects.Object;
import GeometricObjects.Plane;
import GeometricObjects.Sphere;
import Utility.*;
import Utility.Color;
import java.awt.image.BufferedImage;

import java.util.ArrayList;


public class Scene {
    public static ViewPlane vp;
    public static Color background_color = new Color(0.0f,0.0f,0.0f);
    BufferedImage buffer;
    Sphere sphere,sphere2;
    Plane plane;
    public static ArrayList<Object> objects;

    // DEFAULT CONSTRUCTOR
    public Scene(int width, int height, float pixelSize){
        vp = new ViewPlane(width, height, pixelSize);
        objects = new ArrayList<>();

        sphere = new Sphere(100, new Color(255.0f,154.0f,0.0f));
        sphere.setCenter(new Point3D(100.0,100.0,0.0));
        addObject(sphere);

        sphere2 = new Sphere(100, new Color(0.0f,170.0f,0.0f));
        sphere2.setCenter(new Point3D(-100.0,0.0,0.0));
        addObject(sphere2);

        plane = new Plane(new Point3D(0.0,0.0,0.0), new Normal(0.0,1.0,0.2), new Color(100.0f,100.0f,0.0f));
        addObject(plane);
    }
    // ADD OBJECTS TO SCENE (arraylist)
    public void addObject(Object object){
        objects.add(object);
    }
}
