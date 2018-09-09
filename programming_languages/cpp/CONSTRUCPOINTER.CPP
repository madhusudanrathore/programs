#include<iostream.h>
#include<conio.h>

class box
{
	double width,height,depth;
	public:
		box()
		{
			width=3;
			height=4;
			depth=5;
		}
		box(double w,double d,double h)
		{
			width=w;
			height=h;
			depth=d;
		}
		box(box &b)
		{
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
	box b;
	b.volume();
	box *b1=new box(5,6,7);
	bf1->volume();
	box b2(b);
	b2.volume();
	getch();
}