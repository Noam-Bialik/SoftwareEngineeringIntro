package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.LinkedList;

public class Geometries implements Intersectable{
    private LinkedList<Intersectable> geometries;

    public Geometries(LinkedList<Intersectable> geometries) {
        this.geometries = new LinkedList<>(geometries);

    }

    public LinkedList<Intersectable> getGeometries() {
        return new LinkedList<>(geometries);
    }

    public void add(Intersectable geometry)
    {
        geometries.add(geometry);
    }
    public void add(LinkedList<Intersectable> geometry)
    {
        geometries.addAll(geometry);
    }

    @Override
    public ArrayList<Point3D> findIntersections(Ray ray) {
        ArrayList<Point3D> intersections = new ArrayList<>();
        for(Intersectable item : geometries)
        {
            intersections.addAll(item.findIntersections(ray));
        }
        return intersections;
    }
}
