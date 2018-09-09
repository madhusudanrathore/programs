#include<stdio.h>
#include<time.h>

void main(){
	clock_t start, end;
	start = clock();

	//work

	end = clock();
	double time_taken = ((double) (end - start)) / CLOCKS_PER_SEC;
	printf("\n%f",time_taken);	
}