package model;

public class Student {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String department;
    private double cgpa;

    // Constructor with ID
    public Student(int id,
                   String name,
                   String email,
                   String phone,
                   String department,
                   double cgpa) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.cgpa = cgpa;
    }

    // Constructor without ID
    public Student(String name,
                   String email,
                   String phone,
                   String department,
                   double cgpa) {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDepartment() {
        return department;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public String toString() {

        return String.format(
                "| %-4d | %-20s | %-25s | %-12s | %-12s | %-5.2f |",
                id,
                name,
                email,
                phone,
                department,
                cgpa
        );
    }
}