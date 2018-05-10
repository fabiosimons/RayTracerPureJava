package Material;

import Reflections.Ambient;
import Reflections.Diffuse;
import Light.Light;
import Utility.*;
import World.Scene;


public class Matte extends Material {
    private Ambient ambient;
    private Diffuse diffuse;

    public Matte(double ambient, double diffuse) {
        this.ambient = new Ambient(ambient);
        this.diffuse = new Diffuse(diffuse);
    }

    @Override
    public Color getColour(RayHit rayhit) {
        Color temp = ambient.reflect(rayhit).multiply(rayhit.s.ambient.intensity(rayhit));
        for (Light light : Scene.lights) {
            Vector3D lightDirection = light.getDirection(rayhit);
            Ray ray = new Ray(rayhit.hitPoint, lightDirection);
            double ndotlight = rayhit.normal.dot(lightDirection);

            if (ndotlight > 0.0) {   // if it is 0 or less, colour only affected by ambient light
                if (!light.shadow(rayhit, ray)) {
                    temp.add(diffuse.reflect(rayhit, lightDirection)
                            .multiply(light.intensity(rayhit)).multiplyWithDouble(ndotlight));
                } else {
                    temp.add(new Color(0.1f, 0.1f, 0.1f).multiply(light.intensity(rayhit).multiply(rayhit.texture.getColour(rayhit))));
                }
            }
        }
        return temp;
    }
}
