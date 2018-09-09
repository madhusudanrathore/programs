#include<stdio.h>
#include<conio.h>

struct student
{
	char name[20];
	int rno;
};
void display(struct student s1)
{
	printf("\n\nName OF The Student:%s",s1.name);
	printf("\nRoll No Of The Student:%d",s1.rno);
}
void main()
{
	struct student s;
	clrscr();
	printf("\n\nEnter Name Of The Student:");
	gets(s.name);
	printf("\nEnter Roll NO Of The Student:");
	scanf("%d",&s.rno);
	display(s);
	getch();
}