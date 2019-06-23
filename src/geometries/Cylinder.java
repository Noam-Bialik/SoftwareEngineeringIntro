package geometries;

import primitives.Ray;

public class Cylinder extends Tube{

    double height;

    public Cylinder(double radius, Ray hinge, double height){
        super(radius,hinge);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
}
