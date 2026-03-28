import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;

/**
 * Entry point for the message generator program.
 * Reads a CSV file and generates personalized email and/or letter
 * files based on provided templates and command line arguments.
 */
public class Main {

  /**
   * Main method that runs the message generator program.
   * Parses command line arguments, reads the CSV file, processes
   * templates, and writes output files for each row in the CSV.
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    try {
      ArgumentParser parser = new ArgumentParser(args);
      parser.validate();

      CSVParser csvParser = new CSVParser(parser.getCsvFile());
      ArrayList<HashMap<String, String>> rows = csvParser.parse();

      MessageWriter writer = new MessageWriter(parser.getOutputDir());

      for (int i = 0; i < rows.size(); i++) {
        if (parser.isEmail()) {
          TemplateProcessor emailProcessor = new TemplateProcessor(parser.getEmailTemplate());
          String content = emailProcessor.process(rows.get(i));
          writer.writeMessage(content, "email_" + (i + 1) + ".txt");
        }

        if (parser.isLetter()) {
          TemplateProcessor templateProcessor = new TemplateProcessor(parser.getLetterTemplate());
          String content = templateProcessor.process(rows.get(i));
          writer.writeMessage(content, "letter_" + (i + 1) + ".txt");
        }
      }
    }
    catch (IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
      return;
    }
    catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      System.out.println("Usage:\n" +
          "--email Generate email messages. If this option is provided, then --email-template must also be provided.\n" +
          "--email-template <path/to/file> A filename for the email template.\n" +
          "--letter Generate letters. If this option is provided, then --letter-template must also be provided.\n" +
          "--letter-template <path/to/file> A filename for the letter template.\n" +
          "--output-dir <path/to/folder> The folder to store all generated files. This option is required.\n" +
          "--csv-file <path/to/folder> The CSV file to process. This option is required.\n" +
          "\n"
          );
      System.out.println("Examples:\n" +
          "--email --email-template email-template.txt --output-dir emails --csv-file customer.csv\n" +
          "\n" +
          "--letter --letter-template letter-template.txt --output-dir letters --csv-file customer.csv\n");
      return;
    }
  }
}
