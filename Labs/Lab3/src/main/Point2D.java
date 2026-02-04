package main;

import javax.lang.model.util.Elements.Origin;

public class Point2D {
  private final double x;
  private final double y;

  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point2D other) {
    double dx = x - other.x;
    double dy = y - other.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

  public double distanceFromOrigin() {
    return Math.sqrt(x * x + y * y);
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }
}
