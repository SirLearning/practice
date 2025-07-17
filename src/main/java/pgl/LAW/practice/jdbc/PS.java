package pgl.LAW.practice.jdbc;

import java.sql.*;
import java.util.Properties;

public class PS {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/learnJdbc?" +
                "useServerPrepStmts=true&" +
                "cahcePrepstmts=true&" +
                "serverTimezone=Asia/Shanghai";
        Properties prop = new Properties();
        prop.setProperty("user", "root");
        prop.setProperty("password", "hanalijin");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, prop);
        System.out.println("PreparedStatement time is: " + testPS(conn));
        System.out.println("Statement time is: " + testS(conn));
        conn.close();
    }

    public static long testPS(Connection conn) throws SQLException {
        long beginTime = System.currentTimeMillis();
        PreparedStatement ps = conn.prepareStatement("select * from userinfo where id=?");
        for (int i = 0; i < 250000; i++) {
            ps.setObject(1, i + 1);
            ps.executeQuery();
        }
        long endTime = System.currentTimeMillis();
        ps.setString(1, "%中国%");
        ps.executeQuery();
        ps.close();
        return endTime - beginTime;
    }

    public static long testS(Connection conn) throws SQLException {
        long beginTime = System.currentTimeMillis();
        Statement stmt = conn.createStatement();
        for (int i = 0; i < 250000; i++) {
            stmt.executeQuery("select * from userinfo where id=" + (i+1));
        }
        long endTime = System.currentTimeMillis();
        stmt.close();
        return endTime - beginTime;
    }
}
