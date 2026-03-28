import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Parses a CSV file and returns the data as a list of key-value maps,
 * where each map represents one row with column headers as keys.
 */
public class CSVParser {
  private String filePath;

  /**
   * Creates a new CSVParser for the given file path.
   * @param filePath the path to the CSV file to parse
   */
  public CSVParser(String filePath) {
    this.filePath = filePath;
  }

  /**
   * Parses the CSV file and returns all rows as a list of HashMaps.
   * Each HashMap maps column header names to their corresponding values.
   * Handles values that contain commas by respecting quoted fields.
   * @return an ArrayList of HashMaps, where each HashMap represents one row
   * @throws IOException if the file cannot be read
   */
  public ArrayList<HashMap<String, String>> parse() throws IOException {
    ArrayList<HashMap<String, String>> result = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(filePath));

    String firstLine = reader.readLine();
    String[] headers = firstLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

    for (int i = 0; i < headers.length; i++) {
      headers[i] = headers[i].replace("\"", "");
    }

    String line;
    while ((line = reader.readLine()) != null) {
      if (line.trim().isEmpty()) continue;

      String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

      if (values.length != headers.length) continue;

      HashMap<String, String> row = new HashMap<>();
      for (int i = 0; i < headers.length; i++) {
        row.put(headers[i], values[i].replace("\"", ""));
      }
      result.add(row);
    }
    reader.close();
    return result;
  }
}
