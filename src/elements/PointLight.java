package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;
import java.util.Objects;

public class PointLight extends Light{
    Point3D position;
    double _kc, _kl, _kq;

    // ***************** Constructors ********************** //

    public PointLight(Color _color, Point3D position, double _kc, double _kl, double _kq) {
        super(_color);
        this.position = new Point3D(position);
        this._kc = _kc;
        this._kl = _kl;
        this._kq = _kq;
    }

    public PointLight(PointLight pointLight) {
        super(pointLight._color);
        this.position = new Point3D(pointLight.position);
        this._kc = pointLight._kc;
        this._kl = pointLight._kl;
        this._kq = pointLight._kq;
    }



    // ***************** Getters/Setters ********************** //

    public Point3D getPosition() {
        return new Point3D(position);
    }

    public void setPosition(Point3D position) {
        this.position = new Point3D(position);
    }

    public double get_kc() {
        return _kc;
    }

    public void set_kc(double _kc) {
        this._kc = _kc;
    }

    public double get_kl() {
        return _kl;
    }

    public void set_kl(double _kl) {
        this._kl = _kl;
    }

    public double get_kq() {
        return _kq;
    }

    public void set_kq(double _kq) {
        this._kq = _kq;
    }

    // ***************** Administration  ******************** //


    @Override
    public String toString() {
        return "PointLight{" +
                "position=" + position +
                ", _kc=" + _kc +
                ", _kl=" + _kl +
                ", _kq=" + _kq +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PointLight)) return false;
        if (!super.equals(o)) return false;
        PointLight that = (PointLight) o;
        return Double.compare(that.get_kc(), get_kc()) == 0 &&
                Double.compare(that.get_kl(), get_kl()) == 0 &&
                Double.compare(that.get_kq(), get_kq()) == 0 &&
                Objects.equals(getPosition(), that.getPosition());
    }


    // ***************** Operations ******************** //

    @Override
    public Color getIntensity(Point3D point) {
        double d = point.distance(position);
        return multColor(_color,1/(_kc * _kl*d * _kq*d*d));
    }

    @Override
    public Vector getL(Point3D point) {
        return point.substract(position);
    }

}
