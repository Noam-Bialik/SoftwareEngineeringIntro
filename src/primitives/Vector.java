package primitives;

import java.util.Objects;

public class Vector {
    Point3D head;

    public Vector() {
        head = new Point3D();
    }

    public Vector(Point3D head) {
        setHead(head);
    }

    public Vector(Vector vector) {
        setHead(vector.getHead());
    }


    public Vector add(Vector vector)
    {
        return new Vector(head.addVector(vector));
    }

    public Vector substract(Vector vector)
    {
        return head.substract(vector.getHead());
    }

    public double dotProduct(Vector vector)
    {
        return head.getX().multiply(vector.head.getX()).get() + head.getY().multiply(vector.head.getY()).get() + head.getZ().multiply(vector.head.getZ()).get();
    }

    public Vector crossProduct(Vector vector)
    {
        Coordinate X = head.getY().multiply(vector.getHead().getZ()).subtract( head.getZ().multiply(vector.getHead().getY()));
        Coordinate Y = head.getZ().multiply(vector.getHead().getX()).subtract( head.getX().multiply(vector.getHead().getZ()));
        Coordinate Z = head.getX().multiply(vector.getHead().getY()).subtract( head.getY().multiply(vector.getHead().getX()));
        Point3D _head = new Point3D(X,Y,Z);
        return new Vector(_head);
    }
//The length from (0,0,0).
    public double Length()
    {

        return new  Point3D().distance(head);
    }

    public void mult(double num)
    {
        Coordinate helpNum = new Coordinate(num);
        Coordinate X= head.getX().multiply(helpNum);
        Coordinate Y= head.getY().multiply(helpNum);
        Coordinate Z= head.getZ().multiply(helpNum);
        head = new Point3D(X,Y,Z);
    }

    public void normalization()
    {
        mult(1/Length());
    }
    @Override
    public String toString() {
        return "head =" + head ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return head.equals(vector.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head);
    }

    public Point3D getHead() {
        return new Point3D(head);
    }

    public void setHead(Point3D head) {
        this.head = new Point3D(head);
    }
}
