package GLAB305_2;

import java.sql.*;

public class Insert_preparedSt_Example {
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
            /* ------ Lets insert one record using a prepared statement ------*/
            String query = "INSERT INTO EMPLOYEES (officeCode,firstName,lastName,email,extension,reportsTo,VacationHours,employeeNumber,jobTitle) VALUES (?,?,?,?,?,?,?,?,?)";
            pst = connection.prepareStatement(query);
            pst.setInt(1, 6);
            pst.setString(2, "Jamil");
            pst.setString(3, "fink");
            pst.setString(4, "JJ@gmail.com");
            pst.setString(5, "2759");
            pst.setInt(6, 1143);
            pst.setInt(7, 9);
            pst.setInt(8, 0003);
            pst.setString(9, "Manager");
            int rowsInserted = pst.executeUpdate();
            System.out.println(rowsInserted + " row(s) affected !!");

            /* ------ Lets pull data from the database for an inserted record ------*/
            // Query which needs parameters

            pst = connection.prepareStatement("select * from employees where employeeNumber = ?");
            pst.setInt(1, 0003);

            // execute select query
            rs = pst.executeQuery();
            // Display function to show the Resultset
            while (rs.next()){
                System.out.println(rs.getString("firstName"));
                System.out.println(rs.getString("lastName"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("officeCode"));
            }

        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        try {
            pst.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
