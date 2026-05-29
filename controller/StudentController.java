package controller;

import model.Student;

public class StudentController {

    Student[] students;
    int count;

    public StudentController(int size) {

        students = new Student[size];
        count = 0;
    }

    // Add Student
    public void addStudent(int id, String name, int marks) {

        students[count++] = new Student(id, name, marks);
    }

    // Display Students
    public Student[] getStudents() {

        return students;
    }

    public int getCount() {

        return count;
    }

    // Search Student
    public Student searchStudent(int id) {

        for (int i = 0; i < count; i++) {

            if (students[i].id == id) {

                return students[i];
            }
        }

        return null;
    }

    // Delete Student
    public String deleteStudent(int id) {

        for (int i = 0; i < count; i++) {

            if (students[i].id == id) {

                for (int j = i; j < count - 1; j++) {

                    students[j] = students[j + 1];
                }

                count--;

                return "Student Deleted Successfully";
            }
        }

        return "Student Not Found";
    }
}