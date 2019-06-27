package renderer;

import Scene.*;
import elements.Light;
import geometries.Geometry;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Map.*;

public class Renderer {
    Scene _scene;
    ImageWriter _imageWriter;
    final int RECURSION_LEVEL =3;

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
    private Color calcColor(Geometry geometry, Point3D point, Ray inRay, int level) {
        if (level == RECURSION_LEVEL)
            return new Color(0, 0, 0);
        Color ambientLight = _scene.getAmbientLight().getIntensity(point);
        Color emissionLight = geometry.getEmmision();
        Iterator<Light> lights = _scene.getLightsIterator();
        Color diffuseLight = Color.WHITE, specularLight =Color.WHITE;
        while (lights.hasNext())
        {
            if (!occluded(light, point, geometry))
            {
                diffuseLight += calcDiffusiveComp(…);
                specularLight += calcSpecularComp(…);
            }
        }
 
        reﬂectedRay = constructReﬂectedRay(geometry.getNormal(point), point, inRay); 
        reﬂectedEntry = ﬁndClosesntIntersection(reﬂectedRay);
          reﬂectedColor = calcColor(reﬂectedEntry.geometry, reﬂectedEntry.point, reﬂectedRay, level + 1);
        kr = geometry.material.Kr;
        reﬂectedLight = new Color (Kr * reﬂectedColor);
        refractedRay = constructRefractedRay(geometry.getNormal(point), point, inRay);
          refractedEntry = ﬁndClosesntIntersection(reﬂectedRay); 
        refractedColor = calcColor(reﬂectedEntry.geometry, reﬂectedEntry.point, reﬂectedRay, level + 1);
        kt = geometry.material.Kr;
        refractedLight = new Color (Kt * refractedColor);
        return new Color(ambientLight + emissionLight + diffuseLight + specularLight  + reﬂectedLight + refractedLight)
    }

    private boolean occluded(Light light, Point3D point, Geometry geometry)
    {
        Vector lightDirection = light.getL(point);
        lightDirection.mult(-1);
        Point3D geometryPoint = new Point3D(point);
        Vector epsVector = new Vector(geometry.getNormal(point));
        epsVector.mult(2);
        geometryPoint.addVector(epsVector);
        Ray lightRay = new Ray(lightDirection, geometryPoint);
        Map<Geometry, ArrayList<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay);
        // Flat geometry cannot self intersect
        if (geometry instanceof FlatGeometry)
        {
            intersectionPoints.remove(geometry);
        }
        for (Entry<Geometry, ArrayList<Point3D>> entry: intersectionPoints.entrySet())
            if (entry.getKey().getMaterial().get_Kt() == 0)
                return true;
        return false;
    }
}
