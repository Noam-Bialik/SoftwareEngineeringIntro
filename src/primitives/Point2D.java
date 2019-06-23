package primitives;

import java.util.Objects;

public class Point2D {
    protected Coordinate x;
    protected Coordinate y;

    public Point2D() {
        this.setX(Coordinate.ZERO);
        this.setY(Coordinate.ZERO);
    }

    public Point2D(Point2D other) {
        this.setX(other.getX());
        this.setY(other.getY());
    }

    public Point2D(Coordinate x, Coordinate y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Point2D)) return false;
        Point2D point2D = (Point2D) o;
        return getX().equals(point2D.getX()) &&
                getY().equals(point2D.getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    public Point2D substract(Point2D point)
    {
        return new Point2D(x.subtract(point.getX()),y.subtract(point.getY()));
    }

    public Point2D add(Point2D point)
    {
        return new Point2D(x.add(point.getX()),y.add(point.getY()));
    }

    public Coordinate getX() {
        return new Coordinate(x);
    }

    public void setX(Coordinate x) {
        this.x = new Coordinate(x);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ')';
    }

    public Coordinate getY() {
        return new Coordinate(y);
    }

    public void setY(Coordinate y) {
        this.y = new Coordinate(y);
    }
}
