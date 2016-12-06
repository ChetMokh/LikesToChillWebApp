package softwareEngineering.LikesToChillWebApp.Integration.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import softwareEngineering.LikesToChillWebApp.models.Movie;
import softwareEngineering.LikesToChillWebApp.resources.MovieResource;

public class MovieResourcesTest {

	MovieResource myRes;
	String testId = "10154628186114814";
	int rnd;
	int size;
	
	@Before
	public void  beforeTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		myRes = new MovieResource();
		rnd = 1000 + (int)(Math.random() * 99999999);
		size = myRes.getAllUserLikes(testId).size();
				
	}

	@Test
	public void testGetUserMovieTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		assertEquals(size, myRes.getAllUserLikes(testId).size());
	
	}
	
	@Test
	public void addUserMovieTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		assertEquals("**Like Added**", myRes.addNewLike(new Movie(String.valueOf(rnd), testId)));
		assertEquals(size+1, myRes.getAllUserLikes(testId).size());
	
	}
	
	@Test
	public void deleteUserMovieTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		assertEquals("**Like Added**", myRes.addNewLike(new Movie(String.valueOf(rnd), testId)));
		assertEquals("**Like Deleted**", myRes.deleteLike(String.valueOf(rnd), testId));
		assertEquals(size, myRes.getAllUserLikes(testId).size());
	
	}
		
}
