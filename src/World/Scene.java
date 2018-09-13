package World;

import GeometricObjects.*;
import GeometricObjects.Object;
import Light.*;
import Material.*;
import Engine.Main;
import Utility.*;
import Utility.Color;
import Texture.*;

import java.sql.Ref;
import java.util.ArrayList;


public class Scene {
    public static ViewPlane vp;
    public static Color background_color = new Color(0.0f,0.0f,1.0f);
    private Sphere sphere;
    public Texture stripe;
    public Light ambient;
    public static PhongModel phong;
    public static Matte matte;
    public PointLight light;
    public static ArrayList<Object> objects;
    public static ArrayList<Light> lights;

    // DEFAULT CONSTRUCTOR
    public Scene(int width, int height, float pixelSize) {
        vp = new ViewPlane(width, height, pixelSize);
        objects = new ArrayList<>();
        lights = new ArrayList<>();

        ambient = new AmbientLight(new Color(1.0f, 1.0f, 1.0f), 0.5);
        addLight(ambient);

        light = new PointLight(new Color(1.0f, 1.0f, 1.0f), 6.0, new Vector3D(0, 200, 300));
        addLight(light);

        Reflective r = new Reflective(0.2,0.4,0.7,15,0.6);
        Reflective r2 = new Reflective(0.2,0.4,0.7,15,0.4);
        NoTexture red = new NoTexture(new Color(0.8f,0.0f,0.0f));
        NoTexture greenblue = new NoTexture(new Color(0.0f,0.8f,0.08f));
        Grid grid2 = new Grid(new Color(0.0f,0.7f,0.7f), new Color(0.0f,0.0f,0.0f),50);
        Matte m = new Matte(0.2,0.8);
        matte = new Matte(0.2,0.7);
        phong = new PhongModel(0.2,0.8,0.9,15);
        stripe = new Stripe(new Color(0.5f,0.0f,0.0f), new Color(0.0f,0.5f,0.5f), 10, 2);
        Mirror mirror = new Mirror(0.7);

        Rectangle backwall = new Rectangle(new Point3D(-300,0,100), new Point3D(-300,400.0,100), new Point3D(300,0.0,100),
                new Normal(0,0,1), mirror, red);
        addObject(backwall);

        Rectangle leftwall = new Rectangle(new Point3D(-300,0,100),new Point3D(-300,400,100),
                new Point3D(-300,0.0,900), new Normal(1,0,0),
                m, red);
        addObject(leftwall);

        Rectangle rightwall = new Rectangle(new Point3D(300,0,100),new Point3D(300,400,100),
                new Point3D(300,0.0,900), new Normal(-1,0,0),
                m, red);
        addObject(rightwall);

        Rectangle ceiling = new Rectangle(new Point3D(-300,400,100), new Point3D(300, 400,100),
                new Point3D(-300,400,900), new Normal(0,-1,0),matte, greenblue);
        addObject(ceiling);

        Rectangle floor = new Rectangle(new Point3D(-300,0.0,100), new Point3D(300, 0.0,100),
                new Point3D(-300,0.0,900), new Normal(0,1,0),r, grid2);
        addObject(floor);

        Rectangle behindwall = new Rectangle(new Point3D(-300,0,900), new Point3D(300,400,900), new Point3D(-300,400,500), new Normal(0.0,0.0,1),
                matte, red);
        addObject(behindwall);

        stripe = new Stripe(new Color(0.8f,0.0f,0.0f), new Color(0.5f,0.0f,0.5f), 10, 1);
        sphere = new Sphere(new Point3D(100,200,200), 50, r2, stripe);
        addObject(sphere);

        stripe = new Stripe(new Color(0.0f,0.8f,0.0f), new Color(0.0f,0.5f,0.5f), 10, 2);
        sphere = new Sphere(new Point3D(-100.0,200.0,200),50, phong, stripe);
        addObject(sphere);

        stripe = new Stripe(new Color(0.0f,0.0f,0.8f), new Color(0.5f,0.5f,0.0f), 10, 3);
        sphere = new Sphere(new Point3D(0.0,70.0,200),50, r, stripe);
        addObject(sphere);

    }
    // ADD OBJECTS TO SCENE (arraylist)

    public Scene(int width, int height, float pixelSize, ArrayList objects, ArrayList lights, Color background_color){


    }
    public void addObject(Object object) {
        objects.add(object);
    }
    public void addLight(Light light) {
        lights.add(light);
    }
    public static RayHit traceObjects(Ray ray) {
        Normal normal = new Normal();
        RayHit rayhit = new RayHit(Main.s);
        double tInfinity = Double.MAX_VALUE;

        for (Object o : objects) {
            double temp = o.intersect(ray, rayhit);
            if (temp != 0 && temp < tInfinity) {
                rayhit.setHit(true);
                tInfinity = temp;
                rayhit.setMaterial(o.material);
                rayhit.setHitPoint(ray.getOrigin().add(ray.getDirection().multiplyAWithVector(temp)));
                normal = rayhit.normal;
                rayhit.setTexture(o.texture);
                rayhit.t = temp;
            }
        }
        if (rayhit.hit) {
            rayhit.normal = normal;
        } else {
            rayhit.setColor(background_color);
        }
        return rayhit;
    }
}

