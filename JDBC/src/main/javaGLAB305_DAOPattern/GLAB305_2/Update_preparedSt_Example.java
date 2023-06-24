package GLAB305_2;

import java.sql.*;

public class Update_preparedSt_Example {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs= null;

        final String DBURL = "jdbc:mysql://localhost:3306/classicmodels";
        final String DBUSERNAME = "root";
        final String DBPASSWORD = "password";
        try {
            connection = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
            System.out.println("Connected Database Successfully");
            String query = "update employees set firstName = ?, lastName=? where employeeNumber = ?";
            pst = connection.prepareStatement(query);
            pst.setString(1,"Gray");
            pst.setString(2,"Larson");
            pst.setInt(3, 0003);

            int rowsAffected = pst.executeUpdate();
            pst = connection.prepareStatement("select * from employees where employeeNumber= ?");
            pst.setInt(1, 1401);
            // execute select query
            rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("firstName"));
                System.out.println(rs.getString("lastname"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("officeCode"));
            }
            } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
