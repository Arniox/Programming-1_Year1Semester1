package filmDataBaseApp;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings({ "rawtypes", "unchecked", "serial"})
public class FilmDataBaseView extends JLayeredPane{

	private FilmDataBase model;
	
	private JList filmList;
	private JTextField newFilmTitleField, newFilmDirectorField, newFilmRatingField, 
	newFilmReleaseYearField, newFilmCastListField, searchBar;
	private JButton addButton, removeButton, andSearchButton, clearSearchOptions;
	private JLabel simpleLabel, searchLabel, title, director, rating, releaseYear, genre, castList, 
	numberOfFilmsFound, filmListedLabel, addFilmsLabel;
	private JComboBox searchOptions, newFilmGenreField;
	private JTextArea filmListed, andSearchOption;
	
	//setters--------------------------------------------------
	/**
	 * set the model as in input model
	 * @param model
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setModel(FilmDataBase model)
	{
		this.model = model;
	}
	//getters--------------------------------------------------
	/**
	 * get model
	 * @return FilmDataBase
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public FilmDataBase getModel() {
		return this.model;
	}
	/**
	 * get filmList JList
	 * @return JList
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JList getFilmList() {
		return this.filmList;
	}
	/**
	 * get title JTextField
	 * @return JTextField
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JTextField getNewFilmTitleField() {
		return this.newFilmTitleField;
	}
	/**
	 * get director JTextField
	 * @return JTextField
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JTextField getNewFilmDirectorField() {
		return this.newFilmDirectorField;
	}
	/**
	 * get rating JTextField
	 * @return JTextField
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JTextField getNewFilmRatingField() {
		return this.newFilmRatingField;
	}
	/**
	 * get Release Year JTextField
	 * @return JTextField
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JTextField getNewFilmReleaseYearField() {
		return this.newFilmReleaseYearField;
	}
	/**
	 * get cast list JTextField
	 * @return JTextField
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JTextField getNewFilmCastListField() {
		return this.newFilmCastListField;
	}
	/**
	 * get search bar JTextField
	 * @return JTextField
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JTextField getSearchBar() {
		return this.searchBar;
	}
	/**
	 * get Films listed JTextArea
	 * @return JTextArea
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JTextArea getFilmListed() {
		return this.filmListed;
	}
	/**
	 * get the searchOption label as JTextArea
	 * @return JTextArea
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JTextArea getAndSearchOption() {
		return this.andSearchOption;
	}
	/**
	 * get title JLabel
	 * @return JLabel
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JLabel getTitle() {
		return this.title;
	}
	/**
	 * get director JLabel
	 * @return JLabel
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JLabel getDirector() {
		return this.director;
	}
	/**
	 * get rating JLabel
	 * @return JLabel
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JLabel getRating() {
		return this.rating;
	}
	/**
	 * get release year JLabel
	 * @return JLabel
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JLabel getReleaseYear() {
		return this.releaseYear;
	}
	/**
	 * get genre JLabel
	 * @return JLabel
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JLabel getGenre() {
		return this.genre;
	}
	/**
	 * get cast list JLabel
	 * @return JLabel
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JLabel getcastList() {
		return this.castList;
	}
	/**
	 * get simple label JLabel
	 * @return JLabel
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JLabel getSimpleLabel() {
		return this.simpleLabel;
	}
	/**
	 * get the number of films found after a search as JLabel
	 * @return JLabel
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JLabel getNumberOfFilmsFound() {
		return this.numberOfFilmsFound;
	}
	/**
	 * get addButton JButton
	 * @return JButton
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JButton getAddButton() {
		return this.addButton;
	}
	/**
	 * get removeButton JButton
	 * @return JButton
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JButton getRemoveButton() {
		return this.removeButton;
	}
	/**
	 * get andSearchButton as JButton
	 * @return JButton
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JButton getAndSearchButton() {
		return this.andSearchButton;
	}
	/**
	 * get clearSearchOptions as a JButton
	 * @return JButton
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JButton getClearSearchOptions() {
		return this.clearSearchOptions;
	}
	/**
	 * get search options JComboBox
	 * @return JComboBox
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JComboBox getSearchOptions() {
		return this.searchOptions;
	}
	/**
	 * get film genre field as JComboBox
	 * @return JComboBox
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JComboBox getNewFilmGenreField() {
		return this.newFilmGenreField;
	}
	/**
	 * get filmListedLabel as JLabel
	 * @return JLabel
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JLabel getFilmListedLabel() {
		return this.filmListedLabel;
	}
	/**
	 * get addFilmsLabel as a JLabel
	 * @return JLabel
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public JLabel getAddFilmsLabel() {
		return this.addFilmsLabel;
	}
	//----------------------------------------------------
	//draw line for break
	/**
	 * paint takes in a Graphics type, paints it to super, and then type casts the Graphics to Graphics2D
	 * It then draws two lines as Line2D, before finally drawing them to the Graphics2D
	 * @param g
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void paint(Graphics g) {
        super.paint(g); //fixes problem with line appearing on every element.
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin1 = new Line2D.Float(360, 230, 360, 447);
        Line2D lin2 = new Line2D.Float(360, 230, 790, 230);
        g2.draw(lin1);
        g2.draw(lin2);
    }
	//-----------------------------------------------
	/**
	 * FilmDataBaseView constructor takes in a model and constructs a view for the model
	 * @param model
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public FilmDataBaseView(FilmDataBase model)
	{
		this.model = model; //set the model.
		setLayout(null); //Choose to lay out components manually
		
		//add FilmList List
		this.filmList = new JList(this.model.getFilmsListStringArray());
		this.filmList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(filmList, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setLocation(10, 30);
		scrollPane.setSize(350, 200);
		this.add(scrollPane);

		//add Labels
		this.simpleLabel = new JLabel("Films");
		simpleLabel.setLocation(10, 10);
		simpleLabel.setSize(50, 15);
		this.add(simpleLabel);
		//Selected index film-------------------------
		this.filmListed = new JTextArea("Title: __ \nDirected: by __\nReleased: in __\nRating: __\nGenre: __\nCast members: ");
		JScrollPane filmSelectedScrollPane = new JScrollPane(filmListed, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		filmSelectedScrollPane.setLocation(10, 252);
		filmSelectedScrollPane.setSize(345, 198);
		filmSelectedScrollPane.setBorder(null);
		this.add(filmSelectedScrollPane, 1, 0);
		//Title------------------------
		this.title = new JLabel("Title");
		title.setLocation(635, 35);
		title.setSize(100, 15);
		this.add(title);
		//Director------------------------
		this.director = new JLabel("Director");
		director.setLocation(635, 65);
		director.setSize(100, 15);
		this.add(director);
		//Rating------------------------
		this.rating = new JLabel("Rating");
		rating.setLocation(635, 95);
		rating.setSize(100, 15);
		this.add(rating);
		//Release Year------------------
		this.releaseYear = new JLabel("Release Year");
		releaseYear.setLocation(635, 125);
		releaseYear.setSize(100, 15);
		this.add(releaseYear);
		//Genre------------------------
		this.genre = new JLabel("Genre");
		genre.setLocation(635, 155);
		genre.setSize(100, 15);
		this.add(genre);
		//Cast Member------------------------
		this.castList = new JLabel("Cast Memebers");
		castList.setLocation(635, 185);
		castList.setSize(100, 15);
		this.add(castList);
		//Selected film Label---------------
		this.filmListedLabel = new JLabel("Selected Film...");
		filmListedLabel.setLocation(8, 235);
		filmListedLabel.setSize(100, 15);
		this.add(filmListedLabel);
		//addFilmsLabel
		this.addFilmsLabel = new JLabel("Add New Films...");
		addFilmsLabel.setLocation(370, 10);
		addFilmsLabel.setSize(100, 15);
		this.add(addFilmsLabel);
		
		//add addition and removal buttons
		this.addButton = new JButton("Add");
		addButton.setLocation(370, 30);
		addButton.setSize(100, 25);
		this.add(addButton);
		//------------------------------------
		this.removeButton = new JButton("Remove");
		removeButton.setLocation(370, 60);
		removeButton.setSize(100, 25);
		this.add(removeButton);
		
		//add all the text input fields
		this.newFilmTitleField = new JTextField();
		newFilmTitleField.setLocation(480, 30);
		newFilmTitleField.setSize(150, 25);
		this.add(newFilmTitleField);
		//------------------------------------
		this.newFilmDirectorField = new JTextField();
		newFilmDirectorField.setLocation(480, 60);
		newFilmDirectorField.setSize(150, 25);
		this.add(newFilmDirectorField);
		//------------------------------------
		this.newFilmRatingField = new JTextField();
		newFilmRatingField.setLocation(480, 90);
		newFilmRatingField.setSize(150, 25);
		this.add(newFilmRatingField);
		//------------------------------------
		this.newFilmReleaseYearField = new JTextField();
		newFilmReleaseYearField.setLocation(480, 120);
		newFilmReleaseYearField.setSize(150, 25);
		this.add(newFilmReleaseYearField);
		//Combo box for the new film input genre------------------------------------
		String[] genreOptions = new String[] {"Surreal", "Action", "Adventure", "Comedy", "Crime", "Drama", "Fantasy", "Historical",
				"Horror", "Magical", "Mystery", "Paranoid", "Philosophical", "Political", "Romance", 
				"Saga", "Satire", "Sci-Fi", "Slice of Life", "Speculative", "Thriller", "Urban",
				"Western", "Asian", "Family, Animation, Biography, Sport"};
		this.newFilmGenreField = new JComboBox(genreOptions);
		newFilmGenreField.setLocation(480, 150);
		newFilmGenreField.setSize(150, 25);
		this.add(newFilmGenreField);
		//------------------------------------
		this.newFilmCastListField = new JTextField();
		newFilmCastListField.setLocation(480, 180);
		newFilmCastListField.setSize(150, 25);
		this.add(newFilmCastListField);
		
		//add search section
		this.searchLabel = new JLabel("Search our film data base...");
		searchLabel.setLocation(370, 235);
		searchLabel.setSize(200, 15);
		this.add(searchLabel);
		//add search bar
		this.searchBar = new JTextField();
		searchBar.setLocation(370, 255);
		searchBar.setSize(150, 25);
		this.add(searchBar);
		//Add and search button
		this.andSearchButton = new JButton("Add search option");
		andSearchButton.setLocation(525, 285);
		andSearchButton.setSize(155, 25);
		this.add(andSearchButton);
		//Add clear searches button
		this.clearSearchOptions = new JButton("Clear search queries");
		clearSearchOptions.setLocation(525, 315);
		clearSearchOptions.setSize(155, 25);
		this.add(clearSearchOptions);

		//Label for number of films Found
		this.numberOfFilmsFound = new JLabel(this.model.getFilmsList().size() + " films found...");
		numberOfFilmsFound.setLocation(525, 345);
		numberOfFilmsFound.setSize(200, 15);
		this.add(numberOfFilmsFound);
		//Label for searches added
		this.andSearchOption = new JTextArea("Search options...\n");
		JScrollPane andSearchOptionScroll = new JScrollPane(andSearchOption, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		andSearchOptionScroll.setLocation(370, 285);
		andSearchOptionScroll.setSize(148, 150);
		andSearchOptionScroll.setBorder(null);
		this.add(andSearchOptionScroll, 1, 0);

		//Combo search options Box
		String[] searchOptionsArray = new String[] {"By Title", "By Director", "Bellow Rating", "Above Rating",
				"By Year", "Before Year", "After Year", "By Genre", "By Cast Member"};
		this.searchOptions = new JComboBox(searchOptionsArray);
		searchOptions.setSelectedIndex(0);
		searchOptions.setLocation(525, 255);
		searchOptions.setSize(155, 25);
		this.add(searchOptions);
		
		setSize(800, 480); // manually computed sizes at 420p resolution
		this.update();

	}

	//updates the view based on the items stored in the model...
	/**
	 * update function updates the view
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void update()
	{
		this.filmList.setListData(this.model.getFilmsListStringArray());
		this.addButton.setEnabled(!(this.newFilmTitleField.getText().isEmpty() && this.newFilmDirectorField.getText().isEmpty()
				&& this.newFilmRatingField.getText().isEmpty() && this.newFilmReleaseYearField.getText().isEmpty()
				&& this.newFilmCastListField.getText().isEmpty()));
		this.removeButton.setEnabled(this.filmList.getSelectedIndex()!=-1);
		
		String output = "";
		output += this.model.getFilmsList().size();
		this.getNumberOfFilmsFound().setText(output + " films found...");
	}	
	
}
