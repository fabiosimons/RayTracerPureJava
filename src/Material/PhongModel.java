package Material;

import BRDF.*;
import Light.Light;
import Utility.*;
import World.Scene;

public class PhongModel extends Material {
    public AmbientBRDF ambientBRDF;
    public DiffuseBRDF diffuseBRDF;
    public SpecularBRDF specularBRDF;

    public PhongModel() {
        ambientBRDF = new AmbientBRDF();
        diffuseBRDF = new DiffuseBRDF();
        specularBRDF = new SpecularBRDF();
        specularBRDF.setShininessConstant(16); //default
    }
    public void setCoefficients(double ambient, double diffuse, double specular) {
        ambientBRDF.setCoefficient(ambient);
        diffuseBRDF.setCoefficient(diffuse);
        specularBRDF.setCoefficient(specular);
    }
    public void setColour(Color c) {
        ambientBRDF.setColour(c);
        diffuseBRDF.setColour(c);
        specularBRDF.setColour(c);
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
                                .plus((specularBRDF.Reflection(rayhit, outgoingRay, lightDirection)))
                                .multiply(light.intensity(rayhit)).multiplyWithDouble(ndotlight));
                    }
                }
            }
        return temp;
    }
}



