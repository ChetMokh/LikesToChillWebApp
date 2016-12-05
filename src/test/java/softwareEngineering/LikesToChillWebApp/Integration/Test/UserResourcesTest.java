package softwareEngineering.LikesToChillWebApp.Integration.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import softwareEngineering.LikesToChillWebApp.models.User;
import softwareEngineering.LikesToChillWebApp.resources.UserResource;

public class UserResourcesTest {
	
	UserResource myRes;
	int rnd;
	
	@Before
	public void  beforeTest() {
		
		myRes = new UserResource();
		rnd = 1000 + (int)(Math.random() * 99999999);
		
	}

	@Test
	public void testGetAllUsers() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		assertFalse(myRes.getAllUsers().isEmpty());
	
	}
	
	@Test
	public void testGetUser() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		assertEquals(1, (myRes.getUserById("10154628186114814").size()));
		
	}
	
	@Test
	public void testAddUser() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		assertEquals("User Added", myRes.addNewUser(new User(String.valueOf(rnd),"test", "add user", "95148", "a@b.com", "M", "10-10-2000", "I am here to chill", "10-10-2200")));	
		
	}
	
	@Test
	public void testUpdateUser() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		assertEquals("updated", myRes.updateUser(String.valueOf(rnd),new User("test", "updated", "95148", "a@b.com", "M", "10-10-2000", "I am here to chill")).getlName());
		
	}
	
	@Test
	public void testDeleteUser() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		assertEquals("**User Deleted**",myRes.deleteUser(String.valueOf(rnd)));
		
	}
	

}
