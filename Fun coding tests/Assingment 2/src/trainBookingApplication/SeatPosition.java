package trainBookingApplication;

public class SeatPosition {

	private int row;
	private char column;
	
	/**
	 * @return the row
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public int getRow() {
		return this.row;
	}
	/**
	 * @param set the row
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setRow(int row) {
		this.row = row;
	}
	/**
	 * @return the column
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public char getColumn() {
		return this.column;
	}
	/**
	 * @param set the column
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setColumn(char column) {
		this.column = column;
	}
	
	@Override
	public String toString()
	{
		return "" + this.getRow() + this.getColumn();
	}
	
	/**
	 * Sets the seat position
	 * @param x
	 * @param upperLetter
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */	
	public SeatPosition(int x, char upperLetter)
	{
		this.setRow(x); //set the seatpos row number
		this.setColumn(upperLetter); //set the seatpos column character
	}
}
