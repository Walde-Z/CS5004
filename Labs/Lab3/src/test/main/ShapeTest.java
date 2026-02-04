package main;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

  @org.junit.jupiter.api.Test
  void testArea() {
    Shape r = new Rectangle(new Point2D(3, 4), 2, 5);
    Shape c = new Circle(new Point2D(3, 4), 1);

    assertEquals(10.0, r.area());
    assertEquals(Math.PI, c.area());
  }

  @org.junit.jupiter.api.Test
  void testPerimeter() {
    Shape r = new Rectangle(new Point2D(3, 4), 2, 5);
    Shape c = new Circle(new Point2D(3, 4), 1);

    assertEquals(14.0, r.perimeter());
    assertEquals(2.0 * Math.PI, c.perimeter());
  }

  @org.junit.jupiter.api.Test
  void testDistanceFromOrigin() {
    Shape r = new Rectangle(new Point2D(3, 4), 2, 5);
    Shape c = new Circle(new Point2D(3, 4), 1);

    assertEquals(5.0, r.distanceFromOrigin());
    assertEquals(5.0, c.distanceFromOrigin());
  }
}