import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MessageWriterTest {
  private File tempDir;

  @BeforeEach
  void setUp() {
    tempDir = new File(System.getProperty("java.io.tmpdir") + File.separator + "testOutput");
  }

  @AfterEach
  void tearDown() {
    for (File f : tempDir.listFiles()) f.delete();
    tempDir.delete();
  }

  @Test
  void testFileCreated() throws IOException{
    MessageWriter writer = new MessageWriter(tempDir.getPath());
    writer.writeMessage("This is a test.", "test.txt");

    File outputFile = new File(tempDir.getPath() + File.separator + "test.txt");
    assertTrue(outputFile.exists());
  }

  @Test
  void testCorrectContent() throws IOException{
    MessageWriter writer = new MessageWriter(tempDir.getPath());
    writer.writeMessage("This is a test.", "test.txt");

    BufferedReader reader = new BufferedReader(new FileReader(tempDir.getPath() + File.separator + "test.txt"));
    assertEquals("This is a test.", reader.readLine());
    reader.close();
  }

  @Test
  void testDirCreated() throws IOException{
    MessageWriter writer = new MessageWriter(tempDir.getPath());
    writer.writeMessage("This is a test.", "test.txt");
    assertTrue(tempDir.exists());
  }
}