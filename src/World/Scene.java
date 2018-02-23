package World;

import GeometricObjects.Object;
import GeometricObjects.Plane;
import GeometricObjects.Sphere;
import Tracer.ManyObjects;
import Tracer.RayTracer;
import Utility.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Scene {
    ViewPlane vp;
    public Color background_color;
    public Sphere sphere;
    public Sphere sphere2;
    public Plane plane;

    RayTracer tracer;
    BufferedImage buffer;
    ArrayList<Object> objects = new ArrayList<>();

    // DEFAULT CONSTRUCTOR
    public Scene(){
    }

    // ADD OBJECTS TO SCENE (arraylist)
    public void addObject(Object object){
        objects.add(object);
    }

    /*
    detects whether rays hit any of the objects within the scene (from arraylist of objects)
    sets color and whether rayhit = true/false
    @return RayHit
     */
    public RayHit HitObjects(Ray ray){
        RayHit hit = new RayHit(this);
        double t = 0;
        double tmin = 1000000000000000000000000.0;

        for(Object o : objects){
            if (o.Hit(ray, t, hit) && (t < tmin))
                hit.setHit(true);
                tmin = t;
                hit.setColor(new Color(o.color.getR(),o.color.getG(),o.color.getB()));
            }

        return hit;
    }

    // Initialse viewplane and objects in the scene
    public void build(){
        vp = new ViewPlane(800, 800, 1.0f);
        background_color = new Color(0.0f,0.0f,0.0f);
        tracer = new ManyObjects(this);

        sphere = new Sphere(80, new Color(0.0f,0.0f,255.0f));
        sphere.setCenter(new Point3D(0.0,0.0,0.0));
       addObject(sphere);

       // sphere2 = new Sphere(120, new Color(255.0f,255.0f,255.0f));
      //  sphere2.setCenter(new Point3D(0.0,0.0,0.0));
     //   addObject(sphere2);

    //    plane = new Plane(new Point3D(0,0,0), new Normal(0,1,1), new Color(155.0f,155.0f,155.0f));
     //   addObject(plane);
    }

    /*
    Renders the scene
    creates new file and buffered
    initialises ray and loops through each pixel in the viewplane firing rays from the origin
    sets rgb values for each pixel in buffered image
    Calculates the time it takes to create the ray traced image and prints
     */
    public void renderScene(){
        Color pixelColor;
        Ray ray = new Ray();

        double zw = 70;
        double x,y;

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

    // set rgb value of current pixel in the buffered image
    public void setPixel(int row, int column, Color pixelColor){
        buffer.setRGB(row,column,pixelColor.toInteger());

    }
}
