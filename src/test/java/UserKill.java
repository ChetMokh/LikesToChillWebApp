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

//Brian Test
public class UserKill {
	private Connection connection;
	
	@Before
	public void getConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
		System.out.println("Making John");
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		connection = DriverManager.getConnection(
				"jdbc:mysql://likestochill.c2xl5ywnufyt.us-west-1.rds.amazonaws.com:3306/LikesToChill", "ChillAdmin",
				"Chill438");
		
		System.out.println("addUserToDB");
		
		
		String selectTableSQL = "INSERT INTO Users "
                + "VALUES (12314, 'John', 'Smith', 'example@email.com','M', 12345, 'about', CURRENT_DATE, CURRENT_DATE )";
		
        java.sql.Statement statement = connection.createStatement();
        statement.executeUpdate(selectTableSQL);
	}
	
	
	@Test
	public void killUser() throws SQLException{
		System.out.println("Killing John");
		
		String selectTableSQL = "DELETE FROM Users WHERE userId = 12314";
		
		java.sql.Statement statement = connection.createStatement();
		assertEquals(statement.executeUpdate(selectTableSQL), 1);
	}
}