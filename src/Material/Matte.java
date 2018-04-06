package Material;

import BRDF.Lambertian;
import Sampling.Sampler;
import Utility.Color;
import Utility.RayHit;
import Utility.Vector3D;
import World.Scene;
import Light.*;

public class Matte extends Material {
    public Lambertian ambientBRDF;
    public Lambertian diffuseBRDF;

    public Matte(){
        super();
        ambientBRDF = new Lambertian();
        diffuseBRDF = new Lambertian();
    }
    public void setCoefficients(double ambient, double diffuse){
        ambientBRDF.setCoefficient(ambient);
        diffuseBRDF.setCoefficient(diffuse);
    }
    public void setColour(Color c ){
        ambientBRDF.setColour(c);
        diffuseBRDF.setColour(c);
    }
    @Override
    public Color shade(RayHit rayhit) {
        Color temp = ambientBRDF.rho().multiply(rayhit.s.ambient.incidentRadiance(rayhit));
        for(Light light : Scene.lights){
            Vector3D incomingRay = light.getDirection(rayhit);
            double ndotwi = rayhit.normal.dot(incomingRay);

            if(ndotwi > 0.0){
                temp.add(diffuseBRDF.Distribution().multiply(light.incidentRadiance(rayhit).multiplyWithDouble(ndotwi)));
            }
            temp.divide(Sampler.numOfSamples);
        }
        return temp;
    }
}
