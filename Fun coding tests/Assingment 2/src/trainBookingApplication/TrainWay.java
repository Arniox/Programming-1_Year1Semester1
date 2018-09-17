package trainBookingApplication;

import trainBookingApplication.Seat.SeatType;

public class TrainWay extends TrainOperator {

	public TrainWay()
	{
		super.setTrainOperatorName("TrainWay");
	}
	
	@Override
	protected Seat bookFirstClass(TrainJourney trainJourney, SeatType seatType) {
		Seat bookedSeat = null; //set a seat to be booked
		super.trainJourney = new TrainJourney(trainJourney.getStartCity(), //create the journey from the input journey to have a seat booked
				trainJourney.getDestinationCity(), trainJourney.getDepatureTime(), trainJourney.getJourneyNumber(), trainJourney.getChosenFloorGrid());
		
		bookedSeat = super.trainJourney.getChosenFloorGrid().queryAvailableFirstClassSeat(seatType); 
																									 //set the booked seat to a first class seat with
																									//input seat type
		if(bookedSeat == null) //if no seat is found with that seat type, then find a different SeatType in firstClass
		{
			bookedSeat = super.trainJourney.getChosenFloorGrid().queryAvailableFirstClassSeat(SeatType.WINDOW); 
			if(bookedSeat == null)//if no window are found, check next
			{
				bookedSeat = super.trainJourney.getChosenFloorGrid().queryAvailableFirstClassSeat(SeatType.AISLE);
				if(bookedSeat == null) //if no window or aisle are found, check next
				{
					bookedSeat = super.trainJourney.getChosenFloorGrid().queryAvailableFirstClassSeat(SeatType.MIDDLE);
					if(bookedSeat == null) //if no seat type is found in first class, go down
					{
						bookedSeat = super.trainJourney.getChosenFloorGrid().queryAvailableEconomySeat(SeatType.WINDOW); 
						if(bookedSeat == null) //If all first class seats are booked, then check economy window seats, if none are found, return null as is TrainWay policies
						{
							return null;
						}
						else
						{
							System.out.println("\nWe have checked, all First Class seats where booked, we have instead booked you an Economy Window Seat\n");
							return bookedSeat; //otherwise return the booked seat
						}
					}
					else
					{
						System.out.println("\nWe have checked, all First Class " + seatType.toString().toLowerCase() + " seats and Asile seats where taken, we have instead booked you a First Class Middle Seat\n");
						return bookedSeat;//otherwise return the booked seat
					}
				}
				else
				{
					System.out.println("\nWe have checked, all First Class " + seatType.toString().toLowerCase() + " seats and Window seats and they where booked out, we have instead booked you a First Class Aisle Seat\n");
					return bookedSeat;//otherwise return the booked seat
				}
			}
			else
			{
				System.out.println("\nWe have checked, all " + seatType.toString().toLowerCase() + " seats are booked out, we have instead booked you a First Class Window Seat\n");
				return bookedSeat;//otherwise returned the booked seat
			}
		}
		else
		{
			return bookedSeat;//otherwise returned the booked seat
		}
	}

	@Override
	protected Seat bookEconomyClass(TrainJourney trainJourney, SeatType seatType) {
		Seat bookedSeat = null; //set a seat to be booked
		super.trainJourney = new TrainJourney(trainJourney.getStartCity(), //create the journey from the input journey to have a seat booked
				trainJourney.getDestinationCity(), trainJourney.getDepatureTime(), trainJourney.getJourneyNumber(), trainJourney.getChosenFloorGrid());
		
		bookedSeat = super.trainJourney.getChosenFloorGrid().queryAvailableEconomySeat(seatType); //set the booked seat to an economy class with
																								 //input seat type
		if(bookedSeat == null) //if not seats are found with input seat type, then book a first class seat with a window spot
		{
			bookedSeat = super.trainJourney.getChosenFloorGrid().queryAvailableFirstClassSeat(SeatType.WINDOW);
			if(bookedSeat == null) //if none are found, return null as is the policies of TrainWay
			{
				return null;
			}
			else //otherwise return the booked seat
			{
				System.out.println("\nWe have checked, all our Economy " + seatType.toString().toLowerCase() + " seats where booked so we instead booked you a First Class Window Seat");
				return bookedSeat;
			}
		}
		else //otherwise return the booked seat
		{
			return bookedSeat;
		}
	}

}
