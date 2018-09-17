package ticketBookingApplication;

public class Film {

	private String filmTitle; //set -filmTitle: String, -rating: RATING
	private RATING rating;
	
	//---------------------------------------------
	//get and set methods
	/**
	 * @return the filmTitle
	 */
	public String getFilmTitle() 
	{
		return this.filmTitle;
	}

	/**
	 * @param filmTitle the filmTitle to set
	 */
	public void setFilmTitle(String filmTitle) 
	{
		if (!(filmTitle.isEmpty())) //set method for film title must not be empty
		{
			this.filmTitle = filmTitle;
		}
		else
		{
			this.filmTitle = "Unkown";
		}
		
	}

	/**
	 * @return the rating as a string
	 */
	public RATING getRating()  //this is normal get method for rating as full RATING type. No need for string
	{
		return this.rating;
	}
	/**
	 * 
	 * @return the rating as a char
	 */
	public char getRatingCharacter() //this method gets the rating as it's first character
	{
		char ratingCharacter;
		ratingCharacter = this.rating.toString().charAt(0);
		
		return ratingCharacter;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(RATING rating) //the rating check is just here in case new movies are added
	{
		if(!(rating == RATING.GENERAL || rating == RATING.MATURE || rating == RATING.PARENTALGUIDANCE ))
		{
			this.rating = RATING.GENERAL;
		}
		else
		{
			this.rating = rating;
		}
		
	}

	//--------------------------------------------
	/**
	 * The constructor. Sets the title, and then does some testing to find what rating was entered as a string
	 * @param title
	 * @param rating
	 */
	public Film(String title, RATING rating)
	{
		this.setFilmTitle(title);
		this.setRating(rating);
		
	}
	/**
	 * Default constructor
	 */
	public Film()
	{
		this("Unknown", RATING.GENERAL);
	}
	
	//----------------------------------------------------
	@Override
	public String toString() //to string method just returns the film title and the rating as a character
	{
		return this.getFilmTitle() + ", Rating: (" + this.getRatingCharacter() + ")";
	}
}
