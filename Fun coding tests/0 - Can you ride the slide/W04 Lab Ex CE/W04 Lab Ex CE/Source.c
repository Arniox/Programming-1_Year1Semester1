#include <stdio.h>
#include <math.h>
#include <string.h>
#include <time.h>
#include <stdlib.h>

int main(void)
{
	srand(time(0));
	const int dataYouMustPass[] = { 13, 48, 130, 2017 };
	const char bannedName1[] = { "Hitler" };
	const char bannedName2[] = { "Trump" };

	int age = 0;
	int yearOfBirth = 0;
	int height = 0;
	int weight = 0;
	char character = '\0';
	int count = 0;
	char nameOfRide[10];
	char firstName[100];
	char lastName[100];

	while (count < 10)
	{
		character = '!' + (rand() % 94);
		nameOfRide[count++] = character;
	}
	nameOfRide[9] = '\0';

	printf("WELCOME TO THE AMAZING %s RIDE!!!\n\n\n", nameOfRide);
	printf("Please input your Name, your year of birth, your height and your weight > \n");
	printf("Name in format: First Last > ");
	int debugName = scanf(" %s %s", &firstName, &lastName);
	if (!(debugName == 2))
	{
		printf("Please Input your full Name. First Last > ");
	}
	else
	{
		printf("\nYear of birth > ");
		int debugBirth = scanf(" %d", &yearOfBirth);
		if (!(debugBirth == 1))
		{
			printf("Please input your year of birth > ");
		}
		else
		{
			printf("\nWeight > ");
			int debugWeight = scanf(" %d", &weight);
			if (!(debugWeight == 1))
			{
				printf("Please input your weight > ");
			}
			else
			{
				printf("\nHeight > ");
				int debugHeight = scanf(" %d", &height);
				if (!(debugHeight == 1))
				{
					printf("Please input your height > ");
				}
				else
				{


					printf("\n\nThank you for your info. Please hold while we compute the data....\n");

					age = dataYouMustPass[3] - yearOfBirth;


					if ((strcmp(firstName, bannedName1) == 0) || (strcmp(firstName, bannedName2) == 0) || (strcmp(lastName, bannedName1) == 0) || (strcmp(lastName, bannedName2) == 0))
					{
						printf("%s and %s are Banned names. Thank you for attemepting %s ride!!!\n\n", bannedName1, bannedName2, nameOfRide);
					}
					else
					{
						if (!(age >= dataYouMustPass[0] || age < 60))
						{
							printf("%s %s, At age of %d, You are too old/young to go on %s ride\n\n", firstName, lastName, age, nameOfRide);
						}
						else if (!(weight >= dataYouMustPass[1]))
						{
							printf("%s %s, With a height of %d. You are too tall/small to go on %s ride\n\n", firstName, lastName, height, nameOfRide);
						}
						else if (!(height >= dataYouMustPass[2]))
						{
							printf("%s %s, With a weight of %d, You are too fat/thin to go on %s ride\n\n", firstName, lastName, weight, nameOfRide);
						}
						else
						{
							printf("%s %s, You are alegable to go on %s ride.\n", firstName, lastName, nameOfRide);
							printf("With an age of %d, you are not too old, nor too young.\n", age);
							printf("With a weight of %d, you are not too fat no too thin.\n", weight);
							printf("And with a height of %d, you are not too tall nor too small.\n", height);
							printf("Have a good day!!!!\n\n");
						}
					}
				}
			}
		}
	}

	return 0;
}