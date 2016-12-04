package CST438.softwareEngineering.LikesToChillWebApp;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;

import CST438.softwareEngineering.LikesToChillWebApp.model.User;
import CST438.softwareEngineering.LikesToChillWebApp.service.UserDAO;

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
		
		assertEquals(0, test.findById("44").size());
		
	}
	
	@Test
	public void testAddUser() throws SQLException, ClassNotFoundException{
		
		assertEquals(size, test.findAllUserData().size());
		
		assertTrue(test.addNewUser(
				new User(String.valueOf(rnd),"dsad", "Aria", "95148", "a@b.com", "M", "10-10-2000", "I am here to chill", "10-10-2200")));
		
		assertEquals(size+1, test.findAllUserData().size());

	}
	
	@Test
	public void testDelete() throws SQLException{
		
		assertTrue(test.deleteUser(String.valueOf(rnd)));
		
	}

	
	
}
