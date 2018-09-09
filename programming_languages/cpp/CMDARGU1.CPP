#include <iostream.h>
#include<conio.h>

void main(int argc, char **argv)
{
	clrscr();
	cout << "\n\nReceived " << argc << " arguments...\n";
	for (int i=0; i<argc; i++)
	cout << "argument " << i << ": " << argv[i] << endl;
	getch();
}