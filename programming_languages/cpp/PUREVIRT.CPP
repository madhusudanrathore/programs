#include<iostream.h>
#include<conio.h>

class A
{
	public:
		virtual void display()=0;
};
class B:public A
{
	public:
		void display()
		{
			cout<<"\nShow From Class B";
		}
};
class C:public A
{
	public:
		void show()
		{
			cout<<"\nShow From Class B";
		}
		void display()
		{
			cout<<"\nShow From Class C";
		}
};
void main()
{
	clrscr();
	//A a;
	B b;
	C c;
	b.display();
	c.show();
	c.display();
	getch();
}