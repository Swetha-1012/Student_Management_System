package view;

import controller.StudentController;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class StudentView {

    StudentController controller =
            new StudentController();

    Scanner sc = new Scanner(System.in);

    public void showMenu() {

        while (true) {

            System.out.println("\n1.Add Student");
            System.out.println("2.Display Students");
            System.out.println("3.Search Student");
            System.out.println("4.Update Student");
            System.out.println("5.Delete Student");
            System.out.println("6.Exit");

            System.out.print("Enter Choice : ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    private void addStudent() {

        System.out.print("Name : ");
        String name = sc.nextLine();

        System.out.print("Email : ");
        String email = sc.nextLine();

        System.out.print("Phone : ");
        String phone = sc.nextLine();

        System.out.print("Department : ");
        String dept = sc.nextLine();

        System.out.print("CGPA : ");
        double cgpa = Double.parseDouble(sc.nextLine());

        Student s =
                new Student(name, email, phone, dept, cgpa);

        controller.addStudent(s);
    }

    private void displayStudents() {

        List<Student> list =
                controller.getAllStudents();

        for (Student s : list) {

            System.out.println(s);
        }
    }

    private void searchStudent() {

        System.out.print("Enter Name : ");

        String name = sc.nextLine();

        List<Student> list =
                controller.searchByName(name);

        for (Student s : list) {

            System.out.println(s);
        }
    }

    private void updateStudent() {

        System.out.print("ID : ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Name : ");
        String name = sc.nextLine();

        System.out.print("Email : ");
        String email = sc.nextLine();

        System.out.print("Phone : ");
        String phone = sc.nextLine();

        System.out.print("Department : ");
        String dept = sc.nextLine();

        System.out.print("CGPA : ");
        double cgpa = Double.parseDouble(sc.nextLine());

        controller.updateStudent(
                id,
                name,
                email,
                phone,
                dept,
                cgpa
        );
    }

    private void deleteStudent() {

        System.out.print("Enter ID : ");

        int id = Integer.parseInt(sc.nextLine());

        controller.deleteStudent(id);
    }
}