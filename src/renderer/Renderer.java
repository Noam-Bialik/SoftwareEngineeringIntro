package renderer;

import Scene.*;
import geometries.Geometry;
import primitives.Point3D;
import primitives.Ray;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Map.*;

public class Renderer {
    Scene _scene;
    ImageWriter _imageWriter;

    // ***************** Constructors ********************** //

    public Renderer(Scene _scene, ImageWriter _imageWriter) {
        this._scene = new Scene(_scene);
        this._imageWriter = new ImageWriter(_imageWriter);
    }
    public Renderer(Renderer renderer) {
        this._scene = new Scene(renderer._scene);
        this._imageWriter = new ImageWriter(renderer._imageWriter);
    }

    // ***************** Getters/Setters ********************** //

    public Scene get_scene() {
        return new Scene(_scene);
    }

    public void set_scene(Scene _scene) {
        this._scene = new Scene(_scene);
    }

    public ImageWriter get_imageWriter() {
        return new ImageWriter(_imageWriter);
    }

    public void set_imageWriter(ImageWriter _imageWriter) {
        this._imageWriter = new ImageWriter(_imageWriter);
    }

    // ***************** Administration  ******************** //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Renderer)) return false;
        Renderer renderer = (Renderer) o;
        return Objects.equals(get_scene(), renderer.get_scene()) &&
                Objects.equals(get_imageWriter(), renderer.get_imageWriter());
    }


    // ***************** Operations ******************** //

    public void printGrid(int interval){
        for(int i=0; i<_imageWriter.getHeight();i++)//going on the height od the screen
        {
            for (int j = 0; j < _imageWriter.getWidth(); j++)//going on the width of the screen
            {
                if(j%interval==0 || i%interval==0)
                    _imageWriter.writePixel(j, i, new Color( 255,255,255));
            }

        }

    }

    private Map<Geometry, ArrayList<Point3D>> getSceneRayIntersections(Ray ray){
        Map<Geometry, ArrayList<Point3D>> ret = new HashMap<Geometry, ArrayList<Point3D>>();
        Iterator<Geometry> geometries = _scene.getGeometriesIterator();
        while(geometries.hasNext())
        {
            Geometry geo = geometries.next();
            ArrayList<Point3D> intersectionPoints = geo.findIntersections(ray);
            if(intersectionPoints.isEmpty() == false)
                ret.put(geo,intersectionPoints);
        }
        return  ret;
    }

    private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, ArrayList<Point3D>> intersectionPoints)
    {
        double distance = Double.MAX_VALUE;
        Point3D P0 = _scene.get_camera().getCenterOfProjection();
        Map<Geometry, Point3D> minDistancePoint = new HashMap<Geometry, Point3D>();
        for (Entry<Geometry, ArrayList<Point3D>> entry: intersectionPoints.entrySet())
            for (Point3D point: entry.getValue())
                if (P0.distance(point) < distance) {
                    minDistancePoint.clear();
                    minDistancePoint.put(entry.getKey(), new Point3D(point));
                    distance = P0.distance(point);
                }
        return minDistancePoint;

    }
    private Color calcColor(Geometry geometry, Point3D point) {
        Color ambientLight = _scene.getAmbientLight().getIntensity(point);
        Color emissionLight = geometry.getEmmision();
        Color I0 = new Color (ambientLight.getRed()    + emissionLight.getRed(),
                ambientLight.getGreen() + emissionLight.getGreen(),
                ambientLight.getBlue()    + emissionLight.getBlue());
        return I0;
    }
}
