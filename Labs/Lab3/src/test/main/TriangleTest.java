package main;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

  @org.junit.jupiter.api.Test
  void testPerimeter() {
    Point2D A = new Point2D(0, 0);
    Point2D B = new Point2D(3, 0);
    Point2D C = new Point2D(0, 4);

    Triangle p = new Triangle(A, B, C);
    assertEquals(12.0, p.perimeter());
  }

  @org.junit.jupiter.api.Test
  void testArea() {
    Point2D A = new Point2D(0, 0);
    Point2D B = new Point2D(3, 0);
    Point2D C = new Point2D(0, 4);

    Triangle p = new Triangle(A, B, C);
    assertEquals(6.0, p.area());
  }

  @org.junit.jupiter.api.Test
  void testToString() {
  }

  @org.junit.jupiter.api.Test
  void testCollinearTriangle() {
    Point2D A = new Point2D(0, 0);
    Point2D B = new Point2D(0, 3);
    Point2D C = new Point2D(0, 4);

    Triangle p = new Triangle(A, B, C);
    assertEquals(0.0, p.area());
    assertTrue(p.perimeter() > 0);
  }

  @org.junit.jupiter.api.Test
  void testDuplicatePoints() {
    Point2D A = new Point2D(1, 1);

    assertThrows(IllegalArgumentException.class,
        () -> new Triangle(A, A, new Point2D(2, 2)));
  }

  @org.junit.jupiter.api.Test
  void testReferencePoint() {
    Point2D d = new Point2D(3, 4);
    Triangle t = new Triangle(d, new Point2D(0, 0), new Point2D(1, 1));

    assertEquals(5.0, t.distanceFromOrigin());
  }
}