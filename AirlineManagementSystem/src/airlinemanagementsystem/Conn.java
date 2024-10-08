package airlinemanagementsystem;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
// java.sql.Statement;
import java.sql.*;

public class Conn {
    Connection conn;
    Statement s;

    public Conn() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to your database
            conn = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem", "root", "Sohail0622");

            // Create a statement
            s = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public Statement getStatement() {
        return s;
    }
}