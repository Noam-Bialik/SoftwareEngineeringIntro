package primitives;

import java.util.Objects;

public class Point3D extends Point2D {

    private Coordinate z;

    public Point3D() {
        setZ(Coordinate.ZERO);
    }

    public Point3D(Point3D other) {
        super(other);
        setZ(other.z);
    }

    public Point3D(double x, double y , double z)
    {
        super(new Coordinate(x), new Coordinate(y));
        Coordinate help = new Coordinate(z);
        this.z =help;
    }

    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Point3D point3D = (Point3D) o;
        return z.equals(point3D.z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), z);
    }

    @Override
    public String toString() {
        return "("  + getX() + "," + getY() + "," + z + ')';
    }

    public Vector substract(Point3D point) {
        Point2D help  =super.substract(point);
        return new Vector(new Point3D(help.getX(), help.getY(), z.subtract(point.z)));
    }

    public Point3D addVector(Vector vector) {
        Point2D help = super.add(vector.getHead());
        return new Point3D(help.getX(), help.getY(), z.add(vector.getHead().z));
    }

    public double distanceInSquare(Point3D point)
    {
        double helpX = getX().get()- point.getX().get();
        double helpY = getY().get()- point.getY().get();
        double helpZ = z.get()- point.z.get();

        helpX*=helpX;
        helpY*=helpY;
        helpZ*=helpZ;

        return helpX + helpY + helpZ;
    }

    public double distance(Point3D point)
    {
        return Math.sqrt(distanceInSquare(point));
    }


    public Coordinate getZ() {
        return z;
    }

    public void setZ(Coordinate z) {
        this.z = z;
    }
}
