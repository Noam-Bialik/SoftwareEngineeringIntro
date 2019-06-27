package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    Plane plane1 = new Plane(new Point3D(1,1,0),new Point3D(0,0,0),new Point3D(45,62,0));
    Plane plane2 =new Plane(new Point3D(1,1,0),new Vector(0,0,1));

    @Test
    void findIntersectionsTest()
    {

    }

    @Test
    void constractorTest()
    {
        assertEquals(plane1,plane2);
    }

    @Test
    void getNormalTest() {
        assertEquals(plane1.getNormal(new Point3D()),new Vector(0,0,1));
    }
}