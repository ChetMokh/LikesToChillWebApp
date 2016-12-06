package softwareEngineering.LikesToChillWebApp.services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import softwareEngineering.LikesToChillWebApp.models.Movie;

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
	
	
	public List<Movie> findAllUserLikes(String userId) throws SQLException {
    	
		List<Movie> userMovies = new ArrayList<Movie>();
		String selectTableSQL = "SELECT * from LikeBucket WHERE UserId = '"+ userId +"'";
		java.sql.Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(selectTableSQL);
	
		while (rs.next()) {
			
			String movieTitle = rs.getString("MovieTitle");

			userMovies.add(new Movie(movieTitle, userId));
		}
		return userMovies;
    	
	}
	
	public boolean addToLikeBucket(Movie movie) throws SQLException {

	        String selectTableSQL = "INSERT INTO LikeBucket "
	                + "VALUES ('" + movie.getUserId() + "', '" + movie.getMovieTitle() + "')";

	        java.sql.Statement statement = connection.createStatement();
	        statement.executeUpdate(selectTableSQL);
	        return true;

	}
	
	public boolean deleteFromLikeBucket(String movieTitle, String userId) throws SQLException {

        String selectTableSQL = "DELETE FROM LikeBucket "
                + "WHERE MovieTitle = '" + movieTitle + "' AND UserId = '" + userId + "'";

        java.sql.Statement statement = connection.createStatement();
        statement.executeUpdate(selectTableSQL);
        return true;

	}
	
	public boolean deleteAllLikeBucket(String userId) throws SQLException {

        String selectTableSQL = "DELETE FROM LikeBucket WHERE UserId = '"+ userId +"'";
        java.sql.Statement statement = connection.createStatement();
        statement.executeUpdate(selectTableSQL);
        return true;

	}


}
