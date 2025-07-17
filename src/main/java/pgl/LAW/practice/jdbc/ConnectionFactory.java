package pgl.LAW.practice.jdbc;

import java.sql.*;
import java.util.Properties;

public class ConnectionFactory {
    private final String URL;
    private final String USERNAME;
    private final String PASSWORD;

    public ConnectionFactory(String url, String username, String password) {
        this.URL = url;
        this.USERNAME = username;
        this.PASSWORD = password;
    }

    public static Connection getConnection(String dbName) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/" + dbName + "?useServerPrepStmts=TRUE&cachePrepStmts=TRUE";
        Properties prop = new Properties();
        prop.setProperty("user", "dazheng");
        prop.setProperty("password", "hanalijin");
        Class.forName("com.mysql.cj.jdbc.Driver");  // what is the use?
        Connection conn = DriverManager.getConnection(url, prop);
        conn.setAutoCommit(false);
        return conn;
    }

    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("successfully release Connection resources!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn, Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
                System.out.println("successfully release Statement resources!");
            }
            if (conn != null) {
                conn.close();
                System.out.println("successfully release Connection resources!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                System.out.println("successfully release ResultSet resources!");
            }
            if (stmt != null) {
                stmt.close();
                System.out.println("successfully release Statement resources!");
            }
            if (conn != null) {
                conn.close();
                System.out.println("successfully release Connection resources!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
