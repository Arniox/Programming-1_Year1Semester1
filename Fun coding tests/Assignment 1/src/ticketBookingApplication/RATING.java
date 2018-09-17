package ticketBookingApplication;

public enum RATING {

	GENERAL(0), PARENTALGUIDANCE(12), MATURE(16); //set three enum states
	
	private int viewingAge; //set a viewing age variable
	
	/**
	 * 
	 * @param age
	 */
	RATING(int age) //age construction
	{
		this.viewingAge = age;
	}

	/**
	 * @return the age
	 */
	public int getviewingAge() 
	{
		return this.viewingAge;
	}

	/**
	 * @param age the age to set
	 */
	@SuppressWarnings("unused")
	private void setAge(int age)  //unused method for setting new ages and new ratings
	{
		this.viewingAge = age;
	}
	
	//-------------------------------
	public String toString1() //to string method for general
	{
		return GENERAL.toString();
	}
	public String toString2() //parental guidance
	{
		return PARENTALGUIDANCE.toString();
	}
	public String toString3() //mature
	{
		return MATURE.toString();
	}
}
