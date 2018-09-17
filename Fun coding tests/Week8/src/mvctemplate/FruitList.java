package mvctemplate;

import java.util.ArrayList;

import javax.swing.ListModel;

public class FruitList {
	//
	private ArrayList<String> fruitItems;

	public FruitList()
	{
		this.fruitItems = new ArrayList<String>();
	}
	
	public void addFruitItem(String aFruit)
	{
		this.fruitItems.add(aFruit);
	}

	public void removeFruitItem(int index)
	{
		this.fruitItems.remove(index);
	}

	public String[] getFruitList() {
		String[] array = new String[this.fruitItems.size()];

		for(int i=0;i<array.length;i++)
		{
			array[i] = this.fruitItems.get(i);
		}

		return array;
	}

	public boolean hasFruitItem(String text) 
	{
		
		return this.fruitItems.contains(text);
	}


}
