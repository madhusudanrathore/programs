#include<iostream.h>
#include<conio.h>

class box
{
	double width,height,depth;
	public:
		box() //Default Constructor
		{
			cout<<"\nDefault Constructor Called";
			width=5;
			height=6;
			depth=7;
		}
		box(double w,double h,double d)//Parameterized Constructor
		{
			cout<<"\nParameterized Constructor";
			width=w;
			height=h;
			depth=d;
		}
		box(box &b)//Copy Constructor
		{
			cout<<"\n\nCopy Constructor Called";
			width=b.width;
			height=b.height;
			depth=b.depth;
		}
		void volume()
		{
			cout<<"\n\nVolume = "<<width*height*depth;
		}
};
void main()
{
	clrscr();

	box b1;
	b1.volume();

	box b2(10,20,30);
	b2.volume();

	box b3(b2);
	b3.volume();
	getch();
}