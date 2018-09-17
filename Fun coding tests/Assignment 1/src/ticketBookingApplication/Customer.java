package ticketBookingApplication;

public class Customer {
	
	private String name; //set -name: String, -age: int, -student: boolean
	private int age;
	private boolean student;
	
	//----------------------------------------------
	//get and set methods
	/**
	 * @return the name
	 */
	public String getName()
	{
		return this.name;
	}
	/**
	 * @return the age
	 */
	public int getAge() 
	{
		return this.age;
	}
	/**
	 * @return the student
	 */
	public boolean isStudent() 
	{
		return this.student;
	}
	//for any and all set methods, check relatively correct values
	/**
	 * @param name the name to set
	 */
	public void setName(String name) 
	{
		if(!(name.isEmpty())) //name must not be empty
		{
			this.name = name;
		}
		else
		{
			this.name = "Unkown";
		}
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age)
	{
		if(!(age < 0 || age > 150)) // age must not be bellow 0, or impossible higher than 150
		{
			this.age = age;
		}
		else
		{
			this.age = 0;
		}
		
	}
	/**
	 * @param student the student to set
	 */
	public void setStudent(boolean student) //student value can only be yes or no
	{
		this.student = student;
	}
	
	//------------------------------------------------
	/**
	 * Constructor when all data is known
	 * @param name
	 * @param age
	 * @param student
	 */
	public Customer(String name, int age, boolean student)
	{
		this.setName(name);
		this.setAge(age);
		this.setStudent(student);
	}
	/**
	 * Default constructor
	 */
	public Customer()
	{
		this("Unkown", 0, false);
	}
	
	//--------------------------------------------------
	@Override
	public String toString() //to string method, this returns the student state as a yes or no
	{						 //instead of true or false using a small if statement
		String studentYesNo = "Unknown";
		if(this.isStudent() == true)
		{
			studentYesNo = "yes";
		}
		else if (this.isStudent() == false)
		{
			studentYesNo = "no";
		}
		return this.getName() + ", age: " + this.getAge() + ", student? " + studentYesNo;
	}
	
	
}
