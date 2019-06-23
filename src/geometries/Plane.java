package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;

public class Plane implements Geometry {
    Point3D point;
    Vector vector;

    public Plane(Point3D point, Vector vector) {
        if(vector.Length() == 0 )
            throw new ArithmeticException("The vector can't be zhe ZERO vector");
        this.point = new Point3D(point);
        this.vector = new Vector(vector);
    }

    public Plane(Point3D point1, Point3D point2, Point3D point3) {
        if (point1.equals(point2) || point1.equals(point3) || point2.equals(point3))
            throw new ArithmeticException("There are identical points");

        this.point = new Point3D(point1);
        Vector help1 = point1.substract(point2);
        Vector help2 = point1.substract(point3);
        vector = new Vector(help1.crossProduct(help2));
        if(this.vector.Length() == 0)
            throw new ArithmeticException("all the point on the same line");
    }

    public Point3D getPoint() {
        return new Point3D(point);
    }

    public Vector getVector() {
        return new Vector(vector);
    }

    @Override
    public Vector getNormal(Point3D point3D) {
        return vector;
    }

    @Override
    public ArrayList<Point3D> findIntersections(Ray ray) {
        Vector help1 = ray.getStart().substract(point);
        help1.mult(1/vector.dotProduct(ray.getDirection()));
        double t = - vector.dotProduct(help1);
        Vector tv = ray.getDirection();
        tv.mult(t);
        ArrayList<Point3D> ret = new ArrayList<Point3D>();
        ret.add(ray.getStart().addVector(tv));
        return ret;
    }
}
