package Sampling;

import Utility.Point2D;
import Utility.Point3D;

public class MapSamplesToHemisphere {

    public Point3D MapSamplesToHemisphere(double e){

        for(Point2D s : Sampler.diskSamples){
            double cos_phi = Math.cos(2.0 * Math.PI * s.getX());
            double sin_phi = Math.sin(2.0 * Math.PI * s.getX());

            double cos_theta = Math.pow((1.0 - s.getY()), 1.0 / e + 1.0);
            double sin_theta = Math.sqrt(1.0 - cos_theta * cos_theta);
            double u = sin_theta * cos_phi;
            double v = sin_theta * sin_phi;
            double w = cos_theta;

            return new Point3D(u,v,w);
        }
        return null;
    }
}
