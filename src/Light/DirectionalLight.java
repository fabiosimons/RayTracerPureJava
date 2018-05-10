package Light;

import Utility.*;
import World.Scene;

public class DirectionalLight extends Light {
    public Color color;
    public double intensity;
    public Vector3D direction;

    public DirectionalLight(){
        setIntensity(1.0);
        setColour(new Color(1.0f,1.0f,1.0f));
    }

    public DirectionalLight(Color color, double intensity, Vector3D direction){
        setColour(color);
        setIntensity(intensity);
        setDirection(direction);
    }
    @Override
    public Vector3D getDirection(RayHit rayhit){
        direction.normalise();
        return this.direction;
    }
    @Override
    public Color intensity(RayHit rayHit) {
        return color.multiplyWithDouble(intensity);
    }

    @Override
    public boolean shadow(RayHit rayhit, Ray ray) {
        double distance = distance(ray.getOrigin(), direction);
        for(GeometricObjects.Object o : Scene.objects){
            double temp = o.shadowHit(ray);
            if (temp != 0 && temp < distance){
                if(rayhit.transparent){
                    return false;
                }
                return true;
            }
        }
        return false;
    }
    @Override
    public Color getColor() {
        return null;
    }

    public double distance(Point3D p, Vector3D v){
        return Math.sqrt(Math.pow(p.getX() - v.getX(),2) +
                Math.pow(p.getY() - v.getY(),2));
    }
    public void setIntensity(double intensity){
        this.intensity = intensity;
    }
    public void setColour(Color colour){
        this.color = colour;
    }
    public void setDirection(Vector3D direction){
        this.direction = direction;
    }
}
