#include<stdio.h>

struct student
{
	char name[20];
	int rno;
};

int main()
{
	struct student s1;
	printf("\nEnter Name:");
	gets(s1.name);
	printf("\n\nEnter Roll No OF The Student:");
	scanf("%d",&s1.rno);
	printf("\n\nName = %s",s1.name);
	printf("\n\nRoll No = %d",s1.rno);
}