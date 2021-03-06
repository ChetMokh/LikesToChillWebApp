package softwareEngineering.LikesToChillWebApp.resources;
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

import softwareEngineering.LikesToChillWebApp.models.Movie;
import softwareEngineering.LikesToChillWebApp.services.MovieDAO;

@Path ("movies")
public class MovieResource {

	
	MovieDAO userMovies = new MovieDAO();
	
	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getAllUserLikes(@PathParam("userId") String userId ) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        
		userMovies.getConnection();
		return userMovies.findAllUserLikes(userId);
    }
	
    @POST
    @Path("/addLike")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addNewLike(Movie userMovie) throws SQLException, ClassNotFoundException,IllegalAccessException, InstantiationException {

        userMovies.getConnection();
        userMovies.addToLikeBucket(userMovie);
        return "**Like Added**";

    }
    	
    @DELETE
    @Path("/deleteLike/{userId}/{movieTitle}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteLike(@PathParam("movieTitle") String movieName,@PathParam("userId") String userId) throws SQLException, ClassNotFoundException, InstantiationException,IllegalAccessException {

        userMovies.getConnection();
        userMovies.deleteFromLikeBucket(movieName, userId);
        return "**Like Deleted**";

    }
	
}
