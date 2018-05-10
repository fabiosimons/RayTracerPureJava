package Material;

import Engine.Main;
import Light.Light;
import Reflections.Ambient;
import Reflections.Diffuse;
import Reflections.Specular;
import Tracer.RayTracer;
import Utility.*;
import World.Scene;

import java.util.Random;

public class PhongModel extends Material {
    private Ambient ambient;
    private Diffuse diffuse;
    private Specular specular;

    public PhongModel(double ambient, double diffuse, double specular, int shininess) {
        this.ambient = new Ambient(ambient);
        this.diffuse = new Diffuse(diffuse);
        this.specular = new Specular(specular, shininess);
    }
    @Override
    public Color getColour(RayHit rayhit) {
        Vector3D outgoingRay = new Vector3D(rayhit.ray.getDirection().inverse());
        Color temp = ambient.reflect(rayhit).multiply(rayhit.s.ambient.intensity(rayhit));
        for (Light light : Scene.lights) {
            Vector3D lightDirection = light.getDirection(rayhit);
            Ray ray = new Ray(rayhit.hitPoint, lightDirection);
            double ndotlight = rayhit.normal.dot(lightDirection);
            if (ndotlight > 0.0) {   // if it is 0 or less, colour only affected by ambient light
                if (!light.shadow(rayhit, ray)) {
                        temp.add(diffuse.reflect(rayhit, lightDirection)
                                .plus(specular.reflect(rayhit, outgoingRay, lightDirection))
                                .multiply(light.intensity(rayhit)).multiplyWithDouble(ndotlight));
                    }
                    else{
                            temp.add(new Color(0.1f, 0.1f, 0.1f).multiply(light.intensity(rayhit).multiply(rayhit.texture.getColour(rayhit))));
                }
                }
            }
        return temp;
    }
}



