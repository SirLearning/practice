package pgl.LAW.practice.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UseFinally {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection("learnJdbc");
            String sql = "select * from userinfo order by id asc";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            System.out.println(rs.getInt("id"));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(conn, ps, rs);
        }
    }
}
