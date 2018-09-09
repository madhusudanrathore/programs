#include<iostream.h>
#include<conio.h>

class A
{
	int a;
	public:
		void get_a()
		{
			cout<<"\n\n\tEnter Value Of A:";
			cin>>a;
		}
		void put_a()
		{
			cout<<"\n\n\tValue Of A = "<<a;
		}
};
class B
{
	int b;
	public:
		void get_b()
		{
			cout<<"\n\n\tEnter Value Of B:";
			cin>>b;
		}
		void put_b()
		{
			cout<<"\n\n\tValue Of B = "<<b;
		}
};
class C:public A,public B
{
	int c;
	public:
		void get_c()
		{
			cout<<"\n\n\tEnter Value Of C:";
			cin>>c;
		}
		void put_c()
		{
			cout<<"\n\n\tValue Of C = "<<c;
		}
};


void main()
{
	clrscr();
	C c;
	c.get_a();
	c.get_b();
	c.get_c();
	c.put_a();
	c.put_b();
	c.put_c();
	getch();
}


