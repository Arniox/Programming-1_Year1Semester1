package trainBookingApplication;

import trainBookingApplication.Seat.SeatType;

public abstract class FloorGrid {

	protected abstract void initialiseFloorGrid(); //abstract initializing method
	protected Seat[][] seats; //seats 2D array
	private Seat seat; //single seat object used in small uses
	protected int rows; //rows variable
	protected int columns; //columns variable
	protected int NumOfFirstClassRows; //number of first class rows variable
	protected char str[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
			'N', 'O', 'P', 'Q', 'R', 'S', 'Y', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	//Special use variables
	private String petiteFloorText = "    A      B      C      D      E      F      G\n";
	private String grandeFloorText = "    A      B      C      D      E      F      G      H      I\n";
	private String littleGapForTextSpacingInPrintOut = "";
	protected int middleVariable;
	
	/**
	 * @return the rows
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public int getRows() {
		return this.rows;
	}

	/**
	 * @return the columns
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public int getColumns() {
		return this.columns;
	}

	/**
	 * @return the number of first class rows
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public int getNumOfFirstClassRows() {
		return this.NumOfFirstClassRows;
	}

	/**
	 * @return the middle seat variable of a floor grid
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public int getMiddleVariable()
	{
		return this.middleVariable;
	}
	
	/**
	 * Set the rows
	 * @param rows
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setROWS(int rows) {
		this.rows = rows;
	}

	/**
	 * Set the columns
	 * @param columns
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setCOLUMNS(int columns) {
		this.columns = columns;
	}

	/**
	 * set the number of first class rows
	 * @param numOfFirstClassRows
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setNumOfFirstClassRows(int numOfFirstClassRows) {
		this.NumOfFirstClassRows = numOfFirstClassRows;
	}
	
	/**
	 * set the middle seat variable of a floor grid
	 * @param middleVariable
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setMiddleVariable(int middleVariable)
	{
		this.middleVariable = middleVariable;
	}
	
	/**
	 * @return an array of seats
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public Seat[][] getSeats() {
		return this.seats;
	}

	/**
	 * Set an array of seats
	 * @param seats
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setSeats(Seat[][] seats) {
		this.seats = seats;
	}
	
	//------------------------------------------------------------------------------
	//------------------------------------------------------------------------------

	/**
	 * @return the last seat in the object array
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public Seat returnLastSeat() //return the last seat in the array
	{
		this.seat = seats[this.getRows()][this.getColumns()];
		return this.seat;
	}
	
	/**
	 * Books the seat at this position
	 * @param row
	 * @param col
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void bookSeat(int row, int col) //book the seat
	{
		this.seats[row][col].setBooked(true);
	}
	
	/**
	 * @return the seat at a chosen point
	 * @param x
	 * @param y
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public Seat getSeat(int x, char y) //get a seat object at int, char
	{
		int Yvalue = 0; //make a yvalue integer to change the char into
        for(int i=0;i<str.length;i++) //checks through an alphabetical array to find the correct character
        {
            if(y == str[i]) //once found, break the loop and make the yvalue the correct character
            {
            	Yvalue = i;
            	break;
            }
        }
		return this.seats[x][Yvalue]; //return the seat object at this position
	}
	
	/**
	 * @return the seat to the left of the chosen seat
	 * @param x
	 * @param y
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public Seat getLEFTSeat(int x, char y) //get the seat to the left of the chosen seat
	{
		int Yvalue = 0;
        for(int i=0;i<str.length;i++)
        {
            if(y == str[i])
            {
            	Yvalue = i;
            	break;
            }
        }
        if(!(Yvalue <= 0)) //if the left seat DOES EXIST, then return it
        {
        	return this.seats[x][Yvalue-1];
        }
        else //if the left seat DOES NOT EXIST due to being over the edge, then return null
        {
        	return null;
        }
		 
	}
	
	/**
	 * @return the seat to the right of the chosen seat
	 * @param x
	 * @param y
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public Seat getRIGHTSeat(int x, char y) //get right seat of the chosen seat
	{
		int Yvalue = 0;
        for(int i=0;i<str.length;i++)
        {
            if(y == str[i])
            {
            	Yvalue = i;
            	break;
            }
        }
        if(!(Yvalue >= this.getColumns())) //if the right seat DOES EXIST, then return it
        {
        	return this.seats[x][Yvalue+1];
        }
        else //if the right seat DOES NOT EXIST due to being over the edge, then return null
        {
        	return null;
        }
	}
	
	/**
	 * @return a seat with the same seat type as input that IS NOT IN first class and not booked.
	 * if none are found, then search for a seat outside the seat type input. If still, none are found
	 * return null. Currently the second part of this seat search is commented out due to individual 
	 * specifications of the train operators
	 * @param seatType
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public Seat queryAvailableEconomySeat(SeatType seatType)
	{
		boolean returned = false; //create a variable for if anything has been returned. IMPORTANT!
		for(int i=0;i<this.getRows();i++)//for each row
		{
			for(int k=0;k<this.getColumns();k++)//for each column
			{
				if(this.getSeats()[i][k].getSeatType() == seatType)//for if a seat is equal to the input seat type
				{
					if(!(this.getSeats()[i][k].isFirstClass())) //for if a seat IS NOT first class
					{
						if(!(this.getSeats()[i][k].isBooked())) //for if a seat IS NOT booked
						{
							returned = true; //make returned true to show something has been returned
							this.getSeats()[i][k].setBooked(true);
							return this.getSeats()[i][k]; //return the seat at this position
						}
						else
						{
							returned = false; //otherwise make returned false to show nothing has been returned yet
						}
					}
					else
					{
						returned = false; //otherwise make returned false to show nothing has been returned yet
					}
				}
				else
				{
					returned = false; //otherwise make returned false to show nothing has been returned yet
				}
			}
		}
		if(returned == false) //if returned is false at this point, return null
		{
			/*for(int i=0;i<this.getROWS();i++) //for every row
			{
				for(int k=0;k<this.getCOLUMNS();k++) //for every column
				{
					if(!(this.getSeats()[i][k].isFirstClass())) //for if the seat IS NOT first class
					{
						if(!(this.getSeats()[i][k].isBooked())) //for if the seat IS NOT booked
						{
							returned = true; //returned changed to true to show something has been returned
							this.getSeats()[i][k].setBooked(true);
							return this.getSeats()[i][k]; //return the seat at this position
						}
						else
						{
							returned = false; //otherwise make returned false to show nothing has been returned yet
						}
					}
					else
					{
						returned = false; //otherwise make returned false to show nothing has been returned yet
					}
				}
			}*/
			returned = true;
			return null;
		}
		else
		{
			returned = true; //otherwise make returned false to show nothing has been returned yet
			return null; //return null object
		}
	}
	
	/**
	 * @return a seat with the same seat type as input that IS IN first class and not booked.
	 * if none are found, then search for a seat outside the seat type input. If still, none are found
	 * return null. Currently the second part of this seat search is commented out due to individual 
	 * specifications of the train operators
	 * @param seatType
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public Seat queryAvailableFirstClassSeat(SeatType seatType)
	{
		boolean returned = false; //create a variable for if anything has been returned. IMPORTANT!
		for(int i=0;i<this.getRows();i++) //for each row
		{
			for(int k=0;k<this.getColumns();k++) //for each column
			{
				if(this.getSeats()[i][k].getSeatType() == seatType) //for if the seat type matches the input seat type
				{
					if(this.getSeats()[i][k].isFirstClass()) //for if the seat IS A first class seat
					{
						if(!(this.getSeats()[i][k].isBooked())) //for if the seat IS NOT booked
						{
							returned = true; //returned changed to true to show something has been returned
							this.getSeats()[i][k].setBooked(true);
							return this.getSeats()[i][k]; //return the seat at this position
						}
						else
						{
							returned = false; //otherwise make returned false to show nothing has been returned yet
						}
					}
					else
					{
						returned = false; //otherwise make returned false to show nothing has been returned yet
					}
				}
				else
				{
					returned = false; //otherwise make returned false to show nothing has been returned yet
				}
			}
		}
		if(returned == false) //if returned is still false, then return a null
		{
			/*for(int i=0;i<this.getROWS();i++) //for each row
			{
				for(int k=0;k<this.getCOLUMNS();k++) //for each column
				{
					if(this.getSeats()[i][k].isFirstClass()) //for if the seat IS first class
					{
						if(!(this.getSeats()[i][k].isBooked())) //for if the seat IS NOT booked
						{
							returned = true; //returned changed to true to show something has been returned
							this.getSeats()[i][k].setBooked(true);
							return this.getSeats()[i][k]; //return the seat at this position
						}
						else
						{
							returned = false; //otherwise make returned false to show nothing has been returned yet
						}
					}
					else
					{
						returned = false; //otherwise make returned false to show nothing has been returned yet
					}
				}
			}*/
			returned = true;
			return null;
		}
		else
		{
			returned = true; //otherwise make returned false to show nothing has been returned yet
			return null;
		}
	}
	
	@Override
	public String toString()
	{
		String result = ""; //set a string to null
		int firstClassCheck = 0; //set a first class check to 0
		int rowCheck = 0;
		
		for(Seat[] rows : seats) //for every row element
		{
			if(firstClassCheck < this.getNumOfFirstClassRows()) //for if the row is first class 
			{
				if(rows == seats[0]) //if the row is the first row in first class, add first class to the result before anything
				{
					result += "FIRST CLASS\n";
					switch(this.getColumns()) //after First Class text has been added, check how many columns there are, and add text above the whole thing as a key
					{
					case 7:
						result += petiteFloorText;
						break;
					case 9:
						result += grandeFloorText;
						break;
					}
				}
				for(Seat s : rows) //for each column element
				{
					if(s == rows[0] && (rowCheck + 1) < 10)//if the side number is smaller than 10 and you're on the first element, add an extra space for print out line up
					{
						
						littleGapForTextSpacingInPrintOut = " "; //add gab
						result += (rowCheck + 1) + " " + littleGapForTextSpacingInPrintOut; //add it to print out
						littleGapForTextSpacingInPrintOut = ""; //remove gap
					}
					else if(s == rows[0]) //if the element is the first element, add the side number first 
					{
						result += (rowCheck + 1) + " ";
					}
					result += s+" "; //add the single seat object string to the result
				}
				result += "\n"; //make a new line for each row
				firstClassCheck++; //Iterate the first class check
			}
			else if(firstClassCheck >= this.getNumOfFirstClassRows()) //once the first class check goes over the set first class num
			{
				if(rows == seats[this.getNumOfFirstClassRows()]) //if the row is the first of economy class, add economy class
				{												//to result before anything
					result += "ECONOMY CLASS\n";
					switch(this.getColumns()) //after Economy Class text has been added, check how many columns there are, and add text above the whole thing as a key
					{
					case 7:
						result += petiteFloorText;
						break;
					case 9:
						result += grandeFloorText;
						break;
					}
				}
				for(Seat s : rows) //for each column element
				{
					if(s == rows[0] && (rowCheck + 1) < 10)//if the side number is smaller than 10 and you're on the first element, add an extra space for print out line up
					{
						
						littleGapForTextSpacingInPrintOut = " "; //add gab
						result += (rowCheck + 1) + " " + littleGapForTextSpacingInPrintOut; //add it to print out
						littleGapForTextSpacingInPrintOut = ""; //remove gap
					}
					else if(s == rows[0]) //if the element is the first element, add the side number first 
					{
						result += (rowCheck + 1) + " ";
					}
					result += s+" "; //add the single seat object string to the result
				}
				result += "\n"; //make a new line for each row
			}
			rowCheck++; //iterate the row check mechanic
		}
		
		return result; //return the string representation of the entire array of seats
	}
}
