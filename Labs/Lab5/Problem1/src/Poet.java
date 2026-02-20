public class Poet extends Artist{
  private String publishingCompany;
  private String lastCollection;

  public Poet(String firstName,
      String lastName,
      int age,
      String[] genres,
      String[] awards,
      String publishingCompany,
      String lastCollection) {
    super(firstName, lastName, age, genres, awards);
    this.publishingCompany = publishingCompany;
    this.lastCollection = lastCollection;
  }

  public String getPublishingCompany() {
    return publishingCompany;
  }

  public String getLastCollection() {
    return lastCollection;
  }
}
