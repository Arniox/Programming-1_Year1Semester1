#include <stdio.h>
#include <math.h>
#include <string.h>
#include <time.h>
#include <stdlib.h>

int main(void)
{
	srand(time(0));

	char yes[] = {"yes"};
	char no[] = { "no" };
	char yesno[10];
	char input = '\0';
	char a = 'a';
	char b = 'b';
	char c = 'c';
	char d = 'c';

start:
	printf("This is a guessing machine. You think of something and it'll guess what it is. An object, animal, or whatever");
	printf("\nThink of something, anything. When you are ready, type yes. If you're not ready, type no > ");
	scanf("%s", &yesno);
	for (int i = 0; i < 40; i++)
	{
		printf("\n");
	}
yesno:
	if (strcmp(yesno, yes) == 0)
	{
		goto begin;
	}
	else if (strcmp(yesno, no) == 0)
	{
		goto start;
	}
	else
	{
		printf("Please enter a yes or a no > ");
		scanf("%s", &yesno);
		goto yesno;
	}

begin:
	printf("Is the thing in mind: \na) an object\nb) an animal\nc) a food item\nd) other\n > ");
	scanf(" %c", &input);
	if (input == a)
	{
		printf("you chose a");
	}
	else if (input == b)
	{
		printf("you chose b");
	}
	else if (input == c)
	{
		printf("you chose c");
	}
	else if (input == d)
	{
		printf("you chose d");
	}
	else
	{
		printf("You did not input either a, b, c or d. Please try again\n");
		for (int i = 0; i < 40; i++)
		{
			printf("\n");
		}
		goto begin;
	}

	return 0;
}