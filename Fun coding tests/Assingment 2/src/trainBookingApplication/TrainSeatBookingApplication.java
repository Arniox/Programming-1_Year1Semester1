package trainBookingApplication;

import java.util.Random;
import java.util.Scanner;

import trainBookingApplication.Seat.SeatType;

public class TrainSeatBookingApplication {

	/**
	 * @return the int representation of what trainOperator the user will be using
	 * @param scanner
	 * @param trainOps
	 * @param floorGrid
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public static int chooseOperator(Scanner scanner, TrainOperator trainOps[], FloorGrid floorGrid[])
	{
		int chosenOperator = 0;
		System.out.println("WELCOME TO TRAINBOOKING.CO...\n\n"
				+ "Which Train operator would you like to travel with today?"); //prints out welcome message
		
		System.out.println("1: " + trainOps[0].getTrainOperatorName() //prints out two different train operators
				+ "\n2: " + trainOps[1].getTrainOperatorName());
		
		//-------------------------------------
		do //makes sure the chosen menu item is not possible
		{
			System.out.printf("Menu Item: "); //scans in answer
			chosenOperator = scanner.nextInt() - 1;
			
			if(chosenOperator < 0 || chosenOperator >= floorGrid.length)
			{
				System.out.println("Sorry, this is not an option\n");
			}
			else
			{
				break;
			}
		}while(chosenOperator < 0 || chosenOperator >= floorGrid.length);
		
		return chosenOperator;
	}
	/**
	 * @return the int representation of what trainJourney the user will be taking
	 * @param scanner
	 * @param trainOps
	 * @param trainJourney
	 * @param chosenOperator
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public static int chooseTrainJourney(Scanner scanner, TrainOperator trainOps[], TrainJourney trainJourney[], int chosenOperator)
	{
		int chosenTrainJourney = 0;
		System.out.println("\nWelcome to the " + trainOps[chosenOperator].getTrainOperatorName() //prints custom welcome message to train operator
				+ " booking system...");
		System.out.println("Which train journey would you like to book a seat on?"); //asks which journey the user wants to book a seat in
		for(int i=0; i<trainJourney.length; i++)
		{
			System.out.println(i+1 + ": " + trainJourney[i].toString());//prints out list of journeys
		}
		
		//---------------------------------------------------
		do //makes sure journey option is not impossible
		{
			System.out.printf("Menu Item: "); //scans in answer and initializes the answer grid
			chosenTrainJourney = scanner.nextInt() - 1;
			
			if(chosenTrainJourney < 0 || chosenTrainJourney >= trainJourney.length)
			{
				System.out.println("Sorry, this is not an option\n");
			}
			else
			{
				break;
			}
		}while(chosenTrainJourney < 0 || chosenTrainJourney >= trainJourney.length);
				
		return chosenTrainJourney;
	}
	/**
	 * Print out the floor grid based on what form of printing the code is demanding
	 * @param scanner
	 * @param trainJourney
	 * @param chosenTrainJourney
	 * @param typeOfPrint
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public static void printSeating(Scanner scanner, TrainJourney trainJourney[], int chosenTrainJourney, int typeOfPrint)
	{
		if(typeOfPrint == 1)
		{
			System.out.println("\nBooking seats for: " + trainJourney[chosenTrainJourney].toString() + ""); //prints out the journey you'll be booking for
			System.out.println("ENTER TO CONTINUE....\n");
			scanner.nextLine();
			scanner.nextLine();
			System.out.println("----------------------------\n"
					+ "|        FLOOR GRID        |\n"
					+ "----------------------------\n\n" + trainJourney[chosenTrainJourney].getChosenFloorGrid().toString()); //prints out the train seating pattern
		}
		else if(typeOfPrint == 2)
		{
			System.out.println("\nENTER TO SHOW SEATS AND CONTINUE....");
			scanner.nextLine();
			scanner.nextLine();
			System.out.println(trainJourney[chosenTrainJourney].getChosenFloorGrid().toString());
		}
	}
	/**
	 * @return the int representation of what menu item the user chooses
	 * @param scanner
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public static int chooseMenuItem(Scanner scanner)
	{
		int chosenMenuItem = 0;
		System.out.println("1: Book in First Class\n" //prints out a list of user options
				+ "2: Book in Economy Class\n"
				+ "3: Show Floor Grid\n"
				+ "4: Quit");
		//---------------------------------
		do //makes sure menu item choice is not impossible
		{
			System.out.printf("Menu Item: "); //scans in the answer for the user option
			chosenMenuItem = scanner.nextInt();
			
			if(chosenMenuItem < 1 || chosenMenuItem > 4)
			{
				System.out.println("Sorry, this is not an option\n");
			}
			else
			{
				break;
			}
		}while(chosenMenuItem < 1 || chosenMenuItem > 4);

		return chosenMenuItem;
	}
	/**
	 * @return the int representation of what seat type the user will choose
	 * @param scanner
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public static int chooseSeatType(Scanner scanner)
	{
		int chosenSeatType = 0;
		
		System.out.println("\nWhich seat type?");
		System.out.println("1: WINDOW\n"
				+ "2: AISLE\n"
				+ "3: MIDDLE");
		do //makes sure the seat type chosen is not impossible
		{
			System.out.printf("Menu Item: ");
			chosenSeatType = scanner.nextInt();
			
			if(chosenSeatType < 1 || chosenSeatType > 3)
			{
				System.out.println("Sorry, this is not an option\n");
			}
			else
			{
				break;
			}
		}while(chosenSeatType < 1 || chosenSeatType > 3);
		
		return chosenSeatType;
	}
	/**
	 * @return the Seat that is booked using the book[Class]Class command from the trainOps array with the chosenOperator variable
	 * @param trainOps
	 * @param trainJourney
	 * @param chosenSeatType
	 * @param chosenOperator
	 * @param chosenTrainJourney
	 * @param classChosen
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public static Seat bookASeat(TrainOperator trainOps[], TrainJourney trainJourney[],int chosenSeatType, int chosenOperator, int chosenTrainJourney, int classChosen)
	{
		Seat bookedSeat = null;
		
		if(classChosen == 1)
		{
			switch(chosenSeatType) //switch case for seat type
			{
			case 1: //books a first class window seat
				bookedSeat = trainOps[chosenOperator].bookFirstClass(trainJourney[chosenTrainJourney], SeatType.WINDOW);
				break;
			case 2: //books a first class aisle seat
				bookedSeat = trainOps[chosenOperator].bookFirstClass(trainJourney[chosenTrainJourney], SeatType.AISLE);
				break;
			case 3: //books a first class middle seat
				bookedSeat = trainOps[chosenOperator].bookFirstClass(trainJourney[chosenTrainJourney], SeatType.MIDDLE);
				break;
			}
		}
		else if(classChosen == 2)
		{
			switch(chosenSeatType) //switch case for seat type
			{
			case 1: //books a first class window seat
				bookedSeat = trainOps[chosenOperator].bookEconomyClass(trainJourney[chosenTrainJourney], SeatType.WINDOW);
				break;
			case 2: //books a first class aisle seat
				bookedSeat = trainOps[chosenOperator].bookEconomyClass(trainJourney[chosenTrainJourney], SeatType.AISLE);
				break;
			case 3: //books a first class middle seat
				bookedSeat = trainOps[chosenOperator].bookEconomyClass(trainJourney[chosenTrainJourney], SeatType.MIDDLE);
				break;
			}
		}
		
		return bookedSeat;		
	}
	
	/**
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 * @param String[]
	 * @param args
	 */
	public static void main(String[] args)
	{
		Random random = new Random(); //sets up a new random object
		Scanner scanner = new Scanner(System.in); //sets up a new scanner object
		TrainOperator trainOps[] = new TrainOperator[] //sets up a new train operator object array with both operators inside
		{
				new TrainWay(),
				new ChooChoo()
		};
		FloorGrid floorGrid[] = new FloorGrid[] //sets up a new floor grid object array with both floor grids inside
		{
				new PetiteFloorGrid(),
				new GrandeFloorGrid()
		};
		TrainJourney trainJourney[] = new TrainJourney[] //sets up a new train journey array with a bunch of journeys, each one has a random floor grid pattern
		{
				new TrainJourney("Auckland", "Howick", "10:00h", "TJ1000", floorGrid[random.nextInt(2)]),
				new TrainJourney("Britomart", "Henderson", "18:00h", "TS3000", floorGrid[random.nextInt(2)]),
				new TrainJourney("Kings Landing", "East Watch", "15:00h", "GOT100", floorGrid[random.nextInt(2)]),
				new TrainJourney("Winterfell", "Dragonstone", "03:00h", "GOT200", floorGrid[random.nextInt(2)]),
				new TrainJourney("Los Angelous", "Manhatten", "04:05h", "NY3000", floorGrid[random.nextInt(2)]),
				new TrainJourney("Andromena", "Milky Way", "07:06h", "GALACTIC101", floorGrid[random.nextInt(2)])
		};
		
		//---------------------------------------------------	
		int chosenOperator = chooseOperator(scanner, trainOps, floorGrid);
		int chosenTrainJourney= chooseTrainJourney(scanner, trainOps, trainJourney, chosenOperator);
		
		//Initializes the chosen array object inside trainJourney array with the chosen floor grid
		trainJourney[chosenTrainJourney].getChosenFloorGrid().initialiseFloorGrid();
		printSeating(scanner, trainJourney, chosenTrainJourney, 1);
		//---------------------------------------------------
		
		boolean keepGoing = true; //sets a boolean value for if you want to keep booking
		do
		{
			Seat bookedSeat = null; //sets up a booked Seat type
			int chosenSeatType;
			//choose menu item using function
			int chosenMenuItem = chooseMenuItem(scanner);
			
			
			switch(chosenMenuItem) //switch case for menu selection
			{
			case 1: //if you choose to book a first class seat, it asks you what seat type and scans in an answer
				chosenSeatType = chooseSeatType(scanner); //choose a seat type using a function
				bookedSeat = bookASeat(trainOps, trainJourney, chosenSeatType, chosenOperator, chosenTrainJourney, 1); //book a seat using a function
				
				if(!(bookedSeat == null)) //if the booked seat is not a null Seat, it then prints out the string representation of it's position to the user
				{
					System.out.println(bookedSeat.toStringSeatPositionRepresentation());
				}
				else //if the booking failed, then the system prints to the user that it failed
				{
					System.out.println("\nSorry, we could not book the requested seat...");
				}
				
				printSeating(scanner, trainJourney, chosenTrainJourney, 2); //print out the new seating now
				break;
				
			case 2: //if you choose to book an economy class seat, it asks you which seat type and scans in the answer
				chosenSeatType = chooseSeatType(scanner); //choose a seat type using a function
				bookedSeat = bookASeat(trainOps, trainJourney, chosenSeatType, chosenOperator, chosenTrainJourney, 2); //book a seat using a function
				
				if(!(bookedSeat == null)) //if the seat is not a null Seat, it prints a string representation of the seat position
				{
					System.out.println(bookedSeat.toStringSeatPositionRepresentation());
				}
				else //if it fails when booking, tell the user
				{
					System.out.println("\nSorry, we could not book the requested seat...");
				}
				
				printSeating(scanner, trainJourney, chosenTrainJourney, 2); //print out the new seating now
				break;
				
			case 3: //if the user wants to view the grid again, it shows them again
				System.out.println("\nFloor Grid:\n" + trainJourney[chosenTrainJourney].getChosenFloorGrid().toString());
				break;
				
			case 4: //if the user wants to quit, it quits the program
				keepGoing = false;
				System.out.println("Good Bye.\n\n");
				break;
			}
		}while(keepGoing == true);
		
		
		scanner.close();
	}
}
