package Material;

import Light.Light;
import Reflections.Ambient;
import Reflections.Diffuse;
import Reflections.Specular;
import Tracer.RecursiveTracer;
import Utility.*;
import World.Scene;
public class Reflective extends Material {
    private Ambient ambient;
    private Diffuse diffuse;
    private Specular specular;
    private RecursiveTracer tracer;
    private double reflectionRatio;

    public Reflective(double ambient, double diffuse, double specular, int shininess, double reflection) {
        this.ambient = new Ambient(ambient);
        this.diffuse = new Diffuse(diffuse);
        this.specular = new Specular(specular, shininess);
        tracer = new RecursiveTracer();
        this.reflectionRatio = reflection;
    }

    public Vector3D reflectedRay(Vector3D direction, Normal n) {
        // I - 2 * ( N . I ) * N
        return new Vector3D(direction.sub(n.multiplyAWithNormal(2 * (n.dot(direction)))));
    }

    @Override
    public Color getColour(RayHit rayhit) {
        Vector3D outgoingRay = new Vector3D(rayhit.ray.getDirection().inverse());
        Vector3D reflectedRay = reflectedRay(rayhit.ray.getDirection(), rayhit.normal);
        Color temp = ambient.reflect(rayhit).multiply(rayhit.s.ambient.intensity(rayhit));

        for (Light light : Scene.lights) {
            Vector3D lightDirection = light.getDirection(rayhit);
            Ray ray = new Ray(rayhit.hitPoint, lightDirection);
            Ray reflect = new Ray(rayhit.hitPoint,reflectedRay);
            double ndotlight = rayhit.normal.dot(lightDirection);
            if (ndotlight > 0.0) {   // if it is 0 or less, colour only affected by ambient light
                if (!light.shadow(rayhit, ray)) {
                    temp.add(diffuse.reflect(rayhit, lightDirection)
                            .plus(specular.reflect(rayhit, outgoingRay, lightDirection))
                            .plus(tracer.TraceRay(reflect, rayhit).multiplyWithDouble(reflectionRatio))
                            .multiply(light.intensity(rayhit)).multiplyWithDouble(ndotlight));
                }
                else{
                    temp = new Color(0.1f,0.1f,0.1f).multiply(light.intensity(rayhit).multiply(rayhit.texture.getColour(rayhit)));
                }
            }
        }
        return temp;
    }

}


