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
class C:public A
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
class D:public B,public C
{
	int d;
	public:
		void getD()
		{
			cout<<"\nEnter Value Of D:";
			cin>>d;
		}
		void putD()
		{
			cout<<"\nValue Of D = "<<d;
		}
};


void main()
{
	clrscr();
	C c;
	D d;
	c.getA();
	d.getB();
	d.getC();
	d.getD();
	c.putA();
	d.putB();
	d.putC();
	d.putD();
	getch();
}

