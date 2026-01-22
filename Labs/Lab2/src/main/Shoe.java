package main;

/**
 * Represents a shoe with a specific kind, color, brand, and size.
 */

public class Shoe {
  private Kind kind;
  private Color color;
  private Brand brand;
  private double size;

  /**
   * Constructs a Shoe with the given attributes.
   *
   * @param kind  the type of the shoe
   * @param color the color of the shoe
   * @param brand the brand of the shoe
   * @param size  the size of the shoe
   * @throws IllegalArgumentException if the brand is NIKE and the kind is DRESS
   */
  public Shoe(Kind kind, Color color, Brand brand, double size) {
    if (kind == Kind.DRESS && brand == Brand.NIKE) {
      throw new IllegalArgumentException();
    }

    this.kind = kind;
    this.color = color;
    this.brand = brand;
    this.size = size;
  }

  /**
   * Returns the kind of this shoe.
   *
   * @return the shoe kind
   */
  public Kind getKind() {
    return kind;
  }

  /**
   * Returns the color of this shoe.
   *
   * @return the shoe color
   */
  public Color getColor() {
    return color;
  }

  /**
   * Returns the brand of this shoe.
   *
   * @return the shoe brand
   */
  public Brand getBrand() {
    return brand;
  }

  /**
   * Returns the size of this shoe.
   *
   * @return the shoe size
   */
  public double getSize() {
    return size;
  }

  /**
   * Returns a formatted string describing this shoe.
   *
   * @return a string summary of the shoe
   */
  @Override
  public String toString() {
    String kindStr;
    switch (kind) {
      case DRESS:
        kindStr = "Dress";
        break;
      case BOOT:
        kindStr = "Boot";
        break;
      case SNEAKER:
        kindStr = "Sneaker";
        break;
      case SANDAL:
        kindStr = "Sandal";
        break;
      default:
        kindStr = "Unknown";
    }

    String colorStr;
    switch (color) {
      case BLACK:
        colorStr = "Black";
        break;
      case PINK:
        colorStr = "Pink";
        break;
      case BLUE:
        colorStr = "Blue";
        break;
      case GREEN:
        colorStr = "Green";
        break;
      default:
        colorStr = "Neutral";
    }

    String brandStr;
    switch (brand) {
      case NIKE:
        brandStr = "Nike";
        break;
      case ADIDAS:
        brandStr = "Adidas";
        break;
      case FILA:
        brandStr = "Fila";
        break;
      case CONVERSE:
        brandStr = "Converse";
        break;
      default:
        brandStr = "Generic";
    }

    return String.format(
      "%s %s %s (Size %.1f)",
      colorStr, brandStr, kindStr, size
    );
  }
}