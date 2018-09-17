package trainBookingApplication;

import trainBookingApplication.Seat.SeatType;

public class GrandeFloorGrid extends FloorGrid {

	/**
	 * Set up the grande floor grid statistics
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public GrandeFloorGrid()
	{
		super.setROWS(12); //set rows and columns to (12, 9)
		super.setCOLUMNS(9);
		super.setNumOfFirstClassRows(6); //sets the number of first class rows
		super.setMiddleVariable(5); //create a middle constant for grande floor grid that's always the same
	}
	
	@Override
	public void initialiseFloorGrid() //super method
	{
		int firstclasstest = 0;
		
		super.seats = new Seat[super.getRows()][super.getColumns()]; //sets the super seats array with variables above
		
		for(int x = 0; x < super.getRows(); x++) //for each row
		{
			if(firstclasstest < super.getNumOfFirstClassRows()) //for if a row IS A first class row
			{
				for(int y = 0; y < super.getColumns(); y++) //for each column
				{
					if(y == 0 || y == super.getColumns() - 1) //if a seat is at the start or the end, it's a window seat
					{
						super.seats[x][y] = new Seat(true, SeatType.WINDOW, x, y);
					}
					else if(y == super.getMiddleVariable() - 1) //if a seat is equal to the middle constant variable, it's a middle seat
					{
						super.seats[x][y] = new Seat(true, SeatType.MIDDLE, x, y);
					}
					else //if a seat is anything else, it's an aisle seat
					{
						super.seats[x][y] = new Seat(true, SeatType.AISLE, x, y);
					}
				}
				firstclasstest++;
			}												//for economy class	
			else if(firstclasstest >= super.getNumOfFirstClassRows()) //for if a row is NOT A first class row
			{
				for(int y = 0; y < super.getColumns(); y++) //for each column
				{
					if(y == 0 || y == super.getColumns() - 1) //if a seat is at the start or the end, it's a window seat
					{
						super.seats[x][y] = new Seat(false, SeatType.WINDOW, x, y);
					}
					else if(y == super.getMiddleVariable() - 1) //if a seat is equal to the middle constant variable, it's a middle seat
					{
						super.seats[x][y] = new Seat(false, SeatType.MIDDLE, x, y);
					}
					else //if a seat is anything else, it's an aisle seat
					{
						super.seats[x][y] = new Seat(false, SeatType.AISLE, x, y);
					}
				}
			}
		}
	}
}
