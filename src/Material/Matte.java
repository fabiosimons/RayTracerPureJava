package Material;

import BRDF.AmbientBRDF;
import BRDF.DiffuseBRDF;
import Light.Light;
import Utility.Color;
import Utility.Ray;
import Utility.RayHit;
import Utility.Vector3D;
import World.Scene;

public class Matte extends Material {
    private AmbientBRDF ambientBRDF;
    private DiffuseBRDF diffuseBRDF;

    public Matte(){
        ambientBRDF = new AmbientBRDF();
        diffuseBRDF = new DiffuseBRDF();
    }
    public void setCoefficients(double ambient, double diffuse) {
        ambientBRDF.setCoefficient(ambient);
        diffuseBRDF.setCoefficient(diffuse);
    }
    public void setColour(Color c) {
        ambientBRDF.setColour(c);
        diffuseBRDF.setColour(c);
    }

    @Override
    public Color shade(RayHit rayhit) {
        Vector3D outgoingRay = new Vector3D(rayhit.ray.getDirection().inverse());
        Color temp = ambientBRDF.ReflectionWithoutRay().multiply(rayhit.s.ambient.intensity(rayhit));

        for (Light light : Scene.lights) {
            Vector3D lightDirection = light.getDirection(rayhit);
            Ray ray = new Ray(rayhit.hitPoint, lightDirection);
            double ndotlight = rayhit.normal.dot(lightDirection);
            if (ndotlight > 0.0) {   // if it is 0 or less, colour only affected by ambient light
                if (!light.shadow(rayhit, ray)) {
                    temp.add(diffuseBRDF.Reflection(rayhit, outgoingRay, lightDirection)
                            .multiply(light.intensity(rayhit)).multiplyWithDouble(ndotlight));
                }
            }
        }
        return temp;
    }
}
