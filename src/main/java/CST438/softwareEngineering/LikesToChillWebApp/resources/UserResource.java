package CST438.softwareEngineering.LikesToChillWebApp.resources;

import java.sql.SQLException;
import java.util.List;

import javax.swing.text.html.parser.Entity;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.research.ws.wadl.Response;

import CST438.softwareEngineering.LikesToChillWebApp.model.User;
import CST438.softwareEngineering.LikesToChillWebApp.service.UserDAO;


@Path("users")
public class UserResource {
	
	UserDAO users = new UserDAO();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        users.getConnection();
		return users.findAll();
    }
	
	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
    public List<User> getUserById(@PathParam("userId") int userId ) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        users.getConnection();
		return users.findById(userId);
    }
	
	@POST
	@Path("/post")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPost() {
		return "POST works";
	}
	

//	@POST
//	@Path("/post")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response postStudentRecord(Student student){
//		String result = "Record entered: "+ student;	
//		return Response.status(201).entity(result).build();
//  }

	
	@POST
	@Path("/addUser")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public String addNewUser(User newUser) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		users.getConnection();
		users.insertUser(newUser);
		return "User Added";
		
	}
	
	@POST
	@Path("/updateUser/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public User updateUser(@PathParam("userId") int userId, User updateUser) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		users.getConnection();
		users.updateUser(userId, updateUser);
		return updateUser;
		
	}
	
}
