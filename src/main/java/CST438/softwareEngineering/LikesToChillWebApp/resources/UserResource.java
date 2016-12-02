package CST438.softwareEngineering.LikesToChillWebApp.resources;

import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import CST438.softwareEngineering.LikesToChillWebApp.model.User;
import CST438.softwareEngineering.LikesToChillWebApp.service.UserDAO;


@Path("users")
public class UserResource {
	
	UserDAO users = new UserDAO();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        users.getConnectionToAws();
		return users.findAllUserData();
    }
	
	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
    public List<User> getUserById(@PathParam("userId") String userId ) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        users.getConnectionToAws();
		return users.findById(userId);
    }
		
	@POST
	@Path("/addUser")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public String addNewUser(User newUser) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		users.getConnectionToAws();
		users.addNewUser(newUser);
		return "User Added";
		
	}
	
	@POST
	@Path("/updateUser/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public User updateUser(@PathParam("userId") String userId, User updateUser) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		users.getConnectionToAws();
		users.updateUserInfo(userId, updateUser);
		return updateUser;
		
	}
	
	@DELETE
    @Path("/deleteUser/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteLikes(@PathParam("userId") String userId) throws SQLException, ClassNotFoundException, InstantiationException,IllegalAccessException {

        users.getConnectionToAws();
        users.deleteUser(userId);
        return "**User Deleted**";

    }
	
}
