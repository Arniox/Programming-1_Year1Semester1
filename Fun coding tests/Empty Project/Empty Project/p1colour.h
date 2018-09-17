#ifndef __P1COLOUR_H__
#define __P1COLOUR_H__

enum P1Colours
{
	BLACK = 0,
	BLUE = 1,
	GREEN = 2,
	CYAN = 3,
	RED = 4,
	MAGENTA = 5,
	BROWN = 6,
	LIGHTGRAY = 7,
	DARKGRAY = 8,
	LIGHTBLUE = 9,
	LIGHTGREEN = 10,
	LIGHTCYAN = 11,
	LIGHTRED = 12,
	LIGHTMAGENTA = 13,
	YELLOW = 14,
	WHITE = 15
};

void move_cursor_to(int column, int row);
void set_text_colour(int foreground, int background);

#endif // __P1COLOUR_H__
