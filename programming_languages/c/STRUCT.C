#include<stdio.h>

struct student
{
	int rno;
	char name[20];
	int s1,s2,s3;
}student st1[100];

int main()
{
	int i,n;
	printf("\nEnter Nunber Of Student:");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		printf("\nEnter Roll No Of Student %d:",i+1);
		scanf("%d",&st1[i].rno);
		printf("\nEnter Name Of The Student %d",i+1);
		fflush(stdin);
		gets(st1[i].name);
		printf("\nEnter Three Subjects Marks Of Student %d:",i+1);
		scanf("%d%d%d",&st1[i].s1,&st1[i].s2,&st1[i].s3);
	}
	printf("\nEntered Data Is:\n");
	for(i=0;i<n;i++)
	{
		printf("\nRoll No OF Student %d Is %d:",i+1,st1[i].rno);
		fflush(stdin);
		printf("\nName Of Student %d: Is %s",i+1,st1[i].name);
		printf("Marks Of Student %d Is %d %d & %d:",i+1,st1[i].s1,st1[i].s2,st1[i].s3);
	}
}
