package trainBookingApplication;

public class TrainJourney {

	private String startCity;
	private String destinationCity;
	private String depatureTime;
	private String journeyNumber;	
	private FloorGrid chosenFloorGrid;
	
	//getters and setters
	/**
	 * @return the startCity as a String
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public String getStartCity() {
		return this.startCity;
	}

	/**
	 * @return the destinationCity as a String
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public String getDestinationCity() {
		return this.destinationCity;
	}

	/**
	 * @return the departureYime as a String
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public String getDepatureTime() {
		return this.depatureTime;
	}

	/**
	 * @return the journeyNumber as a String
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public String getJourneyNumber() {
		return this.journeyNumber;
	}

	/**
	 * Set the startCity
	 * @param startCity
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}

	/**
	 * Set the destinationCity
	 * @param destinationCity
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	/**
	 * Set the depatureTime
	 * @param depatureTime
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setDepatureTime(String depatureTime) {
		this.depatureTime = depatureTime;
	}

	/**
	 * Set the journeyNumber
	 * @param journeyNumber
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setJourneyNumber(String journeyNumber) {
		this.journeyNumber = journeyNumber;
	}
	
	//-------------------------------------------
	/**
	 * @return the chosenFloorGrid as a FloorGrid
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public FloorGrid getChosenFloorGrid() {
		return this.chosenFloorGrid;
	}

	/**
	 * Set the chosenFloorGrid
	 * @param chosenFloorGrid
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setChosenFloorGrid(FloorGrid chosenFloorGrid) {
		this.chosenFloorGrid = chosenFloorGrid;
	}
	//---------------------------------------------------------

	/**
	 * Constructor used when demanded of code. The code always inputs the needed parameters
	 * @param startCity
	 * @param destinationCity
	 * @param depatureTime
	 * @param journeyNumber
	 * @param floorGrid
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public TrainJourney(String startCity, String destinationCity, String depatureTime, String journeyNumber, FloorGrid floorGrid)
	{
		this.setStartCity(startCity);
		this.setDestinationCity(destinationCity);
		this.setDepatureTime(depatureTime);
		this.setJourneyNumber(journeyNumber);
		
		this.setChosenFloorGrid(floorGrid);
	}
	//---------------------------------------------------------
	
	@Override
	public String toString()
	{
		return "Journey: " + this.getJourneyNumber() + 
				" from: " + this.getStartCity() + 
				" to: " + this.getDestinationCity() +
				" departing at: " + this.getDepatureTime();
	}
	
}
