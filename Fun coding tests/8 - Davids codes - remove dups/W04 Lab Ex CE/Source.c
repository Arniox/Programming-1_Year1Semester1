#define _CRT_SECURE_NO_WARNINGS_
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
//#include <time.h>
#include <string.h>
//#include <math.h>
//#include <Windows.h>


int len(int len[]);
void remove_triples(int *array);

int main(void)
{
	int a_list[] = { 6, 6, 6, 7, 6, 6, 4, 3, 3, 3, 8, 8, 8, 3 };	//sets an array of numbers
	remove_triples(&a_list);										//calls the remove_triples function with the array

	int string_len = len(a_list);									//finds the length of characters

	for (; string_len > 0; --string_len)							//iterates down the list, and prints out in the oposite direction
	{
		printf("%d, ", a_list[!(0 - string_len)]);
	}

	return 0;
}

int len(int len[])
{
	int count = 0;													//sets a count variable
	while (!(len[count] == 0))										//while the array at index count is not equal to NULL, or 0. Keep iterating
	{
		++count;													//add to count
	}
	assert(count != 0);

	return count;													//returns count
}

void remove_triples(int *array)
{
	int list_range = len(array);									//sets the list_array to the length of the array
	assert(list_range != 0);

	int* final_array = malloc(sizeof(int) * list_range);			//sets a final array pointer to a memory allocation of size int * the length of the array

	for (int i = 0; i < list_range; ++i)							//iterates up to the size of the array max
	{
		if (array[i] == array[i + 1] && array[i + 2])				//if the first element is the same as the next 2, then only save 2 values. Essentially popping
		{
			final_array[i] = array[i];
			final_array[i + 1] = array[i + 1];
		}
		else
		{
																	//otherwise, save the elements to the array
		}
		{
			final_array[i] = array[i];
			final_array[i + 1] = array[i + 1];
			final_array[i + 2] = array[i + 2];
		}
	}

	free(final_array);

	return;
}