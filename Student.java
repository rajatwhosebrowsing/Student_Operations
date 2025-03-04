// Student.java

import java.util.*;

class Student {
    private String name;
    private long prn;
    private String dob;
    private double marks;

    // Constructor
    public Student(String name, long prn, String dob, double marks) {
        this.name = validateName(name);
        this.prn = validatePRN(prn);
        this.dob = validateDOB(dob);
        this.marks = validateMarks(marks);
    }

    // Getters and Setters with Exception Handling
    public String getName() { return name; }
    public void setName(String name) { this.name = validateName(name); }
    
    public long getPrn() { return prn; }
    public void setPrn(long prn) { this.prn = validatePRN(prn); }
    
    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = validateDOB(dob); }
    
    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = validateMarks(marks); }
    
    // Validation Methods with 3 Exception Checks Each
    private String validateName(String name) {
        try {
            if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
            if (!name.matches("[a-zA-Z ]+")) throw new IllegalArgumentException("Name must contain only alphabets");
            if (name.length() < 3 || name.length() > 50) throw new IllegalArgumentException("Name must be between 3 and 50 characters long");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Name: " + e.getMessage());
            return "Unknown";
        }
        return name;
    }

    private long validatePRN(long prn) {
    try {
        if (prn <= 0) throw new IllegalArgumentException("PRN must be positive");
        if (String.valueOf(prn).length() != 11) throw new IllegalArgumentException("PRN must be exactly 11 digits long");
        if (prn < 10000000000L || prn > 99999999999L) throw new IllegalArgumentException("PRN must be within valid range");
    } catch (IllegalArgumentException e) {
        System.out.println("Invalid PRN: " + e.getMessage());
        return 99999999999L; // Default PRN to 11 digits (instead of 10)
    }
    return prn;
}


    private String validateDOB(String dob) {
        try {
            if (dob == null || dob.trim().isEmpty()) throw new IllegalArgumentException("DOB cannot be empty");
            if (!dob.matches("\\d{4}-\\d{2}-\\d{2}")) throw new IllegalArgumentException("DOB must be in YYYY-MM-DD format");
            if (Integer.parseInt(dob.substring(0, 4)) < 1900 || Integer.parseInt(dob.substring(0, 4)) > 2025) 
                throw new IllegalArgumentException("Year in DOB must be between 1900 and 2025");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid DOB: " + e.getMessage());
            return "2000-01-01";
        }
        return dob;
    }

    private double validateMarks(double marks) {
        try {
            if (marks < 0 || marks > 100) throw new IllegalArgumentException("Marks must be between 0 and 100");
            if (marks != Math.floor(marks) && marks * 10 % 1 != 0) throw new IllegalArgumentException("Marks must have at most one decimal place");
            if (marks < 35) throw new IllegalArgumentException("Marks indicate failure (below 35)");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Marks: " + e.getMessage());
            return 0.0;
        }
        return marks;
    }
    
    // Display student details
    public void display() {
        System.out.println("PRN: " + prn + ", Name: " + name + ", DOB: " + dob + ", Marks: " + marks);
    }
}