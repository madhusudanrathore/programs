#include<iostream.h>
#include<conio.h>
#include<ctype.h>

void main()
{
	char ch;
	clrscr();
	cout<<"\n\n\tEnter Any Single Character:";
	cin>>ch;
	if(isalnum(ch)!=0)
	{
		cout<<"\n\n\tEntered Charater Is Alpha Or Numeric";
	}
	else
	{
		cout<<"\n\n\tEnter Charater Is Non Alpha Or Numeric";
	}
	getch();
}