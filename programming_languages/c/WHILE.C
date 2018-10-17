#include<stdio.h>

int main()
{
	int n=10,sum=0;
	
	do{
		sum=sum+n;
		n--;
	}while(n>0);
	
	printf("\n\nSum = %d",sum);
	return 0 ;
}