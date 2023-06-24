package Perschola;

import java.sql.*;
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/classicmodels";
        String userName = "root";
        String password = "password";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, userName, password);
            String query = "select * from employees";
            Statement stmt = connection.createStatement();
            ResultSet rst = stmt.executeQuery(query);

            while (rst.next()) {
                String firstName = rst.getString("firstName");
                String lastName = rst.getString("lastName");
                System.out.println(firstName + " " + lastName);
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
