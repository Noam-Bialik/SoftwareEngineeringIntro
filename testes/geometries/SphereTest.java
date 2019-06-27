package geometries;

import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    public void getNormalTest() {
        Vector answer = new Vector(0.7071067811865475, 0.7071067811865475, 0.0);

        Point3D p1 = new Point3D(0, 0, -400);
        Point3D p2 = new Point3D(1,1, -400);

        Sphere sphere = new Sphere(p1,200);

        Vector vector = sphere.getNormal(p2);
        assertEquals(answer, vector);
    }

    @Test
    public void testIntersectionsTest() {
        // creating the expected values
        java.util.List<Point3D> answerList1 = new ArrayList<Point3D>();
        java.util.List<Point3D> answerList2 = new ArrayList<Point3D>();

        Point3D answerPoint1 = new Point3D(0, 0, -200);
        Point3D answerPoint2 = new Point3D(0, 0, -600);

        answerList2.add(answerPoint1);
        answerList2.add(answerPoint2);


        // building the spheres

        Point3D p1 = new Point3D(0, 0, -400);
        Point3D p2 = new Point3D(p1);
        Point3D centerPoint = new Point3D(0,0,0);

        Vector direction1 = new Vector(50, -50, -50);
        Vector direction2 = new Vector(0, 0, -5);
        Sphere sphere1 = new Sphere(p1, 200);
        Sphere sphere2 = new Sphere(p2, 200);

        // building the ray that will intersect the spheres

        Ray ray1 = new Ray( direction1,centerPoint);
        Ray ray2 = new Ray(direction2,centerPoint);

        // testing the findIntersection functions
        java.util.List<Point3D> list1 = new ArrayList<Point3D>();
        list1 = sphere1.findIntersections(ray1);
        assertEquals(answerList1, list1);

        List<Point3D> list2 = new ArrayList<Point3D>();
        list2 = sphere2.findIntersections(ray2);
        assertEquals(answerList2, list2);

    }
}