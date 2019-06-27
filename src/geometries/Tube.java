package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tube)) return false;
        if (!super.equals(o)) return false;
        Tube tube = (Tube) o;
        return Objects.equals(getHinge(), tube.getHinge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getHinge());
    }

    @Override
    public String toString() {
        return "Tube{" +
                "hinge=" + hinge +
                ", emmision=" + emmision +
                ", material=" + material +
                '}';
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public ArrayList<Point3D> findIntersections(Ray ray) {
        return null;
    }
}
