package Sampling;

import Utility.Point2D;
import Utility.Point3D;


public class MapSamplesToDisk {

    public void MapSamplesToDisk(){
        double r, phi;
        Point2D samplePoint = new Point2D();

        for(Point2D s : Sampler.diskSamples){
            samplePoint.x = 2 * s.getX() - 1.0;
            samplePoint.y = 2 * s.getY() - 1.0;

            if(samplePoint.x > -samplePoint.y){
                if(samplePoint.x > samplePoint.y){
                    r = samplePoint.x;
                    phi = samplePoint.y / samplePoint.x;
                }
                else{
                    r = samplePoint.y;
                    phi = 2 - samplePoint.x / samplePoint.y;
                }
            }
            else{
                if(samplePoint.x < samplePoint.y){
                    r = -samplePoint.x;
                    phi = 4 + samplePoint.y / samplePoint.x;
                }
                else{
                    r = -samplePoint.y;
                    if(samplePoint.y != 0.0) {
                        phi = 6 - samplePoint.x / samplePoint.y;
                    }
                    else{
                        phi = 0.0;
                    }
                }
            }
            phi = phi * Math.PI / 4.0;

            s.setX(r * Math.cos(phi));
            s.setY(r * Math.sin(phi));
        }
    }
}
