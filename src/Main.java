import db.DBConnection;
import view.StudentView;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Student Management System...");

        // Test the database connection first
        try {
            DBConnection.getConnection();
        } catch (Exception e) {
            System.err.println("[FATAL] Cannot connect to database!");
            System.err.println("Check your credentials in DatabaseConnection.java");
            System.err.println("Error: " + e.getMessage());
            return;
        }

        StudentView view = new StudentView();
        view.showMenu();

        // Close DB when app exits
        DBConnection.closeConnection();
    }
}
