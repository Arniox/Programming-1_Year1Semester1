package examples;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GameAccountTextIO {

	
	public static void output(GameAccount ga,String filename)
	{
		try {
			PrintWriter out = new PrintWriter(new FileWriter(filename));

			out.println(ga.getName());
			out.println(ga.getAddress());
			out.println(ga.getTrophy());
			out.print(ga.getScore());
			out.close();

		} catch (IOException e) 
		{
			System.err.println("An IO error occurred");
			e.printStackTrace();
		}

	}
	

	public static GameAccount input(String inputFileName)
	{
		try 
		{
			Scanner in = new Scanner(new FileReader(inputFileName));
			String name = in.nextLine();
			String address = in.nextLine();
			String trophyName = in.nextLine();
			int score = in.nextInt();
		
			Trophy trophy = 	Trophy.valueOf(trophyName);
		
			GameAccount ga = new GameAccount(name,address,trophy,score);
			
			in.close();
			return ga;

		} catch (FileNotFoundException e) 
		{		
			e.printStackTrace();
		}
		return null;

	}
	
}
