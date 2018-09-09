#include<iostream.h>
#include<conio.h>

inline 	int add(int a,int b)
{
	return(a+b);
}
void main()
{
	int x,y;
	clrscr();
	cout<<"\n\nEnter Value Of X & Y:";
	cin>>x>>y;
	cout<<"\n\nAddition = "<<add(x,y);
	getch();
}