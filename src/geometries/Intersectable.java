package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;

public interface Intersectable {
    public static final ArrayList<Point3D> EMPTY_LIST = new ArrayList<Point3D>();

    public ArrayList<Point3D> findIntersections(Ray ray);

}
