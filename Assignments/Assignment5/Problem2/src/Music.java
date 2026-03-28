public class Music extends Item {
  private Creator creator;

  public Music(String title, int year, Creator creator) {
    super(title, year);
    this.creator = creator;
  }

  public Creator getCreator() {
    return creator;
  }
}
