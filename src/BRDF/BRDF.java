package BRDF;

import Sampling.Sampler;
import Tracer.RayTracer;
import Utility.Color;
import Utility.RayHit;
import Utility.Vector3D;

public abstract class BRDF {
    protected Sampler sample = RayTracer.sample;

    public abstract Color Distribution();
    public abstract Color rho();


}
