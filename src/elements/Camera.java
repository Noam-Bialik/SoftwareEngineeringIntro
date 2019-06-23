package elements;

import primitives.*;

public class Camera {
    Vector Vup, Vright, Vtowards;
    Point3D centerOfProjection;

    public Camera(Vector v_up, Vector v_towards, Point3D centerOfProjection) {
        if (v_up.dotProduct(v_towards) != 0)
            throw new ArithmeticException("The vectors must be vertical");
        Vup  = new Vector(v_up);
        Vtowards = new Vector(v_towards);
        Vright = new Vector(Vup.crossProduct(Vtowards));
        Vup.normalization();
        Vtowards.normalization();
        Vright.normalization();
        this.centerOfProjection = new Point3D(centerOfProjection);
    }

    public Vector getVup() {
        return new Vector(Vup);
    }

    public Vector getVright() {
        return new Vector(Vright);
    }

    public Vector getVtowards() {
        return new Vector(Vtowards);
    }

    public Point3D getCenterOfProjection() {
        return new Point3D(centerOfProjection);
    }

   public Ray constructRayThroughPixel(int Nx, int Ny, double x, double y, double screenDistance, double screenWidth, double screenHeight)
   {
      //calc the ratio of all  pixel
      double Rx = screenWidth/Nx;
      double Ry = screenHeight/Ny;

      double A = (x - Nx/2) * Rx + Rx/2;
      double B = (y - Ny/2) * Ry + Ry/2;

      Vector helpR = new Vector(Vright);
      helpR.mult(A);
      Vector helpU = new Vector(Vright);
      helpU.mult(B);

      Vector RayVector = new Vector(helpR.substract(helpU));
      return new Ray(RayVector, centerOfProjection);
   }
}
