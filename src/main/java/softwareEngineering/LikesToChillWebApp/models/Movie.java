package softwareEngineering.LikesToChillWebApp.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie {

	private String movieTitle;
	private String userId;

	public Movie() {	
	}
	
	public Movie(String movieTitle, String userId) {
		super();
		this.movieTitle = movieTitle;
		this.userId = userId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Movie [movieTitle=" + movieTitle + ", userId=" + userId + "]";
	}
	
	
}
