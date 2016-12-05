import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import softwareEngineering.LikesToChillWebApp.models.User;

public class updateJohn {
	private Connection connection;
	@Before
	public void getConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
		System.out.println("Making John");
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		connection = DriverManager.getConnection(
				"jdbc:mysql://likestochill.c2xl5ywnufyt.us-west-1.rds.amazonaws.com:3306/LikesToChill", "ChillAdmin",
				"Chill438");

		String selectTableSQL = "INSERT INTO Users "
                + "VALUES (12314, 'John', 'Smith', 'example@email.com','M', 12345, 'about', CURRENT_DATE, CURRENT_DATE )";
		
        java.sql.Statement statement = connection.createStatement();
//        statement.executeUpdate(selectTableSQL);
	}
	
	@Test
	public void johnsNewIdentity() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
		System.out.println("John is on the run from his old gang. New last name!");
		
		String selectTableSQL = "UPDATE Users SET lastName = \"Johnson\" WHERE userId = 12314";
		
		java.sql.Statement statement = connection.createStatement();
		statement.executeUpdate(selectTableSQL);

		
		selectTableSQL = "SELECT * FROM Users WHERE UserId = 12314";
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(selectTableSQL);
		rs.next();
		String lastName = rs.getString("LastName");
	
		assertEquals(lastName, "Johnson");
	}
	
	@After
	public void killUser() throws SQLException{
		System.out.println("Killing John");
		
		String selectTableSQL = "DELETE FROM Users WHERE userId = 12314";
		
		java.sql.Statement statement = connection.createStatement();
		assertEquals(statement.executeUpdate(selectTableSQL), 1);
	}
}

