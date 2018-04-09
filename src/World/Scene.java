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
    public static Color background_color = new Color(0.0f,0.0f,0.0f);
    private Sphere sphere;
    private Plane plane;
    public Light ambient;
    public static PhongModel phong;
    public PointLight light;
    private static ArrayList<Object> objects;
    public static ArrayList<Light> lights;
    public static RenderInRealTime r;

    // DEFAULT CONSTRUCTOR
    public Scene(int width, int height, float pixelSize){
        vp = new ViewPlane(width, height, pixelSize);

        //r = new RenderInRealTime(width, height);

        objects = new ArrayList<>();
        lights = new ArrayList<>();

        phong = new PhongModel();
        phong.setCoefficients(0.1,0.4, 0.1);
        phong.setColour(new Color(1.0f,0.0f,0.0f));

        ambient = new AmbientLight(new Color(1.0f,1.0f,1.0f), 0.5);
        addLight(ambient);

        light = new PointLight(new Color(1.0f,1.0f,1.0f),3,new Vector3D(0,150,250));
        addLight(light);

        sphere = new Sphere(new Point3D(200.0,0.0,0.0),100);
        sphere.setMaterial(phong);
        addObject(sphere);

        phong = new PhongModel();
        phong.setCoefficients(0.5,0.2, 0.2);
        phong.setColour(new Color(0.0f,0.0f,1.0f));
        sphere = new Sphere(new Point3D(0.0,0.0,0.0),100);
        sphere.setMaterial(phong);
        addObject(sphere);

        phong = new PhongModel();
        phong.setCoefficients(0.2,0.7, 0.2);
        phong.setColour(new Color(1.0f,1.0f,0.0f));
        sphere = new Sphere(new Point3D(400.0,0.0,0.0),100);
        sphere.setMaterial(phong);
        addObject(sphere);

        phong = new PhongModel();
        phong.setCoefficients(0.1,0.4, 0.1);
        phong.setColour(new Color(0.5f,0.5f,0.5f));
        plane = new Plane(new Point3D(0.0,0.0,0.0), new Normal(0.0,1.0,0.2));
        plane.material = phong;
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
