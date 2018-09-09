#include<iostream.h>
#include<conio.h>
#include<ctype.h>

void main()
{
	char ch;
	clrscr();
	cout<<"\n\n\tEnter Any Character:";
	cin>>ch;
	if(islower(ch)!=0)
	{
		cout<<"\n\n\tUppercase Of Given Character Is :"<<char(toupper(ch));
	}
	else
	{
		cout<<"\n\n\tUppercase Of Given Character Is :"<<char(tolower(ch));
	}
	getch();
}
