/**
 * Parses and validates command line arguments for the message generator program.
 */
public class ArgumentParser {
  private boolean email;
  private String emailTemplate;
  private boolean letter;
  private String letterTemplate;
  private String outputDir;
  private String csvFile;

  /**
   * Creates a new ArgumentParser and parses the given command line arguments.
   * @param args the command line arguments to parse
   */
  public ArgumentParser(String[] args) {
    email = false;
    emailTemplate = null;
    letter = false;
    letterTemplate = null;
    outputDir = null;
    csvFile = null;

    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case "--email":
          email = true;
          break;
        case "--email-template":
          emailTemplate = args[i + 1];
          i++;
          break;
        case "--letter":
          letter = true;
          break;
        case "--letter-template":
          letterTemplate = args[i + 1];
          i++;
          break;
        case "--output-dir":
          outputDir = args[i + 1];
          i++;
          break;
        case "--csv-file":
          csvFile = args[i + 1];
          i++;
          break;
      }
    }
  }

  /**
   * Validates the parsed arguments to ensure all required options are present
   * and that dependent options are correctly paired.
   * @throws IllegalArgumentException if required arguments are missing or
   * if dependent arguments are not correctly paired
   */
  public void validate() {
    if (outputDir == null) {
      throw new IllegalArgumentException("Error: --output-dir is required.");
    }
    if (csvFile == null) {
      throw new IllegalArgumentException("Error: --csv-file is required.");
    }
    if (email && emailTemplate == null) {
      throw new IllegalArgumentException("Error: --email provided but no --email-template was given.");
    }
    if (letter && letterTemplate == null) {
      throw new IllegalArgumentException("Error: --letter provided but no --letter-template was given.");
    }
    if (!email && !letter) {
      throw new IllegalArgumentException("Error: at least --email or --letter must be provided.");
    }
  }

  /**
   * Returns whether email generation was requested.
   * @return true if --email was provided, false otherwise
   */
  public boolean isEmail() {
    return email;
  }

  /**
   * Returns the path to the email template file.
   * @return the email template file path, or null if not provided
   */
  public String getEmailTemplate() {
    return emailTemplate;
  }

  /**
   * Returns whether letter generation was requested.
   * @return true if --letter was provided, false otherwise
   */
  public boolean isLetter() {
    return letter;
  }

  /**
   * Returns the path to the letter template file.
   * @return the letter template file path, or null if not provided
   */
  public String getLetterTemplate() {
    return letterTemplate;
  }

  /**
   * Returns the path to the output directory.
   * @return the output directory path, or null if not provided
   */
  public String getOutputDir() {
    return outputDir;
  }

  /**
   * Returns the path to the CSV file.
   * @return the CSV file path, or null if not provided
   */
  public String getCsvFile() {
    return csvFile;
  }
}