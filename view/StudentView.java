package view;

import java.util.Scanner;

import model.Student;

public class StudentView {

    Scanner sc = new Scanner(System.in);

    // Menu
    public void showMenu() {

        System.out.println("\n===== Student Menu =====");

        System.out.println("1. Add Student");

        System.out.println("2. Display Students");

        System.out.println("3. Search Student");

        System.out.println("4. Delete Student");

        System.out.println("5. Exit");
    }

    // Get Choice
    public int getChoice() {

        System.out.print("Enter Choice: ");

        return sc.nextInt();
    }

    // Get Student ID
    public int getId() {

        System.out.print("Enter Student ID: ");

        return sc.nextInt();
    }

    // Get Student Name
    public String getName() {

        sc.nextLine();

        System.out.print("Enter Student Name: ");

        return sc.nextLine();
    }

    // Get Marks
    public int getMarks() {

        System.out.print("Enter Student Marks: ");

        return sc.nextInt();
    }

    // Display Students
    public void displayStudents(Student[] students, int count) {

        System.out.println("\nStudent Details:");

        for (int i = 0; i < count; i++) {

            System.out.println(
                    students[i].id + " - " +
                    students[i].name + " - " +
                    students[i].marks);
        }
    }

    // Message
    public void showMessage(String msg) {

        System.out.println(msg);
    }
}