package World;

import GeometricObjects.Object;
import GeometricObjects.Plane;
import GeometricObjects.Sphere;
import Light.*;
import Material.*;
import Engine.Main;
import Utility.*;
import Utility.Color;

import java.util.ArrayList;


public class Scene {
    public static ViewPlane vp;
    public static Color background_color = new Color(0.0f,0.0f,0.0f);
    private Sphere sphere;
    private Plane plane;
    public AmbientLight ambient;
    private Matte matte;
    private static ArrayList<Object> objects;
    public static ArrayList<Light> lights;

    // DEFAULT CONSTRUCTOR
    public Scene(int width, int height, float pixelSize){
        vp = new ViewPlane(width, height, pixelSize);
        objects = new ArrayList<>();
        lights = new ArrayList<>();

        matte = new Matte();
        matte.setCoefficients(0.1,0.9);
        matte.setColour(new Color(255.0f,0.0f,0.0f));

        ambient = new AmbientLight();
        ambient.ls = 1.0;
        ambient.color = new Color(255.0f,255.0f,255.0f);
        addLight(ambient);

        PointLight light = new PointLight();
        light.location = (new Vector3D(100,50,150));
        light.ls = 3;
        light.color = new Color(255.0f,255.0f,255.0f);
        addLight(light);

        sphere = new Sphere(new Point3D(200.0,0.0,0.0),100);
        sphere.material = matte;
        addObject(sphere);

        sphere = new Sphere(new Point3D(0.0,0.0,0.0),100);
        sphere.material = matte;
        addObject(sphere);

        matte = new Matte();
        matte.setCoefficients(0.1,0.9);
        matte.setColour(new Color(0.0f,255.0f,255.0f));
        sphere = new Sphere(new Point3D(-200.0,0.0,0.0),100);
        sphere.material = matte;
        addObject(sphere);

        matte = new Matte();
        matte.setCoefficients(0.1,0.9);
        matte.setColour(new Color(0.0f,0.0f,255.0f));
        sphere = new Sphere(new Point3D(400.0,0.0,0.0),100);
        sphere.material = matte;
        addObject(sphere);

        matte = new Matte();
        matte.setCoefficients(0.1,0.9);
        matte.setColour(new Color(200.0f,150.0f,125.0f));
        plane = new Plane(new Point3D(0.0,0.0,0.0), new Normal(0.0,1.0,0.2));
        plane.material = matte;

        addObject(plane);


    }
    // ADD OBJECTS TO SCENE (arraylist)
    public void addObject(Object object){
        objects.add(object);
    }
    public void addLight(Light light){
        lights.add(light);
    }

    public static RayHit traceObjects(Ray ray){
        RayHit rayhit = new RayHit(Main.s);
        Normal normal = new Normal();
        Point3D localHitPoint = new Point3D();

        double tmin = Double.MAX_VALUE;

        for(Object o : objects){
            double temp = o.Hit(ray, rayhit);
            if(temp != 0 && temp < tmin){
                rayhit.setHit(true);
                tmin = temp;
                rayhit.setColor(o.color);
                rayhit.setMaterial(o.material);
                rayhit.setHitPoint(ray.getOrigin().add(ray.getDirection().multiplyAWithVector(temp)));
                normal = rayhit.normal;
                localHitPoint = rayhit.LocalHitPoint;
            }
        }
        if(rayhit.hit){
            rayhit.normal = normal;
            rayhit.LocalHitPoint = localHitPoint;
        }else{
            rayhit.setColor(background_color);
        }
        return rayhit;
    }
    }
