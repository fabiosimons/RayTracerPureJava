package World;

import GeometricObjects.Object;
import GeometricObjects.Sphere;
import Tracer.ManyObjects;
import Tracer.OneSphere;
import Tracer.RayTracer;
import Utility.*;
import Utility.Color;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Scene {
    ViewPlane vp;
    Color background_color;
    public Sphere sphere;
    public Sphere sphere2;

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

        for(Object o : objects){
            if (o.Hit(ray)){
                hit.setHit(true);
                hit.setColor(o.color);
            }
        }
        return hit;
    }

    // Initialse viewplane and objects in the scene
    public void build(){
        vp = new ViewPlane(800, 800, 1.0f);
        vp.setNumOfSamples(64);
        background_color = new Color(0,0,0);

        sphere = new Sphere(100, new Color(255.0f,155.0f,0.0f));
        sphere.setCenter(new Point3D(100.0,0.0,0.0));
        addObject(sphere);

        sphere2 = new Sphere(100, new Color(0.0f,0.0f,255.0f));
        sphere2.setCenter(new Point3D(-50.0,0.0,0.0));
        addObject(sphere2);
    }

    /*
    Renders the scene
    creates new file and buffered
    initialises ray and loops through each pixel in the viewplane firing rays from the origin
    sets rgb values for each pixel in buffered image
    Calculates the time it takes to create the ray traced image and prints
     */
    public void render(){
        Color pixelColor;
        Ray ray = new Ray();

        double zw = 70;
        double x,y;
        tracer = new OneSphere(this);

        int n = (int)Math.sqrt((float)vp.numOfSamples);
        Point2D point = new Point2D();

        ray.setDirection(new Vector3D(0,0,-1));

        long start = System.nanoTime();

        File image = new File("RayTraced.png");
        buffer = new BufferedImage(vp.getHorizontalRes(), vp.getVerticalRes(), BufferedImage.TYPE_INT_RGB);

        for(int i = 0; i < vp.getVerticalRes(); i++){          // UP
            for(int j = 0; j < vp.getHorizontalRes(); j++) {    // ACROSS
                pixelColor = new Color(0,0,0); //DEFAULT BACKGROUND COLOR


                for(int row = 0; row < n; row++){
                    for(int column = 0; column < n; column++){
                        point.x = vp.getPixelSize() * (j - 0.5 * vp.getHorizontalRes() + (column + 0.5) / n );
                        point.y = vp.getPixelSize() * (i - 0.5 * vp.getVerticalRes() + (row + 0.5) / n );
                        ray.setOrigin(new Point3D(point.x, point.y, zw));
                        pixelColor.add(tracer.TraceRay(ray));

                    }
                    pixelColor.divide(vp.getNumOfSamples());
                    setPixel(i,j,pixelColor);
                }

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
        buffer.setRGB(row,column,pixelColor.toInt());

    }
}
