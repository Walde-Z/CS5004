package main;

public class Rectangle extends AbstractShape{
  private final double width;
  private final double height;

  public Rectangle(Point2D referencePoint, double width, double height) {
    super(referencePoint);

    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Width and height must be non-negative");
    }

    this.width = width;
    this.height = height;
  }

  @Override
  public double area() {
    return width * height;
  }

  @Override
  public double perimeter() {
    return (width + height) * 2;
  }

  @Override
  public String toString() {
    return "Rectangle(width=" + width + ", height=" + height + ")";
  }
}
