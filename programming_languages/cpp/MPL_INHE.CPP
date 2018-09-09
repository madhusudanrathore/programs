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
class B
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
class C:public A,public B
{
	int c;
	public:
		void getC()
		{
			cout<<"\nEnter Value Of C:";
			cin>>c;
		}
		void putC()
		{
			cout<<"\nValue Of C = "<<c;
		}
};

void main()
{
	clrscr();
	C c;
	c.getA();
	c.getB();
	c.getC();
	c.putA();
	c.putB();
	c.putC();
	getch();
}

