package kz.iitu;

import java.sql.*;

public class DBUtil {

    // JDBC URL, username and password of MySQL server
    private final String dbUrl = "jdbc:mysql://localhost/testtzdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=UTF-8";
    private final String dbUname = "sam";
    private final String dbPassword = "sam";
    private final String dbDriver = "com.mysql.cj.jdbc.Driver";
    // JDBC variables for opening and managing connection
    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    public void loadDriver(String dbDriver) {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        loadDriver(dbDriver);
        try {
            con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error connection creation");
        }
        return con;
    }

}


