package CST438.softwareEngineering.LikesToChillWebApp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CST438.softwareEngineering.LikesToChillWebApp.model.Movie;
import CST438.softwareEngineering.LikesToChillWebApp.model.User;

public class MovieDAO {
	
private Connection connection;
	
	public MovieDAO () {
		
	}
		
	public void getConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	
		connection = DriverManager.getConnection(
				"jdbc:mysql://likestochill.c2xl5ywnufyt.us-west-1.rds.amazonaws.com:3306/LikesToChill", "ChillAdmin",
				"Chill438");
		
	}
	
	
	public List<Movie> findMoviesByUserId(int userId) throws SQLException {
    	
		List<Movie> userMovies = new ArrayList<Movie>();
		String selectTableSQL = "SELECT * from LikeBucket WHERE UserId = "+ userId +"";
		java.sql.Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(selectTableSQL);
	
		while (rs.next()) {
			
			String movieId = rs.getString("MovieId");

			userMovies.add(new Movie(movieId));
		}
		return userMovies;
    	
	}
    public boolean insertUser(User user) throws SQLException {
 

    	
		String selectTableSQL = "INSERT INTO Users "
				+ "VALUES (" + user.getUserId() + ", '" + user.getfName() + "', '" 
				+ user.getlName() + "', '" + user.getUserEmail() 
				+ "', '"+ user.getUserGender() + "', " + user.getUserLocation() 
				+ ", '" + user.getUserAbout() + "', '"+ user.getUserDOB() +"',CURRENT_DATE )";
    	
		java.sql.Statement statement = connection.createStatement();
		statement.executeUpdate(selectTableSQL);
		return true;

	}
 
    public boolean updateUser(int userId, User user) throws SQLException {

    	
		String selectTableSQL = "UPDATE Users SET FirstName ='" + user.getfName() 
				+ "', LastName = '" + user.getlName() + "', UserEmail = '" + user.getUserEmail() 
				+ "', UserGender = '"+ user.getUserGender() + "', "
				+ "UserZipcode = "+ user.getUserLocation() + ", UserAbout = '"+ user.getUserAbout() + "', "
				+ "UserDOB = '"+ user.getUserDOB() +"' " 
				+ "WHERE UserId = "+ userId +"";
	
		java.sql.Statement statement = connection.createStatement();
		statement.executeUpdate(selectTableSQL);
		return true;
				
				
	}
    
    public boolean killUser(int userId, User user) throws SQLException {
    	String selectTableSQL = "DELETE FROM Users WHERE UserId = "+ userId +"";
    	
    	java.sql.Statement statement = connection.createStatement();
		statement.executeUpdate(selectTableSQL);
		return true;
    }


}
