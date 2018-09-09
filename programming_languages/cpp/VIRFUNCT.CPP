#include<iostream.h>
#include<conio.h>

class X
{
	int a;
	public:
		void set_a(int a)
		{
			this->a=a;
		}
		void print_a()
		{
			cout<<"\n\n\tA = "<<a;
		}
};
void main()
{
	clrscr();
	X ob;
	int a=5;
	ob.set_a(a);
	ob.print_a();
	getch();
}