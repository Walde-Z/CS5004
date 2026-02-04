package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CircleTest {

  @Test
  void testPerimeter() {
    Circle c = new Circle(new Point2D(0, 0), 3.0);
    assertEquals(6.0 * Math.PI, c.perimeter());
  }

  @Test
  void testArea() {
    Circle c = new Circle(new Point2D(0, 0), 3.0);
    assertEquals(9.0 * Math.PI, c.area());
  }

  @Test
  void testInvalidCircle() {
    assertThrows(IllegalArgumentException.class, () -> new Circle(new Point2D(0, 0), -3));
  }
}