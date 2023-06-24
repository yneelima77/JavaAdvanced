package jdbcLabs_poc_myLabs;


import java.sql.*;

//Main class to illustrate the demo of JDBC
public class SimpleQuery {
    static String connectionUrl = "jdbc:mysql://localhost:3306/classicmodels";
    static String userName = "root";
    static String userPass = "password";
    static Connection con = null;

    public static void main(String[] args) throws SQLException {
        try {
            con = DriverManager.getConnection(connectionUrl, userName,
                    userPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 3: Creating statement
        Statement st = con.createStatement();

        // Step 4: Executing the query and storing the result
        ResultSet rs = st.executeQuery(
                " select employeeNumber,lastName,firstName,VacationHours from employees where VacationHours > 20");

        // Step 5: Processing the results
        while (rs.next()) {
            System.out.println("Begin New Record");
            String EmployeeNumber   = rs.getString("employeeNumber");
            String lastname  = rs.getString("lastName");
            String firstname = rs.getString("firstName");
            String VacationHours = rs.getString("VacationHours");

            System.out.println(EmployeeNumber +" | " + lastname + "|"+ firstname +"|"+ VacationHours);
        }
        // Step 6: Closing the connections
        // using close() method to release memory resources
        con.close();

        // Display message for successful execution of program
        System.out.println("JDBC query completed");
    }
}
