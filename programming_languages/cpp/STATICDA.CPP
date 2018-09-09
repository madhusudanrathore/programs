#include<iostream.h>
#include<conio.h>

class box
{
	double width,height,depth;
	public:
		static int count;
		box(double w,double h,double d)
		{
			cout<<"\nConstructor Called\n";
			width=w;
			height=h;
			depth=d;
			count++;
		}
		static int getCount()
		{
			return count;
		}
};
int box::count=0;

void main()
{
	clrscr();
	cout<<"\nInitial Count:"<<box::getCount();
	box b1(5,6,7);
	box b2(6,7,8);
	box b3(1,2,3);
	cout<<"\n\nTotal Objects :"<<box::getCount();
	getch();
}

