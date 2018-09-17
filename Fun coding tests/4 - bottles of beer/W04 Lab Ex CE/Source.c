#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <math.h>

void print_out(signed long long bottleCount);

int main(void)
{
	signed long long bottleCount;

	bottleCount = 10;
	print_out(bottleCount);

	return 0;
}

void print_out(signed long long bottleCount)
{
	for (signed long long i = bottleCount; i > 0; --i)
	{
		printf("%lld bottles of beer on the wall,\n", i);
		printf("%lld bottles of beer!\n", i);
		printf("Take one down, pass it around!\n");
		printf("%lld bottles of beer on the wall\n\n", i - 1);
	}
}