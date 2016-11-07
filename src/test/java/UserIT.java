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
public class UserIT {
	private Connection connection;
	
	@Before
	public void getConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		connection = DriverManager.getConnection(
				"jdbc:mysql://likestochill.c2xl5ywnufyt.us-west-1.rds.amazonaws.com:3306/LikesToChill", "ChillAdmin",
				"Chill438");
	}
	
	@Test
	public void readDataFromDB() throws SQLException, ClassNotFoundException{

		String selectTableSQL = "SELECT * FROM Users WHERE UserId = 1";
		java.sql.Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(selectTableSQL);

		rs.next();
		String firstName = rs.getString("FirstName");
	
		assertEquals(firstName, "Sean");
	}
}
