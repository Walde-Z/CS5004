public class Book extends Item {
  private Author creator;

  public Book(String title, int year, Author creator) {
    super(title, year);
    this.creator = creator;
  }

  public Author  getCreator() {
    return creator;
  }
}
