public abstract class VisualArtist extends Artist {
  private String[] exhibits;

  public VisualArtist(String firstName,
      String lastName,
      int age,
      String[] genres,
      String[] awards,
      String[] exhibits) {
    super(firstName, lastName, age, genres, awards);
    this.exhibits = exhibits;
  }

  public String[] getExhibits() {
    return exhibits;
  }
}
