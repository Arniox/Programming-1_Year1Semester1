package Exercises;

import java.util.Formatter;
import java.util.Scanner;

public class CelsiusToFahrenheit {

	public static void main(String[] args)
	{
		Formatter formatter = new Formatter();
		Scanner scan = new Scanner(System.in);
		
		int Celsius = 0;
		int Farhenheit = 0;
		
		System.out.println("Please enter the temperature in Fahrenheit");
		Celsius = scan.nextInt();
		
		Farhenheit = ((Celsius*9)/5)+32;
		
		System.out.println(formatter.format("The temperature %dC is %dF", Celsius, Farhenheit));
		
		formatter.close();
		scan.close();
	}
}
