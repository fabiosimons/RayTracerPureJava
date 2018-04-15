package World;

import Engine.RenderInRealTime;
import GeometricObjects.Object;
import GeometricObjects.Plane;
import GeometricObjects.Sphere;
import Light.*;
import Material.*;
import Engine.Main;
import Utility.*;
import Utility.Color;

import java.awt.*;
import java.util.ArrayList;


public class Scene {
    public static ViewPlane vp;
    public static Color background_color = new Color(0.0f,0.4f,1.0f);
    private Sphere sphere;
    private Plane plane;
    public Light ambient;
    public static PhongModel phong;
    public static Reflective reflective;
    public static Matte matte;
    public PointLight light;
    public static ArrayList<Object> objects;
    public static ArrayList<Light> lights;
    public static RenderInRealTime r;

    // DEFAULT CONSTRUCTOR
    public Scene(int width, int height, float pixelSize){
        vp = new ViewPlane(width, height, pixelSize);
        objects = new ArrayList<>();
        lights = new ArrayList<>();

        ambient = new AmbientLight(new Color(1.0f,1.0f,1.0f), 0.5);
        addLight(ambient);

        light = new PointLight(new Color(1.0f,1.0f,1.0f),3,new Vector3D(0,350,250));
        addLight(light);

        phong = new PhongModel();
        phong.setCoefficients(0.1,0.4, 0.1);
        phong.setColour(new Color(1.0f,0.0f,0.0f));

        reflective = new Reflective();
        reflective.setCoefficient(0.1);
        reflective.setColour(new Color(0.0f,1.0f,0.0f));

        sphere = new Sphere(new Point3D(0.0,100.0,0.0), 70);
        sphere.material = phong;
        addObject(sphere);

        sphere = new Sphere(new Point3D(200.0,100.0,0.0), 70);
        sphere.material = reflective;
        addObject(sphere);

        //Reflective sphere
        sphere = new Sphere(new Point3D(100.0,150.0,-150.0), 70);
        sphere.material = reflective;
        addObject(sphere);

        // floor
        matte = new Matte();
        matte.setCoefficients(0.2,0.5);
        matte.setColour(new Color(0.1f,0.8f,0.5f));
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
        Normal normal = new Normal();
        RayHit rayhit = new RayHit(Main.s);
        double tInfinity = Double.MAX_VALUE;

        for(Object o : objects){
            double temp = o.intersect(ray, rayhit);
            if(temp != 0 && temp < tInfinity){
                rayhit.setHit(true);
                tInfinity = temp;
                rayhit.setMaterial(o.material);
                rayhit.setHitPoint(ray.getOrigin().add(ray.getDirection().multiplyAWithVector(temp)));
                normal = rayhit.normal;
            }
        }
        if(rayhit.hit){
            rayhit.normal = normal;
        }else{
            rayhit.setColor(background_color);
        }
        return rayhit;
    }
    }
