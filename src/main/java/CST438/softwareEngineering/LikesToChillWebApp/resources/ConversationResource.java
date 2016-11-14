package CST438.softwareEngineering.LikesToChillWebApp.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import CST438.softwareEngineering.LikesToChillWebApp.model.Conversation;
import CST438.softwareEngineering.LikesToChillWebApp.service.ConversationDAO;

@Path("conversations")
public class ConversationResource {
	
	ConversationDAO usersConvo = new ConversationDAO();
	
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//    public List<User> getAllUsers() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
//        users.getConnection();
//		return users.findAll();
//  }
	
	@GET
	@Path("/{senderId,receiverId}")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Conversation> getUserById(@PathParam("senderId") int senderId, @PathParam("receiverId") int receiverId ) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        usersConvo.getConnection();
		return usersConvo.findUserConversation(senderId, receiverId);
    }

}
