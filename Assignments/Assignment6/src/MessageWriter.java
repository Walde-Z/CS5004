import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Writes generated message content to text files in a specified output directory.
 * Creates the output directory if it does not already exist.
 */
public class MessageWriter {
  private String outputDir;

  /**
   * Creates a new MessageWriter that writes files to the given directory.
   * @param outputDir the path to the output directory
   */
  public MessageWriter(String outputDir) {
    this.outputDir = outputDir;
  }

  /**
   * Writes the given content to a file with the specified name
   * in the output directory. Creates the output directory if it
   * does not already exist.
   * @param content the text content to write to the file
   * @param fileName the name of the output file
   * @throws IOException if the file cannot be written
   */
  public void writeMessage(String content, String fileName) throws IOException {
    File dir = new File(outputDir);
    if (!dir.exists()) {
      dir.mkdir();
    }

    BufferedWriter writer = new BufferedWriter(new FileWriter(outputDir + File.separator + fileName));
    writer.write(content);
    writer.close();
  }
}
