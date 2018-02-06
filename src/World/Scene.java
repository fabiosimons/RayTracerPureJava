package World;

import GeometricObjects.Sphere;
import Utility.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Scene {
    ViewPlane vp;
    Color background_color;
    Sphere sphere;

    public Scene(){
    }

    // CREATE THE OBJECTS AND THE SCENE
    public void build(){
        vp = new ViewPlane(800, 800, 1.0f);
        background_color = new Color();
        sphere = new Sphere(100, new Color(1.0f,0.0f,0.0f));
        sphere.setCenter(new Point3D(100.0,0.0,0.0));
    }

    // RENDER THE SCENE
    public void renderScene(){
        Color pixelColor;
        Ray ray = new Ray();
        double zw = 70.0;
        double x,y;

        ray.setDirection(new Vector3D(0,0,-1));

        File image = new File("Image.png");
        BufferedImage buffer = new BufferedImage(vp.getHorizontalRes(), vp.getVerticalRes(), BufferedImage.TYPE_INT_RGB);

        long start = System.nanoTime();

        for(int i = 0; i < vp.getVerticalRes(); i++){
            for(int j = 0; j < vp.getHorizontalRes(); j++) {
                x = vp.getPixelSize() * (j - 0.5 * (vp.getHorizontalRes() - 1.0));
                y = vp.getPixelSize() * (i - 0.5 * (vp.getVerticalRes() - 1.0));
                ray.setOrigin(new Point3D(x, y, zw));

                if (sphere.Hit(ray)) {
                    pixelColor = sphere.getColor();
                } else {
                    pixelColor = background_color;
                }

                buffer.setRGB(i,j,pixelColor.toInteger());
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
}
