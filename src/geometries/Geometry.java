package geometries;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Geometry  {

    public static final ArrayList<Point3D> EMPTY_LIST = new ArrayList<Point3D>();

    public abstract ArrayList<Point3D> findIntersections(Ray ray);
    public abstract Vector getNormal(Point3D point3D);

     protected Color emmision= new Color(0,0,0);

     protected Material material =new Material();


    // ***************** Getters/Setters ********************** //

    public  Color getEmmision()
    {
        return new Color(emmision.getRGB());
    }
    public Color setEmmision(Color color)
    {
        emmision = new Color(color.getRGB());
        return this.getEmmision();
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double get_kd() {
        return material.get_kd();
    }

    public void set_kd(double _kd) {
        material.set_kd(_kd);
    }

    public double get_ks() {
        return material.get_ks();
    }

    public void set_ks(double _ks) {
        material.set_ks(_ks);
    }

    public double get_nShininess() {
        return material.get_nShininess();
    }

    public void set_nShininess(double _nShininess) {
        material.set_nShininess(_nShininess);
    }

    public double get_Kr() {
        return material.get_Kr();
    }

    public void set_Kr(double _Kr) {
        material.set_Kr(_Kr);
    }

    public double get_Kt() {
        return material.get_Kt();
    }

    public void set_Kt(double _Kt) {
        material.set_kd(_Kt);
    }



    // ***************** Administration  ******************** //


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Geometry)) return false;
        Geometry geometry = (Geometry) o;
        return Objects.equals(getEmmision(), geometry.getEmmision()) &&
                Objects.equals(getMaterial(), geometry.getMaterial());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmmision(), getMaterial());
    }

    @Override
    public String toString() {
        return "Geometry{" +
                "emmision=" + emmision +
                ", material=" + material +
                '}';
    }
}
