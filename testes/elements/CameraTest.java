package elements;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class CameraTest {

    @Test
    void constructRayThroughPixelTest() {


        Camera c = new Camera();

        Ray ray = c.constructRayThroughPixel(3, 3, 3, 3, 100, 150, 150);
        Point3D centerPoint = new Point3D(100,-100,-100);
        Vector direction = new Vector(0.5773502691896257, -0.5773502691896257, -0.5773502691896257);

        Ray answer = new Ray(direction,centerPoint);
        assertEquals(answer, ray);
    }
}