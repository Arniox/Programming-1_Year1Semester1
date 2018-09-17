#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>
#include <string.h>

int main(void)
{
	long long millseconds = 0;
	long long seconds = 0;
	long long mins = 0;
	long long hours = 0;
	long long days = 0;
	long long years = 0;
	long long decades = 0;
	long long century = 0;
	long long millennium = 0;
	long long eon = 0;
	long long timesTheUniverse = 0;
	long long input = 0;
	long long totalOutPutYears = 0;

	printf("Please input the time you want in seconds > ");
	scanf("%lld", &input);

	millseconds = ((input % 60) % 60) % 1000;
	seconds = (input % 60) % 60;
	hours = (input / 60) / 60;
	mins = (input / 60) % 60;
	days = ((input / 60) / 60) / 24;
	years = (((input / 60) / 60) / 24) / 365;
	decades = ((((input / 60) / 60) / 24) / 365) / 10;
	century = (((((input / 60) / 60) / 24) / 365) / 10) / 10;
	millennium = ((((((input / 60) / 60) / 24) / 365) / 10) / 10) / 10;
	eon = (((((((input / 60) / 60) / 24) / 365) / 10) / 10) / 10) / 1000000;
	timesTheUniverse = ((((((((input / 60) / 60) / 24) / 365) / 10) / 10) / 10) / 1000000) / 100000;
	totalOutPutYears = years;

	while (hours >= 24)                                         //hours down to under 24
	{
		while (hours >= 8760)
		{
			while (hours >= 87600)
			{
				while (hours >= 876000)
				{
					while (hours >= 8760000)
					{
						while (hours >= 8760000000000)
						{
							eon += 1;
							hours -= 8760000000000;
						}
						millennium += 1;
						hours -= 8760000;
					}
					century += 1;
					hours -= 876000;
				}
				decades += 1;
				hours -= 87600;
			}
			years += 1;
			hours -= 8760;
		}
		days += 1;
		hours -= 24;
	}

	while (days >= 365)                                        //days to under 365
	{
		while (days >= 3650)
		{
			while (days >= 36500)
			{
				while (days >= 365000)
				{
					while (days >= 365000000000)
					{
						eon += 1;
						days -= 365000000000;
					}
					millennium += 1;
					days -= 365000;
				}
				century += 1;
				days -= 36500;
			}
			decades += 1;
			days -= 3650;
		}
		years += 1;
		days -= 365;
	}

	while (years >= 10)                                      //years to under 10
	{
		while (years >= 100)
		{
			while (years >= 1000)
			{
				while (years >= 1000000000)
				{
					eon += 1;
					years -= 1000000000;
				}
				millennium += 1;
				years -= 1000;
			}
			century += 1;
			years -= 100;
		}
		decades += 1;
		years -= 10;
	}

	while (decades >= 10)                                      //decades to under 10
	{
		while (decades >= 100)
		{
			while (decades >= 100000000)
			{
				eon += 1;
				decades -= 100000000;
			}
			millennium += 1;
			decades -= 100;
		}
		century += 1;
		decades -= 10;
	}

	while (century >= 10)                                   //centuries to under 10
	{
		while (century >= 10000000)
		{
			eon += 1;
			century -= 10000000;
		}
		millennium += 1;
		century -= 10;
	}

	while (millennium >= 1000)                            //millennium to under 1000
	{
		eon += 1;
		millennium -= 1000;
	}

	while (eon >= 100000)                               //eon to under 100,000
	{
		timesTheUniverse += 1;
		eon -= 100000;
	}



	printf("\n\n%lld Times the total length of the universe when using the big freeze theory.\nFor refrence: total age of the universe is ~ 100 trillion + \n", timesTheUniverse);
	printf("%lld Eons\n%lld Millennium\n%lld Centuries\n", eon, millennium, century);
	printf("%lld Decades\n%lld years\n%lld days\n%lld hours\n%lld minutes\n%lld seconds\n%lld milliseconds\n\n", decades, years, days, hours, mins, seconds, millseconds);
	return 0;
}