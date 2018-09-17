package filmDataBaseApp;

public class FilmSearchEngine {
	
	private FilmDataBase filmsList;

	//--------------------------------------------------------------------------------------------------------------
	/**
	 * FilmSearchEngine constructor. Takes in FilmDatabase
	 * @param filmDataBaseInput
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public FilmSearchEngine(FilmDataBase filmDataBaseInput)
	{
		this.filmsList = filmDataBaseInput;
	}
	//--------------------------------------------------------------------------------------------------------------
	/**
	 * Search by title of film function
	 * @param titleTerm
	 * @return FilmDataBase results
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public FilmDataBase byTitle(String titleTerm)
	{
		FilmDataBase results = new FilmDataBase();

		for(Film f : filmsList.getFilmsList())
		{
			if(f.getTitle().toLowerCase().contains(titleTerm.toLowerCase()))
			{
				results.addFilm(f);
			}
		}
		return results;
	}
	//--------------------------------------------------------------------------------------------------------------
	/**
	 * Search by director of film function
	 * @param directorTerm
	 * @return FilmDatabase
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public FilmDataBase byDirector(String directorTerm)
	{
		FilmDataBase results = new FilmDataBase();

		for(Film f : filmsList.getFilmsList())
		{
			if(f.getDirector().toLowerCase().contains(directorTerm.toLowerCase()))
			{
				results.addFilm(f);
			}
		}
		return results;
	}
	//--------------------------------------------------------------------------------------------------------------
	/**
	 * Search for any film bellow an input rating
	 * @param ratingInput
	 * @return FilmDataBase results
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public FilmDataBase bellowRating(double ratingInput)
	{
		FilmDataBase results = new FilmDataBase();

		for(Film f : filmsList.getFilmsList())
		{
			if(f.getRating()<ratingInput)
			{
				results.addFilm(f);
			}
		}
		return results;
	}
	//--------------------------------------------------------------------------------------------------------------
	/**
	 * Search for any film above an input rating
	 * @param ratingInput
	 * @return FilmDataBase results
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public FilmDataBase aboveRating(double ratingInput)
	{
		FilmDataBase results = new FilmDataBase();

		for(Film f : filmsList.getFilmsList())
		{
			if(f.getRating()>ratingInput)
			{
				results.addFilm(f);
			}
		}
		return results;
	}
	//--------------------------------------------------------------------------------------------------------------
	/**
	 * Search by release year of a film function
	 * @param releaseYearTerm
	 * @return FilmDataBase results
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public FilmDataBase byReleaseYear(String releaseYearTerm)
	{
		FilmDataBase results = new FilmDataBase();

		for(Film f : filmsList.getFilmsList())
		{
			if(f.getReleaseYear().contains(releaseYearTerm))
			{
				results.addFilm(f);
			}
		}
		return results;
	}
	//--------------------------------------------------------------------------------------------------------------
	/**
	 * Search for any film released before an input year
	 * @param releaseYearTerm
	 * @return FilmDataBase results
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public FilmDataBase beforeReleaseYear(int releaseYearTerm)
	{
		FilmDataBase results = new FilmDataBase();

		for(Film f : filmsList.getFilmsList())
		{
			int releaseYear = Integer.valueOf(f.getReleaseYear());
			if(releaseYear < releaseYearTerm)
			{
				results.addFilm(f);
			}
		}
		return results;
	}
	//--------------------------------------------------------------------------------------------------------------
	/**
	 * Search for any film released after an input year
	 * @param releaseYearTerm
	 * @return FilmDataBase results
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public FilmDataBase afterReleaseYear(int releaseYearTerm)
	{
		FilmDataBase results = new FilmDataBase();

		for(Film f : filmsList.getFilmsList())
		{
			int releaseYear = Integer.valueOf(f.getReleaseYear());
			if(releaseYear > releaseYearTerm)
			{
				results.addFilm(f);
			}
		}
		return results;
	}
	//--------------------------------------------------------------------------------------------------------------
	/**
	 * Search by genre for a film function
	 * @param genre
	 * @return FilmDataBase results
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public FilmDataBase byGenre(String genre)
	{
		FilmDataBase results = new FilmDataBase();

		for(Film f : filmsList.getFilmsList())
		{
			if(f.getGenre().toString().toLowerCase().contains(genre.toLowerCase()))
			{
				results.addFilm(f);
			}
		}
		return results;
	}
	//--------------------------------------------------------------------------------------------------------------
	/**
	 * Search by a cast member in a film function
	 * @param castMemberTerm
	 * @return FilmDataBase results
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public FilmDataBase byCast(String castMemberTerm)
	{
		FilmDataBase results = new FilmDataBase();

		for(Film f : filmsList.getFilmsList())
		{
			if(f.getCastList().hasPerson(castMemberTerm))
			{
				results.addFilm(f);
			}
		}
		return results;
	}
	//--------------------------------------------------------------------------------------------------------------
}
