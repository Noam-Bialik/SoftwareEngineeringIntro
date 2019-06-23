package primitives;

import java.util.Objects;

public class Ray {

    Vector direction;
    Point3D start;


    public Ray(Vector direction, Point3D start) {
        if(direction.Length() == 0 )
            throw new ArithmeticException("The vector can't be zhe ZERO vector");
        this.direction = new Vector(direction);
        this.direction.normalization();
        this.start = new Point3D(start);
    }

    public Ray(Vector direction) {
        this.direction = new Vector();
        this.start = new Point3D(start);
    }

    public Ray(Ray ray) {
        this.direction = new Vector(ray.direction);
        this.start = new Point3D(ray.start);
    }


    @Override
    public String toString() {
        return  "start=" + start + ", direction:" + direction;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Ray)) return false;
        Ray ray = (Ray) o;
        return getDirection().equals(ray.getDirection()) &&
                getStart().equals(ray.getStart());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getDirection(), getStart());
    }



    public Vector getDirection() {
        return new Vector(direction);
    }

    public void setDirection(Vector direction) {
        this.direction = new Vector(direction);
    }

    public Point3D getStart() {
        return new Point3D(start);
    }

    public void setStart(Point3D start) {
        this.start = new Point3D(start);
    }
}
