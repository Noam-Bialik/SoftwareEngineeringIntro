package Scene;

import elements.Camera;
import geometries.Geometry;
import primitives.Point3D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Scene {

    private Color _background;
    private ArrayList<Geometry> _geometries = new ArrayList<Geometry>();
    private Camera _camera;
    private double _screenDistance;
    private String _sceneName = "scene";
    // ***************** Constructors ********************** //
    public Scene()
    {
        _background=new Color(0, 0, 0);
        _camera=new Camera();
        _screenDistance=100;

    }
    // ***************** Getters/Setters ********************** //

    public Color get_background() {
        return new Color(_background.getRGB());
    }

    public void set_background(Color _background) {
        this._background = new Color(_background.getRGB());
    }

    public ArrayList<Geometry> get_geometries() {
        return new ArrayList<Geometry>(_geometries);
    }

    public Camera get_camera() {
        return new Camera(_camera);
    }

    public void set_camera(Camera _camera) {
        this._camera = new Camera(_camera);
    }

    public double get_screenDistance() {
        return _screenDistance;
    }

    public void set_screenDistance(double _screenDistance) {
        this._screenDistance = _screenDistance;
    }

    public String get_sceneName() {
        return _sceneName;
    }

    public void set_sceneName(String _sceneName) {
        this._sceneName = _sceneName;
    }

    // ***************** Administration  ******************** //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scene)) return false;
        Scene scene = (Scene) o;
        return Double.compare(scene.get_screenDistance(), get_screenDistance()) == 0 &&
                Objects.equals(get_background(), scene.get_background()) &&
                Objects.equals(_geometries, scene._geometries) &&
                Objects.equals(get_camera(), scene.get_camera()) &&
                Objects.equals(get_sceneName(), scene.get_sceneName());
    }

    // ***************** Operations ******************** //
    public void addGeometry(Geometry geometry)
    {
        _geometries.add(geometry);
    }



}
