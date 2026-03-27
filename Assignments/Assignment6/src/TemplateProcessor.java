import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Processes a template file by replacing placeholders with values
 * from a given data map. Placeholders are formatted as [[column_name]].
 */
public class TemplateProcessor {
  private String templatePath;

  /**
   * Creates a new TemplateProcessor for the given template file path.
   * @param templatePath the path to the template file
   */
  public TemplateProcessor(String templatePath) {
    this.templatePath = templatePath;
  }

  /**
   * Reads the template file and returns its content as a single string.
   * @return the full content of the template file
   * @throws IOException if the file cannot be read
   */
  public String readTemplate() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(templatePath));
    StringBuilder content = new StringBuilder();

    String line;
    while ((line = reader.readLine()) != null) {
      content.append(line);
      content.append("\n");
    }
    reader.close();
    return content.toString();
  }

  /**
   * Processes the template by replacing all placeholders with the
   * corresponding values from the given row data.
   * For example, [[first_name]] will be replaced with the value
   * associated with the key "first_name" in the row map.
   * @param row a HashMap containing column names as keys and their
   *            corresponding values for one CSV row
   * @return the processed template content with all placeholders replaced
   * @throws IOException if the template file cannot be read
   */
  public String process(HashMap<String, String> row) throws IOException {
    String content = readTemplate();
    for (Map.Entry<String, String> entry: row.entrySet()) {
      content = content.replace("[[" + entry.getKey() + "]]", entry.getValue());
    }
    return content;
  }
}
