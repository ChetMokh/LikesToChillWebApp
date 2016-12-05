package CST438.softwareEngineering.LikesToChillWebApp;
import static org.junit.Assert.*;

import org.junit.Test;

import CST438.softwareEngineering.LikesToChillWebApp.model.User;
import CST438.softwareEngineering.LikesToChillWebApp.model.Conversation;
import CST438.softwareEngineering.LikesToChillWebApp.model.Movie;

public class ModelUnitTest {
	
	@Test
	public void testEmptyAndSetters() {
		
		User myUser = new User();
		int rnd = 1000 + (int)(Math.random() * 99999999);
		myUser.setUserId(String.valueOf(rnd));
		myUser.setfName("john");
		myUser.setlName("doe");
		myUser.setUserLocation("43939");
		myUser.setUserGender("M");
		myUser.setUserEmail("dd@ww.com");
		myUser.setUserDOB("10-10-2000");
		myUser.setUserAbout("i am cool");
		
		String expected = "User [userId=" + myUser.getUserId() + ", fName=" + myUser.getfName() + ", lName=" + myUser.getlName() + ", userLocation=" + myUser.getUserLocation()
				+ ", userEmail=" + myUser.getUserEmail() + ", userGender=" + myUser.getUserGender() + ", userDOB=" + myUser.getUserDOB() + ", userAbout="
				+ myUser.getUserAbout() + ", userSignupDate=" + myUser.getUserSignupDate() + "]";
		
		assertEquals(expected, myUser.toString());
		
			
	}

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
	public void testUser2() {
		
		User myUser = new User("123","Arash", "Aria", "95148", "a@b.com", "M", "10-10-2000", "I am here to chill", "10-10-1224");
			
			assertEquals("123", myUser.getUserId());
		
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
	public void testConvEmptyAndSetters() {
		
		Conversation myConv = new Conversation();
		
		myConv.setConversationId(12);
		myConv.setSenderId("3424233");
		myConv.setReceiverId("4454566");
		myConv.setMessageBody("adhjasldhaskhd");
		myConv.setTimestamp("435577");
		
		String expected = "Conversations [conversationId=" + myConv.getConversationId() + ", senderId=" + myConv.getSenderId() + ", receiverId="
				+ myConv.getReceiverId() + ", messageBody=" + myConv.getMessageBody() + ", timestamp=" + myConv.getTimestamp() + "]";
		
		
		assertEquals(expected, myConv.toString());
		
	}
	
	
	@Test
	public void testMovie(){
		
		Movie myMovie = new Movie("Frozen", "54");
		
		assertEquals("Frozen", myMovie.getMovieTitle());
		
		assertEquals("54", myMovie.getUserId());
		
	}
	
	@Test
	public void testMovieEmptyAndSetters(){
		
		Movie myMovie = new Movie();
		
		myMovie.setMovieTitle("lhsdalhasdl");
		myMovie.setUserId("fdffd3");
		
		String expected = "Movie [movieTitle=" + myMovie.getMovieTitle() + ", userId=" + myMovie.getUserId() + "]";
		
		assertEquals(expected, myMovie.toString());
		
	}

}

