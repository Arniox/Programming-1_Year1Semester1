package filmDataBaseApp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileCreationIO {

	/**
	 * input function takes in a file name as string, creates a scanner with FileReader based on the file name and reads in data
	 * @param inputFileName
	 * @return ArrayList<Film>
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public static ArrayList<Film> input(String inputFileName)
	{
		ArrayList<Film> filmsFromFile = new ArrayList<Film>();
		
		try {
			Scanner in = new Scanner(new FileReader(inputFileName));
			while(in.hasNextLine())
			{
				String titleI = in.nextLine();
				String directorI = in.nextLine();
				//--------------------------------------
				String ratingI = in.nextLine();
				double rating = Double.valueOf(ratingI);
				//--------------------------------------
				String releaseYearI = in.nextLine();
				//--------------------------------------
				String genreI = in.nextLine();
				Genre genre = Genre.valueOf(genreI);
				//--------------------------------------
				String numberOfMembersI = in.nextLine();
				int numberOfMembers = Integer.valueOf(numberOfMembersI);
				
				String [] castListI = new String[numberOfMembers];
				for(int i = 0; i < numberOfMembers; ++i)
				{
					castListI[i] = in.nextLine();
				}
				
				Collections.addAll(filmsFromFile, new Film(titleI, directorI, rating, releaseYearI, genre, castListI));
			}
			
			in.close();
			
		} catch (FileNotFoundException e) {
			//System.err.println("A FileNotFoundException error occurred: ");
			//e.printStackTrace();
		}

		return filmsFromFile;
	}
	
	/**
	 * output function takes in an ArrayList of films and a file name and prints out the ArrayList to a file
	 * @param filmsToFile
	 * @param filename
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public static void output(ArrayList<Film> filmsToFile, String filename)
	{
		try{
			PrintWriter out = new PrintWriter(new FileWriter(filename, false));
			for(int i = 0; i < filmsToFile.size(); ++i)
			{
				out.println(filmsToFile.get(i).getTitle());
				out.println(filmsToFile.get(i).getDirector());
				out.println(filmsToFile.get(i).getRating());
				out.println(filmsToFile.get(i).getReleaseYear());
				out.println(filmsToFile.get(i).getGenre());
				out.println(filmsToFile.get(i).getCastList().getPeopleList().size());
				
				for(int k = 0; k < filmsToFile.get(i).getCastList().getPeopleList().size(); ++k)
				{
					out.println(filmsToFile.get(i).getCastList().getPeopleList().get(k));
				}
			}
			out.close();
			
		}
		catch(IOException e){
			System.err.println("An IO error occurred: ");
			e.printStackTrace();
		}
	}
	
	/**
	 * createData function is only enacted when there is no file found. It creates default films and calls output to print them into a file
	 * @param filename
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public static void createData(String filename)
	{
		@SuppressWarnings("unused")
		String[] cast = null;
		ArrayList<Film> startingFilms = new ArrayList<Film>();
		Collections.addAll(startingFilms, new Film("The Shawshank Redemption", "Frank Darabont", 9.3, "1994", Genre.CRIME, cast = new String[]{"Tim Robbins", "Morgan Freeman", "Bob Gunton", "William Sadler"}),
			new Film("The Godfather","Francis Ford Coppola",9.2,"1972",Genre.CRIME,cast = new String[] {"Marlon Brando", "Al Pacino", "James Caan", "Richard S. Castellano"}),
			new Film("The Godfather: Part 2","Francis Ford Coppola",9,"1974",Genre.CRIME,cast = new String[] {"Al Pacino", "Robert Duvall", "Diane Keaton", "Robert De Niro"}),
			new Film("The Dark Knight","Christopher Nolan",9,"2008",Genre.ACTION,cast = new String[] {"Christian Bale", "Heath Ledger", "Aaron Eckhart", "Michale Caine"}),
			new Film("12 Angry Men","Sidney Lumet",8.9,"1957",Genre.DRAMA,cast = new String[] {"Martin Balsam", "John Fiedler", "Lee J. Cobb", "E.G Marshall"}),
			new Film("Schindler's List","Steven Spielberg",8.9,"1993",Genre.HISTORICAL,cast = new String[] {"Liam Neeson", "Ben Kingsley", "Ralph Fiennes", "Caroline Goodall"}),
			new Film("Pulp Fiction","Quentin Tarantino",8.9,"1994",Genre.DRAMA,cast = new String[] {"Tim Roth", "Amanda Plummer", "Laura Lovelace", "John Travolta"}),
			new Film("The Lord of the Rings: The Return of the King","Peter Jackson",8.9,"2003",Genre.ADVENTURE,cast = new String[] {"Ali Astin", "Sean Astin", "David Aston", "John Bach"}),
			new Film("The Good, the Bad and the Ugly","Sergio Leone",8.9,"1966",Genre.WESTERN,cast = new String[] {"Eli Wallach", "Clint Eastwood", "Lee Van Cleef", "Aldo Giuffrè"}),
			new Film("Fight Club","David Fincher",8.8,"1999",Genre.DRAMA,cast = new String[] {"Edward Norton", "Brad Pitt", "Meat Loaf", "Zach Grenier"}),
			new Film("The Lord of the Rings: The FellowShip of the Ring","Peter Jackson",8.8,"2001",Genre.FANTASY,cast = new String[] {"Alan Howard", "Noel Appleby", "Sean Astin", "Sala Baker"}),
			new Film("Forrest Gump","Robert Zemeckis",8.8,"1994",Genre.COMEDY,cast = new String[] {"Tom Hanks", "Rebecca Williams", "Sally Field", "Michal Conner Humphreys"}),
			new Film("Star Wars: The Empire Strikes Back","Irvin Kershner",8.8,"1980",Genre.FANTASY,cast = new String[] {"Mark Hmaill", "Harrison Ford", "Carrie Fisher", "Billy Dee Williams"}),
			new Film("Inception","Christpher Nolan",8.8,"2010",Genre.SCIFI,cast = new String[] {"Leonardo DeCaprio", "Joseph Gordon-Levitt", "Ellen Page", "Tom Hardy"}),
			new Film("One Flew Over the Cuckoo's Nest","Milos Forman",8.7,"1975",Genre.DRAMA,cast = new String[] {"Michae; Berryman", "Peter Brocco", "Dean R. Brooks", "Alonzo Brown"}),
			new Film("Goodfellas","Martin Scorsese",8.7,"1990",Genre.CRIME,cast = new String[] {"Robert De Niro", "Ray Liotta", "Jeo Pesci", "Lorraine Bracco"}),
			new Film("The Matrix","Lana Wachowski, Lilly Wachowski",8.7,"1999",Genre.SCIFI,cast = new String[] {"Keanu Reeves", "Laurence Fishblurne", "Carrie-Anne Moss", "Hugo Weaving"}),
			new Film("Seven Sumarai","Akira Kurosawa",8.7,"1954",Genre.ADVENTURE,cast = new String[] {"Toshirô Mifune", "Takashi Shimura", "Keiko Tsushima", "Yukiko Shimazaki"}),
			new Film("The Silence of the Lambs","Jonathan Demme",8.6,"1991",Genre.HORROR,cast = new String[] {"Jodie Foster", "Lawrence A. Bonney", "Kasi Lemmons", "Lawrence T. Wrentz"}),
			new Film("Code Name: K.O.Z", "Celal Çimen", 1.6, "2015", Genre.MYSTERY, cast = new String[] {"Cem Kurtoglu", "Hakan Ural", "Hazim Körmükçü", "Mehmet Çepiç"}),
			new Film("Saving Christmas", "Darren Doane", 1.5, "2014", Genre.FAMILY, cast = new String[] {"Kirk Cameron", "Darren Doane", "Bridgette Cameron", "Raphi Henly"}),	
			new Film("Superbabies: Baby Geniuses 2", "Bob Clark", 2.0, "2004", Genre.SCIFI, cast = new String[] {"Von Voight", "Scott Baio", "Vanessa Angle", "Skyler Shaye"}),
			new Film("Danel the Wizard", "Ulli Lommel", 1.9, "2004", Genre.FANTASY, cast = new String[] {"Daniel Küblböck", "Ulli Lommel", "Rudolf Waldemar Brem", "Katja Rupé"}),
			new Film("Manos: The Hands of Fate", "Harold P. Warren", 1.9, "1966", Genre.HORROR, cast = new String[] {"Tom Neyman", "John Reynolds", "Diane Adelson", "Harold P. Warren"}),
			new Film("Pledge This!", "William Heins, Strathford Hamilton", 1.9, "2006", Genre.COMEDY, cast = new String[] {"Paris Hilton", "Paula Garcés", "Sarah Carter", "Simon Rex"}),
			new Film("Turks in Space", "Kartal Tibet", 1.9, "2006", Genre.SCIFI, cast = new String[] {"Cüneyt Arkin", "Haldun Boysan", "Berda Ceyhan", "Veysel Diker"}),
			new Film("Foodfight!", "Lawrence Kasanoff", 1.7, "2012", Genre.ANIMATION, cast = new String[] {"Charlie Sheen", "Hilary Duff", "Eva Longoria", "Wayne Brady"}),
			new Film("The Express", "Cary Fleder", 7.3, "2008", Genre.BIOGRAPHY, cast = new String[] {"Rob Brown", "Dennis Quaid", "Darrin Dewitt Henson", "Omar Benson Millar"}),
			new Film("The 5th Quarter", "Rick Beiber", 5.7, "2010", Genre.SPORT, cast = new String[] {"Andie MacDowell", "Aidan Quinn", "Ryan Merriman", "Dave Blamy"}),
			new Film("The Sixth Man", "Randall Miller", 5.6, "1997", Genre.DRAMA, cast = new String[] {"Marlon Wayans", "Kadeem Hardison", "David Paymer", "Michael Michele"}),
			new Film("8 Seconds", "John G. Avildsen", 6.5, "1994", Genre.SPORT, cast = new String[] {"James Rebhorn", "Cameron Finley", "Carrie Snodgress", "Dustin Mayfield"}),
			new Film("10 Things I Hate About You", "Gil Junger", 7.2, "1999", Genre.ROMANCE, cast = new String[] {"Heath Ledger", "Julia Stiles", "Joseph Gordon-Levitt", "Larisa Oleynik"}),
			new Film("The 13th Warrior", "John McTiernan, Michael Crichton", 6.6, "1999", Genre.ACTION, cast = new String[] {"Antionio Banderas", "Diane Venora", "Dennis Storhøi", "Vladimir Kulich"}),
			new Film("Angles in the Outfield", "William Dear", 6.1, "1994", Genre.FAMILY, cast = new String[] {"Danny Glover", "Brenda Fricker", "Tony Danza", "Christopher Loyd"})
			);
		
		output(startingFilms, filename);
	}
}
