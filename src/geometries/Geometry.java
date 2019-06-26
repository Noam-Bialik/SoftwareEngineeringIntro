package geometries;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

public interface Geometry extends Intersectable {
    public Vector getNormal(Point3D point3D);

    Color ammision= new Color(0,0,0);
    @Override
    public String toString();
    @Override
    public boolean equals(Object o);


}
