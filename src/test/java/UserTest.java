import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.junit.Before;
import org.junit.Test;

import CST438.softwareEngineering.LikesToChillWebApp.model.User;

public class UserTest {
    private Connection connection;

    @Before
    public void getConnection() throws ClassNotFoundException,
SQLException, InstantiationException, IllegalAccessException{
        Class.forName("com.mysql.jdbc.Driver").newInstance();

        connection = DriverManager.getConnection(

"jdbc:mysql://likestochill.c2xl5ywnufyt.us-west-1.rds.amazonaws.com:3306/LikesToChill",
"ChillAdmin",
                "Chill438");
    }

    @Test
    public void readDataFromDB() throws SQLException{
        System.out.println("readDataFromDB");

        String selectTableSQL = "SELECT * FROM Users WHERE UserId = 1";
        java.sql.Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);

        rs.next();
        String firstName = rs.getString("FirstName");

        assertEquals(firstName, "Sean");

    }

    @Test
    public void addUserToDB() throws SQLException {
        System.out.println("addUserToDB");

        String selectTableSQL = "INSERT INTO Users "
                + "VALUES (0, 'John', 'Smith', 'example@email.com','M', 12345, 'about', CURRENT_DATE, CURRENT_DATE )";

        java.sql.Statement statement = connection.createStatement();
        statement.executeUpdate(selectTableSQL);

        selectTableSQL = "SELECT * FROM Users WHERE UserId = 0";
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);

        rs.next();
        String firstName = rs.getString("FirstName");
        assertEquals(firstName, "John");

    }
}