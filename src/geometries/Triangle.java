package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;

public class Triangle extends Plane{

    Point3D point1, point2, point3;

    public Triangle(Point3D point1, Point3D point2, Point3D point3)  {

        super(point1, point2, point3);
        if (point1.equals(point2) || point1.equals(point3) || point2.equals(point3))
            throw new ArithmeticException("There are identical points");
        this.point1 = new Point3D(point1);
        this.point2 = new Point3D(point2);
        this.point3 = new Point3D(point3);
    }

    public Point3D getPoint1() {
        return new Point3D(point1);
    }

    public Point3D getPoint2() {
        return new Point3D(point2);
    }

    public Point3D getPoint3() {
        return new Point3D(point3);
    }

    @Override
    public ArrayList<Point3D> findIntersections(Ray ray) {

        ArrayList<Point3D> help = super.findIntersections(ray);
        Point3D point = help.get(0);
        boolean help1 = point.substract(ray.getStart()).dotProduct(findIntersectionsHelp(point1,point2,ray.getStart())) > 0;
        boolean help2 = point.substract(ray.getStart()).dotProduct(findIntersectionsHelp(point1,point3,ray.getStart())) > 0;
        boolean help3 = point.substract(ray.getStart()).dotProduct(findIntersectionsHelp(point3,point2,ray.getStart())) > 0;
        if (help1 == help2 && help1 == help3)
            return help;
        return EMPTY_LIST;

    }

    private Vector findIntersectionsHelp(Point3D point_1, Point3D point_2 , Point3D p0)
    {
        Vector V1 = point_1.substract(p0);
        Vector V2 = point_2.substract(p0);
        Vector N1 = V1.crossProduct(V2);
        N1.normalization();
        return N1;
    }
}
