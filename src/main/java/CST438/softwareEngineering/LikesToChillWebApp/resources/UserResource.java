package CST438.softwareEngineering.LikesToChillWebApp.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import CST438.softwareEngineering.LikesToChillWebApp.model.User;
import CST438.softwareEngineering.LikesToChillWebApp.service.UserDAO;


@Path("/users")
public class UserResource {
	
	UserDAO users = new UserDAO();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
        users.getConnection();
		return users.findAll();
    }
	
//	@GET
//	@Path("/{userId}")
//	@Produces(MediaType.APPLICATION_JSON)
//    public List<User> getUserById(@PathParam("userId") int userId ) throws ClassNotFoundException, SQLException {
//        users.getConnection();
//		return users.findById(userId);
//    }
	

}
