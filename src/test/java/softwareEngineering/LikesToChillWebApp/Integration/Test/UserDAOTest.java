package softwareEngineering.LikesToChillWebApp.Integration.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import softwareEngineering.LikesToChillWebApp.models.User;
import softwareEngineering.LikesToChillWebApp.services.UserDAO;

public class UserDAOTest {

	UserDAO test = new UserDAO();
	int size;
	int rnd;
	
	@Before
	public void setConn() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		
		test.getConnectionToAws();
		size = test.findAllUserData().size();
		rnd = 1000 + (int)(Math.random() * 99999999);
		
	}
	
	
	@Test
	public void testFindById() throws SQLException{
		
		assertEquals(1, test.findById("1244060648949581").size());
		
	}
	
	@Test
	public void testFindByIdBad() throws SQLException{
		
		assertEquals(0, test.findById("5").size());
		
	}
	
	@Test
	public void testAddUser() throws SQLException, ClassNotFoundException{
		
		assertEquals(size, test.findAllUserData().size());
		
		assertTrue(test.addNewUser(
				new User(String.valueOf(rnd),"dsad", "Aria", "95148", "a@b.com", "M", "10-10-2000", "I am here to chill", "10-10-2200")));
		
		assertEquals(size+1, test.findAllUserData().size());

	}
	
	@Test
	public void testUpdateUser() throws SQLException{
		
		assertTrue(test.updateUserInfo(String.valueOf(rnd), new User(String.valueOf(rnd),"dsad", "Aria", "95148", "a@b.com", "M", "10-10-2000", "I am here to chill", "10-10-2200")));
		
	}
	
	@Test
	public void testDelete() throws SQLException{
		
		assertTrue(test.deleteUser(String.valueOf(rnd)));
		
	}

	
	
}
