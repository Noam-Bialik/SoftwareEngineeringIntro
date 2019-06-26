package geometries;

import primitives.Ray;

public class Cylinder extends Tube{

    double height;

    public Cylinder(double radius, Ray hinge, double height){
        super(radius,hinge);
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cylinder)) return false;
        if (!super.equals(o)) return false;
        Cylinder cylinder = (Cylinder) o;
        return Double.compare(cylinder.height, height) == 0;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                '}';
    }

    public double getHeight() {
        return height;
    }
}
