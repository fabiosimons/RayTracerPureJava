package Material;

import BRDF.*;
import Light.Light;
import Sampling.Sampler;
import Utility.Color;
import Utility.RayHit;
import Utility.Vector3D;
import World.Scene;

public class PhongModel extends Material {
        public AmbientBRDF ambientBRDF;
        public DiffuseBRDF diffuseBRDF;
        public GlossySpecularBRDF specularBRDF;

        public PhongModel(){
            ambientBRDF = new AmbientBRDF();
            diffuseBRDF = new DiffuseBRDF();
            specularBRDF = new GlossySpecularBRDF();
            specularBRDF.setShininessConstant(16); //default
        }

        public void setCoefficients(double ambient, double diffuse, double specular){
            ambientBRDF.setCoefficient(ambient);
            diffuseBRDF.setCoefficient(diffuse);
            specularBRDF.setCoefficient(specular);
        }
        public void setColour(Color c){
            ambientBRDF.setColour(c);
            diffuseBRDF.setColour(c);
            specularBRDF.setColour(c);
        }
        @Override
        public Color shade(RayHit rayhit){
            Vector3D outgoingRay = new Vector3D(-rayhit.ray.getDirection().getX(),-rayhit.ray.getDirection().getY(),-rayhit.ray.getDirection().getZ());
            Color temp = ambientBRDF.ReflectionWithoutRay().multiply(rayhit.s.ambient.intensity(rayhit));

           //System.out.println(temp.toString());
           for(Light light : Scene.lights){
                Vector3D incomingRay = light.getDirection(rayhit);
                double ndotwi = rayhit.normal.dot(incomingRay);
                if(ndotwi > 0.0){
                   temp.add(diffuseBRDF.Reflection(rayhit,outgoingRay,incomingRay)
                           .plus((specularBRDF.Reflection(rayhit,outgoingRay,incomingRay)))
                           .multiply(light.intensity(rayhit)).multiplyWithDouble(ndotwi));
                }
            }
            return temp;
        }
    }

