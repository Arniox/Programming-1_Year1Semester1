package FunCodes;

import java.util.Random;

public class RandomNumbers {

	public static void main(String[] args)
	{
		Random random = new Random();
		
		int randomNumber = 0;
		randomNumber = random.nextInt();
		
		for(int i = 0; i < 10000; ++i)
		{
			System.out.printf(", %d", randomNumber);
			randomNumber = random.nextInt(10000);
		}
		
	}
}
