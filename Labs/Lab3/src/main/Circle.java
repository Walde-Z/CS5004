package main;

public class Circle extends AbstractShape {
  private final double radius;

  public Circle(Point2D referencePoint, double radius) {
    super(referencePoint);

    if (radius < 0) {
      throw new IllegalArgumentException("Radius must be non-negative");
    }
    this.radius = radius;
  }

  @Override
  public double perimeter() {
    return 2 * Math.PI * radius;
  }

  @Override
  public double area() {
    return Math.PI * radius * radius;
  }

  @Override
  public String toString() {
    return "Circle(radius=" + radius + ")";
  }
}
