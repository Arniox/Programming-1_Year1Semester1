#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char* argv[])
{
	if (argc == 3)
	{
		int argument1;
		sscanf(argv[1], "%d", &argument1);

		for (int i = argument1; i > 0; --i)
		{
			printf("%s,", argv[2]);
		}
	}
}