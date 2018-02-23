package GeometricObjects;


import Utility.Ray;

import java.awt.*;

public abstract class Object {

    public Color color;
    public abstract boolean Hit(Ray ray);

}
