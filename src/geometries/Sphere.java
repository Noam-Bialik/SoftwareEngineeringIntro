package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.Objects;

public class Sphere extends RadialGeometry {

    Point3D center;

    public Sphere(Point3D center, double radius){
        super(radius);
        if(radius <= 0 )
            throw new ArithmeticException("radius must be big than 0");
        this.center = new Point3D(center);
    }

    public Point3D getCenter() {
        return new Point3D(center);
    }

    @Override
    public Vector getNormal(Point3D point3D) {
        Vector ret = point3D.substract(center);
        ret.normalization();
        return ret;
    }

    @Override
    public ArrayList<Point3D> findIntersections(Ray ray) {
        Vector L = ray.getStart().substract(center);
        double tm = L.dotProduct(ray.getDirection());
        double d = Math.sqrt(L.Length()*L.Length() - tm*tm);
        if(get_radius()<d)
            return EMPTY_LIST;
        double th = Math.sqrt(get_radius()*get_radius() - d*d);
        ArrayList<Point3D> ret = new ArrayList<Point3D>();
        if (tm - th > 0)
        {
            Vector help = ray.getDirection();
            help.mult(tm - th);
            ret.add(ray.getStart().addVector(help));
        }
        if (tm + th > 0)
        {
            Vector help = ray.getDirection();
            help.mult(tm + th);
            ret.add(ray.getStart().addVector(help));
        }
        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sphere)) return false;
        Sphere sphere = (Sphere) o;
        return Objects.equals(center, sphere.center);
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "center=" + center +
                '}';
    }
}
