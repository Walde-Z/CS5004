package main;

import java.awt.Point;

/**
 * Calculate the area of a triangle with 3 points.
 */

public class Triangle extends AbstractShape {

  private final Point2D A;
  private final Point2D B;
  private final Point2D C;

  /**
   * Constructs a triangle with the given attributions.
   *
   * @param A Coordinates of point A
   * @param B Coordinates of point B
   * @param C Coordinates of point C
   * @throws IllegalArgumentException A triangle with two (or three) identical points cannot be
   *                                  constructed.
   */
  public Triangle(Point2D A, Point2D B, Point2D C) {
    super(A);

    if (A == null || B == null || C == null) {
      throw new IllegalArgumentException("Points cannot be null");
    }

    if (A.distance(B) == 0 || B.distance(C) == 0 || A.distance(C) == 0) {
      throw new IllegalArgumentException("Triangle cannot have identical points.");
    }

    this.A = A;
    this.B = B;
    this.C = C;
  }

  @Override
  public double perimeter() {
    double a = A.distance(B);
    double b = B.distance(C);
    double c = A.distance(C);

    return a + b + c;
  }

  @Override
  public double area() {
    double a = A.distance(B);
    double b = B.distance(C);
    double c = A.distance(C);

    double s = (a + b + c) / 2.0;
    double value = s * (s - a) * (s - b) * (s - c);

    return Math.sqrt(Math.max(0, value));
  }

  @Override
  public String toString() {
    return "Triangle(" + A + ", " + B + ", " + C + ")";
  }
}