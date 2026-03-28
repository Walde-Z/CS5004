import java.util.ArrayList;

public class Band implements Creator{
  private String name;
  private ArrayList<RecordingArtist> members;

  public Band(String name) {
    this.name = name;
    this.members = new ArrayList<>();
  }

  public Band(String name, ArrayList<RecordingArtist> members) {
    this.name = name;
    this.members = members;
  }

  public String getName() {
    return name;
  }

  public ArrayList<RecordingArtist> getMembers() {
    return members;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Band) {
      return (((Band) other).getName()).equals(getName());
    } else if (other instanceof RecordingArtist) {
      return members.contains(other);
    }
    return false;
  }
}
