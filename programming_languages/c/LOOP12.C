#include <stdio.h>
#include <conio.h>

void main ()
{
	int i = 0;
	int j = 10;

		while( i < j)      //step 1
		{
			//10 time start from 0
			printf("\n\t%d",i); //step 2
			i++;                        //step 3
		}
		printf("\n\n\n\t\t i :\t%d",i);
		printf("\n\n\t\tDo while o/p:\n\n");
		i = 0 ;
		do
	 //step 1
		{
	//step 2
			printf("\n\t%d",i); //step 2
			i++;
			//body of loop
		}
       //step 3
		while(i < 10);
}