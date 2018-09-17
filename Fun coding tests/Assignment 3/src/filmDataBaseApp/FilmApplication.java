package filmDataBaseApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class FilmApplication extends JFrame {

	private FilmDataBaseView view; //View
	private FilmDataBase model; //Model
	private FilmDataBase changedModel; //added search queries
	private static CheckGenre checkGenre;
	
	/**
	 * evenHandelWindowOpened handles the window opening
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	private void eventHandleWindowOpened()
	{
		this.view.update();
	}
	/**
	 * eventHandleWindowClosing handles when the window closes
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	private void eventHandleWindowClosing()
	{
		FileCreationIO.output(this.model.getFilmsList(), "FilmsData.text");
	}
	//-------------------------------------------------
	//Film List selection handle
	/**
	 * eventHandleListSelection handles when the user selects an item in the JList
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	private void eventHandleListSelection()
	{
		this.view.getRemoveButton().setEnabled(this.view.getFilmList().getSelectedIndex()!=-1); //set the remove button enable IF any film is selected
		
		if(this.view.getFilmList().getSelectedIndex() != -1) { //if any film is selected
			int index = this.view.getFilmList().getSelectedIndex(); //get the selected index as a number
			this.view.getFilmListed().setText("Title: " + this.view.getModel().getFilmsList().get(index).getTitle() + "\n" //set the JLabel FilmListed as the selected
					+"Directed by: " + this.view.getModel().getFilmsList().get(index).getDirector() + "\n"				   //film
					+"Released in: " + this.view.getModel().getFilmsList().get(index).getReleaseYear() + "\n"
					+"Rating: " + this.view.getModel().getFilmsList().get(index).getRating() + "\n"
					+"Genre: " + this.view.getModel().getFilmsList().get(index).getGenre().toString().toLowerCase() + "\n"
					+"Cast members: " + this.view.getModel().getFilmsList().get(index).getCastList().toString());
		}		
	}
	//---------------------------------------------------------------------------------------------------
	//Set the add button to enabled if all the text fields for adding a new film are filled
	/**
	 * eventHandleKeyReleased handles what happens when keys are released in the newFilm JTextFields
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	private void eventHandleKeyReleased(KeyEvent e)
	{
		this.view.getAddButton().setEnabled((!this.view.getNewFilmTitleField().getText().isEmpty()) &&
				(!this.view.getNewFilmDirectorField().getText().isEmpty()) && 
				(!this.view.getNewFilmRatingField().getText().isEmpty()) && 
				(!this.view.getNewFilmReleaseYearField().getText().isEmpty()) &&
				(!this.view.getNewFilmCastListField().getText().isEmpty()) &&
				(this.view.getSearchBar().getText().isEmpty()) &&
				(this.view.getAndSearchOption().getText().trim().equalsIgnoreCase(new String("Search options..."))));
		
		if(!(this.view.getNewFilmRatingField().getText().isEmpty())) //prevention from typing anything other than numbers in rating field
		{
			char c = e.getKeyChar(); //gets the new character typed
			if(this.view.getNewFilmRatingField().hasFocus()) //only wipes the right text field and not both year and rating fields
			{
				if(!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == '.'))) { //if it's NOT between 0 and 9 (integers),
					this.getToolkit().beep(); //make a beep sound															    a key event, or a decimal place
					this.view.getNewFilmRatingField().setText(""); //wipe the rating field
				}
			}
		}
		if(!(this.view.getNewFilmReleaseYearField().getText().isEmpty())) //prevention from typing anything other than numbers in year field
		{
			char c = e.getKeyChar(); //gets the new character typed
			if(this.view.getNewFilmReleaseYearField().hasFocus())
			{
				if(!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					this.getToolkit().beep(); //make a beep sound
					this.view.getNewFilmReleaseYearField().setText(""); //wipe the release year field
				}
			}	
		}
	}
	//---------------------------------------------------------------------------------------------------
	//Event handle for when the add button is clicked
	/**
	 * eventHandleAddButton handles when the user fills out the newFilm JTextFileds and clicks add
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	private void eventHandleAddButton()
	{
		String title = this.view.getNewFilmTitleField().getText().trim(); //set all the data. Mostly as strings
		String director = this.view.getNewFilmDirectorField().getText().trim();
		
		String ratingIO = this.view.getNewFilmRatingField().getText().trim();
		double rating = Double.valueOf(ratingIO); //convert the rating string to a double
		
		String releaseYear = this.view.getNewFilmReleaseYearField().getText().trim();
		
		int index = this.view.getNewFilmGenreField().getSelectedIndex();
		checkGenre = new CheckGenre();
		Genre genre = checkGenre.checkSelectedGenre(index);
		
		String[] cast = this.view.getNewFilmCastListField().getText().split("\\s*,\\s*");
		
		Film film = new Film(title, director, rating, releaseYear, genre, cast);
		
		if((!title.isEmpty()) && (!director.isEmpty()) && (!(rating == 0)) && (!releaseYear.isEmpty()) && (!this.model.hasFilm(film)))
		{
			this.model.addFilm(film);
			this.changedModel = model;
			
			this.view.getNewFilmTitleField().setText("");
			this.view.getNewFilmDirectorField().setText("");
			this.view.getNewFilmRatingField().setText("");
			this.view.getNewFilmReleaseYearField().setText("");
			this.view.getNewFilmCastListField().setText("");
		}
		this.view.update();
	}
	//----------------------------------------------------------------------------------------------------
	//Event handle for when the remove button is clicked
	/**
	 * eventHandleRemoveButton handles when the user selects an item on the list and clicks remove
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	private void eventHandleRemoveButton() {
		
		int index = this.view.getFilmList().getSelectedIndex();
		if(index!=-1)
		{
			for(int f = 0; f < this.model.getFilmsList().size(); ++f)
			{
				if(this.model.getFilmsList().get(f).equals(this.changedModel.getFilmsList().get(index)))
				{
					this.model.removeFilm(f);
				}
			}
			//this.model.removeFilm(index);
		}
		this.view.setModel(changedModel);
		
		this.view.getAndSearchOption().setText("Search options...");
		this.view.getSearchBar().setText("");
		
		enableAll(true);
		
		this.changedModel = model;
		this.view.setModel(changedModel);
		this.view.update();
	}
	//----------------------------------------------------------------------------------------------------
	//Event handler for when the user clicks add search option
	/**
	 * eventHandleAndSearchButton handles when the user clicks Add search query. This function adds the search query to
	 * the application so the user can stack infinite search queries
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	private void eventHandleAndSearchButton() {
		this.view.getAndSearchOption().setText(
				this.view.getAndSearchOption().getText() 
				+ "\n" + this.view.getSearchOptions().getSelectedItem().toString() + ": "
				+ this.view.getSearchBar().getText().toString().trim());
		
		int index = this.view.getSearchOptions().getSelectedIndex();
		
		FilmDataBase result = null;
		result = this.searchResultsGet(index);
		this.changedModel = result;
		
		this.view.setModel(changedModel);
		this.view.getSearchBar().setText("");
		this.view.update();
	}
	//----------------------------------------------------------------------------------------------------
	//Event handler for the clear search options button
	/**
	 * eventHandleClearSearchOptions handles when the user clicks clear search options button. This function clears all search queries
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	private void eventHandleClearSearchOptions() {
		
		this.view.getAndSearchOption().setText("Search options...");
		this.view.getSearchBar().setText("");
		
		enableAll(true);
		
		this.changedModel = model;
		this.view.setModel(changedModel);
		this.view.update();
	}
	//----------------------------------------------------------------------------------------------------
	//Event handler for when the user types in the search bar
	/**
	 * eventHandleSearchBar handles when the user types inside the search bar
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	private void eventHandleSearchBar(KeyEvent e) {
		
		int index = this.view.getSearchOptions().getSelectedIndex();
		FilmDataBase result = null;
		String output = "";
		
		if(this.view.getSearchBar().getText().isEmpty() && 
				(this.view.getAndSearchOption().getText().trim().equalsIgnoreCase(new String("Search options..."))))
		{
			enableAll(true);
		}else {
			enableAll(false);
		}
		
		switch(index)
		{
		case 0: //search by title
			result = this.changedModel.getSearchEngine().byTitle(this.view.getSearchBar().getText().trim());
			break;
		case 1: //search by director
			result = this.changedModel.getSearchEngine().byDirector(this.view.getSearchBar().getText().trim());
			break;
		case 2: //search bellow rating
			if(this.view.getSearchBar().getText().isEmpty()) { //need to check if this is empty. If it's not, it tries converting a backspace to a double
				result = this.changedModel;
				this.view.update(); //if the user has wiped the search bar, then just update the list
			}else {
				if(!(this.view.getSearchBar().getText().isEmpty())) { //prevention from typing anything other than numbers in searchBar field
					char c = e.getKeyChar(); //gets the new character typed
					if(!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == '.'))) { //also check for dot
						this.getToolkit().beep(); //make a beep sound
						this.view.getSearchBar().setText(""); //wipe the searchBar field
					}else {
						result = this.changedModel.getSearchEngine().bellowRating(Double.valueOf(this.view.getSearchBar().getText().trim()));
						break;
					}
					
					result = this.changedModel;
					this.view.update(); //if the checker has wiped the search bar, then just update the list
				}
			}
			break;
		case 3: //search above rating
			if(this.view.getSearchBar().getText().isEmpty()) {
				result = this.changedModel;
				this.view.update();
			}else {
				if(!(this.view.getSearchBar().getText().isEmpty())) { //prevention from typing anything other than numbers in searchBar field
					char c = e.getKeyChar(); //gets the new character typed
					if(!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == '.'))) { //also check for dot
						this.getToolkit().beep(); //make a beep sound
						this.view.getSearchBar().setText(""); //wipe the searchBar field
					}else {
						result = this.changedModel.getSearchEngine().aboveRating(Double.valueOf(this.view.getSearchBar().getText().trim()));
						break;
					}
					
					result = this.changedModel;
					this.view.update(); //if the checker has wiped the search bar, then just update the list
				}
			}
			break;
		case 4: //search by year
			result = this.changedModel.getSearchEngine().byReleaseYear(this.view.getSearchBar().getText().trim());
			break;
		case 5: //search before year
			if(this.view.getSearchBar().getText().isEmpty()) {
				result = this.changedModel;
				this.view.update();
			}else {
				if(!(this.view.getSearchBar().getText().isEmpty())) { //prevention from typing anything other than numbers in searchBar field
					char c = e.getKeyChar(); //gets the new character typed
					if(!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == '.'))) { //also check for dot
						this.getToolkit().beep(); //make a beep sound
						this.view.getSearchBar().setText(""); //wipe the searchBar field
					}else {
						result = this.changedModel.getSearchEngine().beforeReleaseYear(Integer.valueOf(this.view.getSearchBar().getText().trim()));
						break;
					}
					
					result = this.changedModel;
					this.view.update(); //if the checker has wiped the search bar, then just update the list
				}
			}
			break;
		case 6: //search after year
			if(this.view.getSearchBar().getText().isEmpty()) {
				result = this.changedModel;
				this.view.update();
			}else {
				if(!(this.view.getSearchBar().getText().isEmpty())) { //prevention from typing anything other than numbers in searchBar field
					char c = e.getKeyChar(); //gets the new character typed
					if(!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == '.'))) { //also check for dot
						this.getToolkit().beep(); //make a beep sound
						this.view.getSearchBar().setText(""); //wipe the searchBar field
					}else {
						result = this.changedModel.getSearchEngine().afterReleaseYear(Integer.valueOf(this.view.getSearchBar().getText().trim()));
						break;
					}
					
					result = this.changedModel;
					this.view.update(); //if the checker has wiped the search bar, then just update the list
				}
			}
			break;
		case 7: //search by genre
			result = this.changedModel.getSearchEngine().byGenre(this.view.getSearchBar().getText());
			break;
		case 8: //search by cast member
			result = this.changedModel.getSearchEngine().byCast(this.view.getSearchBar().getText().trim());
			break;
		}
		
		output += result.getFilmsList().size();
		this.view.getNumberOfFilmsFound().setText(output + " films found...");
		//this.view.getFilmList().setListData(result.getFilmsListStringArray());
		this.view.setModel(result);
		this.view.update();
	}
	//----------------------------------------------------------------------------------------------------
	//Event handler for when the search options is changed
	/**
	 * eventHandleSearchOptions handles any events generated by the search Option drop down menu
	 *  @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void eventHandleSearchOptions()
	{
		this.view.setModel(changedModel);
		this.view.getSearchBar().setText("");
		this.view.update();
	}
	//-------------------------------------------------
	/**
	 * FilmApplication constructor constructs the controller for the JFrame
	 * @param name
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public FilmApplication(String name) {
		
		super(name); //sets application name
		
		//File reading start
		//create new filmDataBase. This will be the base one 
		
		model = new FilmDataBase(FileCreationIO.input("FilmsData.text")); //read in data from file: FilmsData.text
		if(model.getFilmsList().isEmpty()) //if the file is non existant, resulting in an empty FilmDataBase
		{
			FileCreationIO.createData("FilmsData.text"); //create new, default data and save it to a file
			model = new FilmDataBase(FileCreationIO.input("FilmsData.text")); //red-read the data from the file: FilmsData.text
		}
		
		//MVC control starts here
		this.changedModel = model;
		this.view = new FilmDataBaseView(this.changedModel); //sets up a FilmDataBaseView with the model input
		this.getContentPane().add(this.view); //adds the view to the content pane

		setSize(800, 480); // manually computed sizes
		setResizable(false); //stops user from resizing the pane

		//window listener for opening the window
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowOpened(WindowEvent e) 
			{
				eventHandleWindowOpened();
			}
			@Override
			public void windowClosing(WindowEvent e)
			{
				eventHandleWindowClosing();
				e.getWindow().dispose();
			}
		});
		//----------------------------------------------------
		//Action Listeners
		//JLists
		this.view.getFilmList().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				eventHandleListSelection();
			}
		});
		//----------------------------------------------------
		//JTextFields
		this.view.getNewFilmTitleField().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				eventHandleKeyReleased(e);
			}
		});
		this.view.getNewFilmDirectorField().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				eventHandleKeyReleased(e);
			}
		});
		this.view.getNewFilmRatingField().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				eventHandleKeyReleased(e);
			}
		});
		this.view.getNewFilmReleaseYearField().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				eventHandleKeyReleased(e);
			}
		});
		this.view.getNewFilmGenreField().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				eventHandleKeyReleased(e);
			}
		});
		this.view.getNewFilmCastListField().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				eventHandleKeyReleased(e);
			}
		});
		//----------------------------------------------------
		//JButtons
		this.view.getAddButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandleAddButton();
			}
		});
		this.view.getRemoveButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandleRemoveButton();
			}
		});
		//----------------------------------------------------
		//JTextField for search bar
		this.view.getSearchBar().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				eventHandleSearchBar(e);
			}
		});
		//----------------------------------------------------
		//JComboBox for search bar
		this.view.getSearchOptions().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandleSearchOptions();
			}
		});
		//----------------------------------------------------
		//JButton for add search query
		this.view.getAndSearchButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandleAndSearchButton();
			}
		});
		//----------------------------------------------------
		this.view.getClearSearchOptions().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandleClearSearchOptions();
			}
		});
	}
	
	public static void main(String[] args)
	{
		JFrame frame = new FilmApplication("Film Data Base Application");
		frame.setVisible(true);
	}
	/**
	 * searchResultsGet assumes that the search bar is being handled by its own event handler so the search bar
	 * will ALWAYS be fill because of that event handler. Because of this, this function doesn't need to worry about
	 * checking if the search bar is empty or if the right info is in the bar.
	 * @param index
	 * @return a new FilmDataBase where any old searches are put back through the search engine to stack search queries
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	private FilmDataBase searchResultsGet(int index)
	{
		FilmDataBase result = null; //all this searching is assuming that the normal search went to plan
		
		switch(index)
		{
		case 0: //search by title
			result = this.changedModel.getSearchEngine().byTitle(this.view.getSearchBar().getText().trim());
			break;
		case 1: //search by director
			result = this.changedModel.getSearchEngine().byDirector(this.view.getSearchBar().getText().trim());
			break;
		case 2: //search bellow rating
			result = this.changedModel.getSearchEngine().bellowRating(Double.valueOf(this.view.getSearchBar().getText().trim()));
			break;
		case 3: //search above rating
			result = this.changedModel.getSearchEngine().aboveRating(Double.valueOf(this.view.getSearchBar().getText().trim()));
			break;
		case 4: //search by year
			result = this.changedModel.getSearchEngine().byReleaseYear(this.view.getSearchBar().getText().trim());
			break;
		case 5: //search before year
			result = this.changedModel.getSearchEngine().beforeReleaseYear(Integer.valueOf(this.view.getSearchBar().getText().trim()));
			break;
		case 6: //search after year
			result = this.changedModel.getSearchEngine().afterReleaseYear(Integer.valueOf(this.view.getSearchBar().getText().trim()));
			break;
		case 7: //search by genre
			result = this.changedModel.getSearchEngine().byGenre(this.view.getSearchBar().getText());
			break;
		case 8: //search by cast member
			result = this.changedModel.getSearchEngine().byCast(this.view.getSearchBar().getText().trim());
			break;
		}
		
		return result;
	}
	/**
	 * Enable all
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	private void enableAll(boolean falseOrTrue)
	{
		if(falseOrTrue)
		{
			this.view.getNewFilmTitleField().setEnabled(true);
			this.view.getNewFilmDirectorField().setEnabled(true);
			this.view.getNewFilmRatingField().setEnabled(true);
			this.view.getNewFilmReleaseYearField().setEnabled(true);
			this.view.getNewFilmGenreField().setEnabled(true);
			this.view.getNewFilmCastListField().setEnabled(true);
		}else {
			this.view.getNewFilmTitleField().setEnabled(false);
			this.view.getNewFilmDirectorField().setEnabled(false);
			this.view.getNewFilmRatingField().setEnabled(false);
			this.view.getNewFilmReleaseYearField().setEnabled(false);
			this.view.getNewFilmGenreField().setEnabled(false);
			this.view.getNewFilmCastListField().setEnabled(false);
		}
	}
}

