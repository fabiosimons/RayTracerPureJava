package World;

import GeometricObjects.*;
import GeometricObjects.Object;
import Light.*;
import Material.*;
import Engine.Main;
import Utility.*;
import Utility.Color;
import Texture.*;
import java.util.ArrayList;


public class Scene {
    public static ViewPlane vp;
    public static Color background_color = new Color(0.0f,0.0f,0.0f);
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


    }
    // ADD OBJECTS TO SCENE (arraylist)
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

