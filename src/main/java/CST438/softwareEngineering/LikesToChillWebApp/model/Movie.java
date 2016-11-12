package CST438.softwareEngineering.LikesToChillWebApp.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie {

	private String movieId;
	
	public Movie() {
		
	}
	
	public Movie(String movieId) {
		super();
		this.movieId = movieId;
		
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
	@Override
	public String toString() {
		return "Movies [movieId=" + movieId + "]";
	}
}
