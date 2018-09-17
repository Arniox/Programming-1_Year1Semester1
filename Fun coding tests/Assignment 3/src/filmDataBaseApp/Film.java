package filmDataBaseApp;

import java.util.ArrayList;

public class Film{
	
	private String title;
	private String director;
	private double rating;
	private String releaseYear;
	private Genre genre;
	private CastList castList;
	
	
	//getters--------------------------------------------
	/**
	 * get title
	 * @return String title
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public String getTitle() {
		return this.title;
	}
	/**
	 * get director
	 * @return String director
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public String getDirector() {
		return this.director;
	}
	/**
	 * get rating
	 * @return int rating
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public double getRating() {
		return this.rating;
	}
	/**
	 * get releaseYear
	 * @return String releaseYear
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public String getReleaseYear() {
		return this.releaseYear;
	}
	/**
	 * get genre
	 * @return Genre genre
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public Genre getGenre() {
		return this.genre;
	}
	/**
	 * get castList
	 * @return CastList castList
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public CastList getCastList() {
		return this.castList;
	}
	
	//setters--------------------------------------------
	/**
	 * set title
	 * @param title
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * set director
	 * @param director
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	/**
	 * set rating
	 * @param rating
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	/**
	 * set releaseYear
	 * @param releaseYear
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	/**
	 * set genre
	 * @param genre
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	//constructor----------------------------------------
	/**
	 * Constructor takes in title, director, rating, releaseYear, genre as strings and int and then takes in a basic string
	 * array which it then sets as the castList using the CastList function of setPeople with a basic string array input
	 * @param title
	 * @param director
	 * @param rating
	 * @param releaseYear
	 * @param genre
	 * @param castList
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public Film(String title, String director, double rating, String releaseYear, Genre genre, String[] castList)
	{
		ArrayList<String> cast = new ArrayList<String>();
		for(String p : castList)
		{
			cast.add(p);
		}
		
		this.setTitle(title);
		this.setDirector(director);
		this.setRating(rating);
		this.setReleaseYear(releaseYear);
		this.setGenre(genre);
		
		this.castList = new CastList(cast);
	}
	
	//---------------------------------------------------
	@Override
	public String toString()
	{
		String output = "";
		
		output += this.getTitle() + ", directed by and directed by ";
		output += this.getDirector() + "\n";
		output += "Released in: " + this.getReleaseYear() + "\n";
		output += "Rating/Genre: " + this.getRating() + "/";
		output += this.getGenre().toString().toLowerCase() + "\n";
		output += "Cast members: " + this.getCastList().toString();
		
		return output;
	}
	/**
	 * halfToString is a broken down version of the default toString method
	 * @return just the title of the film along with the rating
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public String halfToString()
	{
		String output = "";
		
		output += this.getTitle() + " / " + this.getRating();
				
		return output;
	}
	
}
