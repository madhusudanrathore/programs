#include<iostream.h>
#include<conio.h>

class base
{
       public:
		void show()
		{
			cout<<"\n\n\tShow Base";
		}
		virtual void display()
		{
			cout<<"\n\n\tDisplay Base";
		}
};
class derived:public base
{
	public:
		void show()
		{
			cout<<"\n\n\tShow Derived";
		}
		void display()
		{
			cout<<"\n\n\tDisplay Derived";
		}
};

void main()
{
	clrscr();
	base b1,*b2;
	derived d;
	b2=&b1;
	b2->show();
	b2->display();
	b2=&d;
	b2->show();
	b2->display();
	getch();
}

