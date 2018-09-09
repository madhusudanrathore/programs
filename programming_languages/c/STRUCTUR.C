#include<stdio.h>
#include<conio.h>

struct student
{
	char name[20];
	int rno;
};

void main()
{
	struct student s1;
	clrscr();
	printf("\nEnter Name:");
	gets(s1.name);
	printf("\n\nEnter Roll No OF The Student:");
	scanf("%d",&s1.rno);
	printf("\n\nName = %s",s1.name);
	printf("\n\nRoll No = %d",s1.rno);
	getch();
}