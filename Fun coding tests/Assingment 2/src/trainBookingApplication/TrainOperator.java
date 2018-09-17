package trainBookingApplication;

import trainBookingApplication.Seat.SeatType;

public abstract class TrainOperator {

	protected String TrainOperatorName;
	protected TrainJourney trainJourney;

	/**
	 * @return the TrainOperatorName as a string
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public String getTrainOperatorName() {
		return this.TrainOperatorName;
	}

	/**
	 * Set the TrainOperatorName
	 * @param trainOperatorName
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setTrainOperatorName(String trainOperatorName) {
		this.TrainOperatorName = trainOperatorName;
	}
	//-----------------------------------------------------------
	
	/**
	 * @return a Seat object that has been booked in first class based on the parameters
	 * @param trainJourney
	 * @param seatType
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	protected abstract Seat bookFirstClass(TrainJourney trainJourney, SeatType seatType);
	
	/**
	 * @return a Seat object that has been booked in Economy class based on the parameters
	 * @param trainJourney
	 * @param seatType
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	protected abstract Seat bookEconomyClass(TrainJourney trainJourney, SeatType seatType);
	
	
}
