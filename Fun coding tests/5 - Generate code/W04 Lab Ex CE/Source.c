#include <stdio.h>
#include <string.h>
#include <time.h>
#include <stdlib.h>
#include <math.h>

int main(void)
{
	srand(time(0));
	int code;
	
	for (int y = 0; y < 390000; ++y)
	{
		for (int i = 0; i < 4; ++i)
		{
			code = rand() % 0xFFFF;
			printf("%04X", code);
			if (!(i == 3))
			{
				printf("-");
			}
		}
		printf("\n");
	}
	printf("\n\n");

	return 0;
}