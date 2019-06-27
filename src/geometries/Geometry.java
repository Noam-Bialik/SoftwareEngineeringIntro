package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.*;
import java.util.ArrayList;

public abstract class Geometry  {

    public static final ArrayList<Point3D> EMPTY_LIST = new ArrayList<Point3D>();

    public abstract ArrayList<Point3D> findIntersections(Ray ray);
    public abstract Vector getNormal(Point3D point3D);

     Color emmision= new Color(0,0,0);
    @Override
     public abstract String toString();

    @Override
    public abstract boolean equals(Object o);

    public  Color getEmmision()
    {
        return new Color(emmision.getRGB());
    }
    public Color setEmmision(Color color)
    {
        emmision = new Color(color.getRGB());
        return this.getEmmision();
    }

}
