package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;
import java.util.Objects;

public class SpotLight extends PointLight {


    Vector _direction;
    // ***************** Constructors ********************** //

    public SpotLight(Color _color, Point3D position, double _kc, double _kl, double _kq, Vector _direction) {
        super(_color, position, _kc, _kl, _kq);
        this._direction = _direction;
    }

    public SpotLight(SpotLight spotLight) {
        super(spotLight._color, spotLight.position, spotLight._kc, spotLight._kl, spotLight._kq);
        this._direction = new Vector(spotLight._direction);
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
        return "SpotLight{" +
                "_direction=" + _direction +
                ", position=" + position +
                ", _kc=" + _kc +
                ", _kl=" + _kl +
                ", _kq=" + _kq +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpotLight)) return false;
        if (!super.equals(o)) return false;
        SpotLight spotLight = (SpotLight) o;
        return Objects.equals(_direction, spotLight._direction);
    }



    // ***************** Operations ******************** //


    @Override
    public Color getIntensity(Point3D point) {
        double d = point.distance(position);
        return multColor(multColor(_color,_direction.dotProduct(getL(point))),1/(_kc + _kl*d + _kq*d*d));
    }
}
