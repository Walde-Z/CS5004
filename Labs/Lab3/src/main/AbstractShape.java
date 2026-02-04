package main;

public abstract class AbstractShape implements Shape {
  protected Point2D referencePoint;

  protected AbstractShape(Point2D referencePoint) {
    if (referencePoint == null) {
      throw new IllegalArgumentException("Reference point can not be null.");
    }
    this.referencePoint = referencePoint;
  }

  @Override
  public double distanceFromOrigin() {
    return referencePoint.distanceFromOrigin();
  }
}
