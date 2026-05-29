package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/studentmanagement_db";

    private static final String USER = "root";
    private static final String PASSWORD = "swetha@006";

    private static Connection con;

    public static Connection getConnection() {

        try {
            if (con == null || con.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD
                );

                System.out.println("✅ Database Connected");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL Driver Not Found");

        } catch (SQLException e) {
            System.out.println("❌ Database Connection Failed");
            System.out.println(e.getMessage());
        }

        return con;
    }

    public static void closeConnection() {

        try {
            if (con != null) {
                con.close();
                System.out.println("✅ Connection Closed");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}