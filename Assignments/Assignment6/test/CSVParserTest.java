import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CSVParserTest {
  private File tempFile;

  @BeforeEach
  void setUp() throws IOException {
    tempFile = File.createTempFile("test", ".csv");
    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
    writer.write("\"first_name\",\"last_name\",\"email\",\"company\"\n");
    writer.write("\"Art\",\"Venere\",\"art@venere.org\",\"Chemel\"\n");
    writer.write("\"James\",\"Reign\",\"james.reign@gmail.com\",\"Benton\"\n");
    writer.write("\"Josephine\",\"R, Darakjy\",\"josie55@hotmail.com\",\"Canay\"\n");
    writer.close();
  }

  @Test
  void testSize() throws IOException {
      CSVParser parser = new CSVParser(tempFile.getPath());
      ArrayList<HashMap<String, String>> row = parser.parse();
      assertEquals(3, row.size());
  }

  @Test
  void testFirstLineContent() throws IOException {
    CSVParser parser = new CSVParser(tempFile.getPath());
    ArrayList<HashMap<String, String>> row = parser.parse();
    assertEquals("Art", row.get(0).get("first_name"));
  }

  @Test
  void testContentWithComma() throws IOException {
    CSVParser parser = new CSVParser(tempFile.getPath());
    ArrayList<HashMap<String, String>> row = parser.parse();
    assertEquals("R, Darakjy", row.get(2).get("last_name"));
  }
}