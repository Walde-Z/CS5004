package main;

import static org.junit.jupiter.api.Assertions.*;

class ShoeTest {
  private Shoe shoe;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    shoe = new Shoe(Kind.BOOT, Color.BLUE, Brand.FILA, 9.5);
  }

  @org.junit.jupiter.api.Test
  void testConstructorValid() {
    Shoe shoe = new Shoe(Kind.SNEAKER, Color.BLACK, Brand.ADIDAS, 9.5);

    assertEquals(Kind.SNEAKER, shoe.getKind());
    assertEquals(9.5, shoe.getSize());
  }

  @org.junit.jupiter.api.Test
  void testConstructorInvalid() {
    assertThrows(IllegalArgumentException.class,
        () -> new Shoe(Kind.DRESS, Color.BLACK, Brand.NIKE, 8.0));
  }

  @org.junit.jupiter.api.Test
  void getKind() {
    assertEquals(Kind.BOOT, shoe.getKind());
  }

  @org.junit.jupiter.api.Test
  void getColor() {
    assertEquals(Color.BLUE, shoe.getColor());
  }

  @org.junit.jupiter.api.Test
  void getBrand() {
    assertEquals(Brand.FILA, shoe.getBrand());
  }

  @org.junit.jupiter.api.Test
  void getSize() {
    assertEquals(9.5, shoe.getSize());
  }

  @org.junit.jupiter.api.Test
  void testToString() {
    Shoe shoe = new Shoe(Kind.SNEAKER, Color.BLACK, Brand.NIKE, 9.0);
    String s = shoe.toString();

    assertTrue(s.contains("Nike"));
    assertTrue(s.contains("Sneaker"));
  }
}