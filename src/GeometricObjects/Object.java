package GeometricObjects;

import Utility.Color;
import Utility.Ray;

public abstract class Object {

    public Color color;
    public abstract boolean Hit(Ray ray);

}
