package Scene;

import elements.AmbientLight;
import elements.Camera;
import elements.Light;
import geometries.Geometry;
import primitives.Point3D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Scene {

    private Color _background;
    private ArrayList<Geometry> _geometries = new ArrayList<Geometry>();
    private AmbientLight _ambientLight;
    private Camera _camera;
    private double _screenDistance;
    private String _sceneName = "scene";
    private ArrayList<Light> _lights = new ArrayList<Light>();
    // ***************** Constructors ********************** //
    public Scene()
    {
        _background=new Color(0, 0, 0);
        _camera=new Camera();
        _screenDistance=100;
        _ambientLight=new AmbientLight();

    }
    public Scene (Scene scene)
    {
        _background=new Color(scene._background.getRGB());
        _ambientLight=new AmbientLight(scene._ambientLight);
        _geometries=new ArrayList<Geometry>(scene._geometries);
        _camera=new Camera(scene._camera);
        _screenDistance=scene._screenDistance;
        _sceneName=new String(scene._sceneName);
        _lights = new ArrayList<Light>(scene._lights);
    }
    public Scene(AmbientLight aLight, Color background, Camera camera, double screenDistance)
    {
        _background=new Color(background.getRGB());
        _ambientLight=new AmbientLight(aLight);
        _camera=new Camera(camera);
        _screenDistance=screenDistance;
        _lights = new ArrayList<Light>(_lights);

    }
    // ***************** Getters/Setters ********************** //
    public AmbientLight getAmbientLight()
    {
        return _ambientLight;
    }

    public void setAmbientLight(AmbientLight ambientLight)
    {
        _ambientLight=new AmbientLight(ambientLight);
    }

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

    public ArrayList<Light> get_lights() {
        return new ArrayList<Light>(_lights);
    }

    public void set_lights(ArrayList<Light> _lights) {
        this._lights = new ArrayList<Light>(_lights);
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

    public Iterator<Geometry> getGeometriesIterator()
    {
        return _geometries.iterator();

    }

    public void addLight(Light light)
    {
        _lights.add(light);
    }

    public Iterator<Light> getLightsIterator()
    {
        return _lights.iterator();

    }
}
