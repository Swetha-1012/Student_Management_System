package controller;

import db.DBConnection;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentController {

    private Connection con;

    public StudentController() {

        con = DBConnection.getConnection();
        createTable();
    }

    // Create Table
    private void createTable() {

        String sql = """
                CREATE TABLE IF NOT EXISTS students(
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    name VARCHAR(100),
                    email VARCHAR(100),
                    phone VARCHAR(15),
                    department VARCHAR(50),
                    cgpa DOUBLE
                )
                """;

        try {

            Statement stmt = con.createStatement();
            stmt.execute(sql);

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }

    // Add Student
    public void addStudent(Student s) {

        String sql =
                "INSERT INTO students(name,email,phone,department,cgpa) VALUES(?,?,?,?,?)";

        try {

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPhone());
            ps.setString(4, s.getDepartment());
            ps.setDouble(5, s.getCgpa());

            ps.executeUpdate();

            System.out.println("✅ Student Added");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }

    // Display All Students
    public List<Student> getAllStudents() {

        List<Student> list = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try {

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("department"),
                        rs.getDouble("cgpa")
                );

                list.add(s);
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

        return list;
    }

    // Search by Name
    public List<Student> searchByName(String name) {

        List<Student> list = new ArrayList<>();

        String sql =
                "SELECT * FROM students WHERE name LIKE ?";

        try {

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("department"),
                        rs.getDouble("cgpa")
                );

                list.add(s);
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

        return list;
    }

    // Update Student
    public void updateStudent(
            int id,
            String name,
            String email,
            String phone,
            String department,
            double cgpa
    ) {

        String sql =
                "UPDATE students SET name=?,email=?,phone=?,department=?,cgpa=? WHERE id=?";

        try {

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, department);
            ps.setDouble(5, cgpa);
            ps.setInt(6, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("✅ Student Updated");

            } else {

                System.out.println("❌ Student ID Not Found");
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }

    // Delete Student
    public void deleteStudent(int id) {

        String sql =
                "DELETE FROM students WHERE id=?";

        try {

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("✅ Student Deleted");

            } else {

                System.out.println("❌ Student ID Not Found");
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }
}