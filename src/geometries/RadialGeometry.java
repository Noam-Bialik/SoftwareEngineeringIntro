package geometries;

import java.util.Objects;

abstract class RadialGeometry extends Geometry {
    private double _radius;

    public RadialGeometry(double radius){
        _radius = radius;
    }

    public RadialGeometry(RadialGeometry other){
        _radius = other._radius;
    }

    public double get_radius() {
        return _radius;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RadialGeometry)) return false;
        if (!super.equals(o)) return false;
        RadialGeometry that = (RadialGeometry) o;
        return Double.compare(that.get_radius(), get_radius()) == 0;
    }

}
