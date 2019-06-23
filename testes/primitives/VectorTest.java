package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {
    Vector v1 = new Vector(new Point3D());
    Vector v2 = new Vector(new Point3D());
    Vector v3 = new Vector(new Point3D());

    @Test
    void add() {
        v1.head= new Point3D(1.5,2,2.5);
        v2.head = new Point3D(2.5,2,1.5);
        v3.head = new Point3D(4,4,4);
        assertEquals( v3,v1.add(v2));

    }

    @Test
    void substract() {
        v1.head= new Point3D(1.5,2,2.5);
        v2.head = new Point3D(2.5,2,1.5);
        v3.head = new Point3D(4,4,4);
        assertEquals(v1,v3.substract(v2));
    }

    @Test
    void dotProduct() {
        v1.head = new Point3D(3,4,-5);
        v2.head = new Point3D(-1,4,4);
        assertEquals(-7,v1.dotProduct(v2),0.001);
        assertEquals(v1.dotProduct(v2), v2.dotProduct(v1));
        v1.head =new Point3D(8,0,0);
        v2.head = new Point3D(0 ,0 ,15);
        assertEquals(0, v1.dotProduct(v2));
    }

    @Test
    void crossProduct() {
        v1.head = new Point3D(1,0,0);
        v2.head = new Point3D(0,1,0);
        v3.head = new Point3D(0,0,1);
        assertEquals(v3,v1.crossProduct(v2));
        v3.mult(-1);
        assertEquals(v3,v2.crossProduct(v1));
    }

    @Test
    void length() {
        assertEquals(0,v1.Length());
        v1.head= new Point3D(1.5,2,2.5);
        assertEquals(3.535533906,v1.Length(),0.00000001);
        v1.head= new Point3D(-1.5,-2,-2.5);
        assertEquals(3.535533906,v1.Length(),0.00000001);

    }

    @Test
    void mult() {
        v1.head = new Point3D(1.5,2,2.5);
        v2.head = new Point3D(1.5*3,6,7.5);
        v1.mult(3);
        assertEquals(v2, v1);
        v1.mult(-2);
        assertEquals(new Vector(new Point3D(-9,-12,-15)),v1);
        v1.mult(0);
        assertEquals(new Point3D(),v1.head);
    }

    @Test
    void normalization() {
        v1.head = new Point3D(1,1,1);
        v2.head = new Point3D(0.5773502692,0.5773502692,0.5773502692);
        v1.normalization();
        assertEquals(v2,v1);
       /* it was insted of : (it works because in equal in Coordinate set it to work with delta(0.001).
       assertEquals(v1.head.x._coord,v2.head.x._coord,00.0000001);
        assertEquals(v1.head.y._coord,v2.head.y._coord,00.0000001);
        assertEquals(v1.head.getZ()._coord,v2.head.getZ()._coord,00.0000001);*/

    }


    @Test
    void equals1() {
        v1.head = new Point3D();
        v2.head = new Point3D(0.0001,0.00001,0.0001);
        assertTrue(v1.equals(v2));
    }





}