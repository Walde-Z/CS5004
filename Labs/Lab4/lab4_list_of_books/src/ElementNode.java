public class ElementNode implements IListOfBooks{

  private Book book;
  private IListOfBooks rest;

  public ElementNode(Book book, IListOfBooks rest) {
    this.book = book;
    this.rest = rest;
  }

  @Override
  public int count() {
    return 1 + rest.count();
  }

  @Override
  public float totalPrice() {
    return book.getPrice() + rest.totalPrice();
  }

  @Override
  public IListOfBooks allBefore(int year) {
    if (book.getYear() < year) {
      return new ElementNode(book, rest.allBefore(year));
    }
    else {
      return rest.allBefore(year);
    }
  }

  @Override
  public IListOfBooks addAtEnd(Book newBook) {
    return new ElementNode(this.book, rest.addAtEnd(newBook));
  }

  @Override
  public String toString() {
    if (rest instanceof EmptyNode) {
      return book.toString();
    }
    else {
      return book.toString() + "\n" + rest.toString();
    }
  }
}
