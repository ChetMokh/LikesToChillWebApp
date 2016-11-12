package CST438.softwareEngineering.LikesToChillWebApp.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import CST438.softwareEngineering.LikesToChillWebApp.model.Movie;
import CST438.softwareEngineering.LikesToChillWebApp.service.MovieDAO;

@Path("conversations")
public class ConversationResource {
	
	MovieDAO userMovies = new MovieDAO();
	
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//    public List<User> getAllUsers() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
//        users.getConnection();
//		return users.findAll();
//  }
	
	@GET
	@Path("/{senderId,receiverId}")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getUserById(@PathParam("userId") int userId ) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        userMovies.getConnection();
		return userMovies.findMoviesByUserId(userId);
    }

}
