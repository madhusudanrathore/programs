#include<iostream.h>
#include<conio.h>

class A
{
	public:
		virtual void show()
		{
			cout<<"\nShow From A";
		}
		virtual void display()
		{
			cout<<"\nDisplay From A";
		}
};
class B:public A
{
	public:
		void show()
		{
			cout<<"\nShow From B";
		}
		void display()
		{
			cout<<"\nDisplay From B";
		}
};

void main()
{
	clrscr();
	A *p;
	A a;
	B b;
	p=&a;
	p->show();
	p->display();
	p=&b;
	p->show();
	p->display();
	getch();
}