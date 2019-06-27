package elements;

import primitives.*;

import java.awt.*;
import java.util.Objects;

public abstract class Light {
    Color _color;

    // ***************** Constructors ********************** //

    public Light(Color _color) {
        this._color = new Color(_color.getRGB());
    }
    public Light()
    {
        _color=new Color(0, 0, 0);
    }
    public Light(Light light) {
        this._color = new Color(light._color.getRGB());
    }

    // ***************** Getters/Setters ********************** //


    public Color get_color() {
        return new Color(_color.getRGB());
    }

    public void set_color(Color _color) {
        this._color = new Color(_color.getRGB());
    }

    // ***************** Administration  ******************** //
    @Override
    public String toString() {
        return "Light{" +
                "_color=" + _color +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Light)) return false;
        Light light = (Light) o;
        return Objects.equals(get_color(), light.get_color());
    }



    // ***************** Operations ******************** //

    public abstract Color getIntensity(Point3D point);
    public abstract Vector getL(Point3D point);

    protected Color multColor(Color color, double num)
    {
        int r=(int)(_color.getRed()*num);
        int g=(int)(_color.getGreen()*num);
        int b=(int)(_color.getBlue()*num);
        return new Color(r,g,b);
    }
}
