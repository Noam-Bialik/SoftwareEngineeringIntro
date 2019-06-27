package primitives;

import java.util.Objects;

public class Material {
    private double _kd; // Diffusion attenuation coefficient
    private double _ks; // Specular attenuation coefficient
    private double _nShininess;  // Refraction index
    private double _Kr;
    private double _Kt;
    // ***************** Constructors ********************** //
    public Material(){

    }
    public Material(double _kd, double _ks, double _nShininess) {
        this._kd = _kd;
        this._ks = _ks;
        this._nShininess = _nShininess;
    }

    public Material(double _kd, double _ks, double _nShininess, double _Kr, double _Kt) {
        this(_kd, _ks, _nShininess);
        this._Kr = _Kr;
        this._Kt = _Kt;
    }

    public Material(Material material) {
        this(material._kd, material._ks, material._nShininess);
        this._Kr = material._Kr;
        this._Kt = material._Kt;
    }

    // ***************** Getters/Setters ********************** //

    public double get_kd() {
        return _kd;
    }

    public void set_kd(double _kd) {
        this._kd = _kd;
    }

    public double get_ks() {
        return _ks;
    }

    public void set_ks(double _ks) {
        this._ks = _ks;
    }

    public double get_nShininess() {
        return _nShininess;
    }

    public void set_nShininess(double _nShininess) {
        this._nShininess = _nShininess;
    }

    public double get_Kr() {
        return _Kr;
    }

    public void set_Kr(double _Kr) {
        this._Kr = _Kr;
    }

    public double get_Kt() {
        return _Kt;
    }

    public void set_Kt(double _Kt) {
        this._Kt = _Kt;
    }

    // ***************** Administration  ******************** //

    @Override
    public String toString() {
        return "Material{" +
                "_kd=" + _kd +
                ", _ks=" + _ks +
                ", _nShininess=" + _nShininess +
                ", _Kr=" + _Kr +
                ", _Kt=" + _Kt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Material)) return false;
        Material material = (Material) o;
        return Double.compare(material.get_kd(), get_kd()) == 0 &&
                Double.compare(material.get_ks(), get_ks()) == 0 &&
                Double.compare(material.get_nShininess(), get_nShininess()) == 0 &&
                Double.compare(material.get_Kr(), get_Kr()) == 0 &&
                Double.compare(material.get_Kt(), get_Kt()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_kd(), get_ks(), get_nShininess(), get_Kr(), get_Kt());
    }

    // ***************** Operations ******************** //


}
