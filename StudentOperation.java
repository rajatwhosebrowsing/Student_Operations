// File: StudentOperation.java
import java.util.*;

class StudentOperation {
    private ArrayList<Student> students;

    public StudentOperation() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void displayStudents() {
        if (students.isEmpty()) System.out.println("No students found.");
        else students.forEach(Student::display);
    }

    public Student searchByPrn(long prn) {
        for (Student student : students) {
            if (student.getPrn() == prn) {
                return student;
            }
        }
        System.out.println("Student with PRN " + prn + " not found.");
        return null;
    }

    public List<Student> searchByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                result.add(student);
            }
        }
        if (result.isEmpty()) System.out.println("No students found with name " + name);
        return result;
    }

    public Student searchByPosition(int position) {
        if (position >= 0 && position < students.size()) {
            return students.get(position);
        }
        System.out.println("Invalid position: " + position);
        return null;
    }

    public void updateStudent(long prn, String newName, String newDob, double newMarks) {
        Student student = searchByPrn(prn);
        if (student != null) {
            student.setName(newName);
            student.setDob(newDob);
            student.setMarks(newMarks);
            System.out.println("Student updated successfully.");
        }
    }

    public void deleteStudent(long prn) {
        Student student = searchByPrn(prn);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully.");
        }
    }
}