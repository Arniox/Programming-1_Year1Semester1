package filmDataBaseApp;

import java.util.ArrayList;

public class FilmDataBase {

	private ArrayList<Film> filmsList;
	private FilmSearchEngine searchEngine;
	
	@Override
	public String toString()
	{
		String out = "";
		out+= "Film data base has: "+this.filmsList.size()+" films:";
		for(Film f : this.filmsList)
		{
			out+="\n"+f.toString();
		}
		//essentially out+= this.filmsList.toString();
		return "---------\n"+out+"\n";
	}
	//-----------------------------------------------------------------
	/**
	 * Empty constructor for FilmsDataBase. Auto directs to the filled constructor with a new ArrayList<Film>
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public FilmDataBase()
	{
		this(new ArrayList<Film>());
	}
	/**
	 * FilmDataBase constructor. Takes in an ArrayList<Film> and sets the filmsList to films, 
	 * and sets the search engine to a new one with 'this' as input
	 * @param films
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public FilmDataBase(ArrayList<Film> films)
	{
		this.setFilmsList(films);
		this.searchEngine = new FilmSearchEngine(this);
	}
	//-----------------------------------------------------------------
	/**
	 * getter for filmsList.
	 * @return this.filmsList
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public ArrayList<Film> getFilmsList() {
		return this.filmsList;
	}
	/**
	 * getter for searchEngine
	 * @return this.searchEngine
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public FilmSearchEngine getSearchEngine() {
		return this.searchEngine;
	}
	/**
	 * setter for filmsList
	 * @param filmsList
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setFilmsList(ArrayList<Film> filmsList) {
		this.filmsList = filmsList;
	}
	/**
	 * getFilmsListStringArray returns a string array representation of the films ArrayList
	 * @return String[] array
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public String[] getFilmsListStringArray() {
		String[] array = new String[this.filmsList.size()];

		for(int i=0;i<array.length;i++)
		{
			array[i] = this.filmsList.get(i).halfToString();
		}

		return array;
	}
	/**
	 * hasFilm checks if there are any films inside the array that match a given film
	 * @param film
	 * @return boolean
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public boolean hasFilm(Film film)
	{
		for(Film f : filmsList)
		{
			if(f.equals(film))
			{
				return true;
			}
		}
		return false;
	}
	//--------------------------------------------------------------------
	/**
	 * addFilm function takes in a Film and adds it to filmsList
	 * @param inputFilm
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void addFilm(Film inputFilm)
	{
		this.filmsList.add(inputFilm);
	}
	/**
	 * removeFilm function takes in an index and removes the Film associated with it.
	 * @param index
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void removeFilm(int index)
	{
		this.filmsList.remove(index);
	}
}
