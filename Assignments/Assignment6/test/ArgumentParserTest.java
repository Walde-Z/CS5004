import static org.junit.jupiter.api.Assertions.*;

class ArgumentParserTest {

  @org.junit.jupiter.api.Test
  void testValidEmailArgs() {
    String[] args = {"--email", "--email-template", "email.txt",
        "--output-dir", "output/", "--csv-file", "data.csv"};
    ArgumentParser parser = new ArgumentParser(args);
    parser.validate();

    assertTrue(parser.isEmail());
    assertEquals("email.txt", parser.getEmailTemplate());
    assertEquals("output/", parser.getOutputDir());
    assertEquals("data.csv", parser.getCsvFile());
  }

  @org.junit.jupiter.api.Test
  void testValidLetterArgs() {
    String[] args = {"--letter", "--letter-template", "letter.txt",
        "--output-dir", "output/", "--csv-file", "data.csv"};
    ArgumentParser parser = new ArgumentParser(args);
    parser.validate();

    assertTrue(parser.isLetter());
    assertEquals("letter.txt", parser.getLetterTemplate());
    assertEquals("output/", parser.getOutputDir());
    assertEquals("data.csv", parser.getCsvFile());
  }

  @org.junit.jupiter.api.Test
  void testMissingOutputDir() {
    String[] args = {"--email", "--email-template", "email.txt",
        "--csv-file", "data.csv"};
    ArgumentParser parser = new ArgumentParser(args);

    assertThrows(IllegalArgumentException.class, () -> parser.validate());
  }

  @org.junit.jupiter.api.Test
  void testMissingCsvFile() {
    String[] args = {"--email", "--email-template", "email.txt",
        "--output-dir", "output/"};
    ArgumentParser parser = new ArgumentParser(args);

    assertThrows(IllegalArgumentException.class, () -> parser.validate());
  }

  @org.junit.jupiter.api.Test
  void testMissingEmailTemplate() {
    String[] args = {"--email", "--output-dir", "output/", "--csv-file", "data.csv"};
    ArgumentParser parser = new ArgumentParser(args);

    assertThrows(IllegalArgumentException.class, () -> parser.validate());
  }

  @org.junit.jupiter.api.Test
  void testMissingLetterTemplate() {
    String[] args = {"--letter", "--output-dir", "output/", "--csv-file", "data.csv"};
    ArgumentParser parser = new ArgumentParser(args);

    assertThrows(IllegalArgumentException.class, () -> parser.validate());
  }

  @org.junit.jupiter.api.Test
  void testMissingEmailAndLetter() {
    String[] args = {"--output-dir", "output/", "--csv-file", "data.csv"};
    ArgumentParser parser = new ArgumentParser(args);

    assertThrows(IllegalArgumentException.class, () -> parser.validate());
  }
}