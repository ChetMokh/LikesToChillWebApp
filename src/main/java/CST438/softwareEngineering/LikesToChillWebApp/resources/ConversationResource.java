package CST438.softwareEngineering.LikesToChillWebApp.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import CST438.softwareEngineering.LikesToChillWebApp.model.Conversation;
import CST438.softwareEngineering.LikesToChillWebApp.service.ConversationDAO;

@Path("conversations")
public class ConversationResource {
	
	ConversationDAO usersConversations = new ConversationDAO();

	@GET
	@Path("{senderId}/{receiverId}")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Conversation> getChat(@PathParam("senderId") int senderId, @PathParam("receiverId") int receiverId ) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        usersConversations.getConnection();
		return usersConversations.findUserConversation(senderId, receiverId);
    }
	
	@POST
    @Path("/addNewChat")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addNewChat(Conversation conversation) throws SQLException, ClassNotFoundException, InstantiationException,IllegalAccessException {

		usersConversations.getConnection();
		usersConversations.addConversation(conversation);
        return "**Got it**";

    }

}
