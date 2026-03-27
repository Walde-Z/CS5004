import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemplateProcessorTest {
  private File templateFile;

  @BeforeEach
  void setUp() throws IOException {
    templateFile = File.createTempFile("template", ".txt");
    BufferedWriter writer = new BufferedWriter(new FileWriter(templateFile));
    writer.write("Dear [[first_name]] [[last_name]],\n");
    writer.write("Your email is [[email]].\n");
    writer.close();
  }

  @Test
  void testSingleReplace() throws IOException {
    TemplateProcessor path = new TemplateProcessor(templateFile.getPath());
    HashMap<String, String> row = new HashMap<>();
    row.put("first_name", "Art");
    row.put("last_name", "Venere");
    row.put("email", "art@venere.org");

    String content = path.process(row);
    assertEquals("Dear Art Venere,\nYour email is art@venere.org.\n", content);
  }

  @Test
  void testNoParentheses() throws IOException {
    TemplateProcessor path = new TemplateProcessor(templateFile.getPath());
    HashMap<String, String> row = new HashMap<>();
    row.put("first_name", "Art");
    row.put("last_name", "Venere");
    row.put("email", "art@venere.org");

    String content = path.process(row);
    assertFalse(content.contains("[") || content.contains("]"));
  }
}