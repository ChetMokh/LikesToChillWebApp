import static org.junit.Assert.*;

import org.junit.Test;

import CST438.softwareEngineering.LikesToChillWebApp.model.User;
import CST438.softwareEngineering.LikesToChillWebApp.model.Conversation;
import CST438.softwareEngineering.LikesToChillWebApp.model.Movie;

public class ModelUnitTest {
	
	

	@Test
	public void testUser() {
		
		User myUser = new User("Arash", "Aria", "95148", "a@b.com", "M", "10-10-2000", "I am here to chill");
		
		assertEquals("Arash", myUser.getfName());
		
		assertEquals("Aria", myUser.getlName());
		
		assertEquals("95148", myUser.getUserLocation());
		
		assertEquals("a@b.com", myUser.getUserEmail());
		
		assertEquals("M", myUser.getUserGender());
		
		assertEquals("10-10-2000", myUser.getUserDOB());
		
		assertEquals("I am here to chill", myUser.getUserAbout());
		
	}
	
	@Test
	public void testConversation(){
		
		Conversation myConv =  new Conversation(1, "3333", "9999", "Hi there.", "21:50");
		
		assertEquals(1, myConv.getConversationId());
		
		assertEquals("3333", myConv.getSenderId());
		
		assertEquals("9999", myConv.getReceiverId());

		assertEquals("Hi there.", myConv.getMessageBody());
		
		assertEquals("21:50", myConv.getTimestamp());
		
		
	}
	
	@Test
	public void testMovie(){
		
		Movie myMovie = new Movie("Frozen", "54");
		
		assertEquals("Frozen", myMovie.getMovieTitle());
		
		assertEquals("54", myMovie.getUserId());
		
	}

}

