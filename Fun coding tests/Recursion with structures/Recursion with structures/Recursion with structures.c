#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <Windows.h>

typedef struct PMovie
{
	char tital[50];
	char directors[200];
	int duration;
	struct PMovie* Sequal;

}Movie;

typedef enum PMovieName
{
	STONE = 0,
	SECRETS = 1,
	ASKABAN = 2,
	GOBLET = 3,
	PHEONIX = 4,
	BLOOD = 5,
	HALLOWS1 = 6,
	HALLOWS2 = 7,

	LENGTH = 8

}MovieName;

void print_movie_name(Movie* movie);

int main(void)
{
	MovieName moviname;
	Movie movie[LENGTH];
	
	//first movie
	sprintf(movie[STONE].tital, "Harry Potter and the Philosophers stone");
	sprintf(movie[STONE].directors, "J.K Rowling, Some other person");
	movie[STONE].duration = 2; //hours
	movie[STONE].Sequal = &movie[SECRETS];
	//second movie
	sprintf(movie[SECRETS].tital, "Harry Potter and the Chamber of Secrets");
	sprintf(movie[SECRETS].directors, "J.K Rowling, Some other person");
	movie[SECRETS].duration = 2; //hours
	movie[SECRETS].Sequal = &movie[ASKABAN];
	//third movie
	sprintf(movie[ASKABAN].tital, "Harry Potter and the Prisoner of Askaban");
	sprintf(movie[ASKABAN].directors, "J.K Rowling, Some other person");
	movie[ASKABAN].duration = 2; //hours
	movie[ASKABAN].Sequal = &movie[GOBLET];
	//fourth movie
	sprintf(movie[GOBLET].tital, "Harry Potter and the Goblet of Fire");
	sprintf(movie[GOBLET].directors, "J.K Rowling, Some other person");
	movie[GOBLET].duration = 2; //hours
	movie[GOBLET].Sequal = &movie[PHEONIX];
	//fifth movie
	sprintf(movie[PHEONIX].tital, "Harry Potter and the Order of the Pheonix");
	sprintf(movie[PHEONIX].directors, "J.K Rowling, Some other person");
	movie[PHEONIX].duration = 2; //hours
	movie[PHEONIX].Sequal = &movie[BLOOD];
	//sixth movie
	sprintf(movie[BLOOD].tital, "Harry Potter and the Half Blood Prince");
	sprintf(movie[BLOOD].directors, "J.K Rowling, Some other person");
	movie[BLOOD].duration = 2; //hours
	movie[BLOOD].Sequal = &movie[HALLOWS1];
	//seventh movie
	sprintf(movie[HALLOWS1].tital, "Harry Potter and the Deathly Hallows part 1");
	sprintf(movie[HALLOWS1].directors, "J.K Rowling, Some other person");
	movie[HALLOWS1].duration = 2; //hours
	movie[HALLOWS1].Sequal = &movie[HALLOWS2];
	//eighth movie
	sprintf(movie[HALLOWS2].tital, "Harry Potter and the Deathly Hallows part 2");
	sprintf(movie[HALLOWS2].directors, "J.K Rowling, Some other person");
	movie[HALLOWS2].duration = 2; //hours
	movie[HALLOWS2].Sequal = 0;

	print_movie_name(&movie);

	return 0;
}

void print_movie_name(Movie* movie)
{
	printf("Tital: %s\n", movie->tital);
	printf("Directors: %s\n", movie->directors);
	printf("Duration: %d Hours\n", movie->duration);
	
	if (movie->Sequal)
	{
		printf("Sequal: \n\n");
		print_movie_name(movie->Sequal);
	}
	printf("\n");
}