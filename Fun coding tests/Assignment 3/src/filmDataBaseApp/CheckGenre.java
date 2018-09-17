package filmDataBaseApp;

public class CheckGenre {
	//--------------------------------------------
	/**
	 * checkSelectedGenre is a separate class due to brevity. It takes in a selected index and gives the equating genre
	 * @param index
	 * @return a Genre output
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public Genre checkSelectedGenre(int index)
	{
		Genre output = null;
		switch(index)
		{
		case 0:
			output = Genre.SURREAL;
			break;
		case 1:
			output = Genre.ACTION;
			break;
		case 2:
			output = Genre.ADVENTURE;
			break;
		case 3:
			output = Genre.COMEDY;
			break;
		case 4:
			output = Genre.CRIME;
			break;
		case 5:
			output = Genre.DRAMA;
			break;
		case 6:
			output = Genre.FANTASY;
			break;
		case 7:
			output = Genre.HISTORICAL;
			break;
		case 8:
			output = Genre.HORROR;
			break;
		case 9:
			output = Genre.MAGICAL;
			break;
		case 10:
			output = Genre.MYSTERY;
			break;
		case 11:
			output = Genre.PARANOID;
			break;
		case 12:
			output = Genre.PHILOSOPHICAL;
			break;
		case 13:
			output = Genre.POLITICAL;
			break;
		case 14:
			output = Genre.ROMANCE;
			break;
		case 15:
			output = Genre.SAGA;
			break;
		case 16:
			output = Genre.SATIRE;
			break;
		case 17:
			output = Genre.SCIFI;
			break;
		case 18:
			output = Genre.SLICEOFLIFE;
			break;
		case 19:
			output = Genre.SPECULATIVE;
			break;
		case 20:
			output = Genre.THRILLER;
			break;
		case 21:
			output = Genre.URBAN;
			break;
		case 22:
			output = Genre.WESTERN;
			break;
		case 23:
			output = Genre.ASIAN;
			break;
		case 24:
			output = Genre.FAMILY;
			break;
		case 25:
			output = Genre.ANIMATION;
			break;
		case 26:
			output = Genre.BIOGRAPHY;
			break;
		case 27:
			output = Genre.SPORT;
			break;
		}
		return output;
	}
}
