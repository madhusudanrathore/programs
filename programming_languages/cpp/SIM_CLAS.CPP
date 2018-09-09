#include<iostream.h>
#include<conio.h>

class student
{
	int rno;
	char name[20];
	public:
		void getData()
		{
			cout<<"\nEnter Roll NO:";
			cin>>rno;
			cout<<"\nEnter Name:";
			cin>>name;
		}
		void putData();
};
void student::putData()
{
	cout<<"\nRoll No = "<<rno;
	cout<<"\nName = "<<name;
}
void main()
{
	clrscr();
	student s;
	s.getData();
	s.putData();
	getch();
}