#define _CRT_SECURE_NO_WARNINGS
#define LLWORD long long

#include <string.h>
#include <stdio.h>
#include <stdlib.h>

int main(char* argv, int argc)
{
	char code;

	FILE* file = fopen("test.exe", "r");
	
	if (file)
	{
		while (fscanf(file, "%c", &code) != EOF)
		{
			printf("%c", code);
		}
		printf("\n\n");

		fclose(file);
	}
	else
	{
		printf("File Failed to Scanf. Please put the program inside the file inwhich the .exe file exists\n\n");
	}

	system("pause");

	return 0;
}