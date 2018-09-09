#include<iostream.h>
#include<conio.h>

class complex
{
	int a,b;
	public:
		void getValue()
		{
			cout<<"\n\n\tEnter Value Of A & B:";
			cin>>a>>b;
		}
		complex operator+(complex ob)
		{
			complex t;
			t.a=a+ob.a;
			t.b=b+ob.b;
			return(t);
		}
		complex operator-(complex ob)
		{
			complex t;
			t.a=a-ob.a;
			t.b=b-ob.b;
			return(t);
		}
		void display()
		{
			cout<<"\n\n\t"<<a<<"+"<<b<<"i"<<"\n";
		}
};

void main()
{
	clrscr();
	complex ob1,ob2,res1,res2;
	ob1.getValue();
	ob2.getValue();
	res1=ob1+ob2;
	res2=ob1-ob2;
	cout<<"\n\n\tIntut Values :\n";
	ob1.display();
	ob2.display();
	cout<<"\n\n\t Result:\n";
	res1.display();
	res2.display();
	getch();
}


