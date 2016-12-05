package CST438.softwareEngineering.LikesToChillWebApp;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import CST438.softwareEngineering.LikesToChillWebApp.model.Conversation;
import CST438.softwareEngineering.LikesToChillWebApp.model.User;
import CST438.softwareEngineering.LikesToChillWebApp.service.ConversationDAO;
import CST438.softwareEngineering.LikesToChillWebApp.service.UserDAO;

public class ConversationDAOTest {

	UserDAO test = new UserDAO();
	ConversationDAO conv = new ConversationDAO();
	int rnd1;
	int rnd2;
	
	
	@Before
	public void addUsers() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		
		rnd1 = 1000 + (int)(Math.random() * 99999999);
		rnd2 = 1000 + (int)(Math.random() * 99999999);
		test.getConnectionToAws();
		test.addNewUser(
				new User(String.valueOf(rnd1),"dsad", "Aria", "95148", "a@b.com", "M", "10-10-2000", "I am here to chill", "10-10-2200"));
		test.addNewUser(
				new User(String.valueOf(rnd2),"sdasdaf", "dfddfAria", "95148", "a@b.com", "M", "10-10-2000", "I am here to chill", "10-10-2200"));
		conv.getConnection();
		
		
	}
	
	@Test
	public void testFindChat() throws SQLException {
		
		conv.addConversation(new Conversation(String.valueOf(rnd1), String.valueOf(rnd2), "Hi there."));
		assertFalse(conv.findUserConversation(String.valueOf(rnd1), String.valueOf(rnd2)).isEmpty());
		
	}
	
	@Test
	public void testAddChat() throws SQLException{
		
		assertTrue(conv.addConversation(new Conversation(String.valueOf(rnd1), String.valueOf(rnd2), "Hi there.")));
		
	}
	
	
}
