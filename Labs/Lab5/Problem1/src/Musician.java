public class Musician extends Artist{
  private String recordingCompany;
  private String lastAlbum;

  public Musician(String firstName,
      String lastName,
      int age,
      String[] genres,
      String[] awards,
      String recordingCompany,
      String lastAlbum) {
    super(firstName, lastName, age, genres, awards);
    this.recordingCompany = recordingCompany;
    this.lastAlbum = lastAlbum;
  }

  public String getRecordingCompany() {
    return recordingCompany;
  }

  public String getLastAlbum() {
    return lastAlbum;
  }
}
