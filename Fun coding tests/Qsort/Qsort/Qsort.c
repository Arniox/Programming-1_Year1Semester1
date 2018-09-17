#define _CRT_SECURE_NO_WARNINGS_
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

typedef struct table_of_objects
{
	char Game_name[40];
	char Brand[40];
	int SKU;
	int stock;
	float price;

}objects;

int game_nameSort(void* first, void* second)
{
	objects* firstObjs = (objects*)first;
	objects* secondObjs = (objects*)second;

	return strcmp(firstObjs->Game_name, secondObjs->Game_name);
}
int brand_nameSort(void* first, void* second)
{
	objects* firstObjs = (objects*)first;
	objects* secondObjs = (objects*)second;

	return strcmp(firstObjs->Brand, secondObjs->Brand);
}
int SKUSort(void* first, void* second)
{
	objects* firstObjs = (objects*)first;
	objects* secondObjs = (objects*)second;

	return firstObjs->SKU - secondObjs->SKU;
}
int StockSort(void* first, void* second)
{
	objects* firstObjs = (objects*)first;
	objects* secondObjs = (objects*)second;

	return firstObjs->stock - secondObjs->stock;
}
int priceSort(void* first, void* second)
{
	objects* firstObjs = (objects*)first;
	objects* secondObjs = (objects*)second;

	return firstObjs->price - secondObjs->price;
}

int main(void)
{
	int choice;

	objects objs[9] =
	{
		{ "Atlantis", "Mayfair Games", 2233, 0, 44.50f},
		{ "Catan: Junior", "Mayfair Games", 2570, 12, 52.50f},
		{ "Carcassonne", "Z-Man Games", 3124, 3, 61.99f },
		{ "King of Tokyo", "Iello", 3332, 6, 71.80f},
		{ "Pandemic", "Z-Man Games", 3144, 10, 77.00f},
		{ "Dominion", "Rio Grande Games", 3149, 4, 78.90f},
		{ "Catan", "Mayfair Games", 3109, 8, 83.50f},
		{ "Ticket to Ride Europe", "Games of Wonder", 3137, 4, 82.60f},
		{ "Ticket to Ride", "Days of Wonder", 3136, 9, 86.95f}
	};

	printf("Board Game Inventory - Choose sort by option:\n");
	printf("=============================================\n");

	printf("1) Game Name\n");
	printf("2) Brand Name\n");
	printf("3) Stock Keeping Unit (SKU) \n");
	printf("4) Stock Level (S#) \n");
	printf("5) Retail Price\n");

	do
	{
		printf("Stock choice: ");
		scanf(" %d", &choice);

		switch (choice)
		{
		case 1: //fall through
			qsort(objs, 9, sizeof(objects), game_nameSort);
		case 2:
			qsort(objs, 9, sizeof(objects), brand_nameSort);
		case 3:
			qsort(objs, 9, sizeof(objects), SKUSort);
		case 4:
			qsort(objs, 9, sizeof(objects), StockSort);
		case 5:
			qsort(objs, 9, sizeof(objects), priceSort);
			break;
		default:
			printf("\nSorry, %d is an invalid sort option. Please try again\n", choice);
		}
	} while (choice > 6 || choice < 1);

	printf("+-----------------------+------------------+------+----+--------+\n");
	printf("| Game Name             | Brand name       | SKU  | S# | Price  |\n");
	printf("+-----------------------+------------------+------+----+--------+\n");
	for (int k = 0; k < 9; ++k)
	{
		printf("| %-21s | %-16s | %-4d | %-2d | $%-4.2f |\n", objs[k].Game_name, objs[k].Brand, objs[k].SKU, objs[k].stock, objs[k].price);
	}
	printf("+-----------------------+------------------+------+----+--------+\n");


	return 0;
}