package elements;

import primitives.Point3D;

import java.awt.*;
import java.util.Objects;

public class AmbientLight {
    Color _color;
    double _ka;
    // ***************** Constructors ********************** //

    public AmbientLight(Color _color, double _ka) {
        this._color = new Color(_color.getRGB());
        this._ka = _ka;
    }

    public AmbientLight(AmbientLight ambientLight) {
        this._color = new Color(ambientLight._color.getRGB());
        this._ka = ambientLight._ka;
    }

    public AmbientLight() {
        _color = new Color(255,255,255);
        _ka =1;
    }

    public AmbientLight (int Red, int Green, int Blue){
        _color = new Color(Red,Green,Blue);
        _ka =0.1;
    }
    // ***************** Getters/Setters ********************** //
    // ***************** Administration  ******************** //

    @Override
    public String toString() {
        return "AmbientLight{" +
                "_color=" + _color +
                ", _ka=" + _ka +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AmbientLight)) return false;
        AmbientLight that = (AmbientLight) o;
        return Double.compare(that._ka, _ka) == 0 &&
                Objects.equals(_color, that._color);
    }


    // ***************** Operations ******************** //
    public Color getIntensity(Point3D point3D)
    {
    return new Color(1,2,2);
    }
}
