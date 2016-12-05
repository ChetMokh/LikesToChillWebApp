package softwareEngineering.LikesToChillWebApp.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import softwareEngineering.LikesToChillWebApp.models.Conversation;



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
	
	public List<Conversation> findUserConversation(String senderId, String receiverId) throws SQLException {
    	
		List<Conversation> userConvo = new ArrayList<Conversation>();
		String selectTableSQL = "SELECT * from Conversations WHERE (SenderId = '"+ senderId +"' AND ReceiverId ='" + receiverId + "') OR " +
				"(SenderId = '"+ receiverId +"' AND ReceiverId ='" + senderId + "')";
		java.sql.Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(selectTableSQL);
	
		while (rs.next()) {
			
			int convoId = rs.getShort("ConversationId");
			String message = rs.getString("Message");
			String convoTime = rs.getString("TimeStamp");
			String senderUId = rs.getString("SenderId");
			String receiverUId = rs.getString("ReceiverId");
			userConvo.add(new Conversation(convoId, senderUId, receiverUId, message, convoTime));
		}
		return userConvo;
    	
	}

	public boolean addConversation(Conversation userConvo) throws SQLException {
		
        String selectTableSQL = "INSERT INTO Conversations (ReceiverId, SenderId, Message, TimeStamp) "
        		+ "VALUES ('" + userConvo.getReceiverId() + "', '" + userConvo.getSenderId() + "' , '" + userConvo.getMessageBody() + "' ,CURRENT_DATE )";

        java.sql.Statement statement = connection.createStatement();
        statement.executeUpdate(selectTableSQL);
        return true;
		
	}
}
