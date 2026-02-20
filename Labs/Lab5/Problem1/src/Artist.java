import java.util.Arrays;

public abstract class Artist {
  private String firstName;
  private String lastName;
  private int age;
  private String[] genres;
  private String[] awards;

  public Artist(String firstName, String lastName, int age,
      String[] genres, String[] awards) {
    this.firstName = firstName;
    this.lastName = lastName;
    if (age < 0 || age > 128) {
      throw new IllegalArgumentException("Age should between 0 and 128 years old.");
    }
    else {this.age = age;}
    this.genres = genres;
    this.awards = awards;
  }

  public String getFirstName() {return firstName;}

  public String getLastName() {return lastName;}

  public int getAge() {return age;}

  public String[] getGenres() {return genres;}

  public String[] getAwards() {return awards;}

  public void receiveAward(String award) {
    this.awards = Arrays.copyOf(awards, awards.length + 1);
    this.awards[awards.length - 1] = award;
  }
}