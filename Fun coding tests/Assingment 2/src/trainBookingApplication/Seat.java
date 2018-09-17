package trainBookingApplication;

public class Seat {

	private boolean booked; //bool value for if a seat is booked
	private boolean FirstClass; //bool value for if a seat is first class
	private SeatType seatType; //enum type for the seat type
	private SeatPosition seatPos; //seat position object
	
	/**
	 * set FirstClass status
	 * @param firstC
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setFirstClass(boolean firstC)
	{
		this.FirstClass = firstC;
	}
	
	/**
	 * @return the FirstClass status
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public boolean isFirstClass()
	{
		return this.FirstClass;
	}
	
	/**
	 * @return the seat type of a seat
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public SeatType getSeatType() {
		return this.seatType;
	}

	/**
	 * Set the seat type for a seat
	 * @param seatType
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

	/**
	 * @return the booked status
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public boolean isBooked() {
		return this.booked;
	}

	/**
	 * Set Booked status
	 * @param booked
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	

	/**
	 * Constructor set up for default Seat creation
	 * @param firstC: boolean
	 * @param seatType: SeatType
	 * @param x: int
	 * @param y: char
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public Seat(boolean firstC, SeatType seatType, int x, int y) //seat constructor
	{
		this.setFirstClass(firstC); //set if the seat is first class or not
		this.setBooked(false); //set the seat to not booked
		this.seatType = seatType; //set the seat type to the input
		char ALPHABET[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
				'N', 'O', 'P', 'Q', 'R', 'S', 'Y', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		char upperLetter = ALPHABET[y]; //change the input value to a character for the seat position
		seatPos = new SeatPosition(x+1, upperLetter); //make it one forward to seat position is better human readable. IE: position (0, 0) is displayed as (1, A)
	}
	
	/**
	 * enum type for middle, aisle and wall
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	enum SeatType //seat type enum
	{
		MIDDLE("M"), AISLE("A"), WINDOW("W"), ALL("");
		
		private String symbol;
		SeatType(String symbol)
		{
			this.symbol = symbol;
		}
		
		private String symbol()
		{
			return symbol;
		}
	}
	
	@Override
	public String toString()
	{
		if(this.isFirstClass() == true) //if the seat is first class, then the seat type symbol is upper case
		{
			if(this.isBooked() == true) //if the seat is booked, then return a full seat symbol representation
			{
				return "[" + this.seatType.symbol().toUpperCase() + " X ]";
			}
			else //if the seat is not booked, then return an empty seat symbol representation
			{
				return "[" + this.seatType.symbol().toUpperCase() + " _ ]";
			}
		}
		else //if the seat is economy class, then the seat type symbol is lower case
		{
			if(this.isBooked() == true)
			{
				return "[" + this.seatType.symbol().toLowerCase() + " X ]";
			}
			else
			{
				return "[" + this.seatType.symbol().toLowerCase() + " _ ]";
			}
		}
		
	}
	
	/**
	 * @return String representation sentence of the seat you're booking or looking at
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public String toStringSeatPositionRepresentation()
	{
		if(this.isFirstClass() == true) //if the seat is first class
		{
			if(this.isBooked() == true) //if the seat is booked and in first class
			{
				return "\nFirst class " + 
						this.seatType.toString() + 
						" seat at: " + this.seatPos.toString() +
						" has been reserved for you";
			}
			else  						//if the seat is not booked and in first class (for checking purposes, no other use)
			{
				return "\nFirst class " +
						this.seatType.toString() +
						" seat at: " + this.seatPos.toString() +
						" is not reserved";
			}
		}
		else 							//if the seat is in economy class
		{
			if(this.isBooked() == true) //if the seat is booked and in economy class
			{
				return "\nEconomy class " + 
						this.seatType.toString() + 
						" seat at: " + this.seatPos.toString() +
						" has been reserved for you";
			}
			else						//if the seat is not booked and in economy class (for checking purposes, no other use)
			{
				return "\nEconomy class " +
						this.seatType.toString() +
						" seat at: " + this.seatPos.toString() +
						" is not reserved";
			}
		}
	}
}
