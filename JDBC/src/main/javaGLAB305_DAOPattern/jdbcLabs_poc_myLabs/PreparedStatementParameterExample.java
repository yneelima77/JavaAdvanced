package jdbcLabs_poc_myLabs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementParameterExample {
    String driverName = "com.mysql.jdbc.Driver";
    static String connectionUrl = "jdbc:mysql://localhost:3306/studentsdb";
    static String userName = "root";
    static String userPass = "password";
    static Connection connection = null;

    public PreparedStatementParameterExample() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(connectionUrl, userName,
                    userPass);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        PreparedStatementParameterExample ptmtExample = new PreparedStatementParameterExample();
        Connection con = ptmtExample.getConnection();
        ResultSet resultSet = null;
        // Writing a parameterised query in prepared Statement
        String insertQuery = "INSERT INTO student(RollNo,Name,Course,Address) VALUES(?,?,?,?)";
        try {
            // Compiling query String
            PreparedStatement statement = con.prepareStatement(insertQuery);
            // setting parameter to the query
            statement.setInt(1, 1);
            statement.setString(2, "Toms");
            statement.setString(3, "Java");
            statement.setString(4, "123 pixar ln");
            //Updating Query
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close();
        }

    }
}
