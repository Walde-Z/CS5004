import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArtistTest {

  @Test
  void testActorCreation() {
    String[] genres = {"Drama"};
    String[] awards = {"Oscar"};
    String[] movies = {"M test"};
    String[] series = {"S test"};
    String[] otherMultimedia = {"O test"};

    Actor A = new Actor("Ada", "White", 23, genres, awards, movies, series, otherMultimedia);
    assertEquals("Ada", A.getFirstName());
    assertEquals("White", A.getLastName());
    assertEquals(23, A.getAge());
    assertEquals(1, A.getGenres().length);
  }

  @Test
  void testMusicianCreation() {
    String[] genres = {"G"};
    String[] awards = {"O"};
    String recordingCompany = "Sony";
    String lastAlbum = "Test";

    Musician B = new Musician("Brave", "Green", 33, genres, awards, recordingCompany, lastAlbum);
    assertEquals("Brave", B.getFirstName());
    assertEquals("Green", B.getLastName());
    assertEquals("Sony", B.getRecordingCompany());
  }

  @Test
  void testPoetCreation() {
    String[] genres = {"R"};
    String[] awards = {"S"};
    String publishingCompany = "Publish";
    String lastCollection = "Test";

    Poet C = new Poet("Christine", "L", 45, genres, awards, publishingCompany, lastCollection);

    assertEquals("L", C.getLastName());
    assertEquals("Publish", C.getPublishingCompany());
  }

  @Test
  void testPainterCreation() {
    String[] genres = {"M"};
    String[] awards = {"C"};
    String[] exhibits = {"Ex"};

    Painter P = new Painter("Peter", "Wong", 11, genres, awards, exhibits);

    assertEquals("Peter", P.getFirstName());
    assertEquals(1, P.getExhibits().length);
  }

  @Test
  void testReceiveAvard() {
    Actor actor = new Actor("John", "Doe", 40,
        new String[]{"Action"},
        new String[]{"Oscar"},
        new String[]{}, new String[]{}, new String[]{});

    assertEquals(1, actor.getAwards().length);

    actor.receiveAward("B");
    assertEquals(2, actor.getAwards().length);
    assertEquals("B", actor.getAwards()[1]);
  }

  @Test
  void testInvalidAge() {
    assertThrows(IllegalArgumentException.class, () -> new Actor("John",
        "Doe", -1,
        new String[]{"Action"},
        new String[]{"Oscar"},
        new String[]{}, new String[]{}, new String[]{}));

    assertThrows(IllegalArgumentException.class, () -> new Actor("John",
        "Doe", 130,
        new String[]{"Action"},
        new String[]{"Oscar"},
        new String[]{}, new String[]{}, new String[]{}));
  }
}