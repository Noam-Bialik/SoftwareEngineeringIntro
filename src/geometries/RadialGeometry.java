package geometries;

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

}
