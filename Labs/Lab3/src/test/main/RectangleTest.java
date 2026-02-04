package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectangleTest {

  @Test
  void testArea() {
    Rectangle r = new Rectangle(new Point2D(0, 0), 4, 5);
    assertEquals(20.0, r.area());
  }

  @Test
  void testPerimeter() {
    Rectangle r = new Rectangle(new Point2D(0, 0), 4, 5);
    assertEquals(18.0, r.perimeter());
  }

  @Test
  void testInvalidRectangle() {
    assertThrows(IllegalArgumentException.class, () -> new Rectangle(new Point2D(0, 0), -4, 5));
    assertThrows(IllegalArgumentException.class, () -> new Rectangle(new Point2D(0, 0), 4, -5));
  }
}