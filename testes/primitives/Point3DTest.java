package primitives;

import org.junit.jupiter.api.Test;


import static junit.framework.TestCase.assertEquals;


class Point3DTest {

    @org.junit.jupiter.api.Test
    void distance() {
        Point3D p1 =new Point3D(1.5,2.333,100.6);
        Point3D p2 =new Point3D(1.5,2.333,100.6);

        assertEquals(0,p1.distance(p2),0.0000001);
    }

    @Test
    void distanceInSquare() {
        Point3D p1=new Point3D(-1,-1,-1);
        Point3D p2 = new Point3D(0,0,0);

        assertEquals(3,p1.distanceInSquare(p2),0.00000001);
        p2.x= new Coordinate(3);
        p2.setY(new Coordinate(3));
        p2.setZ(new Coordinate(3));
        assertEquals(48, p1.distanceInSquare(p2),0.000001);
    }

    @Test
    void equals1() {
        Point3D p1=new Point3D(-1,-1,-1);
        Point3D p2 = new Point3D(1,1,1);
        assertEquals(false,p1.equals(p2));
        p1 =p2;
        assertEquals(true,p1.equals(p2));
    }
}