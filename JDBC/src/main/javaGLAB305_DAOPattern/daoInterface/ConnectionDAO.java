package daoInterface;

import java.sql.*;

public class ConnectionDAO {
    static Connection conn = null;
    protected PreparedStatement pstmt = null;
    protected ResultSet rst = null;

    public static Connection getConn() throws ClassNotFoundException {
        final String DBURL = "jdbc:mysql://localhost:3306/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String DBUSERNAME = "root";
        final String DBPASSWORD = "password";

        try {
            conn = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
            System.out.println("Connected Database Successfully");
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return conn;
    }

    public void disconnect() {
        try {
            if (rst != null) {
                rst.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
