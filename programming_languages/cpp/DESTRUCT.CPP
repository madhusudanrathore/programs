#include<iostream.h>
#include<conio.h>

class box
{
	public:
		box()
		{
			cout<<"\nConstructor Called";
		}
		~box()
		{
			cout<<"\nDestructor Called";
		}
};

void main()
{
	clrscr();
	box b1,b2,b3;
	cout<<"\nEnter Into Block - 1:";
	{
		box b4;
	}
	cout<<"\nEnter Into Block - 2:";
	{
		box b5;
	}
	getch();
}