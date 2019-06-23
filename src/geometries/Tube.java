package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;

public class Tube extends RadialGeometry {
    Ray hinge;

    public Tube(double radius, Ray hinge){
        super(radius);
        if(radius <= 0 )
            throw new ArithmeticException("radius must be big than 0");
        this.hinge = new Ray(hinge);
    }

    public Ray getHinge() {
        return new Ray(hinge);
    }

    @Override
    public Vector getNormal(Point3D point3D) {
        double hypotenuse = hinge.getStart().substract(point3D).Length();
        double t = Math.sqrt(hypotenuse*hypotenuse + get_radius()*get_radius());

        Vector helpVector = new Vector(hinge.getDirection());
        helpVector.mult(t/helpVector.Length());
        Point3D circleCenter  = hinge.getStart().addVector(helpVector);

        Vector ret = point3D.substract(circleCenter);
        ret.normalization();
        return ret;
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public ArrayList<Point3D> findIntersections(Ray ray) {
        return null;
    }
}
