package ticketBookingApplication;

import java.util.Scanner;

public class CinemaTicketBookingApplication {

	static int NUMBER_OF_FILMS = 4;
	
	/**
	 * customerDetailsInput prompts the user for info about themselves
	 * @return customer
	 */
	private static Customer customerDetailsInput(Scanner scanner)
	{
		Scanner scanner1 = scanner; //take in the scanner object from main
		
		System.out.println("Please enter your name: "); //get the name and age of the customer
		String name = scanner1.nextLine();
		System.out.println("Please enter your age: ");
		int age = scanner1.nextInt();
		scanner1.nextLine(); //remove the spare \n that is created from entering the age
		
		System.out.println("Are you a student? (Y/N)"); //ask if student, and get a boolean value answer
		boolean student = false;
		
		char studentNoYes = scanner1.nextLine().charAt(0);
		if(studentNoYes == 'Y' || studentNoYes == 'y') //if the customer is a student, set boolean to yes, ect...
		{
			student = true;
		}
		else if (studentNoYes == 'N' || studentNoYes == 'n')
		{
			student = false;
		}
		else
		{
			student = false;
		}
	
		Customer customer = new Customer(name, age, student); //create the customer object with constructor
		
		return customer; //return customer object
		
	}
	
	/**
	 * filmSelection method takes in an array of films and prompts the customer to pick one
	 * @param films
	 * @return filmChoice
	 */
	private static Film filmSelection(Film[] films, Scanner scanner)
	{
		Scanner scanner2 = scanner; //take in the scanner object from main
		Film filmChoice = new Film(); //create a new Film Object for the chosen film
		
		System.out.println("Which film would you like to watch: "); //prints out the list of available films
		System.out.println("1 " + films[0].toString());
		System.out.println("2 " + films[1].toString());
		System.out.println("3 " + films[2].toString());
		System.out.println("4 " + films[3].toString());
		
		int movieToWatch = 0;
		movieToWatch = scanner2.nextInt(); //create an int value for the input chosen film
		
		switch(movieToWatch) //do a switch case on the film chosen to watch
		{
		case 1:
			filmChoice = films[0];
			break;
		case 2:
			filmChoice = films[1];
			break;
		case 3:
			filmChoice = films[2];
			break;
		case 4:
			filmChoice = films[3];
			break;
		default:
			filmChoice = null;
		}
		
		return filmChoice; //return the chosen film object
	}
	
	public static Ticket issueTicket(Customer aCustomer, Film aFilm)
	{
		if(aCustomer.getAge() >= aFilm.getRating().getviewingAge()) //if the customer age is appropriate for the film
		{															//return a ticket object, otherwise, return null
			Ticket ticket = new Ticket(aCustomer, aFilm);
			return ticket;
		}
		else if (aCustomer.getAge() < aFilm.getRating().getviewingAge())
		{
			return null;
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in); //create scanner object to be fed into all methods
		Film[] films = new Film[NUMBER_OF_FILMS]; //create Film array object referencer
		
		Film film1 = new Film("Ant-Man", RATING.PARENTALGUIDANCE); //create 4 Film objects for all the movies needed
		Film film2 = new Film("Minions", RATING.PARENTALGUIDANCE);
		Film film3 = new Film("Jarassic World", RATING.MATURE);
		Film film4 = new Film("Inside Out", RATING.GENERAL);
		
		films[0] = film1; //put all Film objects into the Film array
		films[1] = film2;
		films[2] = film3;
		films[3] = film4;
		
		System.out.println("Welcome to the Cinema Ticket Purchasing System");
		char goAgain = 'N'; //create a char variable for redoing the ticket application
		do
		{
			Customer customer = customerDetailsInput(scanner); //create a customer object from a method
			Film chosenFilm = filmSelection(films, scanner); //create a Film Object from a method
			
			Ticket ticket = issueTicket(customer, chosenFilm); //create a ticket object from a method
			if (ticket == null) //if the customer is not of age, return this error
			{
				System.out.println("Sorry, there was an error in purchasing this ticket...");
				goAgain = 'N';
			}
			else //if the customer is of age, return the ticket to be collected
			{
				System.out.println("Your ticket is ready to be collected!");
				System.out.println("------------------------------------------------------------\n" + ticket.toString()
								+ "\n------------------------------------------------------------\n");
				
				System.out.println("Issue another ticket? (Y/N)"); //rerun the ticket application if
				scanner.nextLine();								   //customer chooses to
				goAgain = scanner.nextLine().charAt(0);
			}
		}while(goAgain == 'Y' || goAgain == 'y');
		
		scanner.close();
	}
}
