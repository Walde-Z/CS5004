import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentReader {

  public static void main(String[] args) throws IOException {
    ArrayList<Student> students = new ArrayList<>();

    BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
    String line;
    while ((line = reader.readLine()) != null) {
      String[] parts = line.split(" ");
      Student s = new Student(parts[0], parts[1], parts[2], parts[3]);
      students.add(s);
    }
    reader.close();

    for (int i = 0; i < students.size(); i++) {
      Student s = students.get(i);
      System.out.println((i + 1) + ". " + s.getFirstName() + " " +
          s.getLastName() + " " +
          s.getStudentID() + " " +
          s.getEmail());
    }

    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("\nMenu:");
      System.out.println("1. Add a student");
      System.out.println("2. Remove a student by ID");
      System.out.println("3. Search for a student by ID");
      System.out.println("4. Exit");
      System.out.print("Choose an option: ");

      String choice = scanner.nextLine();

      switch (choice) {
        case "1": {   // Add student
          System.out.println(
              "Please enter student information as: first name, last name, student ID, email.");

          String l = scanner.nextLine();
          String[] parts = l.split(" ");
          Student s = new Student(parts[0], parts[1], parts[2], parts[3]);
          students.add(s);

          try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"));
            for (Student student : students) {
              writer.write(student.getFirstName() + " " + student.getLastName() + " " +
                  student.getStudentID() + " " + student.getEmail());
              writer.newLine();
            }
            writer.close();
            System.out.println("Student added successfully.");

            for (int i = 0; i < students.size(); i++) {
              Student student = students.get(i);
              System.out.println((i + 1) + ". " + student.getFirstName() + " " +
                  student.getLastName() + " " +
                  student.getStudentID() + " " +
                  student.getEmail());
            }
          }
          catch (IOException e) {
            e.printStackTrace();
          }
          break;
        }
        case "2": {   // Remove student
          System.out.println("Please enter student ID.");

          String id = scanner.nextLine();
          boolean found = false;
          for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID().equals(id)) {
              students.remove(i);
              found = true;
              break;
            }
          }
          if (!found) {
            System.out.println("Error: No student with the ID: " + id + " was found.");
          }
          else {
            try {
              BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"));
              for (Student s : students) {
                writer.write(s.getFirstName() + " " + s.getLastName() + " " + s.getStudentID() + " "
                    + s.getEmail());
                writer.newLine();
              }
              writer.close();
              System.out.println("Student removed successfully.");
            }
            catch (IOException e) {
              e.printStackTrace();
            }
          }
          break;
        }
        case "3": {// Search for student
          System.out.println("Please enter student ID.");

          String id = scanner.nextLine();
          boolean found = false;
          for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getStudentID().equals(id)) {
              System.out.println((i + 1) + ". " +
                  s.getFirstName() + " " +
                  s.getLastName() + " " +
                  s.getStudentID() + " " +
                  s.getEmail());
              found = true;
              break;
            }
          }

          if (!found)
            System.out.println("Error: No student with the ID: " + id + " was found.");
          break;
        }
        case "4":
          System.out.println("Goodbye!");
          scanner.close();
          return;
        default:
          System.out.println("Invalid option.");
      }
    }
  }
}