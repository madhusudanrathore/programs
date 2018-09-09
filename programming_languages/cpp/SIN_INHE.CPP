#include<iostream.h>
#include<conio.h>

class A
{
	int a;
	public:
		void getA()
		{
			cout<<"\nEnter Value Of A:";
			cin>>a;
		}
		void putA()
		{
			cout<<"\nValue Of A = "<<a;
		}
};
class B:public A
{
	int b;
	public:
		void getB()
		{
			cout<<"\nEnter Value Of B:";
			cin>>b;
		}
		void putB()
		{
			cout<<"\nValue Of B = "<<b;
		}
};

void main()
{
	clrscr();
	B b;
	b.getA();
	b.getB();
	b.putA();
	b.putB();
	getch();
}

