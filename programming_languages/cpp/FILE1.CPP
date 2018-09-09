#include<iostream.h>
#include<conio.h>
#include<fstream.h>

void main()
{
	char data[100];
	clrscr();
	ofstream of;
	of.open("sample.dat");
	cout<<"\n\n\tEnter Name:";
	cin>>data;
	of<<data<<endl;
	cout<<"\n\n\tEnter Age:";
	cin>>data;
	cin.ignore();
	of<<data<<endl;
	of.close();
	ifstream ifs;
	ifs.open("sample.dat");
	cout<<"\n\n\tReading From File:\n";
	ifs>>data;
	cout<<data<<endl;
	ifs>>data;
	cout<<data<<endl;
	ifs.close();
	getch();
}
