package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;
import java.util.Objects;

public class DirectionalLight extends Light {

    Vector _direction;
    // ***************** Constructors ********************** //

    public DirectionalLight(Color _color, Vector _direction) {
        super(_color);
        this._direction = new Vector(_direction);
    }
    public DirectionalLight(DirectionalLight directionalLight) {
        super(directionalLight._color);
        this._direction = new Vector(directionalLight._direction);
    }



    // ***************** Getters/Setters ********************** //

    public Vector get_direction() {
        return new Vector(_direction);
    }

    public void set_direction(Vector _direction) {
        this._direction = new Vector(_direction);
    }

    // ***************** Administration  ******************** //
    @Override
    public String toString() {
        return "DirectionalLight{" +
                "_direction=" + _direction +
                ", _color=" + _color +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DirectionalLight)) return false;
        if (!super.equals(o)) return false;
        DirectionalLight that = (DirectionalLight) o;
        return Objects.equals(_direction, that._direction);
    }

    // ***************** Operations ******************** //

    @Override
    public Color getIntensity(Point3D point) {
        return get_color();
    }

    @Override
    public Vector getL(Point3D point) {
        return new Vector(_direction);
    }
}
