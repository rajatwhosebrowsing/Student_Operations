// File: Main.java
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentOperation operations = new StudentOperation();

        while (true) {
            System.out.println("\n1. Add Student\n2. Display Students\n3. Search by PRN\n4. Search by Name\n5. Search by Position\n6. Update Student\n7. Delete Student\n8. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter PRN: ");
                    long prn = sc.nextLong();
                    sc.nextLine();
                    System.out.print("Enter DOB (YYYY-MM-DD): ");
                    String dob = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    operations.addStudent(new Student(name, prn, dob, marks));
                    break;

                case 2:
                    operations.displayStudents();
                    break;

                case 3:
                    System.out.print("Enter PRN to search: ");
                    long searchPrn = sc.nextLong();
                    Student foundByPrn = operations.searchByPrn(searchPrn);
                    if (foundByPrn != null) foundByPrn.display();
                    break;

                case 4:
                    System.out.print("Enter Name to search: ");
                    String searchName = sc.nextLine();
                    List<Student> foundByName = operations.searchByName(searchName);
                    foundByName.forEach(Student::display);
                    break;

                case 5:
                    System.out.print("Enter Position to search (0-based index): ");
                    int position = sc.nextInt();
                    Student foundByPosition = operations.searchByPosition(position);
                    if (foundByPosition != null) foundByPosition.display();
                    break;

                case 6:
                    System.out.print("Enter PRN of student to update: ");
                    long updatePrn = sc.nextLong();
                    sc.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new DOB (YYYY-MM-DD): ");
                    String newDob = sc.nextLine();
                    System.out.print("Enter new Marks: ");
                    double newMarks = sc.nextDouble();
                    operations.updateStudent(updatePrn, newName, newDob, newMarks);
                    break;

                case 7:
                    System.out.print("Enter PRN of student to delete: ");
                    long deletePrn = sc.nextLong();
                    operations.deleteStudent(deletePrn);
                    break;

                case 8:
                    System.out.println("Exiting program.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}