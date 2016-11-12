package CST438.softwareEngineering.LikesToChillWebApp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CST438.softwareEngineering.LikesToChillWebApp.model.Conversation;


public class ConversationDAO {

private Connection connection;
	
	public ConversationDAO () {
		
	}
		
	public void getConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	
		connection = DriverManager.getConnection(
				"jdbc:mysql://likestochill.c2xl5ywnufyt.us-west-1.rds.amazonaws.com:3306/LikesToChill", "ChillAdmin",
				"Chill438");
		
	}
	
	public List<Conversation> findUserConversation(int senderId, int receiverId) throws SQLException {
    	
		List<Conversation> userConvo = new ArrayList<Conversation>();
		String selectTableSQL = "SELECT * from Conversations WHERE SenderId = "+ senderId +" AND ReceiverId" + receiverId;
		java.sql.Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(selectTableSQL);
	
		while (rs.next()) {
			
			int convoId = rs.getShort("ConversationId");
			String message = rs.getString("Message");
			String convoTime = rs.getString("TimeStamp");
//			String senderUId = rs.getString("SenderId");
//			String receiverUId = rs.getString("ReceiverId");
			userConvo.add(new Conversation( convoId, senderId, receiverId, message, convoTime));
		}
		return userConvo;
    	
	}
}
