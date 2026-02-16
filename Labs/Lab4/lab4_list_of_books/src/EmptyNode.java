public class EmptyNode implements IListOfBooks{

  public EmptyNode() {}

  @Override
  public int count() { return 0;}

  @Override
  public float totalPrice() { return 0.0f;}

  @Override
  public IListOfBooks allBefore(int year) {
    return new EmptyNode();
  }

  @Override
  public IListOfBooks addAtEnd(Book book) {
    return new ElementNode(book, new EmptyNode());
  }

  @Override
  public String toString() {
    return "";
  }
}
