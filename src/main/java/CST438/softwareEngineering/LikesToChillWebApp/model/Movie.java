package CST438.softwareEngineering.LikesToChillWebApp.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie {

	private String movieId;
	private int userId;

	public Movie() {	
	}
	
	public Movie(String movieId, int userId) {
		super();
		this.movieId = movieId;
		this.userId = userId;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", userId=" + userId + "]";
	}
	
	
}
