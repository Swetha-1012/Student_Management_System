import controller.StudentController;

import model.Student;

import view.StudentView;

public class Main {

    public static void main(String[] args) {

        StudentController controller =
                new StudentController(10);

        StudentView view = new StudentView();

        while (true) {

            view.showMenu();

            int choice = view.getChoice();

            switch (choice) {

                case 1:

                    int id = view.getId();

                    String name = view.getName();

                    int marks = view.getMarks();

                    controller.addStudent(id, name, marks);

                    view.showMessage("Student Added Successfully");

                    break;

                case 2:

                    view.displayStudents(
                            controller.getStudents(),
                            controller.getCount());

                    break;

                case 3:

                    int searchId = view.getId();

                    Student s = controller.searchStudent(searchId);

                    if (s != null) {

                        view.showMessage(
                                "Student Found: " +
                                s.name + " - " + s.marks);
                    }

                    else {

                        view.showMessage("Student Not Found");
                    }

                    break;

                case 4:

                    int deleteId = view.getId();

                    view.showMessage(
                            controller.deleteStudent(deleteId));

                    break;

                case 5:

                    System.out.println("Exiting...");

                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}