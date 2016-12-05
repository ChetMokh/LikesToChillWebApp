package softwareEngineering.LikesToChillWebApp.Integration.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import softwareEngineering.LikesToChillWebApp.models.Movie;
import softwareEngineering.LikesToChillWebApp.models.User;
import softwareEngineering.LikesToChillWebApp.services.MovieDAO;
import softwareEngineering.LikesToChillWebApp.services.UserDAO;

public class MovieDAOTest {

	UserDAO test = new UserDAO();
	MovieDAO movieList = new MovieDAO();
	int size;
	int rnd;
	
	@Before
	public void addUser() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		
		rnd = 1000 + (int)(Math.random() * 99999999);
		test.getConnectionToAws();
		test.addNewUser(
				new User(String.valueOf(rnd),"dsad", "Aria", "95148", "a@b.com", "M", "10-10-2000", "I am here to chill", "10-10-2200"));
		movieList.getConnection();
		
	}
	
	@Test
	public void addFindDeleteMovieTest() throws SQLException{
		
		assertTrue(movieList.addToLikeBucket(new Movie("test", String.valueOf(rnd))));
		assertEquals("test", movieList.findAllUserLikes(String.valueOf(rnd)).get(0).getMovieTitle());
		assertTrue(movieList.deleteFromLikeBucket("test", String.valueOf(rnd)));
		
	}
	
	@Test
	public void testAddAddDeleteAll() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
	
		assertTrue(movieList.addToLikeBucket(new Movie("test1", String.valueOf(rnd))));
		assertTrue(movieList.addToLikeBucket(new Movie("test2", String.valueOf(rnd))));
		assertTrue(movieList.addToLikeBucket(new Movie("test3", String.valueOf(rnd))));
		assertEquals("test1", movieList.findAllUserLikes(String.valueOf(rnd)).get(0).getMovieTitle());
		assertEquals("test2", movieList.findAllUserLikes(String.valueOf(rnd)).get(1).getMovieTitle());
		assertEquals("test3", movieList.findAllUserLikes(String.valueOf(rnd)).get(2).getMovieTitle());
		assertTrue(movieList.deleteAllLikeBucket(String.valueOf(rnd)));
		assertEquals(0, movieList.findAllUserLikes(String.valueOf(rnd)).size());
	
	}

	
}
