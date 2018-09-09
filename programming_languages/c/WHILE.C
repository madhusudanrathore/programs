#include<stdio.h>
#include<conio.h>

void main()
{
	int n,sum=0;
	clrscr();
	printf("Enter Value OF N:");
	scanf("%d",&n);
	do
	{
		sum=sum+n;
		n--;
	}while(n>0);
	printf("\n\nSum = %d",sum);
	getch();
}