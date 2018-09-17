package ticketBookingApplication;

public class Ticket {

	Customer customer = new Customer(); //create Customer object
	Film film = new Film(); //create film object
	private double ticketCost; //create -ticketCost: double
	
	//-----------------------------------------------
	/**
	 * @return the ticketCost (private)
	 */
	private double getTicketCost() 
	{
		this.setTicketCost(this.cost());
		return this.ticketCost;
	}
	/**
	 * @param ticketCost the ticketCost to set (private)
	 */
	private void setTicketCost(double ticketCost) 
	{
		if (!(ticketCost < 0)) //if the ticket cost is less than 0, then set it to default
		{
			this.ticketCost = ticketCost;
		}
		else
		{
			this.ticketCost = 10;
		}
		
	}


	//------------------------------------------------
	/**
	 * constructor
	 * @param customer
	 * @param film
	 */
	public Ticket(Customer customer, Film film)
	{
		this.customer.setAge(customer.getAge());
		this.customer.setName(customer.getName());
		this.customer.setStudent(customer.isStudent());
		
		this.film.setFilmTitle(film.getFilmTitle());
		this.film.setRating(film.getRating());
	}
	
	//--------------------------------------------------
	/**
	 * cost() method calculates the customers ticket cost based on their age and if they're a student
	 * @return
	 */
	public double cost()
	{		
		double ticketCostCalculated = 0; //create a double for ticket cost
		if(this.customer.getAge() < 18) //if customer is less than 18, price is $7
		{
			ticketCostCalculated = 7;
		}
		else if(this.customer.getAge() >= 18) //if customer is creator or equal to 18, default price is $10
		{
			if((this.customer.getAge() >= 10 && this.customer.getAge() <= 25) && this.customer.isStudent() == true)
			{
				ticketCostCalculated = 10 - (10*0.15); //if customer is a student, and between 10 and 25 years old
			}										   //price is $8.50
			else if(this.customer.getAge() > 25 && this.customer.isStudent() == true)
			{
				ticketCostCalculated = 10 - (10*0.10); //if customer is a student and over 25, price is $9
			}
			else if(this.customer.getAge() > 65 && this.customer.isStudent() == false)
			{
				ticketCostCalculated = 10 - (10*0.07); //if customer is not a student, and over 65, price is $9.50
			}
			else
			{
				ticketCostCalculated = 10; //default price
			}
		}
		
		return ticketCostCalculated;
	}
	
	//----------------------------------------------------
	@Override
	public String toString() //to string method override for the ticket details which also contain the price using the cose method
	{
		return "FILM TICKET for: " + this.film.toString() +  "\nCUSTOMER DETAILS: " + this.customer.toString() + "\nTOTAL COST: $" + this.getTicketCost() + "0";
	}
}
