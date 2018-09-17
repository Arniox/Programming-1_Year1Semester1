#include <stdio.h>

int main(void)
{
	long long x, y, z;
	long long test = -1;

	while (test < 0)
	{
		x = 0;
		y = 1;
		do
		{
			printf("%lld\n", x);

			z = x + y;
			x = y;
			y = z;
		} while (x < 9000000000000);
		test = 1000;
	}

	return 0;
}