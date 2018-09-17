package FunCodes;

import java.util.Formatter;
import java.util.Scanner;

public class oneMillionExclamationPoints {

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Formatter formatter = new Formatter();
		
		long numberOfCharacters;
		String Character;
		
		System.out.printf("Please enter the character to print: ");
		Character = scanner.nextLine();
		System.out.printf("Please enter the number of times you want %s printed: ", Character);
		numberOfCharacters = scanner.nextLong();
		
		if (numberOfCharacters >= 1000000)
		{
			for (int i = 0; i < 10000; ++i)
			{
				System.out.println(Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character);
			}
		}
		else if (numberOfCharacters >= 100000)
		{
			for (int i = 0; i < 1000; ++i)
			{
				System.out.println(Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character);
			}
		}
		else if (numberOfCharacters >= 10000)
		{
			for (int i = 0; i < 100; ++i)
			{
				System.out.println(Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character);
			}
		}
		else if (numberOfCharacters >= 1000)
		{
			for (int i = 0; i < 10; ++i)
			{
				System.out.println(Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character+Character);
			}
		}
		else if (numberOfCharacters >= 100)
		{
			for (int i = 0; i < 10; ++i)
			{
				System.out.println(Character+Character+Character+Character+Character+Character+Character+Character+Character+Character);
			}
		}
		else
		{
			for (int i = 0; i < numberOfCharacters; ++i)
			{
				System.out.printf("%s\n", Character);
			}
		}
		System.out.println("\nDone");
		
		formatter.close();
		scanner.close();
	}
}
