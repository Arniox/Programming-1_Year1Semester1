package trainBookingApplication;

import trainBookingApplication.Seat.SeatType;

public class ChooChoo extends TrainOperator {

	public ChooChoo()
	{
		super.setTrainOperatorName("ChooChoo");
	}
	
	@Override
	protected Seat bookFirstClass(TrainJourney trainJourney, SeatType seatType) {
		Seat bookedSeat = null; //set a seat to be booked
		super.trainJourney = new TrainJourney(trainJourney.getStartCity(), //create the journey from the input journey to have a seat booked
				trainJourney.getDestinationCity(), trainJourney.getDepatureTime(), trainJourney.getJourneyNumber(), trainJourney.getChosenFloorGrid());
		
		bookedSeat = super.trainJourney.getChosenFloorGrid().queryAvailableFirstClassSeat(seatType); //set the booked seat to a first class seat with
																									//input seat type
		int firstClassSeats = 0;
		if(bookedSeat == null) //if the seat is already booked, book an entire row in economy as such of the ChooChoo policies
		{
			for(Seat[] rows : super.trainJourney.getChosenFloorGrid().seats) //for each row of the seats array
			{
				if(!(firstClassSeats < super.trainJourney.getChosenFloorGrid().getNumOfFirstClassRows())) //if the seat is economy class
				{
					for(Seat s : rows) //for each element in the seats row
					{
						s.setBooked(true); //book each seat of this row
					}
					bookedSeat = new Seat(false, SeatType.ALL, super.trainJourney.getChosenFloorGrid().getNumOfFirstClassRows(),
							super.trainJourney.getChosenFloorGrid().getMiddleVariable()-1); //once done, return the middle seat of the booked row
					bookedSeat.setBooked(true);
					System.out.println("\nWe have checked, and your requested seat was booked, we have instead booked an entire Economy Row as per our policies\n"
							+ "Please be aware, the seat shown to be booked bellow is the middle seat in the Row booked for you\n");
					return bookedSeat; //then return the booked seat above
				}
				else
				{
					firstClassSeats++; //iterate first class check
				}
			}
		}
		else
		{
			return bookedSeat; //otherwise just return the booked seat
		}
		return bookedSeat;
	}

	@Override
	protected Seat bookEconomyClass(TrainJourney trainJourney, SeatType seatType) {
		Seat bookedSeat = null; //set a seat to be booked
		super.trainJourney = new TrainJourney(trainJourney.getStartCity(), //create the journey from the input journey to have a seat booked
				trainJourney.getDestinationCity(), trainJourney.getDepatureTime(), trainJourney.getJourneyNumber(), trainJourney.getChosenFloorGrid());
		
		bookedSeat = super.trainJourney.getChosenFloorGrid().queryAvailableEconomySeat(seatType); 
																								  //set the booked seat to an economy seat
																								 //input seat type
		if(bookedSeat == null)
		{
			return null; //due to the chosen seat in economy not being open, return null as per the ChooChoo policies
		}
		else
		{
			return bookedSeat; //otherwise, return the booked seat
		}
	}

}
