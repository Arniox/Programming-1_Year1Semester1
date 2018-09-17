package filmDataBaseApp;

import java.util.ArrayList;

public class CastList {

	private ArrayList<String> peopleList;
	
	/**
	 * get the peopleList ArrayList
	 * @return
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public ArrayList<String> getPeopleList() {
		return this.peopleList;
	}

	/**
	 * set the peopleList ArrayList
	 * @param peopleList
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void setPeopleList(ArrayList<String> peopleList) {
		this.peopleList = peopleList;
	}

	/**
	 * getIndexedPerson takes in an int index and returns a single person string object
	 * @param index
	 * @return
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public String getIndexedPerson(int index)
	{
		return this.getPeopleList().get(index);
	}
	
	/**
	 * addPerson takes in a person string object and adds them to the ArrayList
	 * @param person
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public void addPerson(String person)
	{
		this.peopleList.add(person);
	}
	
	//------------------------------------------------
	/**
	 * CastList constructor takes in any amount of people string objects and adds them to the ArrayList
	 * @param person
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public CastList(ArrayList<String> peopleInputList)
	{
		this.setPeopleList(peopleInputList);
	}
	
	//------------------------------------------------
	/**
	 * takes in a term and searches for any matching people in peopleList
	 * @param term
	 * @return
	 * @author 16945724 - Nikkolas Diehl - bjy5305
	 */
	public boolean hasPerson(String term)
	{
		for(String aPerson : peopleList)
		{
			if(aPerson.toLowerCase().contains(term.toLowerCase()))
			{
				return true;
			}
		}
		
		return false;
	}
	
	
	@Override
	public String toString()
	{
		String output = "\n  -";
		
		for(int i = 0; i < this.getPeopleList().size(); ++i)
		{
			if(i == this.getPeopleList().size()-1) {
				output += this.getPeopleList().get(i);
			}
			else {
				output += this.getPeopleList().get(i) + "\n  -";
			}
		}
		
		return output;
	}
	
}
