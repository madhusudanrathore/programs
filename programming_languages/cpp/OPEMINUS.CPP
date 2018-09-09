#include<iostream.h>
#include<conio.h>

class Distance
{
	int feet,inches;
	public:
		Distance()
		{
			feet=0;
			inches=0;
		}
		Distance(int f,int i)
		{
			feet=f;
			inches=i;
		}
		void display()
		{
		      cout<<"\n\n\tF = "<<feet<<" I = "<<inches<<"\n";
		}
		Distance operator-()
		{
			feet=-feet;
			inches=-inches;
			return Distance(feet,inches);
		}
};

void main()
{
	clrscr();
	Distance d1(10,20),d2(-5,10);
	-d1;
	d1.display();
	-d2;
	d2.display();
	getch();
}