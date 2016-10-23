package CST438.softwareEngineering.LikesToChillWebApp.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie {

	private int movieId;
	
	private String movieName;
	private String movieYear;
	private String moviePlot;
	private String movieGenres;
	
	public Movie() {
		
	}
	
	public Movie(int movieId, String movieName, String movieYear, String moviePlot, String movieGenres) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieYear = movieYear;
		this.moviePlot = moviePlot;
		this.movieGenres = movieGenres;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(String movieYear) {
		this.movieYear = movieYear;
	}

	public String getMoviePlot() {
		return moviePlot;
	}

	public void setMoviePlot(String moviePlot) {
		this.moviePlot = moviePlot;
	}

	public String getMovieGenres() {
		return movieGenres;
	}

	public void setMovieGenres(String movieGenres) {
		this.movieGenres = movieGenres;
	}

	@Override
	public String toString() {
		return "Movies [movieId=" + movieId + ", movieName=" + movieName + ", movieYear=" + movieYear + ", moviePlot="
				+ moviePlot + ", movieGenres=" + movieGenres + "]";
	}
}
