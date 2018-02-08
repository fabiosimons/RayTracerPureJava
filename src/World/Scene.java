package World;

import GeometricObjects.Object;
import GeometricObjects.Plane;
import GeometricObjects.Sphere;
import Tracer.ManyObjects;
import Tracer.OneSphere;
import Tracer.RayTracer;
import Utility.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Scene {
    ViewPlane vp;
    Color background_color;
    public Sphere sphere;
    public Sphere sphere2;
    public Plane plane;

    RayTracer tracer;
    BufferedImage buffer;
    ArrayList<Object> objects = new ArrayList<>();

    public Scene(){
    }

    // ADD OBJECTS TO SCENE
    public void addObject(Object object){
        objects.add(object);
    }

    public RayHit HitObjects(Ray ray){
        RayHit hit = new RayHit(this);

        for(Object o : objects){
            if (o.Hit(ray)){
                hit.setHit(true);
                hit.setColor(new Color(o.color.getR(),o.color.getG(),o.color.getB()));
            }
        }
        return hit;
    }

    // CREATE THE OBJECTS AND THE SCENE
    public void build(){
        vp = new ViewPlane(800, 800, 1.0f);
        background_color = new Color();

        sphere = new Sphere(100, new Color(1.0f,0.0f,0.0f));
        sphere.setCenter(new Point3D(100.0,0.0,0.0));
        addObject(sphere);

        sphere2 = new Sphere(100, new Color(0.0f,0.0f,155.0f));
        sphere2.setCenter(new Point3D(-50.0,0.0,0.0));
        addObject(sphere2);


    }

    // RENDER THE SCENE
    public void renderScene(){
        Color pixelColor;
        Ray ray = new Ray();

        double zw = 70;
        double x,y;
        tracer = new ManyObjects(this);
        ray.setDirection(new Vector3D(0,0,-1));

        long start = System.nanoTime();

        File image = new File("Image.png");
        buffer = new BufferedImage(vp.getHorizontalRes(), vp.getVerticalRes(), BufferedImage.TYPE_INT_RGB);

        for(int i = 0; i < vp.getVerticalRes(); i++){
            for(int j = 0; j < vp.getHorizontalRes(); j++) {
                x = vp.getPixelSize() * (j - 0.5 * (vp.getHorizontalRes() - 1.0));
                y = vp.getPixelSize() * (i - 0.5 * (vp.getVerticalRes() - 1.0));
                ray.setOrigin(new Point3D(x, y, zw));
                pixelColor = tracer.TraceRay(ray);
                setPixel(i,j,pixelColor);
                }
        }
        try{
            ImageIO.write(buffer, "PNG", image);
        }catch(Exception e){
            System.out.print("cant");
            System.exit(1);
        }

        long end = System.nanoTime();
        long timeTaken = end - start;
        System.out.println(timeTaken / 1000000000.0);
    }

    public void setPixel(int row, int column, Color pixelColor){
        buffer.setRGB(row,column,pixelColor.toInteger());

    }
}
