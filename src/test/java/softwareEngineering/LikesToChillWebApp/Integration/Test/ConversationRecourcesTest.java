package softwareEngineering.LikesToChillWebApp.Integration.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import softwareEngineering.LikesToChillWebApp.models.Conversation;
import softwareEngineering.LikesToChillWebApp.resources.ConversationResource;


public class ConversationRecourcesTest {

	ConversationResource myRes;
	String testId1 = "10154628";
	String testId2 = "10272394";
	
	@Before
	public void  beforeTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		myRes = new ConversationResource();
		myRes.addNewChat(new Conversation(testId1, testId2, "test test"));
	}

	@Test
	public void testGetChatTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		assertEquals("test test",myRes.getChat(testId1, testId2).get(myRes.getChat(testId1, testId2).size()-1).getMessageBody());
	
	}
	
	@Test
	public void addUserMovieTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		int size = myRes.getChat(testId1, testId2).size();
		
		assertEquals("**Got it**", myRes.addNewChat(new Conversation(testId1, testId2, "test test")));
		assertEquals(size+1, myRes.getChat(testId1, testId2).size());
		
		assertEquals("**Got it**", myRes.addNewChat(new Conversation(testId1, testId2, "test test")));
		assertEquals(size+2, myRes.getChat(testId1, testId2).size());
	
	}


}
